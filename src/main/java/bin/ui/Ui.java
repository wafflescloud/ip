package bin.ui;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * UI of the application.
 */
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

    /**
     * Generates and prints the welcome message upon the start of the application.
     * @return welcome message for users
     */
    public String greeting() {
        return this.showToUser(logo + greeting);
    }

    /**
     * Generates and prints the exit message upon the end of the application.
     * @return exit message for users
     */
    public String exit() {
        return this.showToUser(exit);
    }

    public void showLoadingError() {
    }

    /**
     * Prompts for the command and reads the text entered by the user.
     * @return command (full line) entered by the user
     */
    public String getUserCommand() {
        return in.nextLine();
    }


    /**
     * Shows message(s) to the user
     * @param message String to be shown to users
     */
    public String showToUser(String message) {
        String output = line + message + line;
        out.println(output);
        return output;
    }
}
