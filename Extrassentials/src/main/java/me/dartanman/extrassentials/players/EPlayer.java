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
	
	/**
	 * EPlayer constructor
	 * @param player
	 * 		The Player that this EPlayer wraps
	 */
	public EPlayer(Player player)
	{
		this.player = player;
		this.uuid = player.getUniqueId();
	}
	
	/**
	 * Gets the UUID of the EPlayer -- it is an exact copy of the Player's UUID
	 * @return
	 * 		The UUID of the EPlayer
	 */
	public UUID getUniqueId()
	{
		return uuid;
	}
	
	/**
	 * Sends a colored message. See me.dartanman.extrassentials.utils.StringUtils.colorize(String) to understand how it colors the message
	 * @param message
	 * 		The message to color and send
	 */
	public void sendColoredMessage(String message)
	{
		message = StringUtils.colorize(message);
		player.sendMessage(message);
	}

}
