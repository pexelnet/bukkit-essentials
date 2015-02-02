package eu.matejkormuth.bukkit.inventory;

import org.bukkit.Color;
import org.bukkit.Material;

public class LeatherArmor extends Armor {
	public LeatherArmor() {
		this.armor[0] = new ItemStackBuilder(Material.LEATHER_HELMET).build();
		this.armor[1] = new ItemStackBuilder(Material.LEATHER_CHESTPLATE).build();
		this.armor[2] = new ItemStackBuilder(Material.LEATHER_LEGGINGS).build();
		this.armor[3] = new ItemStackBuilder(Material.LEATHER_BOOTS).build();
	}
	
	public LeatherArmor(Color color) {
		this.armor[0] = new ItemStackBuilder(Material.LEATHER_HELMET).color(color).build();
		this.armor[1] = new ItemStackBuilder(Material.LEATHER_CHESTPLATE).color(color).build();
		this.armor[2] = new ItemStackBuilder(Material.LEATHER_LEGGINGS).color(color).build();
		this.armor[3] = new ItemStackBuilder(Material.LEATHER_BOOTS).color(color).build();
	}
}
