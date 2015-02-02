package eu.matejkormuth.bukkit.inventory;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Armor {
    protected final ItemStack[] armor;

    protected Armor() {
        this.armor = new ItemStack[4];
    }

    public Armor(final ItemStack helmet, final ItemStack chestplate,
            final ItemStack leggings, final ItemStack boots) {
        this.armor = new ItemStack[4];
        this.armor[0] = helmet;
        this.armor[1] = chestplate;
        this.armor[2] = leggings;
        this.armor[3] = boots;
    }

    public boolean hasHelmet() {
        return this.armor[0] != null;
    }

    public boolean hasChestplate() {
        return this.armor[1] != null;
    }

    public boolean hasLeggings() {
        return this.armor[2] != null;
    }

    public boolean hasBoots() {
        return this.armor[3] != null;
    }

    public ItemStack getHelmet() {
        return this.armor[0];
    }

    public ItemStack getChestplate() {
        return this.armor[1];
    }

    public ItemStack getLeggings() {
        return this.armor[2];
    }

    public ItemStack getBoots() {
        return this.armor[3];
    }

    public ItemStack[] toArray() {
        return this.armor;
    }

    public void apply(Player player) {
        player.getInventory().setHelmet(this.armor[0]);
        player.getInventory().setChestplate(this.armor[1]);
        player.getInventory().setLeggings(this.armor[2]);
        player.getInventory().setBoots(this.armor[3]);
    }

    public static Armor createLether(Color color) {
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta im = helmet.getItemMeta();
        ((LeatherArmorMeta) im).setColor(color);
        helmet.setItemMeta(im);

        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        chestplate.setItemMeta(im);
        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        leggings.setItemMeta(im);
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        boots.setItemMeta(im);

        return new Armor(helmet, chestplate, leggings, boots);
    }
}
