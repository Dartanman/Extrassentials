package me.dartanman.extrassentials.core.players;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * EPlayerManager -- Manages EPlayer objects
 * @author Austin Dart (Dartanman)
 */
public class EPlayerManager 
{
	
	private final List<EPlayer> ePlayerList;
	
	/**
	 * EPlayerManager constructor
	 */
	public EPlayerManager()
	{
		ePlayerList = new ArrayList<>();
	}
	
	/**
	 * Get a list of all the EPlayers
	 * @return
	 * 		List of EPlayers
	 */
	public List<EPlayer> getEPlayerList()
	{
		return ePlayerList;
	}
	
	/**
	 * Add an EPlayer to the list
	 * @param ePlayer
	 * 		EPlayer to add
	 * @return
	 * 		The boolean value of List.add()
	 */
	public boolean addEPlayer(EPlayer ePlayer)
	{
		return ePlayerList.add(ePlayer);
	}
	
	/**
	 * Remove an EPlayer from the list
	 * @param ePlayer
	 * 		EPlayer to remove
	 * @return
	 * 		The boolean value of List.remove()
	 */
	public boolean removeEPlayer(EPlayer ePlayer)
	{
		return ePlayerList.remove(ePlayer);
	}
	
	/**
	 * Get an EPlayer based off of the UUID
	 * @param uuid
	 * 		The UUID
	 * @return
	 * 		The EPlayer, or null if not found
	 */
	public EPlayer getByUUID(UUID uuid)
	{
		for(EPlayer ePlayer : ePlayerList)
		{
			if(ePlayer.getUniqueId().equals(uuid))
			{
				return ePlayer;
			}
		}
		return null;
	}

}
