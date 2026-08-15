package space.plague.chatpositioner.forge;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

import space.plague.chatpositioner.Main;

@Mod(Main.MOD_ID)
public final class MainForge {

    public MainForge() {

        if (FMLEnvironment.dist == Dist.CLIENT) {
            MainForgeClient.init(this);
        }
        else {
            MainForgeServer.init(this);
        }

    }

}
