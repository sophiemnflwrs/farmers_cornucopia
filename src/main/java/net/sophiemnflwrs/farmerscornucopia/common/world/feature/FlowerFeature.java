package net.sophiemnflwrs.farmerscornucopia.common.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;

public class FlowerFeature extends Feature<RandomPatchConfiguration> {
    public FlowerFeature(Codec<RandomPatchConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
        RandomPatchConfiguration config = context.config();
        RandomSource random = context.random();
        BlockPos origin = context.origin();
        WorldGenLevel level = context.level();

        int i = 0;
        int xzSpread = config.xzSpread() + 1;
        int ySpread = config.ySpread() + 1;

        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for(int f = 0; f < config.tries(); ++f) {
            pos.setWithOffset(origin, random.nextInt(xzSpread) - random.nextInt(xzSpread), random.nextInt(ySpread) - random.nextInt(ySpread), random.nextInt(xzSpread) - random.nextInt(xzSpread));
            if ((config.feature().value()).place(level, context.chunkGenerator(), random, pos)) {
                ++i;
            }
        }

        return i > 0;
    }

}
