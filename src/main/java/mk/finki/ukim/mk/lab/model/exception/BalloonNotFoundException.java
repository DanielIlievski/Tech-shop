package mk.finki.ukim.mk.lab.model.exception;

public class BalloonNotFoundException extends RuntimeException {
    public BalloonNotFoundException(Long id) {
        super(String.format("Balloon with id: %d not exists!", id));
    }
}
