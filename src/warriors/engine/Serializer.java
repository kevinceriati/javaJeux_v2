package warriors.engine;
import com.google.gson.*;
import warriors.engine.Cases;
import java.lang.reflect.Type;

public class Serializer implements JsonSerializer<Cases>, JsonDeserializer<Cases> {

        @Override
        public JsonElement serialize(Cases src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject result = new JsonObject();
            result.add("type", new JsonPrimitive(src.getClass().getSimpleName()));  // result -> ma case convertie en json
            result.add("properties", context.serialize(src, src.getClass()));      // proerties -> ma case avec tous ces attributs
            return result;
        }

        @Override
        public Cases deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            JsonObject jsonObject = json.getAsJsonObject();
            String type = jsonObject.get("type").getAsString();
            JsonElement element = jsonObject.get("properties");
            try {
                return context.deserialize(element, Class.forName("warriors.engine." + type));
            } catch (JsonParseException e) {                                                     // message pour qur ce soit propre
                System.out.println("JsonParseException error");
            } catch (ClassNotFoundException e) {
                System.out.println("ClassNotFoundException e error");
            }
            return null;
        }
    }
