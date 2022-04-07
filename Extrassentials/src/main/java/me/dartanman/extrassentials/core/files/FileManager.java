package me.dartanman.extrassentials.core.files;

import me.dartanman.extrassentials.core.Extrassentials;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * FileManager -- Manages all of Extrassentials' files
 */
public class FileManager
{

    private static Extrassentials plugin;

    /**
     * Initialize everything that needs to be initialized for FileManager to function
     */
    public static void init()
    {
        plugin = JavaPlugin.getPlugin(Extrassentials.class);
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    /**
     * Get the main Extrassentials configuration file
     * @return
     *      The main Extrassentials configuration file
     */
    public static FileConfiguration getConfig()
    {
        return plugin.getConfig();
    }

    /**
     * Save the main Extrassentials configuration file
     */
    public static void saveConfig()
    {
        plugin.saveConfig();
    }

}
