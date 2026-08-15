package space.plague.chatpositioner.forge;

import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;

import space.plague.chatpositioner.Main;
import space.plague.chatpositioner.config.gui.GeneralOptionsScreen;

public class MainForgeClient {

    public static void init(MainForge mainForge) {
        if (ModList.get().isLoaded("framinglib")) {
            ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.CONFIGGUIFACTORY, () ->
                (minecraft, screen) -> GeneralOptionsScreen.getConfigBuilder().build()
            );
        }

        Main.init();
    }

}
