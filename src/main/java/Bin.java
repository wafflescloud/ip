import java.util.ArrayList;
import java.util.List;
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
    private static List<String> list = new ArrayList<>();

    public static String greeting() {
        return line + logo + greeting + line;
    }

    public static String exit() {
        return line + exit + line;
    }

    public static String list() {
        int length = list.size();
        String result = "";
        for (int i = 1; i <= length; i++) {
            result += "    " + i + ". " + list.get(i - 1) + "\n";
        }
        return line + result + line;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(greeting());
        String action = scanner.nextLine();
        while (!action.equals("bye")) {
            if (action.equals("list")) {
                System.out.println(list());
            } else {
                list.add(action);
                System.out.println(line + "\n   added: " + action + "\n" + line);
            }
            action = scanner.nextLine();
        }
        System.out.println(exit());
    }
}
