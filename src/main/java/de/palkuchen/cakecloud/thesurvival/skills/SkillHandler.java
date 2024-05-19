package de.palkuchen.cakecloud.thesurvival.skills;

import de.palkuchen.cakecloud.thesurvival.user.CustomPlayer;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.logging.Level;

public class SkillHandler {

    public static void update(CustomPlayer player, double xp, Skill skill) {
        int oldLevel = player.getSkillLevel(skill);
        // calculates the level with new XP gain
        int newLevel = getLevel(xp + player.getSkillXp(skill));

        player.getPlayer().sendMessage("XP: " + xp); // debug
        player.setSkillXp(skill, xp + player.getSkillXp(skill));
        if (newLevel > oldLevel) {
            // Level updates,
            // meaning that the player levels up one or multiple levels

            player.setLevel(skill, newLevel);
            player.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR,
                    new TextComponent("§7" +
                            skill.name() + " §c" + oldLevel + " §8-> §a" + newLevel));
        }
    }

    public static int getLevel(double xp) {
        return (int) Math.pow(xp, 0.4);
    }
}
