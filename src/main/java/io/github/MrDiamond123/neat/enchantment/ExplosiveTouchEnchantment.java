package io.github.MrDiamond123.neat.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class ExplosiveTouchEnchantment extends Enchantment {
    public ExplosiveTouchEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMinimumPower(int level) {
        return 14 + level * 3;
    }

    @Override
    public int getMaximumPower(int level) {
        return 21 + level * 3;
    }

    @Override
    public int getMaximumLevel() {
        return 3;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            World world = user.getEntityWorld();
            world.createExplosion(target, DamageSource.explosion(user), target.getX(), target.getY(), target.getZ(), 1 + level / 2, false, Explosion.DestructionType.NONE);
        }
        super.onTargetDamaged(user, target, level);
    }
}

