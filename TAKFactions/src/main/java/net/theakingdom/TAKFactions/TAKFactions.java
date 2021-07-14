package net.theakingdom.TAKFactions;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class TAKFactions extends JavaPlugin {

    public static File data;
    public static YamlConfiguration dataConfig;

    public void onEnable() {
        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdir();
        }
        this.loadDataConfig();
    }

    public FileConfiguration loadDataConfig() {
        data = new File(this.getDataFolder(), "ranks.yml");
        if (!data.exists()) {
            try {
                data.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        dataConfig = YamlConfiguration.loadConfiguration(data);
        return dataConfig;
    }
}