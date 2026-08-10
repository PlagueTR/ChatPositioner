package space.plague.chatpositioner.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import space.plague.chatpositioner.Main;

@Mixin(Minecraft.class)
public class MixinMinecraft {

    @Inject(
        method = "<init>(Lnet/minecraft/client/main/GameConfig;)V",
        at = @At(
            value = "TAIL"
        )
    )
    private void afterConstructor(GameConfig gameConfig, CallbackInfo ci) {
        Main.initConfig();
    }

}
