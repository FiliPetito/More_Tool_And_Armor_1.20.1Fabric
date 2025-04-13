package com.lykeon.block.entity.renderer;

import com.lykeon.block.entity.custom.MultyPedestalBlockEntity;
import com.lykeon.block.entity.custom.PedestalBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class MultyPedestalBlockEntityRenderer implements BlockEntityRenderer<MultyPedestalBlockEntity> {

    public MultyPedestalBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    @Override
    public void render(MultyPedestalBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        World world = entity.getWorld();
        BlockPos pos = entity.getPos();
        int packedLight = getLightLevel(world, pos);

        float rotation = (entity.getWorld().getTime() + tickDelta) % 360;

        for (int i = 0; i < entity.size(); i++) {
            ItemStack stack = entity.getStack(i);
            if (!stack.isEmpty()) {
                matrices.push();

                // Posizione centrale del blocco
                matrices.translate(0.5, 1.15, 0.5);

                // Offset radiale per disporli in cerchio
                double angle = 2 * Math.PI * i / entity.size();
                double radius = 0.35;
                double dx = Math.cos(angle) * radius;
                double dz = Math.sin(angle) * radius;
                matrices.translate(dx, 0, dz);

                // Rotazione
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation + i * (360f / entity.size())));
                matrices.scale(0.5f, 0.5f, 0.5f);

                // Render dell'item
                itemRenderer.renderItem(stack, ModelTransformationMode.GUI, packedLight,
                        OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, world, 1);

                matrices.pop();
            }
        }
    }

    private int getLightLevel(World world, BlockPos pos) {
        int blockLight = world.getLightLevel(LightType.BLOCK, pos);
        int skyLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(blockLight, skyLight);
    }
}
