package space.plague.chatpositioner.config;

import net.minecraft.client.Minecraft;

import space.plague.framinglib.api.util.AlignmentSizeOffset;
import space.plague.framinglib.api.util.Alignments;

public class ModConfig {

    private int offsetX;
    private int offsetY;

    private int width;
    private int height;

    private Alignments.HAlignment hAlignment;
    private Alignments.VAlignment vAlignment;

    private Alignments.HAlignment scrHAlignment;
    private Alignments.VAlignment scrVAlignment;

    public ModConfig() {
        this.offsetX = 0;
        this.offsetY = 40;

        this.width = Minecraft.getInstance().gui.getChat().getWidth() + 5;
        this.height = Minecraft.getInstance().gui.getChat().getHeight();

        this.hAlignment = Alignments.HAlignment.LEFT;
        this.vAlignment = Alignments.VAlignment.BOTTOM;

        this.scrHAlignment = Alignments.HAlignment.LEFT;
        this.scrVAlignment = Alignments.VAlignment.BOTTOM;
    }

    public AlignmentSizeOffset getAlignmentSizeOffset() {
        return AlignmentSizeOffset.create(this.offsetX, this.offsetY, this.width, this.height,
            Alignments.create(this.hAlignment, this.vAlignment),
            Alignments.create(this.scrHAlignment, this.scrVAlignment)
        );
    }

    public void setAlignmentSizeOffset(AlignmentSizeOffset newAlignmentSizeOffset) {
        this.offsetX = newAlignmentSizeOffset.getOffsetX();
        this.offsetY = newAlignmentSizeOffset.getOffsetY();

        this.width = newAlignmentSizeOffset.getWidth();
        this.height = newAlignmentSizeOffset.getHeight();

        this.hAlignment = newAlignmentSizeOffset.getAlignment().getHAlignment();
        this.vAlignment = newAlignmentSizeOffset.getAlignment().getVAlignment();

        this.scrHAlignment = newAlignmentSizeOffset.getScreenAlignment().getHAlignment();
        this.scrVAlignment = newAlignmentSizeOffset.getScreenAlignment().getVAlignment();
    }

}
