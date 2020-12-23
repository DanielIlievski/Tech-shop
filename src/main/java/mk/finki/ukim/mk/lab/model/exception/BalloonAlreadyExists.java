package mk.finki.ukim.mk.lab.model.exception;

public class BalloonAlreadyExists extends RuntimeException {
    public BalloonAlreadyExists(Long id) {
        super(String.format("Balloon with id: %d already exists!", id));
    }
}
