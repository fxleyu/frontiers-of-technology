package fx.leyu.notes.service.reader.impl;

import com.google.common.collect.Maps;
import fx.leyu.notes.domain.Reader;
import fx.leyu.notes.service.reader.ReaderService;

import java.util.Map;

public class MemoryReaderServiceImpl implements ReaderService {
    private static final Map<Long, Reader> STORAGE = Maps.newConcurrentMap();

    @Override
    public void updateName(long readerId, String name) {
        Reader reader = gainReader(readerId);
        reader.setName(name);
    }

    private Reader gainReader(long readerId) {
        Reader reader = STORAGE.get(readerId);
        if (reader == null) {
            throw new IllegalArgumentException("the reader is illegal");
        }
        return reader;
    }

    @Override
    public void updateEmail(long readerId, String email) {
        Reader reader = gainReader(readerId);
        reader.setEmail(email);
    }

    @Override
    public void updateLocation(long readerId, String location) {
        Reader reader = gainReader(readerId);
        reader.setLocation(location);
    }
}
