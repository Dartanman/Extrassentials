package me.dartanman.extrassentials.chat.commands;

import me.dartanman.extrassentials.Permissions;
import me.dartanman.extrassentials.core.ExtrassentialsAPI;
import me.dartanman.extrassentials.core.files.FileManager;
import me.dartanman.extrassentials.core.players.EPlayer;
import me.dartanman.extrassentials.core.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.UUID;

public class MessageCommand implements CommandExecutor
{

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        FileConfiguration config = FileManager.getConfig();
        if(!(sender instanceof Player))
        {
            String mustBePlayer = StringUtils.colorize(config.getString("Global-Messages.Must-Be-A-Player"));
            sender.sendMessage(mustBePlayer);
            return true;
        }
        Player player = (Player) sender;
        UUID uuid = player.getUniqueId();
        ExtrassentialsAPI api = ExtrassentialsAPI.getInstance();
        EPlayer ePlayer = api.getEPlayerManager().getByUUID(uuid);

        if(args.length <= 1)
        {
            ePlayer.sendColoredMessage(config.getString("Global-Messages.Incorrect-Args").replace("<suggestion>",
                    "/" + label + " <player> <message>"));
            return true;
        }
        else
        {
            String targetName = args[0];
            Player target = Bukkit.getPlayer(targetName);
            if(target == null)
            {
                ePlayer.sendColoredMessage(config.getString("Global-Messages.Target-Offline"));
                return true;
            }
            EPlayer eTarget = api.getEPlayerManager().getByUUID(target.getUniqueId());
            String message = "";
            for (int i = 1; i < args.length; i++)
            {
                message = message.concat(args[i]);
            }
            String sendMessageFormat = StringUtils.colorize(config.getString("Extrassentials-Chat.Private-Message-Format.Sender"))
                    .replace("<sender>", player.getName())
                    .replace("<receiver>", target.getName())
                    .replace("<message>", message);
            String receiveMessageFormat = StringUtils.colorize(config.getString("Extrassentials-Chat.Private-Message-Format.Receiver"))
                    .replace("<sender>", player.getName())
                    .replace("<receiver>", target.getName())
                    .replace("<message>", message);
            if(player.hasPermission(Permissions.COLOR_CHAT))
            {
                ePlayer.sendColoredMessage(sendMessageFormat);
                eTarget.sendColoredMessage(receiveMessageFormat);
            }
            else
            {
                player.sendMessage(sendMessageFormat);
                target.sendMessage(receiveMessageFormat);
            }
            return true;
        }
    }

}
