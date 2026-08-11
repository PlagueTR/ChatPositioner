package space.plague.chatpositioner.config.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;

import space.plague.chatpositioner.Main;
import space.plague.chatpositioner.config.ModConfig;

import space.plague.framinglib.api.LayoutConfigScreenBuilder;
import space.plague.framinglib.api.LayoutElementBuilder;
import space.plague.framinglib.api.util.Alignments;

public class GeneralOptionsScreen {

    public static LayoutConfigScreenBuilder getConfigBuilder() {

        ModConfig defaults = new ModConfig();
        ModConfig config = Main.getConfig();

        LayoutConfigScreenBuilder builder = LayoutConfigScreenBuilder.create()
            .setParentScreen(Minecraft.getInstance().screen)
            .setTitle(new TextComponent(Main.MOD_NAME + " - General"))
            .setSavingRunnable(Main::saveConfig)
            .setTransparentBackground(true)
            .setShowResetButton(false);

        LayoutElementBuilder chatElementBuilder = builder.startLayoutElement(
                config.getAlignmentSizeOffset(),
                new TextComponent("Chat HUD")
            )
            .setDefaultValue(defaults.getAlignmentSizeOffset())
            .setSaveConsumer(
                config::setAlignmentSizeOffset
            )
            .setNameAlignment(Alignments.HAlignment.RIGHT, Alignments.VAlignment.TOP)
            .setButtonsAlignment(Alignments.HAlignment.RIGHT, Alignments.VAlignment.BOTTOM);

        builder.addLayoutElementEntry(chatElementBuilder.build());

        return builder;
    }

}
