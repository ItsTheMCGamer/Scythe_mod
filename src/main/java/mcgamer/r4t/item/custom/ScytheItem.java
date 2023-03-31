package mcgamer.r4t.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.predicate.entity.EntityEffectPredicate;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class ScytheItem extends SwordItem {

    private final Map<StatusEffect, EntityEffectPredicate.EffectData> effects;

    public ScytheItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings,
                      Map<StatusEffect, EntityEffectPredicate.EffectData> effects) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.effects = effects;
    }


    public TypedActionResult<ItemStack> use(World world, PlayerEntity attacker, Hand hand, LivingEntity target) {
        if (!world.isClient() && hand == Hand.MAIN_HAND) {
            //check if enchant is present

            //clear attacker effect
            removeEffect(attacker);
            //add effects to target
            getEffect(target, attacker);
            //add a cooldown
            attacker.getItemCooldownManager().set(this, 20);
        }

        return super.use(world, attacker, hand);
    }

    private void removeEffect(PlayerEntity player) {
        player.removeStatusEffect(StatusEffect.byRawId(1 - 31));
    }

    public static int getEffect(LivingEntity target, PlayerEntity attacker) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;
        int g = 0;
        int h = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        int m = 0;
        int n = 0;
        int o = 0;
        int p = 0;
        int q = 0;
        int r = 0;
        int s = 0;
        int t = 0;
        int u = 0;
        int v = 0;
        int w = 0;
        int x = 0;
        int y = 0;
        int z = 0;
        int aa = 0;
        int ab = 0;
        int ac = 0;
        int ad = 0;
        int ae = 0;
        int af = 0;
        int ag = 0;
        int ah = 0;
        int ai = 0;
        int aj = 0;
        int ak = 0;
        int al = 0;
        int am = 0;
        int an = 0;
        int ao = 0;
        int ap = 0;
        int aq = 0;
        int ar = 0;
        int as = 0;
        int at = 0;
        int au = 0;
        int av = 0;
        int aw = 0;
        int ax = 0;
        int ay = 0;
        int az = 0;
        int ba = 0;
        int bb = 0;
        int bc = 0;
        int bd = 0;
        int be = 0;
        int bf = 0;
        int bg = 0;
        int bh = 0;
        int bi = 0;
        int bj = 0;
        int bk = 0;

        if (attacker.hasStatusEffect(StatusEffects.HASTE)) {
            b = attacker.getStatusEffect(StatusEffects.HASTE).getDuration();
            a = attacker.getStatusEffect(StatusEffects.HASTE).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, b, a));
        }
        if (attacker.hasStatusEffect(StatusEffects.CONDUIT_POWER)) {
            c = attacker.getStatusEffect(StatusEffects.CONDUIT_POWER).getDuration();
            d = attacker.getStatusEffect(StatusEffects.CONDUIT_POWER).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, c, d));
        }
        if (attacker.hasStatusEffect(StatusEffects.HUNGER)) {
            e = attacker.getStatusEffect(StatusEffects.HUNGER).getDuration();
            f = attacker.getStatusEffect(StatusEffects.HUNGER).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, e, f));
        }
        if (attacker.hasStatusEffect(StatusEffects.ABSORPTION)) {
            g = attacker.getStatusEffect(StatusEffects.ABSORPTION).getDuration();
            h = attacker.getStatusEffect(StatusEffects.ABSORPTION).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, g, h));
        }
        if (attacker.hasStatusEffect(StatusEffects.SLOWNESS)) {
            i = attacker.getStatusEffect(StatusEffects.SLOWNESS).getDuration();
            j = attacker.getStatusEffect(StatusEffects.SLOWNESS).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, i, j));
        }
        if (attacker.hasStatusEffect(StatusEffects.BAD_OMEN)) {
            k = attacker.getStatusEffect(StatusEffects.BAD_OMEN).getDuration();
            l = attacker.getStatusEffect(StatusEffects.BAD_OMEN).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, k, l));
        }
        if (attacker.hasStatusEffect(StatusEffects.BLINDNESS)) {
            m = attacker.getStatusEffect(StatusEffects.BLINDNESS).getDuration();
            n = attacker.getStatusEffect(StatusEffects.BLINDNESS).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, m, n));
        }
        if (attacker.hasStatusEffect(StatusEffects.DARKNESS)) {
            o = attacker.getStatusEffect(StatusEffects.DARKNESS).getDuration();
            p = attacker.getStatusEffect(StatusEffects.DARKNESS).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, o, p));
        }
        if (attacker.hasStatusEffect(StatusEffects.DOLPHINS_GRACE)) {
            q = attacker.getStatusEffect(StatusEffects.DOLPHINS_GRACE).getDuration();
            r = attacker.getStatusEffect(StatusEffects.DOLPHINS_GRACE).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, q, r));
        }
        if (attacker.hasStatusEffect(StatusEffects.FIRE_RESISTANCE)) {
            s = attacker.getStatusEffect(StatusEffects.FIRE_RESISTANCE).getDuration();
            t = attacker.getStatusEffect(StatusEffects.FIRE_RESISTANCE).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, s, t));
        }
        if (attacker.hasStatusEffect(StatusEffects.GLOWING)) {
            u = attacker.getStatusEffect(StatusEffects.GLOWING).getDuration();
            v = attacker.getStatusEffect(StatusEffects.GLOWING).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, u, v));
        }
        if (attacker.hasStatusEffect(StatusEffects.HERO_OF_THE_VILLAGE)) {
            w = attacker.getStatusEffect(StatusEffects.HERO_OF_THE_VILLAGE).getDuration();
            x = attacker.getStatusEffect(StatusEffects.HERO_OF_THE_VILLAGE).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, w, x));
        }
        if (attacker.hasStatusEffect(StatusEffects.INVISIBILITY)) {
            y = attacker.getStatusEffect(StatusEffects.INVISIBILITY).getDuration();
            z = attacker.getStatusEffect(StatusEffects.INVISIBILITY).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, y, z));
        }
        if (attacker.hasStatusEffect(StatusEffects.JUMP_BOOST)) {
            aa = attacker.getStatusEffect(StatusEffects.JUMP_BOOST).getDuration();
            ab = attacker.getStatusEffect(StatusEffects.JUMP_BOOST).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, aa, ab));
        }
        if (attacker.hasStatusEffect(StatusEffects.LEVITATION)) {
            ac = attacker.getStatusEffect(StatusEffects.LEVITATION).getDuration();
            ad = attacker.getStatusEffect(StatusEffects.LEVITATION).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, ac, ad));
        }
        if (attacker.hasStatusEffect(StatusEffects.LUCK)) {
            ae = attacker.getStatusEffect(StatusEffects.LUCK).getDuration();
            af = attacker.getStatusEffect(StatusEffects.LUCK).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, ae, af));
        }
        if (attacker.hasStatusEffect(StatusEffects.MINING_FATIGUE)) {
            ag = attacker.getStatusEffect(StatusEffects.MINING_FATIGUE).getDuration();
            ah = attacker.getStatusEffect(StatusEffects.MINING_FATIGUE).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, ag, ah));
        }
        if (attacker.hasStatusEffect(StatusEffects.NAUSEA)) {
            ai = attacker.getStatusEffect(StatusEffects.NAUSEA).getDuration();
            aj = attacker.getStatusEffect(StatusEffects.NAUSEA).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, ai, aj));
        }
        if (attacker.hasStatusEffect(StatusEffects.NIGHT_VISION)) {
            ak = attacker.getStatusEffect(StatusEffects.NIGHT_VISION).getDuration();
            al = attacker.getStatusEffect(StatusEffects.NIGHT_VISION).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, ak, al));
        }
        if (attacker.hasStatusEffect(StatusEffects.POISON)) {
            am = attacker.getStatusEffect(StatusEffects.POISON).getDuration();
            an = attacker.getStatusEffect(StatusEffects.POISON).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, am, an));
        }
        if (attacker.hasStatusEffect(StatusEffects.REGENERATION)) {
            ao = attacker.getStatusEffect(StatusEffects.REGENERATION).getDuration();
            ap = attacker.getStatusEffect(StatusEffects.REGENERATION).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, ao, ap));
        }
        if (attacker.hasStatusEffect(StatusEffects.RESISTANCE)) {
            aq = attacker.getStatusEffect(StatusEffects.RESISTANCE).getDuration();
            ar = attacker.getStatusEffect(StatusEffects.RESISTANCE).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, aq, ar));
        }
        if (attacker.hasStatusEffect(StatusEffects.SLOW_FALLING)) {
            as = attacker.getStatusEffect(StatusEffects.SLOW_FALLING).getDuration();
            at = attacker.getStatusEffect(StatusEffects.SLOW_FALLING).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, as, at));
        }
        if (attacker.hasStatusEffect(StatusEffects.SPEED)) {
            au = attacker.getStatusEffect(StatusEffects.SPEED).getDuration();
            av = attacker.getStatusEffect(StatusEffects.SPEED).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, au, av));
        }
        if (attacker.hasStatusEffect(StatusEffects.STRENGTH)) {
            aw = attacker.getStatusEffect(StatusEffects.STRENGTH).getDuration();
            ax = attacker.getStatusEffect(StatusEffects.STRENGTH).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, aw, ax));
        }
        if (attacker.hasStatusEffect(StatusEffects.UNLUCK)) {
            ay = attacker.getStatusEffect(StatusEffects.UNLUCK).getDuration();
            az = attacker.getStatusEffect(StatusEffects.UNLUCK).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, ay, az));
        }
        if (attacker.hasStatusEffect(StatusEffects.WATER_BREATHING)) {
            ba = attacker.getStatusEffect(StatusEffects.WATER_BREATHING).getDuration();
            bb = attacker.getStatusEffect(StatusEffects.WATER_BREATHING).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, ba, bb));
        }
        if (attacker.hasStatusEffect(StatusEffects.WEAKNESS)) {
            bc = attacker.getStatusEffect(StatusEffects.WEAKNESS).getDuration();
            bd = attacker.getStatusEffect(StatusEffects.WEAKNESS).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, bc, bd));
        }
        if (attacker.hasStatusEffect(StatusEffects.WITHER)) {
            be = attacker.getStatusEffect(StatusEffects.WITHER).getDuration();
            bf = attacker.getStatusEffect(StatusEffects.WITHER).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, be, bf));
        }

        if (attacker.hasStatusEffect(StatusEffects.HASTE)) {
            bg = attacker.getStatusEffect(StatusEffects.HASTE).getDuration();
            bh = attacker.getStatusEffect(StatusEffects.HASTE).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, b, a));
        }
        if (attacker.hasStatusEffect(StatusEffects.HASTE)) {
            b = attacker.getStatusEffect(StatusEffects.HASTE).getDuration();
            a = attacker.getStatusEffect(StatusEffects.HASTE).getAmplifier();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, b, a));
        }

        return a-be;
    }
}
