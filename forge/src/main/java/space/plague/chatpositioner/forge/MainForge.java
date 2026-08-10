package space.plague.chatpositioner.forge;

import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

import space.plague.chatpositioner.Main;
import space.plague.chatpositioner.config.gui.GeneralOptionsScreen;

@Mod(Main.MOD_ID)
public final class MainForge {
    public MainForge() {

        if (ModList.get().isLoaded("framinglib")) {
            ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.CONFIGGUIFACTORY, () ->
                (minecraft, screen) -> GeneralOptionsScreen.getConfigBuilder().build()
            );
        }

        Main.init();
    }
}
