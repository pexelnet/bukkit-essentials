package eu.matejkormuth.bukkit;

import org.bukkit.event.block.Action;

public class Actions {
    public static final boolean isRightClick(Action action) {
        return action.equals(Action.RIGHT_CLICK_AIR)
                || action.equals(Action.RIGHT_CLICK_BLOCK);
    }

    public static final boolean isLeftClick(Action action) {
        return action.equals(Action.LEFT_CLICK_AIR)
                || action.equals(Action.LEFT_CLICK_BLOCK);
    }

    public static final boolean isPhysical(Action action) {
        return action.equals(Action.PHYSICAL);
    }
}
