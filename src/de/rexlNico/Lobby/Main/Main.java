package de.rexlNico.Lobby.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.rexlNico.Lobby.Listeners.Join;
import de.rexlNico.Lobby.Methodes.configAPI;

public class Main extends JavaPlugin{

	public static Main plugin;
	private PluginManager pm = Bukkit.getPluginManager();
	
	@Override
	public void onEnable() {
		plugin = this;
		cfgToList();
		register();
		Bukkit.getConsoleSender().sendMessage("§erexlVorbau §aAktiviert");
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static Main getPlugin() {
		return plugin;
	}
	
	public void register(){
		pm.registerEvents(new Join(), this);
		
		
	}
	
	public static void cfgToList(){
		if(!configAPI.Serverfile.exists()){
			List<String> player = new ArrayList<>();
			player.add("TESTNAME");
			configAPI.servercfg.set("Players", player);
			try {
				configAPI.servercfg.save(configAPI.Serverfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
