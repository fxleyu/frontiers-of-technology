package fx.leyu.notes.service.impl;

import com.google.common.collect.Maps;
import fx.leyu.notes.service.BookService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BookServiceImpl implements BookService {
    private static final Map<String, String> STORE = Maps.newConcurrentMap();

    static {
        STORE.put("9787559627759", "The Sun");
        STORE.put("9787540489069", "A Visit from the Goon Squad");
    }


    @Override
    public String getBook(String isbn) {
        return MapUtils.getString(STORE, isbn, "error isbn");
    }

    @Override
    public boolean storeBook(String isbn, String info) {
        if (STORE.containsKey(isbn)) {
            return false;
        }
        STORE.put(isbn, info);
        return true;
    }
}
