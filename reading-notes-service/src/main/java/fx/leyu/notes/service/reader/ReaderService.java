package fx.leyu.notes.service.reader;

public interface ReaderService {
    void updateName(long readerId, String name);
    void updateEmail(long readerId, String email);
    void updateLocation(long readerId, String location);
}
