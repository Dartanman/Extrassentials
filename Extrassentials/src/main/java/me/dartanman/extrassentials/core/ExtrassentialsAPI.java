package me.dartanman.extrassentials.core;

import me.dartanman.extrassentials.core.commands.ExtrassentialsCommand;
import me.dartanman.extrassentials.core.players.EPlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class ExtrassentialsAPI
{

    private static ExtrassentialsAPI api;

    private final EPlayerManager ePlayerManager;
    private final Extrassentials plugin;

    public ExtrassentialsAPI()
    {
        ePlayerManager = new EPlayerManager();
        plugin = JavaPlugin.getPlugin(Extrassentials.class);
    }

    public static ExtrassentialsAPI getInstance()
    {
        if(api == null)
        {
            api = new ExtrassentialsAPI();
        }
        return api;
    }

    public EPlayerManager getEPlayerManager()
    {
        return ePlayerManager;
    }

    public String getVersion()
    {
        return plugin.getDescription().getVersion();
    }

    public List<String> getAuthors()
    {
        return plugin.getDescription().getAuthors();
    }

    public String getAuthorsAsString()
    {
        StringBuilder authorStringBuilder = new StringBuilder();
        List<String> authors = getAuthors();
        if(authors.size() == 1)
        {
            authorStringBuilder = new StringBuilder(authors.get(0));
        }
        else if (authors.size() == 2)
        {
            authorStringBuilder = new StringBuilder(authors.get(0) + " and " + authors.get(1));
        }
        else
        {
            for (String author : authors) {
                authorStringBuilder.append(author).append(", ");
            }
        }
        if(authors.size() > 2)
        {
            return authorStringBuilder.substring(0, authorStringBuilder.length() - 2);
        }
        return authorStringBuilder.toString();
    }

}
