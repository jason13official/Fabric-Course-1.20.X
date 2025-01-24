package net.kaupenjoe.mccourse.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class ModParticles {
    public static final SimpleParticleType PINK_GARNET_PARTICLE =
            registerParticle("pink_garnet_particle", FabricParticleTypes.simple());


    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, new ResourceLocation(MCCourseMod.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        MCCourseMod.LOGGER.info("Registering Particles for " + MCCourseMod.MOD_ID);
    }
}
