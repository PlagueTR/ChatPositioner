package space.plague.chatpositioner;

import space.plague.chatpositioner.config.ModConfig;
import space.plague.chatpositioner.config.ModConfigManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Main {

    public static final String MOD_ID = "chatpositioner";
    public static final String MOD_NAME = "Chat Positioner";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static void init() {
        LOGGER.info("[" + MOD_NAME + "] Loading...");

        LOGGER.info("[" + MOD_NAME + "] All done!");
    }

    public static void initConfig() {
        ModConfigManager.initializeConfig();
    }

    public static ModConfig getConfig() {
        return ModConfigManager.getConfig();
    }

    public static void saveConfig() {
        ModConfigManager.save();
    }

}
