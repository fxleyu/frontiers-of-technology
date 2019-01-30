package fx.leyu.notes.service;

public interface NoteService {
    String gainNotes(String ISBN);
    boolean storeNote(String note);
}
