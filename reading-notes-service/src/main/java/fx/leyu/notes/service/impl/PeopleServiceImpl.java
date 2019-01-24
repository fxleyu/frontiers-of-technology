package fx.leyu.notes.service.impl;

import com.google.common.collect.Sets;
import fx.leyu.notes.service.PeopleService;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

@Component
public class PeopleServiceImpl implements PeopleService {
    private static final Set<String> STORE = Sets.newConcurrentHashSet();
    static {
        STORE.add("fxleyu");
    }

    @Override
    public boolean isValid(@Nullable String pin) {
        return STORE.contains(pin);
    }

    @Override
    public boolean register(@Nonnull String pin) {
        return STORE.add(pin);
    }
}
