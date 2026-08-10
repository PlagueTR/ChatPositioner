package space.plague.chatpositioner.config.adapters;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonParseException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import space.plague.framinglib.api.util.AlignmentSizeOffset;
import space.plague.framinglib.api.util.Alignments;

import java.lang.reflect.Type;

public class AlignmentSizeOffsetAdapter implements JsonSerializer<AlignmentSizeOffset>, JsonDeserializer<AlignmentSizeOffset> {

    @Override
    public AlignmentSizeOffset deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject obj = json.getAsJsonObject();

        int offsetX = obj.get("offset_x").getAsInt();
        int offsetY = obj.get("offset_y").getAsInt();
        int width = obj.get("width").getAsInt();
        int height = obj.get("height").getAsInt();

        JsonObject alignmentObj = obj.getAsJsonObject("alignment");
        Alignments.HAlignment hAlign = Alignments.HAlignment.valueOf(alignmentObj.get("h_alignment").getAsString());
        Alignments.VAlignment vAlign = Alignments.VAlignment.valueOf(alignmentObj.get("v_alignment").getAsString());

        JsonObject screenAlignmentObject = obj.getAsJsonObject("screen_alignment");
        Alignments.HAlignment screenHAlign = Alignments.HAlignment.valueOf(screenAlignmentObject.get("h_alignment").getAsString());
        Alignments.VAlignment screenVAlign = Alignments.VAlignment.valueOf(screenAlignmentObject.get("v_alignment").getAsString());

        return AlignmentSizeOffset.create(offsetX, offsetY, width, height, Alignments.create(hAlign, vAlign), Alignments.create(screenHAlign, screenVAlign));
    }

    @Override
    public JsonElement serialize(AlignmentSizeOffset src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = new JsonObject();
        json.addProperty("offset_x", src.getOffsetX());
        json.addProperty("offset_y", src.getOffsetY());
        json.addProperty("width", src.getWidth());
        json.addProperty("height", src.getHeight());

        JsonObject jsonAlign = new JsonObject();
        Alignments alignment = src.getAlignment();
        jsonAlign.addProperty("h_alignment", alignment.getHAlignment().name());
        jsonAlign.addProperty("v_alignment", alignment.getVAlignment().name());

        json.add("alignment", jsonAlign);

        JsonObject jsonScreenAlignment = new JsonObject();
        Alignments screenAlignment = src.getScreenAlignment();
        jsonScreenAlignment.addProperty("h_alignment", screenAlignment.getHAlignment().name());
        jsonScreenAlignment.addProperty("v_alignment", screenAlignment.getVAlignment().name());

        json.add("screen_alignment", jsonScreenAlignment);

        return json;
    }
}
