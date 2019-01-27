package fx.leyu.notes.web.controller;

import com.google.common.collect.Maps;
import fx.leyu.notes.common.content.JsonUtils;
import fx.leyu.notes.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloWorldController {

    @Autowired
    private PeopleService peopleService;

    @RequestMapping("/people")
    public @ResponseBody String getMap() {
        Map map = Maps.newHashMap();
        map.put("hello", "world");
        map.put("people", peopleService.register("fxleyu"));
        return JsonUtils.toJson(map);
    }
}
