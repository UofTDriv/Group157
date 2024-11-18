package data_access;

public class BadWikiRequestException extends RuntimeException {
    // we might not need a bespoke exception for this kinda thing but worst case scenario we just delete it lol
    private final String code;

    public BadWikiRequestException(String code, String message) {
        super(message);
        this.code = code;
    }

    public boolean isPageNotFound() {
        return code.equals("missingtitle");
    }
}
