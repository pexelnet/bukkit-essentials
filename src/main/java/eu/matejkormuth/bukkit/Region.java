package eu.matejkormuth.bukkit;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import eu.matejkormuth.bukkit.iterators.BlockIterator;
import eu.matejkormuth.bukkit.iterators.block.HighestBlockIterator;

public class Region implements Iterable<Block> {
    private Vector min;
    private Vector max;
    private World world;

    public Region(Location location1, Location location2) {
        if (location1.getWorld() != location2.getWorld()) {
            throw new IllegalArgumentException(
                    "Locations must be from the same world!");
        }
        this.ctor(location1.toVector(), location2.toVector(),
                location1.getWorld());
    }

    public Region(Vector vector1, Vector vector2, World world) {
        this.ctor(vector1, vector2, world);
    }

    // Constructor that does not have to be first statement in another
    // contructor.
    private void ctor(Vector vector1, Vector vector2, World world) {
        this.min = new Vector(Math.min(vector1.getX(), vector2.getX()),
                Math.min(vector1.getY(), vector2.getY()), Math.min(
                        vector1.getZ(), vector2.getZ()));
        this.max = new Vector(Math.max(vector1.getX(), vector2.getX()),
                Math.max(vector1.getY(), vector2.getY()), Math.max(
                        vector1.getZ(), vector2.getZ()));
        this.world = world;
    }

    public BlockIterator iterator() {
        return new Itr();
    }

    public HighestBlockIterator surfaceIterator() {
        return new HighestBlockIterator(this);
    }

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<Player>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (this.intersects(player.getLocation())) {
                players.add(player);
            }
        }
        return players;
    }

    public boolean intersects(Location location) {
        if (location.getWorld() != this.world) {
            return false;
        }
        return this.intersects(location.toVector());
    }

    public boolean intersects(Vector vector) {
        return inRange(vector.getX(), this.min.getX(), this.max.getX())
                && inRange(vector.getY(), this.min.getY(), this.max.getY())
                && inRange(vector.getZ(), this.min.getZ(), this.max.getZ());
    }

    public Vector getMax() {
        return max;
    }

    public Vector getMin() {
        return min;
    }

    public World getWorld() {
        return world;
    }

    public double getWidth() {
        return this.max.getX() - this.min.getX();
    }

    public double getHeight() {
        return this.max.getY() - this.min.getY();
    }

    public double getLength() {
        return this.max.getZ() - this.min.getZ();
    }

    private class Itr implements BlockIterator {
        private int cx;
        private int cy;
        private int cz;

        public boolean hasNext() {
            return cx <= max.getBlockX() && cy <= max.getBlockY()
                    && cz <= max.getBlockZ();
        }

        public Block next() {
            if (cz <= max.getBlockZ()) {
                cz++;
            } else {
                if (cy <= max.getBlockY()) {
                    cy++;
                } else {
                    if (cx <= max.getBlockX()) {
                        cx++;
                    } else {
                        cz = min.getBlockX();
                    }
                    cy = min.getBlockY();
                }
                cz = min.getBlockZ();
            }
            return world.getBlockAt(cx, cy, cz);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static boolean inRange(double val, double min, double max) {
        return val >= min && val <= max;
    }
}
