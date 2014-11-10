package me.GrimReaper52498.mcmmoLevelPrefix;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.nossr50.api.ExperienceAPI;

public class Main extends JavaPlugin implements Listener
{
    
    String brackets =  ChatColor.translateAlternateColorCodes('&', getConfig().getString("Bracket-Color"));
    String num = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Number-Color"));
    
    
    
    public void onEnable()
    {
	getConfig().options().copyDefaults(true);
	saveDefaultConfig();

	getServer().getPluginManager().registerEvents(this, this);
    }

    public void onDisable()
    {

	saveDefaultConfig();
	
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
	event.setFormat(event.getFormat().replace("{LEVEL}", brackets + "[" + num + ExperienceAPI.getPowerLevel(event.getPlayer()) + brackets + "]"));
    }
}