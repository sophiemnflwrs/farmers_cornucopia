package net.sophiemnflwrs.farmerscornucopia.common.utility;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class FCBlockUtility {

    // method for copying one linked blockstate to another.
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static BlockState transferAllBlockStates(BlockState initial, BlockState after) {
        BlockState block = after;
        for (Property property : initial.getBlock().getStateDefinition().getProperties()) {
            if (after.hasProperty(property) && initial.getValue(property) != null) {
                block = block.setValue(property, initial.getValue(property));
            }
        }
        return block;
    }
}
