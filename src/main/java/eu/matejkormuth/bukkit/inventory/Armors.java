package eu.matejkormuth.bukkit.inventory;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Armors {
    private Armors() {
    }

    public static final Armor EMPTY_ARMOR = new Armor(null, null, null, null);

    public static final Armor LEATHER_ARMOR = new LeatherArmor();

    public static final Armor IRON_ARMOR = new Armor(new ItemStack(
            Material.IRON_HELMET), new ItemStack(Material.IRON_CHESTPLATE),
            new ItemStack(Material.IRON_LEGGINGS), new ItemStack(
                    Material.IRON_BOOTS));
    public static final Armor GOLD_ARMOR = new Armor(new ItemStack(
            Material.GOLD_HELMET), new ItemStack(Material.GOLD_CHESTPLATE),
            new ItemStack(Material.GOLD_LEGGINGS), new ItemStack(
                    Material.GOLD_BOOTS));
    public static final Armor DIAMOND_ARMOR = new Armor(new ItemStack(
            Material.DIAMOND_HELMET),
            new ItemStack(Material.DIAMOND_CHESTPLATE), new ItemStack(
                    Material.DIAMOND_LEGGINGS), new ItemStack(
                    Material.DIAMOND_BOOTS));
    public static final Armor CHAINMAIL_ARMOR = new Armor(new ItemStack(
            Material.CHAINMAIL_HELMET), new ItemStack(
            Material.CHAINMAIL_CHESTPLATE), new ItemStack(
            Material.CHAINMAIL_LEGGINGS), new ItemStack(
            Material.CHAINMAIL_BOOTS));
}
