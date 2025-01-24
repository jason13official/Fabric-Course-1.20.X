package net.kaupenjoe.mccourse.item.custom;

import net.kaupenjoe.mccourse.util.ModTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;

public class PaxelItem extends DiggerItem {
    public PaxelItem(Tier material, float attackDamage, float attackSpeed, Properties settings) {
        super(attackDamage, attackSpeed, material, ModTags.Blocks.PAXEL_MINEABLE, settings);
    }
}
