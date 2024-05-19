package de.palkuchen.cakecloud.thesurvival.user;

import de.palkuchen.cakecloud.thesurvival.skills.Skill;
import de.palkuchen.cakecloud.thesurvival.skills.SkillHandler;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class CustomPlayer {

    private HashMap<Skill, Integer> SkillLevels = new HashMap<>();
    private HashMap<Skill, Double> SkillXp = new HashMap<>();
    private Player player;

    // Extends the basic values saved in a Player by custom game variables
    public CustomPlayer(Player player) {
        this.player = player;

        // Load values from MySQL
        for (Skill skill : Skill.values()) {
            SkillLevels.put(skill, 0);
            SkillXp.put(skill, 0.0);
        }

        /*
        for (Map.Entry<Skill, Integer> skill : SkillLevels.entrySet()) {
            Skill skill1 = skill.getKey();
            int level = skill.getValue();
        }
         */

        UserHandler.customPlayers.put(player.getUniqueId().toString(), this);
    }

    // gets the Skill Level from Hashmap (Could be outdated!)
    public int getSkillLevel(Skill skill) {
        return SkillLevels.get(skill);
    }

    public double getSkillXp(Skill skill) {
        return SkillXp.get(skill);
    }

    public void addSkillXp(Skill skill, double xp) {
        SkillHandler.update(this, xp, skill);
    }

    public void setSkillXp(Skill skill, double xp) {
        SkillXp.put(skill, xp);
    }

    public void setLevel(Skill skill, int level) {
        SkillLevels.put(skill, level);
    }

    public Player getPlayer() {
        return player;
    }
}
