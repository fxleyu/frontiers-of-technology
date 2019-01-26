package fx.leyu.notes.common.content;

import com.alibaba.fastjson.JSON;

public class JsonUtils {
    private JsonUtils() {
    }

    public static String toJson(Object obj) {
        return JSON.toJSONString(obj);
    }
}
