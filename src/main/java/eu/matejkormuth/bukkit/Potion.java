package eu.matejkormuth.bukkit;

import org.bukkit.potion.PotionType;

public class Potion extends org.bukkit.potion.Potion {
    public Potion(final PotionType type) {
        super(type);
    }

    public Potion(final PotionType type, final int level) {
        super(type, level);
    }

    public Potion splash() {
        this.setSplash(true);
        return this;
    }
}
