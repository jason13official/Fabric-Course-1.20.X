package net.kaupenjoe.mccourse.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.fabricmc.tinyremapper.OutputConsumerPath;
import net.kaupenjoe.mccourse.block.custom.GemEmpoweringStationBlock;
import net.kaupenjoe.mccourse.item.ModItems;
import net.kaupenjoe.mccourse.networking.ModMessages;
import net.kaupenjoe.mccourse.recipe.GemEmpoweringRecipe;
import net.kaupenjoe.mccourse.screen.GemEmpoweringScreenHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import java.util.Optional;

public class GemEmpoweringStationBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(4, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int FLUID_ITEM_SLOT = 1;
    private static final int OUTPUT_SLOT = 2;
    private static final int ENERGY_ITEM_SLOT = 3;

    protected final ContainerData propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    private final int DEFAULT_MAX_PROGRESS = 72;

    private int energyAmount = 25;
    private final int DEFAULT_ENERGY_AMOUNT = 25;

    public GemEmpoweringStationBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GEM_EMPOWERING_STATION_BE, pos, state);
        this.propertyDelegate = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> GemEmpoweringStationBlockEntity.this.progress;
                    case 1 -> GemEmpoweringStationBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: GemEmpoweringStationBlockEntity.this.progress = value;
                    case 1: GemEmpoweringStationBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    public ItemStack getRenderStack() {
        if(this.getItem(OUTPUT_SLOT).isEmpty()) {
            return this.getItem(INPUT_SLOT);
        } else {
            return this.getItem(OUTPUT_SLOT);
        }
    }

    @Override
    public void setChanged() {
        if(!level.isClientSide()) {
            FriendlyByteBuf data = PacketByteBufs.create();
            data.writeInt(inventory.size());
            for(int i = 0; i < inventory.size(); i++) {
                data.writeItem(inventory.get(i));
            }
            data.writeBlockPos(getBlockPos());

            for(ServerPlayer player : PlayerLookup.tracking((ServerLevel) level, getBlockPos())) {
                ServerPlayNetworking.send(player, ModMessages.ITEM_SYNC, data);
            }
        }

        super.setChanged();
    }

    public void setInventory(NonNullList<ItemStack> list) {
        for(int i = 0; i < list.size(); i++) {
            this.inventory.set(i, list.get(i));
        }
    }

    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(64000, 200, 200) {
        @Override
        protected void onFinalCommit() {
            setChanged();
            getLevel().sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    };

    public final SingleVariantStorage<FluidVariant> fluidStorage = new SingleVariantStorage<FluidVariant>() {
        @Override
        protected FluidVariant getBlankVariant() {
            return FluidVariant.blank();
        }

        @Override
        protected long getCapacity(FluidVariant variant) {
            return (FluidConstants.BUCKET / 81) * 64; // 1 Bucket = 81000 Droplets = 1000mB || *64 ==> 64,000mB = 64 Buckets
        }

        @Override
        protected void onFinalCommit() {
            setChanged();
            getLevel().sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    };

    @Override
    public boolean canPlaceItemThroughFace(int slot, ItemStack stack, @Nullable Direction side) {
        Direction localDir = this.getLevel().getBlockState(worldPosition).getValue(GemEmpoweringStationBlock.FACING);

        if(side == Direction.DOWN) {
            return false;
        }

        if(side == Direction.UP) {
            return slot == INPUT_SLOT;
        }

        return switch (localDir) {
            default -> //NORTH
                        side.getOpposite() == Direction.NORTH && slot == INPUT_SLOT ||
                        side.getOpposite() == Direction.WEST && slot == INPUT_SLOT;
            case EAST ->
                        side.getClockWise() == Direction.NORTH && slot == INPUT_SLOT ||
                        side.getClockWise() == Direction.WEST && slot == INPUT_SLOT;
            case SOUTH ->
                        side == Direction.NORTH && slot == INPUT_SLOT ||
                        side == Direction.WEST && slot == INPUT_SLOT;
            case WEST ->
                        side.getCounterClockWise() == Direction.NORTH && slot == INPUT_SLOT ||
                        side.getCounterClockWise() == Direction.WEST && slot == INPUT_SLOT;
        };
    }

    @Override
    public boolean canTakeItemThroughFace(int slot, ItemStack stack, Direction side) {
        Direction localDir = this.getLevel().getBlockState(this.worldPosition).getValue(GemEmpoweringStationBlock.FACING);

        if(side == Direction.UP) {
            return false;
        }

        // Down extract 2
        if(side == Direction.DOWN) {
            return slot == OUTPUT_SLOT;
        }

        // bottom extract 2
        // right extract 2
        return switch (localDir) {
            default ->  side.getOpposite() == Direction.SOUTH && slot == OUTPUT_SLOT ||
                    side.getOpposite() == Direction.EAST && slot == OUTPUT_SLOT;

            case EAST -> side.getClockWise() == Direction.SOUTH && slot == OUTPUT_SLOT ||
                    side.getClockWise() == Direction.EAST && slot == OUTPUT_SLOT;

            case SOUTH ->   side == Direction.SOUTH && slot == OUTPUT_SLOT ||
                    side == Direction.EAST && slot == OUTPUT_SLOT;

            case WEST -> side.getCounterClockWise() == Direction.SOUTH && slot == OUTPUT_SLOT ||
                    side.getCounterClockWise() == Direction.EAST && slot == OUTPUT_SLOT;
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayer player, FriendlyByteBuf buf) {
        buf.writeBlockPos(this.worldPosition);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Gem Empowering Station");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory playerInventory, Player player) {
        return new GemEmpoweringScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        ContainerHelper.saveAllItems(nbt, inventory);
        nbt.putInt("gem_empowering_station.progress", progress);
        nbt.putInt("gem_empowering_station.max_progress", maxProgress);
        nbt.putInt("gem_empowering_station.energy_amount", energyAmount);
        nbt.putLong(("gem_empowering_station.energy"), energyStorage.amount);
        nbt.put("gem_empowering_station.variant", fluidStorage.variant.toNbt());
        nbt.putLong("gem_empowering_station.fluid_amount", fluidStorage.amount);
    }

    @Override
    public void load(CompoundTag nbt) {
        ContainerHelper.loadAllItems(nbt, inventory);
        progress = nbt.getInt("gem_empowering_station.progress");
        maxProgress = nbt.getInt("gem_empowering_station.max_progress");
        energyAmount = nbt.getInt("gem_empowering_station.energy_amount");
        energyStorage.amount = nbt.getLong("gem_empowering_station.energy");
        fluidStorage.variant = FluidVariant.fromNbt((CompoundTag) nbt.get("gem_empowering_station.variant"));
        fluidStorage.amount = nbt.getLong("gem_empowering_station.fluid_amount");
        super.load(nbt);
    }

    public void tick(Level world, BlockPos pos, BlockState state) {
        fillUpOnEnergy(); // until we have machines/other mods that give us Energy
        fillUpOnFluid();

        if(canInsertIntoOutputSlot() && hasRecipe()) {
            increaseCraftingProgress();
            extractEnergy();
            setChanged(world, pos, state);

            if(hasCraftingFinished()) {
                craftItem();
                extractFluid();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void extractFluid() {
        try(Transaction transaction = Transaction.openOuter()) {
            this.fluidStorage.extract(FluidVariant.of(Fluids.WATER), 500, transaction);
            transaction.commit();
        }
    }

    private void fillUpOnFluid() {
        if(hasFluidSourceItemInFluidSlot(FLUID_ITEM_SLOT)) {
            transferItemFluidToTank(FLUID_ITEM_SLOT);
        }
    }

    private void transferItemFluidToTank(int fluidItemSlot) {
        try(Transaction transaction = Transaction.openOuter()) {
            this.fluidStorage.insert(FluidVariant.of(Fluids.WATER),
                    (FluidConstants.BUCKET / 81), transaction);
            transaction.commit();

            this.setItem(fluidItemSlot, new ItemStack(Items.BUCKET));
        }
    }

    private boolean hasFluidSourceItemInFluidSlot(int fluidItemSlot) {
        return this.getItem(fluidItemSlot).getItem() == Items.WATER_BUCKET;
    }

    private void extractEnergy() {
        try(Transaction transaction = Transaction.openOuter()) {
            this.energyStorage.extract(energyAmount, transaction);
            transaction.commit();
        }
    }

    private void fillUpOnEnergy() {
        if(hasEnergyItemInEnergySlot(ENERGY_ITEM_SLOT)) {
            try(Transaction transaction = Transaction.openOuter()) {
                this.energyStorage.insert(64, transaction);
                transaction.commit();
            }
        }
    }

    private boolean hasEnergyItemInEnergySlot(int energyItemSlot) {
        return this.getItem(energyItemSlot).getItem() == ModItems.CAULIFLOWER;
    }

    private void craftItem() {
        Optional<RecipeHolder<GemEmpoweringRecipe>> recipe = getCurrentRecipe();

        this.removeItem(INPUT_SLOT, 1);

        this.setItem(OUTPUT_SLOT, new ItemStack(recipe.get().value().getResultItem(null).getItem(),
                this.getItem(OUTPUT_SLOT).getCount() + recipe.get().value().getResultItem(null).getCount()));
    }

    private void resetProgress() {
        this.progress = 0;
        this.maxProgress = DEFAULT_MAX_PROGRESS;
        this.energyAmount = DEFAULT_ENERGY_AMOUNT;
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<GemEmpoweringRecipe>> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        }
        ItemStack output = recipe.get().value().getResultItem(null);
        this.maxProgress = recipe.get().value().getCraftTime();
        this.energyAmount = recipe.get().value().getEnergyAmount();

        return canInsertAmountIntoOutputSlot(output.getCount())
                && canInsertItemIntoOutputSlot(output) && hasEnoughEnergyToCraft() && hasEnoughFluidToCraft();
    }

    private boolean hasEnoughFluidToCraft() {
        return this.fluidStorage.amount >= 500; // mB amount!
    }

    private boolean hasEnoughEnergyToCraft() {
        return this.energyStorage.amount >= this.energyAmount * this.maxProgress;
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getItem(OUTPUT_SLOT).isEmpty() || this.getItem(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.getItem(OUTPUT_SLOT).getMaxStackSize() >= this.getItem(OUTPUT_SLOT).getCount() + count;
    }

    private Optional<RecipeHolder<GemEmpoweringRecipe>> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer((this.getContainerSize()));
        for(int i = 0; i < this.getContainerSize(); i++) {
            inventory.setItem(i, this.getItem(i));
        }

        return this.getLevel().getRecipeManager().getRecipeFor(GemEmpoweringRecipe.Type.INSTANCE, inventory, this.getLevel());
    }

    private boolean canInsertIntoOutputSlot() {
        return this.getItem(OUTPUT_SLOT).isEmpty() ||
                this.getItem(OUTPUT_SLOT).getCount() < this.getItem(OUTPUT_SLOT).getMaxStackSize();
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

}
