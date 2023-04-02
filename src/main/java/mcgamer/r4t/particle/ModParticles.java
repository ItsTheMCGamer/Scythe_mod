package mcgamer.r4t.particle;

import mcgamer.r4t.r4t;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModParticles {
    public static final DefaultParticleType BLOOD_BLADES_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType BLOOD_BLADES_PARTICLE2 = FabricParticleTypes.simple();


    public static void registerParticles() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(r4t.MOD_ID, "blood_blades_particle"),
                BLOOD_BLADES_PARTICLE);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(r4t.MOD_ID, "blood_blades_particle2"),
                BLOOD_BLADES_PARTICLE2);
    }
}
