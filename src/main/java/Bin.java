import java.util.Scanner;

public class Bin {
    private static final String greeting = "    Hello! I'm Bin\n" +
                                           "    What can I do for you?\n";
    private static final String line = "  ___________________________________________\n";
    private static final String logo = "  _____    _  \n"
                                    + " |  __  \\ |_|\n"
                                    + " | |__| / ___  ________\n"
                                    + " |  __  \\|   ||   __   |\n"
                                    + " | |__| ||   ||  |  |  |\n"
                                    + " |_____/ |___||__|  |__|\n"
                                    + "\n";
    private static final String exit = "    Bye. Hope to see you again soon!\n";
    public static String greeting() {
        return line + logo + greeting + line;
    }

    public static String exit() {
        return line + exit + line;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(greeting());
        String action = scanner.nextLine();
        while (!action.equals("bye")) {
            System.out.println(line + "\n   " + action + "\n" + line);
            action = scanner.nextLine();
        }
        System.out.println(exit());
    }
}
