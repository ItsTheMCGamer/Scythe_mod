package mcgamer.r4t.enchantments;

import mcgamer.r4t.item.custom.ScytheItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class BloodBladesEnchantment extends Enchantment {
    protected BloodBladesEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity attacker, Hand hand, LivingEntity target) {
        if (!attacker.world.isClient() && hand == Hand.MAIN_HAND) {


            //clear attacker effect
            clearEffects(attacker);
            //add effects to target
            applyStatusEffects(target, attacker);
        }

        return null;
    }

    public static void clearEffects(PlayerEntity attacker) {
        for (StatusEffectInstance effect : attacker.getStatusEffects()) {
            attacker.removeStatusEffect(effect.getEffectType());
        }
    }

    public static void applyStatusEffects(LivingEntity target, PlayerEntity attacker) {

        HashMap<StatusEffect, StatusEffectInstance> effects = new HashMap<>();

        // Add all the status effects that the attacker has to the HashMap
        for (StatusEffect effect : Registry.STATUS_EFFECT) {
            if (attacker.hasStatusEffect(effect)) {
                effects.put(effect, attacker.getStatusEffect(effect));
            }
        }

        // Apply all the status effects to the target
        for (Map.Entry<StatusEffect, StatusEffectInstance> entry : effects.entrySet()) {
            target.addStatusEffect(new StatusEffectInstance(entry.getKey(), entry.getValue().getDuration(), entry.getValue().getAmplifier()));
        }
    }


    @Override
    public int getMaxLevel() {
        return 1;
    }
}