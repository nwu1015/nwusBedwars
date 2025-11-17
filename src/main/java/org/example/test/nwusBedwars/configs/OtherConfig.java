package org.example.test.nwusBedwars.configs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.example.test.nwusBedwars.NwusBedwars;


import java.io.File;
import java.io.IOException;

public class OtherConfig {
    private File file;
    private FileConfiguration config;

    private static OtherConfig data;

    public OtherConfig(String fileName){
        file = new File(NwusBedwars.getInstance().getDataFolder(), fileName);
        try {
            if(!file.exists() && !file.createNewFile()) throw new IOException();
        } catch (IOException e) {
            throw new RuntimeException("Oh, can't create file 'other.yml'",e);
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void save(){
        try {
            config.save(file);
        } catch (IOException e) {
            throw new RuntimeException("Can't save file 'other.yml'",e);
        }
    }

    public static OtherConfig getData() {
        return data;
    }

    public static void setData(OtherConfig data) {
        OtherConfig.data = data;
    }
}
