import static org.junit.Assert.*;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;
import org.junit.Test;

import eu.matejkormuth.bukkit.Region;
import eu.matejkormuth.bukkit.Worlds;

public class RegionTest {

    @Test
    public void test() {
        Region region = new Region(Vector.getRandom(), Vector.getRandom(),
                Worlds.first());
        for (Block b : region) {
            b.setType(Material.STONE);
        }
    }
}
