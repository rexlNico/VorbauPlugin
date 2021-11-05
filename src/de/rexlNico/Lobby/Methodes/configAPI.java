package de.rexlNico.Lobby.Methodes;

import java.io.File;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class configAPI {

	public static File Serverfile = new File("../Setings/Vorbau/config.yml");
	public static YamlConfiguration servercfg = YamlConfiguration.loadConfiguration(Serverfile);
	
}
