package me.dartanman.extrassentials.core;

import me.dartanman.extrassentials.core.commands.ExtrassentialsCommand;
import me.dartanman.extrassentials.core.files.FileManager;
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
	}

	/**
	 * Enables the core module
	 */
	private void enableCore()
	{
		FileManager.init();
		getCommand("extrassentials").setExecutor(new ExtrassentialsCommand());
		getLogger().info("Extrassentials-Core has been enabled. The core cannot be disabled (except by uninstalling Extrassentials)");
	}

	/**
	 * Enables the Extrassentials-Join module
	 */
	private void enableExtrassentialsJoin()
	{
		boolean enabled = FileManager.getConfig().getBoolean("Extrassentials-Join.Enabled");

		if(enabled)
		{
			getServer().getPluginManager().registerEvents(new JoinListener(), this);
			getServer().getPluginManager().registerEvents(new QuitListener(), this);
			getLogger().info("Extrassentials-Join has been enabled.");
		}
		else
		{
			getLogger().info("Extrassentials-Join has not been enabled. If you wish to enable this module, do so in the Extrassentials config.yml");
		}
	}

}
