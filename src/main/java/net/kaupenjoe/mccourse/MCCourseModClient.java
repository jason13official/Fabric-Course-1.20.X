package net.kaupenjoe.mccourse;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.block.entity.ModBlockEntities;
import net.kaupenjoe.mccourse.block.entity.renderer.GemEmpoweringBlockEntityRenderer;
import net.kaupenjoe.mccourse.entity.ModBoats;
import net.kaupenjoe.mccourse.entity.ModEntities;
import net.kaupenjoe.mccourse.entity.client.MagicProjectileModel;
import net.kaupenjoe.mccourse.entity.client.MagicProjectileRenderer;
import net.kaupenjoe.mccourse.entity.client.PorcupineModel;
import net.kaupenjoe.mccourse.entity.client.PorcupineRenderer;
import net.kaupenjoe.mccourse.entity.layer.ModModelLayers;
import net.kaupenjoe.mccourse.fluid.ModFluids;
import net.kaupenjoe.mccourse.networking.ModMessages;
import net.kaupenjoe.mccourse.particle.ModParticles;
import net.kaupenjoe.mccourse.particle.PinkGarnetParticle;
import net.kaupenjoe.mccourse.screen.GemEmpoweringScreen;
import net.kaupenjoe.mccourse.screen.KaupenFurnaceScreen;
import net.kaupenjoe.mccourse.screen.ModScreenHandlers;
import net.kaupenjoe.mccourse.util.ModModelPredicateProvider;
import net.kaupenjoe.mccourse.util.ModWoodTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.level.FoliageColor;

public class MCCourseModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_TRAPDOOR, RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAULIFLOWER_CROP, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PETUNIA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_PETUNIA, RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIFTWOOD_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CATTAIL_CROP, RenderType.cutout());

        ModModelPredicateProvider.registerModModels();

        ParticleFactoryRegistry.getInstance().register(ModParticles.PINK_GARNET_PARTICLE, PinkGarnetParticle.Factory::new);

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_SOAP_WATER, ModFluids.FLOWING_SOAP_WATER,
                SimpleFluidRenderHandler.coloredWater(0xA1E038D0));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(),
                ModFluids.STILL_SOAP_WATER, ModFluids.FLOWING_SOAP_WATER);

        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> new ModelResourceLocation(MCCourseMod.MOD_ID, "radiation_staff_3d", "inventory"));

        MenuScreens.register(ModScreenHandlers.GEM_EMPOWERING_SCREEN_HANDLER, GemEmpoweringScreen::new);
        MenuScreens.register(ModScreenHandlers.KAUPEN_FURNACE_SCREEN_HANDLER, KaupenFurnaceScreen::new);

        ModMessages.registerS2CPackets();

        BlockEntityRenderers.register(ModBlockEntities.GEM_EMPOWERING_STATION_BE, GemEmpoweringBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.MOD_SIGN_BLOCK_ENTITY, SignRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY, HangingSignRenderer::new);

        Sheets.SIGN_MATERIALS.put(ModWoodTypes.DRIFTWOOD, Sheets.getSignMaterial(ModWoodTypes.DRIFTWOOD));

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PORCUPINE, PorcupineModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MAGIC_PROJECTILE, MagicProjectileModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.PORCUPINE, PorcupineRenderer::new);
        EntityRendererRegistry.register(ModEntities.THROWN_DICE_PROJECTILE, ThrownItemRenderer::new);
        EntityRendererRegistry.register(ModEntities.MAGIC_PROJECTILE, MagicProjectileRenderer::new);

        TerraformBoatClientHelper.registerModelLayers(ModBoats.DRIFTWOOD_BOAT_ID, false);

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos)
                : FoliageColor.getDefaultColor(), ModBlocks.COLORED_LEAVES);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> FoliageColor.getDefaultColor(), ModBlocks.COLORED_LEAVES);
    }
}
