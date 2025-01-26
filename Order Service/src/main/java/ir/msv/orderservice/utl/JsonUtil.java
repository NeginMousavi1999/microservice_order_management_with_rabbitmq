package ir.msv.orderservice.utl;

import com.google.gson.Gson;
import lombok.experimental.UtilityClass;
import org.json.JSONObject;

/**
 * @author Negin Mousavi 1/25/2025 - Saturday
 */
@UtilityClass
public class JsonUtil {
    public <T> String toJson(T pojo) {
        return new JSONObject(pojo).toString();
    }

    public <T> T fromJson(String json, Class<T> tClass) {
        return new Gson().fromJson(
                json,
                tClass
        );
    }
}
