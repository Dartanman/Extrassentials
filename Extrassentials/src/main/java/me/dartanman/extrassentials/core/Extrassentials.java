package me.dartanman.extrassentials.core;

import me.dartanman.extrassentials.chat.commands.MessageCommand;
import me.dartanman.extrassentials.core.commands.ExtrassentialsCommand;
import me.dartanman.extrassentials.core.files.FileManager;
import me.dartanman.extrassentials.core.listeners.EPlayerListener;
import me.dartanman.extrassentials.join.listeners.JoinListener;
import me.dartanman.extrassentials.join.listeners.QuitListener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Extrassentials Main Class
 * @author Austin Dart (Dartanman)
 */
public class Extrassentials extends JavaPlugin
{
	
	public void onEnable()
	{
		// Enable the core of Extrassentials
		enableCore();
		enableExtrassentialsJoin();
		enableExtrassentialsChat();
	}

	/**
	 * Enables the core module
	 */
	private void enableCore()
	{
		// Setup
		FileManager.init();

		// Events
		getServer().getPluginManager().registerEvents(new EPlayerListener(), this);

		// Commands
		getCommand("extrassentials").setExecutor(new ExtrassentialsCommand());

		// Info
		getLogger().info("Extrassentials-Core has been enabled. The core cannot be disabled (except by uninstalling Extrassentials)");
	}

	/**
	 * Enables the Extrassentials-Join module
	 */
	private void enableExtrassentialsJoin()
	{
		// Setup
		boolean enabled = FileManager.getConfig().getBoolean("Extrassentials-Join.Enabled");

		if(enabled)
		{
			// Events
			getServer().getPluginManager().registerEvents(new JoinListener(), this);
			getServer().getPluginManager().registerEvents(new QuitListener(), this);

			// Commands
			// (there are none right now)

			// Info
			getLogger().info("Extrassentials-Join has been enabled. You may disable it in the Extrassentials config.yml");
		}
		else
		{
			// Info
			getLogger().info("Extrassentials-Join has not been enabled. If you wish to enable this module, do so in the Extrassentials config.yml");
		}
	}

	/**
	 * Enables the Extrassentials-Chat module
	 */
	private void enableExtrassentialsChat()
	{
		// Setup
		boolean enabled = FileManager.getConfig().getBoolean("Extrassentials-Chat.Enabled");

		if(enabled)
		{
			// Events
			// (there are none right now)

			// Commands
			getCommand("message").setExecutor(new MessageCommand());

			// Info
			getLogger().info("Extrassentials-Chat has been enabled. You may disable it in the Extrassentials config.yml");
		}
		else
		{
			// Info
			getLogger().info("Extrassentials-Chat has not been enabled. If you wish to enable this module, do so in the Extrassentials config.yml");
		}
	}

}
