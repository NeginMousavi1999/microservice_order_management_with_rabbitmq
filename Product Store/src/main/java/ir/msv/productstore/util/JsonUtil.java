package ir.msv.productstore.util;

import com.google.gson.Gson;
import lombok.experimental.UtilityClass;

/**
 * @author Negin Mousavi 1/25/2025 - Saturday
 */
@UtilityClass
public class JsonUtil {
    public <T> T fromJson(String json, Class<T> tClass) {
        return new Gson().fromJson(
                json,
                tClass
        );
    }
}
