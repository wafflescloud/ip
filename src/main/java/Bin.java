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
    private static List<Task> list = new ArrayList<>();

    public static String greeting() {
        return line + logo + greeting + line;
    }

    public static String exit() {
        return line + exit + line;
    }

    public static String list() {
        int length = list.size();
        String result = "    Here are the tasks in your list:\n";
        for (int i = 1; i <= length; i++) {
            Task task = list.get(i - 1);
            result += "    " + i + ". [" + task.getStatusIcon() + "] " + task.toString() + "\n";
        }
        return line + result + line;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(greeting());
        String input = scanner.nextLine();
        while (!input.equals("bye")) {
            String[] parts = input.split("\\s+", 2);
            String action = parts[0];
            String task = input;
            switch (action) {
                case "list":
                    System.out.println(list());
                    break;
                case "mark":
                    int num = Integer.parseInt(parts[1]);
                    System.out.println(line + list.get(num - 1).markAsDone() + line);
                    break;
                case "unmark":
                    num = Integer.parseInt(parts[1]);
                    System.out.println(line + list.get(num - 1).markAsNotDone() + line);
                    break;
                default:
                    list.add(new Task(task));
                    System.out.println(line + "   added: " + task + "\n" + line);
                    break;

            }
            input = scanner.nextLine();
        }
        System.out.println(exit());
    }
}
