package me.dartanman.extrassentials.core;

import me.dartanman.extrassentials.core.files.FileManager;
import me.dartanman.extrassentials.join.listeners.JoinListener;
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

		boolean esJoinEnabled = FileManager.getConfig().getBoolean("Extrassentials-Join.Enabled");

		if(esJoinEnabled)
		{
			enableExtrassentialsJoin();
		}
	}

	/**
	 * Enables the core module
	 */
	private void enableCore()
	{
		FileManager.init();
	}

	/**
	 * Enables the Extrassentials-Join module
	 */
	private void enableExtrassentialsJoin()
	{
		getServer().getPluginManager().registerEvents(new JoinListener(), this);
	}

}
