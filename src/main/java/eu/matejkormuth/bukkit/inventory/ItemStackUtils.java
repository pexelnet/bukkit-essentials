package eu.matejkormuth.bukkit.inventory;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemStackUtils {
	public static ItemStack rename(ItemStack itemStack, String name) {
		ItemMeta im = itemStack.getItemMeta();
		im.setDisplayName(ChatColor.RESET + name);
		itemStack.setItemMeta(im);
		return itemStack;
	}
}
