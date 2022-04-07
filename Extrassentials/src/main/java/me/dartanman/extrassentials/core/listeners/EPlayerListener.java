package me.dartanman.extrassentials.core.listeners;

import me.dartanman.extrassentials.core.ExtrassentialsAPI;
import me.dartanman.extrassentials.core.players.EPlayer;
import me.dartanman.extrassentials.core.players.EPlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class EPlayerListener implements Listener
{

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        EPlayer ePlayer = new EPlayer(player);

        ExtrassentialsAPI api = ExtrassentialsAPI.getInstance();
        EPlayerManager ePlayerManager = api.getEPlayerManager();
        ePlayerManager.addEPlayer(ePlayer);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        ExtrassentialsAPI api = ExtrassentialsAPI.getInstance();
        EPlayerManager ePlayerManager = api.getEPlayerManager();
        EPlayer ePlayer = ePlayerManager.getByUUID(uuid);
        ePlayerManager.removeEPlayer(ePlayer);
    }

}
