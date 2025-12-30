package sirma.SantaWorkshop.exception;

public class GiftNotFoundException extends RuntimeException {
    public GiftNotFoundException(Long id) {
        super("Gift not found with id: " + id);
    }
}