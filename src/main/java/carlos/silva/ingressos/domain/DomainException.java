package carlos.silva.ingressos.domain;

public class DomainException extends RuntimeException {
    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public DomainException(String message) {
        super(message);
    }

    public DomainException(Throwable cause) {
        super(cause);
    }
}
