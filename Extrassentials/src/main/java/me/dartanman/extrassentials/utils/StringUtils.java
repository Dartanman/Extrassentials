package me.dartanman.extrassentials.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.md_5.bungee.api.ChatColor;

/**
 * StringUtils -- Utility class for dealing with Strings
 * @author Austin Dart (Dartanman)
 */
public class StringUtils 
{
	
	/**
	 * Colors a string -- looks at both & color codes and hex codes
	 * @param string
	 * 		The string to color
	 * @return
	 * 		The colored string
	 */
	public static String colorize(String string)
	{
		// & color codes
		string = ChatColor.translateAlternateColorCodes('&', string);
		
		// hex codes
		final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
		Matcher match = pattern.matcher(string);
		while(match.find())
		{
			String color = string.substring(match.start(), match.end());
			string = string.replace(color, ChatColor.of(color) + "");
			match = pattern.matcher(string);
		}
		return string;
	}

}
