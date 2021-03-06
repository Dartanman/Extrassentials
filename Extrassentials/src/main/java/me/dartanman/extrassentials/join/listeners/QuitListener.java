package me.dartanman.extrassentials.join.listeners;

import me.dartanman.extrassentials.core.files.FileManager;
import me.dartanman.extrassentials.core.utils.StringUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener
{

    @EventHandler
    public void onQuit(PlayerQuitEvent event)
    {
        String quitMessage = StringUtils.colorize(FileManager.getConfig().getString("Extrassentials-Join.Custom-Quit-Message"));
        quitMessage = quitMessage.replace("<player>", event.getPlayer().getName());
        event.setQuitMessage(quitMessage);
    }

}
