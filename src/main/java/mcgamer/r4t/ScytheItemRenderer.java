package mcgamer.r4t;

import mcgamer.r4t.item.custom.ScytheItem;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.resource.ResourceReloadListenerKeys;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceReload;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.Collections;

public class ScytheItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer, SimpleSynchronousResourceReloadListener {
    private final Identifier id;
    private final Identifier scytheId;
    private ItemRenderer itemRenderer;
    private BakedModel inventoryScytheModel;
    private BakedModel worldScytheModel;

    public ScytheItemRenderer(Identifier scytheId) {
        this.id = new Identifier("r4t", "scythe");
        this.scytheId = scytheId;
    }

    @Override
    public Identifier getFabricId() {
        return this.id;
    }

    @Override
    public Collection<Identifier> getFabricDependencies() {
        return Collections.singletonList(ResourceReloadListenerKeys.MODELS);
    }

    @Override
    public void reload(ResourceManager manager) {
        final MinecraftClient client = MinecraftClient.getInstance();
        this.itemRenderer = client.getItemRenderer();
        this.inventoryScytheModel = client.getBakedModelManager().getModel(new ModelIdentifier(this.scytheId + "_gui",
                "inventory"));
        this.worldScytheModel = client.getBakedModelManager().getModel(new ModelIdentifier(this.scytheId + "_handheld",
                "inventory"));
        System.out.println("Reloading scythe item renderer...");
    }
    @Override
    public void render(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers,
                       int light, int overlay) {
        System.out.println("Rendering scythe item...");
        matrices.pop();
        matrices.push();
        if(mode != ModelTransformation.Mode.FIRST_PERSON_LEFT_HAND && mode != ModelTransformation.Mode.FIRST_PERSON_RIGHT_HAND
        && mode != ModelTransformation.Mode.THIRD_PERSON_LEFT_HAND && mode != ModelTransformation.Mode.THIRD_PERSON_RIGHT_HAND) {
            itemRenderer.renderItem(stack, mode, false, matrices, vertexConsumers, light, overlay, this.inventoryScytheModel);
        } else {
            boolean leftHanded;
            switch (mode) {
                case FIRST_PERSON_LEFT_HAND, THIRD_PERSON_LEFT_HAND -> leftHanded = true;
                default -> leftHanded = true;
            }
            itemRenderer.renderItem(stack, mode, leftHanded, matrices, vertexConsumers, light, overlay, this.worldScytheModel);
        }
    }
}
