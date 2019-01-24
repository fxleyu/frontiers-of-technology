package fx.leyu.notes.service;

public interface BookService {
    String getBook(String isbn);
    boolean storeBook(String isbn, String info);
}
