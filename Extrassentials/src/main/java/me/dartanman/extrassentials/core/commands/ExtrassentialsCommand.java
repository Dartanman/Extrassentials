package me.dartanman.extrassentials.core.commands;

import me.dartanman.extrassentials.core.ExtrassentialsAPI;
import me.dartanman.extrassentials.core.files.FileManager;
import me.dartanman.extrassentials.core.utils.StringUtils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ExtrassentialsCommand implements CommandExecutor
{

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        ExtrassentialsAPI api = ExtrassentialsAPI.getInstance();
        sender.sendMessage(ChatColor.BLUE + "Extrassentials Version " + ChatColor.GOLD + api.getVersion() + ChatColor.BLUE + " by " + ChatColor.GOLD + api.getAuthorsAsString());
        return true;
    }

}
