package de.palkuchen.cakecloud.thesurvival.fighting;

import de.palkuchen.cakecloud.thesurvival.buff.Buff;
import de.palkuchen.cakecloud.thesurvival.buff.buffs.Strength;
import de.palkuchen.cakecloud.thesurvival.skills.Skill;
import de.palkuchen.cakecloud.thesurvival.user.CustomPlayer;
import de.palkuchen.cakecloud.thesurvival.user.UserHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageEvents implements Listener {

    @EventHandler
    public void onEntityDmgByEntity(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player damager = (Player) e.getDamager();
            e.setDamage(e.getDamage() * new Strength().getValue(UserHandler.getCustomPlayer(damager)));

            CustomPlayer player = UserHandler.getCustomPlayer(damager);
            player.addSkillXp(Skill.Combat, 1);
        }
    }

}
