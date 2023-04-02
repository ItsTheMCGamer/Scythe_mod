package mcgamer.r4t;

import mcgamer.r4t.ScytheItemRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.item.Item;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class ScytheItemModelManager implements IdentifiableResourceReloadListener {
    private static final ScytheItemRenderer SCYTHE_ITEM_RENDERER = new ScytheItemRenderer(new Identifier("r4t", "scythe"));

    public static void registerScytheItemModel(Item scytheItem) {
        BuiltinItemRendererRegistry.INSTANCE.register(scytheItem, SCYTHE_ITEM_RENDERER);
    }

    @Override
    public Identifier getFabricId() {
        return null;
    }

    @Override
    public CompletableFuture<Void> reload(Synchronizer synchronizer, ResourceManager manager, Profiler prepareProfiler, Profiler applyProfiler, Executor prepareExecutor, Executor applyExecutor) {
        return null;
    }
}
