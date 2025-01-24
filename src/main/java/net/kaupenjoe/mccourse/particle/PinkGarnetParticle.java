package net.kaupenjoe.mccourse.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class PinkGarnetParticle extends TextureSheetParticle {
    public PinkGarnetParticle(ClientLevel world, double xCoord, double yCoord, double zCoord,
                                 SpriteSet spriteSet, double xd, double yd, double zd) {
        super(world, xCoord, yCoord, zCoord, xd, yd, zd);

        this.friction = 0.5f;
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;

        this.quadSize *= 0.75f;
        this.lifetime = 10;
        this.setSpriteFromAge(spriteSet);

        this.rCol = 1f;
        this.gCol = 1f;
        this.bCol = 1f;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Factory(SpriteSet spriteProvider) {
            this.sprites = spriteProvider;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel clientWorld,
                                       double x, double y, double z, double xd, double yd, double zd) {
            return new PinkGarnetParticle(clientWorld, x, y, z, this.sprites, xd, yd, zd);
        }
    }
}
