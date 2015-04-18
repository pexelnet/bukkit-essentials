package eu.matejkormuth.bukkit;

import net.minecraft.server.v1_8_R2.EntityItem;
import net.minecraft.server.v1_8_R2.World;

import org.apache.commons.lang.Validate;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftItem;
import org.bukkit.craftbukkit.v1_8_R2.inventory.CraftItemStack;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class ItemDrops {
    public static final Item drop(Location loc, ItemStack is) {
        return loc.getWorld().dropItem(loc, is);
    }

    public static final Item dropNotMergable(Location loc, ItemStack is) {
        Validate.notNull(is, "Cannot drop a Null item.");
        Validate.isTrue(is.getType() != Material.AIR, "Cannot drop AIR.");
        World w = ((CraftWorld) loc.getWorld()).getHandle();
        EntityItem entity = new EntityItem(
                w, loc.getX(),
                loc.getY(), loc.getZ(), CraftItemStack.asNMSCopy(is)) {
            @SuppressWarnings("unused")
            private void w() {
                // Do not merge item stacks.
            }
        };
        entity.pickupDelay = 10;
        w.addEntity(entity);

        return new CraftItem(w.getServer(), entity);
    }

    public static final Item dropNotMergable(Location loc, ItemStack is,
            int pickupDeplay) {
        Validate.notNull(is, "Cannot drop a Null item.");
        Validate.isTrue(is.getType() != Material.AIR, "Cannot drop AIR.");
        World w = ((CraftWorld) loc.getWorld()).getHandle();
        EntityItem entity = new EntityItem(
                w, loc.getX(),
                loc.getY(), loc.getZ(), CraftItemStack.asNMSCopy(is)) {
            @SuppressWarnings("unused")
            private void w() {
                // Do not merge item stacks.
            }
        };
        entity.pickupDelay = pickupDeplay;
        w.addEntity(entity);

        return new CraftItem(w.getServer(), entity);
    }

    public static final Item setPickUpDeplay(Item is, int ticks) {
        is.setPickupDelay(ticks);
        return is;
    }
}
