package net.kaupenjoe.mccourse.mixin;

import net.kaupenjoe.mccourse.util.IEntityDataSaver;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class ModEntityDataSaverMixin implements IEntityDataSaver {
    private CompoundTag persistentData;

    @Override
    public CompoundTag getPersistentData() {
        if(this.persistentData == null) {
            this.persistentData = new CompoundTag();
        }
        return persistentData;
    }

    @Inject(method = "writeNbt", at = @At("HEAD"))
    protected void injectWriteMethod(CompoundTag nbt, CallbackInfoReturnable<CompoundTag> info) {
        if(this.persistentData != null) {
            nbt.put("mccourse.custom_data", persistentData);
        }
    }

    @Inject(method = "readNbt", at = @At("HEAD"))
    protected void injectReadMethod(CompoundTag nbt, CallbackInfo info) {
        if(nbt.contains("mccourse.custom_data", 10)) {
            this.persistentData = nbt.getCompound("mccourse.custom_data");
        }
    }
}
