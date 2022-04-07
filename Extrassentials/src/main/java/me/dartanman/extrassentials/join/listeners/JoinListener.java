package me.dartanman.extrassentials.join.listeners;

import me.dartanman.extrassentials.Permissions;
import me.dartanman.extrassentials.core.files.FileManager;
import me.dartanman.extrassentials.core.utils.StringUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener
{

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        FileConfiguration config = FileManager.getConfig();
        Player player = event.getPlayer();
        String joinMessage = StringUtils.colorize(config.getString("Extrassentials-Join.Custom-Join-Message"));
        joinMessage = joinMessage.replace("<player>", player.getName());
        event.setJoinMessage(joinMessage);

        boolean silentJoinEnabled = config.getBoolean("Extrassentials-Join.Silent-Join.Enabled");
        if(silentJoinEnabled)
        {
            String silentPermission = Permissions.SILENT_JOIN;
            if(player.hasPermission(silentPermission))
            {
                event.setJoinMessage(null);
            }
        }
    }

}
