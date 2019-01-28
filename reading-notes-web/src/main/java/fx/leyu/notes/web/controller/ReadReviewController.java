package fx.leyu.notes.web.controller;

import fx.leyu.notes.common.content.JsonUtils;
import fx.leyu.notes.domain.ReadReview;
import fx.leyu.notes.service.ReadReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/book/review")
public class ReadReviewController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadReviewController.class);
    @Autowired
    private ReadReviewService readReviewService;

    @RequestMapping("/")
    public @ResponseBody String query(@RequestParam String ISBN) {
        List<ReadReview> result = readReviewService.gainReviewsOfBook(ISBN);
        LOGGER.debug("[{}] the result is {}", this.getClass().getCanonicalName(), result);
        return JsonUtils.toJson(result);
    }


    @RequestMapping("/write")
    public @ResponseBody String write(@RequestParam String ISBN,
                                      @RequestParam String peopleId,
                                      @RequestParam String review) {
        readReviewService.storeReview(ISBN, peopleId, review);
        return "";
    }
}
