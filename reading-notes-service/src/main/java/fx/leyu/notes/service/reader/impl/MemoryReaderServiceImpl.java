package fx.leyu.notes.service.reader.impl;

import com.google.common.collect.Maps;
import fx.leyu.notes.domain.Reader;
import fx.leyu.notes.service.reader.ReaderService;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class MemoryReaderServiceImpl implements ReaderService {
    private static final Map<Long, Reader> STORAGE = Maps.newConcurrentMap();

    @Override
    public void updateName(long readerId, String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("name MUST BE NOT blank");
        }

        Reader reader = STORAGE.get(readerId);
        if (reader == null) {
            throw new IllegalArgumentException("the reader is illegal");
        }
        reader.setName(name);
    }

    @Override
    public void updateEmail(long readerId, String email) {

    }

    @Override
    public void updateLocation(long readerId, String location) {

    }
}
