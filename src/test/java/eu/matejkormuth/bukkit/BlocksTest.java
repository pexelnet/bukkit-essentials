package eu.matejkormuth.bukkit;

import static org.junit.Assert.*;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.junit.Test;
import org.mockito.Mockito;

public class BlocksTest {
    @Test
    public void testWater1() {
        Block waterBlock = Mockito.mock(Block.class);
        waterBlock.setType(Material.WATER);
        assertTrue("water is not water", Blocks.isWater(waterBlock));
    }

    @Test
    public void testWater2() {
        Block waterBlock = Mockito.mock(Block.class);
        waterBlock.setType(Material.STATIONARY_WATER);
        assertTrue("static water is not water", Blocks.isWater(waterBlock));
    }

    @Test
    public void testLava1() {
        Block lavaBlock = Mockito.mock(Block.class);
        lavaBlock.setType(Material.LAVA);
        assertTrue("lava is not lava", Blocks.isLava(lavaBlock));
    }

    @Test
    public void testLava2() {
        Block lavaBlock = Mockito.mock(Block.class);
        lavaBlock.setType(Material.STATIONARY_LAVA);
        assertTrue("static lava is not lava", Blocks.isLava(lavaBlock));
    }

    @Test
    public void testSign1() {
        Block block = Mockito.mock(Block.class);
        block.setType(Material.WALL_SIGN);
        assertTrue("wall sign is not sign", Blocks.isSign(block));
    }

    @Test
    public void testSign2() {
        Block block = Mockito.mock(Block.class);
        block.setType(Material.SIGN_POST);
        assertTrue("post sign is not sign", Blocks.isSign(block));
    }

    @Test
    public void testSign3() {
        Block block = Mockito.mock(Block.class);
        block.setType(Material.SIGN);
        assertTrue("sign is not sign", Blocks.isSign(block));
    }

    @Test
    public void testGlassPane1() {
        Block block = Mockito.mock(Block.class);
        block.setType(Material.THIN_GLASS);
        assertTrue("this glass is not glass pane", Blocks.isGlassPane(block));
    }

    @Test
    public void testGlassPane2() {
        Block block = Mockito.mock(Block.class);
        block.setType(Material.STAINED_GLASS_PANE);
        assertTrue("stained glass pane is not glass pane",
                Blocks.isGlassPane(block));
    }

}
