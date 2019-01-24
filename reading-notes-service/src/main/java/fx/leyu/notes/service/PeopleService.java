package fx.leyu.notes.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface PeopleService {
    boolean isValid(@Nullable String pin);
    boolean register(@Nonnull String pin);
}
