package me.dartanman.extrassentials.players;

import java.util.UUID;

import org.bukkit.entity.Player;

import me.dartanman.extrassentials.utils.StringUtils;

/**
 * EPlayer -- Extrassentials Player wrapper. Used for convenience (improvement over the Player class)
 * @author Austin Dart (Dartanman)
 */
public class EPlayer 
{
	
	private UUID uuid;
	
	private Player player;
	
	public EPlayer(Player player)
	{
		this.player = player;
		this.uuid = player.getUniqueId();
	}
	
	public UUID getUniqueId()
	{
		return uuid;
	}
	
	public void sendColoredMessage(String message)
	{
		message = StringUtils.colorize(message);
		player.sendMessage(message);
	}

}
