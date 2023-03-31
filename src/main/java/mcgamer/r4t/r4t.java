package mcgamer.r4t;

import mcgamer.r4t.enchantments.ModEnchantments;
import mcgamer.r4t.particle.ModParticles;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mcgamer.r4t.block.ModBlocks;
import mcgamer.r4t.item.ModItems;

public class r4t implements ModInitializer {
	public static final String MOD_ID = "r4t";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModEnchantments.registerModEnchantments();

		ModParticles.registerParticles();

	}
}