import java.io.PrintStream;
import java.util.Scanner;

public class Ui {
    private static final String greeting = "    Hello! I'm Bin\n" +
            "    What can I do for you?\n";
    private static final String line = "  -----------------------------------------------\n";
    private static final String logo = "  _____    _\n"
            + " |  __  \\ |_|\n"
            + " | |__| / ___  ________\n"
            + " |  __  \\|   ||   __   |\n"
            + " | |__| ||   ||  |  |  |\n"
            + " |_____/ |___||__|  |__|\n"
            + "\n";
    private static final String exit = "    Bye. Hope to see you again soon!\n";
    private final Scanner in;
    private final PrintStream out;

    public Ui() {
        this.in = new Scanner(System.in);
        this.out = new PrintStream(System.out);
    }

    public void greeting() {
        this.showToUser(logo + greeting);
    }

    public void exit() {
        this.showToUser(exit);
    }

    public void showLoadingError() {
    }

    public String getUserCommand() {
        return in.nextLine();
    }

    public void showToUser(String message) {
        out.println(line + message + line + "\n");
    }
}
