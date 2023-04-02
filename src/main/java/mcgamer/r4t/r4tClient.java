package mcgamer.r4t;

import mcgamer.r4t.item.ModItems;
import mcgamer.r4t.particle.ModParticles;
import mcgamer.r4t.particle.custom.BloodBladesParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;


@Environment(EnvType.CLIENT)
public class r4tClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Register scythe item renderer
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.SCYTHE, new ScytheItemRenderer(new Identifier("r4t", "scythe")));

        // Register scythe item model and texture
        ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(new ScytheItemModelManager());

        ParticleFactoryRegistry.getInstance().register(ModParticles.BLOOD_BLADES_PARTICLE, BloodBladesParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLOOD_BLADES_PARTICLE2, BloodBladesParticle.Factory::new);

    }
}