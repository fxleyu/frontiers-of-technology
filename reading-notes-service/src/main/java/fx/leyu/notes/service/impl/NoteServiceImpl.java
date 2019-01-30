package fx.leyu.notes.service.impl;

import com.google.common.collect.Maps;
import fx.leyu.notes.common.content.JsonUtils;
import fx.leyu.notes.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoteServiceImpl implements NoteService {
    private static Map<String, List<String>> STORE = Maps.newConcurrentMap();

    @Override
    public String gainNotes(String ISBN) {
        return JsonUtils.toJson(STORE.get(ISBN));
    }

    @Override
    public boolean storeNote(String note) {
        return false;
    }
}
