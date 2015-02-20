package eu.matejkormuth.bukkit;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import eu.matejkormuth.bukkit.inventory.ItemStackBuilder;

public class Items {
    public static final ItemStack of(Material material) {
        return of(material, 1);
    }

    private static final ItemStack of(Material material, int amount) {
        return new ItemStack(material, amount);
    }

    public static final ItemStack named(String name, Material material) {
        return new ItemStackBuilder(material).name(name).build();
    }
}
