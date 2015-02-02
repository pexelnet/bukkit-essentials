package eu.matejkormuth.bukkit.iterators.block;

import java.util.Iterator;

import org.bukkit.block.Block;

import eu.matejkormuth.bukkit.Region;

public class HighestBlockIterator implements Iterator<Block> {
    private final Region region;
    private int cx;
    private int cz;

    public HighestBlockIterator(final Region region) {
        this.region = region;
        this.cx = region.getMin().getBlockX();
        this.cz = region.getMin().getBlockZ();
    }

    public boolean hasNext() {
        return cx <= this.region.getMax().getBlockX()
                && cz <= this.region.getMax().getBlockZ();
    }

    public Block next() {
        if (cx <= this.region.getMax().getBlockX()) {
            cx++;
        } else {
            if (cz < this.region.getMax().getBlockZ()) {
                cz++;
            } else {
                cz = this.region.getMin().getBlockZ();
            }
            cx = this.region.getMin().getBlockX();
        }
        return this.region.getWorld().getHighestBlockAt(cx, cz);
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
