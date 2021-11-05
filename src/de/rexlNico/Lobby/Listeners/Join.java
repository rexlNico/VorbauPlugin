package de.rexlNico.Lobby.Listeners;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.rexlNico.Lobby.Methodes.configAPI;

public class Join implements Listener{

	@EventHandler
	public void on(PlayerJoinEvent e){
		e.setJoinMessage(null);
		File file = configAPI.Serverfile;
		YamlConfiguration cfg = configAPI.servercfg;
		Player p = e.getPlayer();
		List<String> player = cfg.getStringList("Players");
		if(player.contains(p.getName())){
			if(!p.getUniqueId().toString().equals(cfg.getString(p.getName()))){
				p.kickPlayer("");
			}else{
				if(p.isOp()){
					Bukkit.broadcastMessage("§aDer Spieler §4"+p.getName()+" §aist dem Server beigetreten.");
				}else{
					Bukkit.broadcastMessage("§aDer Spieler §6"+p.getName()+" §aist dem Server beigetreten.");
				}
			}
		}else{
			player.add(p.getName());
			cfg.set("Players", player);
			cfg.set(p.getName(), p.getUniqueId().toString());
			try {
				cfg.save(file);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			if(p.isOp()){
				Bukkit.broadcastMessage("§aDer Spieler §4"+p.getName()+" §aist dem Server beigetreten.");
			}else{
				Bukkit.broadcastMessage("§aDer Spieler §6"+p.getName()+" §aist dem Server beigetreten.");
			}
			
		}
	}
}
