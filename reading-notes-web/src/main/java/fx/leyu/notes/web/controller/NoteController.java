package fx.leyu.notes.web.controller;

import fx.leyu.notes.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book/note")
public class NoteController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NoteController.class);

    @Autowired
    private NoteService noteService;

    @RequestMapping("/")
    public @ResponseBody String query(@RequestParam String ISBN) {
        String string = noteService.gainNotes(ISBN);
        LOGGER.debug("[{}] the result is {}", this.getClass().getCanonicalName(), string);
        return string;
    }


    @RequestMapping("/write")
    public @ResponseBody String write(@RequestParam String ISBN,
                                      @RequestParam String peopleId,
                                      @RequestParam String review) {
        return "";
    }
}
