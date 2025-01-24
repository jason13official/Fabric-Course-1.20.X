package net.kaupenjoe.mccourse.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.kaupenjoe.mccourse.world.tree.ModFoliagePlacerTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class DriftwoodFoliagePlacer extends FoliagePlacer {
    public static final Codec<DriftwoodFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) -> foliagePlacerParts(instance)
            .and(Codec.intRange(0, 12).fieldOf("height").forGetter((placer) -> placer.height)).apply(instance, DriftwoodFoliagePlacer::new));
    private final int height;

    public DriftwoodFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacerTypes.DRIFTWOOD_FOLIAGE_PLACER;
    }

    @Override
    protected void createFoliage(LevelSimulatedReader world, FoliageSetter placer, RandomSource random, TreeConfiguration config, int trunkHeight,
                            FoliageAttachment treeNode, int foliageHeight, int radius, int offset) {
        // CREATE THE FOLIAGE
        // treeNode.getCenter() is the first position ABOVE the last log placed!

        for(int i = 0; i < 4; i++) {
            // placeFoliageBlock(world, placer, random, config, treeNode.getCenter());
            // radius on how many blocks it extends into x and z direction
            // y how much offset in the y direction from treeNode.getCenter()
            // y if it is dependent on i, also offsets each new layer in the y direction

            this.placeLeavesRow(world, placer, random, config, treeNode.pos().above(i), 2, i + 1, treeNode.doubleTrunk());
        }
    }

    @Override
    public int foliageHeight(RandomSource random, int trunkHeight, TreeConfiguration config) {
        return height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }
}
