package de.palkuchen.cakecloud.thesurvival.user;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import javax.crypto.CipherInputStream;
import java.util.HashMap;

public class UserHandler implements Listener {

    public static HashMap<String, CustomPlayer> customPlayers = new HashMap<>();

    public static CustomPlayer getCustomPlayer(Player player) {
        return customPlayers.get(player.getUniqueId().toString());
    }

    @EventHandler
    public void onConnect(PlayerJoinEvent e) {
        CustomPlayer player = new CustomPlayer(e.getPlayer());
    }
}
