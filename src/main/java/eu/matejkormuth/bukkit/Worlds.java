package eu.matejkormuth.bukkit;

import java.util.Objects;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public final class Worlds {
    public static final World first() {
        return Bukkit.getWorlds().get(0);
    }

    public static final World by(final Location location) {
        Objects.requireNonNull(location);
        return location.getWorld();
    }

    public static final World by(final String name) {
        Objects.requireNonNull(name);
        return Bukkit.getWorld(name);
    }

    public static final World by(final UUID uuid) {
        Objects.requireNonNull(uuid);
        return Bukkit.getWorld(uuid);
    }

    public static final String nameOfFirst() {
        return Bukkit.getWorlds().get(0).getName();
    }

    public static final String nameOf(final World world) {
        Objects.requireNonNull(world);
        return world.getName();
    }

    public static final String nameOf(final Location location) {
        Objects.requireNonNull(location);
        return location.getWorld().getName();
    }
}
