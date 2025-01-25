package ir.msv.orderservice.utl;

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
}
