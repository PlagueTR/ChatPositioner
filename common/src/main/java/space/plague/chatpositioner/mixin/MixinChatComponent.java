package space.plague.chatpositioner.mixin;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.components.ChatComponent;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import space.plague.chatpositioner.Main;
import space.plague.chatpositioner.config.ModConfig;

@Mixin(ChatComponent.class)
public class MixinChatComponent {

    @Inject(
        method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;I)V",
        at = @At("HEAD")
    )
    private void beforeChatRender(PoseStack poseStack, int i, CallbackInfo ci) {
        ModConfig config = Main.getConfig();

        poseStack.pushPose();
        poseStack.translate(
            config.getAlignmentSizeOffset().getActualX(),
            -(config.getAlignmentSizeOffset().getActualY()) + 40,
            0.0f
        );
    }

    @Inject(
        method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;I)V",
        at = @At("RETURN")
    )
    private void afterChatRender(PoseStack poseStack, int i, CallbackInfo ci) {
        poseStack.popPose();
    }

}
