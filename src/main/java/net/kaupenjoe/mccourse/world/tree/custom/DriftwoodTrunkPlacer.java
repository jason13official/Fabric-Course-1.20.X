package net.kaupenjoe.mccourse.world.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.kaupenjoe.mccourse.world.tree.ModTrunkPlacerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import java.util.List;
import java.util.function.BiConsumer;

public class DriftwoodTrunkPlacer extends TrunkPlacer {
    public static final Codec<DriftwoodTrunkPlacer> CODEC = RecordCodecBuilder.create(driftwoodTrunkPlacerInstance ->
            trunkPlacerParts(driftwoodTrunkPlacerInstance).apply(driftwoodTrunkPlacerInstance, DriftwoodTrunkPlacer::new));

    public DriftwoodTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.DRIFTWOOD_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> replacer, RandomSource random,
                                                 int height, BlockPos startPos, TreeConfiguration config) {
        // BLOCK PLACING LOGIC GOES RIGHT HERE
        setDirtAt(world, replacer, random, startPos.below(), config);
        // getAndSetState() places down a Log

       int height_ = height + random.nextIntBetweenInclusive(heightRandA, heightRandA + 3) +
       random.nextIntBetweenInclusive(heightRandB - 2, heightRandB + 2);

        for(int i = 0; i < height_; i++) {
            placeLog(world, replacer, random, startPos.above(i), config);

            if(i % 2 == 0 && random.nextBoolean()) {
                if(random.nextFloat() > 0.25f) {
                    for(int x = 0; x < 4; x++) {
                        placeLog(world, replacer, random, startPos.above(i).relative(Direction.NORTH, x), config);
                    }
                }

                if(random.nextFloat() > 0.25f) {
                    for(int x = 0; x < 4; x++) {
                        placeLog(world, replacer, random, startPos.above(i).relative(Direction.SOUTH, x), config);
                    }
                }

                if(random.nextFloat() > 0.25f) {
                    for(int x = 0; x < 4; x++) {
                        placeLog(world, replacer, random, startPos.above(i).relative(Direction.EAST, x), config);
                    }
                }

                if(random.nextFloat() > 0.25f) {
                    for(int x = 0; x < 4; x++) {
                        placeLog(world, replacer, random, startPos.above(i).relative(Direction.WEST, x), config);
                    }
                }
            }
        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(startPos.above(height_), 0, false));
    }
}
