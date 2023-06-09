package mcgamer.r4t.enchantments;

import mcgamer.r4t.r4t;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModEnchantments {
    public static Enchantment BLOOD_BLADES = register("blood_blades",
            new BloodBladesEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(r4t.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Register ModEnchantments for" + r4t.MOD_ID);
    }

}
