package de.palkuchen.cakecloud.thesurvival;

import de.palkuchen.cakecloud.thesurvival.buff.Buff;
import de.palkuchen.cakecloud.thesurvival.fighting.DamageEvents;
import de.palkuchen.cakecloud.thesurvival.user.UserHandler;
import de.palkuchen.cakecloud.thesurvival.worldGen.CustomChunkGenerator;
import org.bukkit.Bukkit;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.logging.Level;

public final class TheSurvival extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("--- The Survival ---");
        registerListener();
        System.out.println("--- The Survival ---");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    /*
    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        getLogger().log(Level.WARNING, "CustomChunkGenerator is used!");
        return new CustomChunkGenerator(); // Return an instance of the chunk generator we want to use.
    }
     */

    public boolean registerListener() {
        try {
            PluginManager pluginManager = Bukkit.getPluginManager();
            pluginManager.registerEvents(new DamageEvents(), this);
            pluginManager.registerEvents(new UserHandler(), this);

            System.out.println("Success - Listener loaded properly");
            return true;
        } catch (Exception e) {
            System.out.println("ERROR - Listener didn't load properly!");
            return false;
        }
    }

}
