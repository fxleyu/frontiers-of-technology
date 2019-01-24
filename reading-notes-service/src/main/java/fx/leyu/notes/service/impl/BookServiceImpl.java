package fx.leyu.notes.service.impl;

import fx.leyu.notes.service.BookService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Component
public class BookServiceImpl implements BookService {
    private Map<String, String> store = new HashMap<>();
    {
        store.put("9787559627759", "The Sun");
        store.put("9787540489069", "A Visit from the Goon Squad");
    }


    @Override
    public String getBook(String isbn) {
        String name = store.get(isbn);
        return StringUtils.isEmpty(name) ? "error isbn " + isbn : name;
    }

    @Override
    public boolean storeBook(String isbn, String info) {
        if (store.containsKey(isbn)) {
            return false;
        }
        store.put(isbn, info);
        return true;
    }
}
