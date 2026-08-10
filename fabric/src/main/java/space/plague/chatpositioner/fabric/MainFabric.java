package space.plague.chatpositioner.fabric;

import net.fabricmc.api.ModInitializer;

import space.plague.chatpositioner.Main;

public final class MainFabric implements ModInitializer {
    @Override
    public void onInitialize() {

        Main.init();

    }
}