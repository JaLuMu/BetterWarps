package de.jalumu.neowarps.exception;

public class WarpNotExistsException extends Exception {
    public WarpNotExistsException(final Throwable cause, final String message) {
        super(message, cause);
    }

    public WarpNotExistsException(final Throwable cause) {
        super("Invalid module.json", cause);
    }

    public WarpNotExistsException(final String message) {
        super(message);
    }

    public WarpNotExistsException() {
        super("The warp does not exists");
    }
}
