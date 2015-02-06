package eu.matejkormuth.bukkit;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class Blocks {
    public static final boolean isSign(final Block block) {
        if (block == null) {
            return false;
        }

        return block.getType().equals(Material.SIGN)
                || block.getType().equals(Material.SIGN_POST)
                || block.getType().equals(Material.WALL_SIGN);
    }

    public static final boolean isWater(final Block block) {
        if (block == null) {
            return false;
        }

        return block.getType().equals(Material.WATER)
                || block.getType().equals(Material.STATIONARY_WATER);
    }

    public static final boolean isLava(final Block block) {
        if (block == null) {
            return false;
        }

        return block.getType().equals(Material.LAVA)
                || block.getType().equals(Material.STATIONARY_LAVA);
    }

    public static final boolean isGlassPane(final Block block) {
        if (block == null) {
            return false;
        }

        return block.getType().equals(Material.STAINED_GLASS_PANE)
                || block.getType().equals(Material.THIN_GLASS);
    }
}
