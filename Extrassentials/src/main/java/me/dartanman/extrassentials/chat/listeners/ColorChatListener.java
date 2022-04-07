package me.dartanman.extrassentials.chat.listeners;

import me.dartanman.extrassentials.Permissions;
import me.dartanman.extrassentials.core.utils.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ColorChatListener implements Listener
{
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event)
    {
        Player player = event.getPlayer();
        String message = event.getMessage();
        if(player.hasPermission(Permissions.COLOR_CHAT))
        {
            event.setMessage(StringUtils.colorize(message));
        }
    }
}
