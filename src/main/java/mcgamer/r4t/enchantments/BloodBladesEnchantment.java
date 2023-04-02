package mcgamer.r4t.enchantments;

import mcgamer.r4t.item.ModItems;
import mcgamer.r4t.item.custom.ScytheItem;
import mcgamer.r4t.particle.ModParticles;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class BloodBladesEnchantment extends Enchantment {

    protected BloodBladesEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity attacker, Hand hand, LivingEntity target,
                                            ServerPlayerEntity player) {
        if (!attacker.world.isClient() && hand == Hand.MAIN_HAND && player.getStackInHand(hand).getItem() == ModItems.SCYTHE) {

            //takes 1.5 hearts
            player.damage(DamageSource.GENERIC, 3.0f);
            //spawns particles
            spawnParticles(player);
            //clear attacker effect
            clearEffects(attacker);
            //add effects to target
            applyStatusEffects(target, attacker);
        }

        return TypedActionResult.pass(player.getStackInHand(hand));
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
    public static void spawnParticles(ServerPlayerEntity player) {
        ServerWorld world = player.getServer().getWorld(player.getEntityWorld().getRegistryKey());
        BlockPos playerPos = player.getBlockPos();
        Vec3d playerLookVec = player.getRotationVec(1.0F);

        // Calculate the start and end positions for the line of particles
        double startX = playerPos.getX() + playerLookVec.x * 15.0;
        double startY = playerPos.getY() + 1.0;
        double startZ = playerPos.getZ() + playerLookVec.z * 15.0;
        double endX = playerPos.getX() + playerLookVec.x * -15.0;
        double endY = playerPos.getY() + 1.0;
        double endZ = playerPos.getZ() + playerLookVec.z * -15.0;

        // Spawn the first particle
        DefaultParticleType particleType1 = ModParticles.BLOOD_BLADES_PARTICLE;
        double particleX1 = startX;
        double particleY1 = startY;
        double particleZ1 = startZ;
        world.spawnParticles(particleType1, particleX1, particleY1, particleZ1, 1, 0.0, 0.0, 0.0, 0.0);

        // Spawn the second particle
        DefaultParticleType particleType2 = ModParticles.BLOOD_BLADES_PARTICLE2;
        double particleX2 = endX;
        double particleY2 = endY;
        double particleZ2 = endZ;
        world.spawnParticles(particleType2, particleX2, particleY2, particleZ2, 1, 0.0, 0.0, 0.0, 0.0);
    }


    @Override
    public int getMaxLevel() {
        return 1;
    }
}