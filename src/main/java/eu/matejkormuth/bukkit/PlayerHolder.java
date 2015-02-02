package eu.matejkormuth.bukkit;

import org.bukkit.entity.Player;

public interface PlayerHolder {
	Iterable<Player> getPlayers();
	
	int getPlayerCount();
}
