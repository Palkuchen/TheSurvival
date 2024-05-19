package de.palkuchen.cakecloud.thesurvival.buff.buffs;

import de.palkuchen.cakecloud.thesurvival.buff.Buff;
import de.palkuchen.cakecloud.thesurvival.skills.Skill;
import de.palkuchen.cakecloud.thesurvival.user.CustomPlayer;

public class Strength implements Buff {

    @Override
    public double getValue(CustomPlayer player) {
        return player.getSkillLevel(Skill.Combat);
    }
}
