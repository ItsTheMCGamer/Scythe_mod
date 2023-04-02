package mcgamer.r4t.item;

import mcgamer.r4t.item.custom.ScytheItem;
import mcgamer.r4t.r4t;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
	public static final Item SILVER_INGOT = registerItem("silver_ingot",
           new Item(new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item SCYTHE = registerItem("scythe",
            new SwordItem(ModToolMaterial.STEEL, 4, -2.4f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(r4t.MOD_ID, name), item);
    }

    public static void registerModItems() {
        r4t.LOGGER.debug("Registering Mod Items for " + r4t.MOD_ID);
    }
}
