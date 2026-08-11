package space.plague.chatpositioner.config;

import net.minecraft.client.Minecraft;

import space.plague.framinglib.api.util.AlignmentSizeOffset;
import space.plague.framinglib.api.util.Alignments;

public class ModConfig {

    private final AlignmentSizeOffset chatHudASO;

    public ModConfig() {
        this.chatHudASO = AlignmentSizeOffset.create(
            0, 40,
            Minecraft.getInstance().gui.getChat().getWidth() + 5,
            Minecraft.getInstance().gui.getChat().getHeight(),
            Alignments.create(Alignments.HAlignment.LEFT, Alignments.VAlignment.BOTTOM),
            Alignments.create(Alignments.HAlignment.LEFT, Alignments.VAlignment.BOTTOM)
        );
    }

    public AlignmentSizeOffset getAlignmentSizeOffset() {
        return this.chatHudASO;
    }

}
