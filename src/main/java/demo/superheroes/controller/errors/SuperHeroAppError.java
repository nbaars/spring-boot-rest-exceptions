package demo.superheroes.controller.errors;

public class SuperHeroAppError {

    private final ErrorBlock error;

    public SuperHeroAppError(final String code, final String message) {
        this.error = new ErrorBlock(code, message);
    }

    public ErrorBlock getError() {
        return error;
    }

    private static final class ErrorBlock {

        private final String code;
        private final String message;

        public ErrorBlock(final String code, final String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
