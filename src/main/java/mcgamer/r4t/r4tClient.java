package mcgamer.r4t;

import mcgamer.r4t.particle.ModParticles;
import mcgamer.r4t.particle.custom.BloodBladesParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

public class r4tClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ParticleFactoryRegistry.getInstance().register(ModParticles.BLOOD_BLADES_PARTICLE, BloodBladesParticle.Factory::new);

    }
}