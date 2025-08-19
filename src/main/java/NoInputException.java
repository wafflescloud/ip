public class NoInputException extends BinException{
    public NoInputException(String input) {
        super("    Please have a valid " + input);
    }
}
