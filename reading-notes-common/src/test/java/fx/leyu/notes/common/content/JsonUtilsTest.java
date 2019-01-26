package fx.leyu.notes.common.content;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

public class JsonUtilsTest {
    @Test
    public void testMapToJsonString() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("null", null);
        map.put("number", 1);
        map.put("string", "hello world!");
        map.put("array", new int[] {1, 2, 3});
        map.put("empty_array", new int[0]);
        map.put("obj", new Object());
        System.out.println(JsonUtils.toJson(map));
    }

    @Test
    public void testObjectToJsonString() {
        System.out.println(JsonUtils.toJson(new Obj(1, "")));
        System.out.println(JsonUtils.toJson(new Obj(1, null)));
    }

    private static class Obj {
        private int number;
        private String string;

        public Obj(int number, String string) {
            this.number = number;
            this.string = string;
        }

        public int getNumber() {
            return number;
        }

        public String getString() {
            return string;
        }
    }
}
