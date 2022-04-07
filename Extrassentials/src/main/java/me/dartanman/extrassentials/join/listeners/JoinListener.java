package me.dartanman.extrassentials.join.listeners;

import me.dartanman.extrassentials.core.files.FileManager;
import me.dartanman.extrassentials.core.utils.StringUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener
{

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        String joinMessage = StringUtils.colorize(FileManager.getConfig().getString("Extrassentials-Join.Custom-Join-Message"));
        joinMessage = joinMessage.replace("<player>", event.getPlayer().getName());
        event.setJoinMessage(joinMessage);
    }

}
