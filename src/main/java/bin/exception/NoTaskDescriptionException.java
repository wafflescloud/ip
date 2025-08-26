package bin.exception;

public class NoTaskDescriptionException extends NoInputException{
    public NoTaskDescriptionException() {
        super("description of task");
    }
}
