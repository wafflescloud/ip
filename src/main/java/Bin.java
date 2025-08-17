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
    private static Task[] tasks = new Task[100];
    private static int taskNum = 0;

    public static String greeting() {
        return line + logo + greeting + line;
    }

    public static String exit() {
        return line + exit + line;
    }

    public static String list() {
        String result = "    Here are the tasks in your list:\n";
        for (int i = 0; i < taskNum; i++) {
            Task task = tasks[i];
            int num = i + 1;
            result += "    " + num + "." + task.toString() + "\n";
        }
        return line + result + line;
    }

    public static String add(Task task) {
        tasks[taskNum] = task;
        taskNum++;
        return line + "    Got it. I've added this task:\n      " + task.toString() + "\n" +
               "    Now you have " + taskNum + " tasks in the list.\n" + line;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(greeting());
        String input = scanner.nextLine();
        while (!input.equals("bye")) {
            String[] parts = input.split("\\s+", 2);
            String action = parts[0];
            String from;
            String to;
            String by;
            switch (action) {
                case "list":
                    System.out.println(list());
                    break;
                case "mark":
                    int num = Integer.parseInt(parts[1]);
                    System.out.println(line + tasks[num - 1].markAsDone() + line);
                    break;
                case "unmark":
                    num = Integer.parseInt(parts[1]);
                    System.out.println(line + tasks[num - 1].markAsNotDone() + line);
                    break;
                case "todo":
                    String task = parts[1];
                    System.out.println(add(new Todo(task)));
                    break;
                case "deadline":
                    parts = parts[1].split("/by", 2);
                    task = parts[0];
                    by = parts[1];
                    System.out.println(add(new Deadline(task, by)));
                    break;
                case "event":
                    parts = parts[1].split("/from", 2);
                    task = parts[0];
                    parts = parts[1].split("/to", 2);
                    from = parts[0];
                    to = parts[1];
                    System.out.println(add(new Event(task, from, to)));
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(exit());
    }
}
