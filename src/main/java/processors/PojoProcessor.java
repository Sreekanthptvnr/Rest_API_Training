package processors;

import java.lang.reflect.Type;

import com.google.gson.Gson;

public class PojoProcessor {
	public static Object convertJsonToDTO(String json, Type type) {
        Object containerObject = null;
        try {
            containerObject = new Gson().fromJson(json,type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return containerObject;
    }

}
