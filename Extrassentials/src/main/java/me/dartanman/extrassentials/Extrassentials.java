package me.dartanman.extrassentials;

import me.dartanman.extrassentials.files.FileManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Extrassentials Main Class
 * @author Austin Dart (Dartanman)
 */
public class Extrassentials extends JavaPlugin
{
	
	public void onEnable()
	{
		FileManager.init();
		// This will enable everything in the plugin
	}

}
