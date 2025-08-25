import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Bin {
    private static final String greeting = "    Hello! I'm Bin\n" +
                                           "    What can I do for you?\n";
    private static final String line = "  ___________________________________________\n";
    private static final String logo = "  _____    _\n"
                                    + " |  __  \\ |_|\n"
                                    + " | |__| / ___  ________\n"
                                    + " |  __  \\|   ||   __   |\n"
                                    + " | |__| ||   ||  |  |  |\n"
                                    + " |_____/ |___||__|  |__|\n"
                                    + "\n";
    private static final String exit = "    Bye. Hope to see you again soon!\n";
    private static List<Task> tasks = new ArrayList<>();
    private static int taskNum = 0;

    public static String greeting() {
        return line + logo + greeting + line;
    }

    public static String exit() {
        return line + exit + line;
    }

    public static String list() {
        try {
            loadData();
        } catch (FileNotFoundException e) {
            File dir = new File("./data");
            dir.mkdir();
            new File(dir, "bin.txt");
        }

        String result = "    Here are the tasks in your list:\n";
        for (int i = 0; i < taskNum; i++) {
            Task task = tasks.get(i);
            int num = i + 1;
            result += "    " + num + "." + task.toString() + "\n";
        }
        return line + result + line;
    }

    public static String add(Task task) {
        tasks.add(task);
        taskNum++;
        return line + "    Got it. I've added this task:\n      " + task.toString() + "\n" +
               "    Now you have " + taskNum + " tasks in the list.\n" + line;
    }

    public static String delete(int i) {
        Task task = tasks.get(i);
        tasks.remove(i);
        taskNum--;
        return line + "    Noted. I've removed this task:\n      " + task.toString() + "\n" +
               "    Now you have " + taskNum + " tasks in the list.\n" + line;
    }

    public static void saveData() throws IOException {
        FileWriter fw = new FileWriter("./data/bin.txt", false);
        tasks.forEach(task -> {
                    try {
                        fw.write(task.addTask() + System.lineSeparator());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        fw.close();
    }

    public static void loadData() throws FileNotFoundException {
        tasks.clear();
        taskNum = 0;
        File f = new File("./data/bin.txt");
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String task = s.nextLine();
            String[] parts = task.split("\\s*\\|\\s*");
            Boolean isDone = parts[1].equals("1");
            switch (parts[0]) {
            case "T":
                add(new Todo(isDone, parts[2]));
                break;
            case "D":
                add(new Deadline(isDone, parts[2], parts[3]));
                break;
            case "E":
                add(new Event(isDone, parts[2], parts[3], parts[4]));
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(greeting());

        String input = scanner.nextLine();

        while (!input.equals("bye")) {
            try {
                if (input.isEmpty()) {
                    throw new NoInputException("input");
                }
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
                    if (parts.length < 2) {
                        throw new NoTaskNumberException();
                    }
                    int num = Integer.parseInt(parts[1]);
                    System.out.println(line + tasks.get(num - 1).markAsDone() + line);
                    break;
                case "unmark":
                    if (parts.length < 2) {
                        throw new NoTaskNumberException();
                    }
                        num = Integer.parseInt(parts[1]);
                        System.out.println(line + tasks.get(num - 1).markAsNotDone() + line);
                        break;
                case "todo":
                    if (parts.length < 2) {
                        throw new NoTaskDescriptionException();
                    }
                    String task = parts[1];
                    System.out.println(add(new Todo(false, task)));
                    break;
                case "deadline":
                    if (parts.length < 2) {
                        throw new NoTaskDescriptionException();
                    }
                    parts = parts[1].split("/by", 2);
                    if (parts.length < 2) {
                        throw new NoInputException("deadline");
                    }
                    task = parts[0];
                    by = parts[1];
                    System.out.println(add(new Deadline(false, task, by)));
                    break;
                case "event":
                    if (parts.length < 2) {
                        throw new NoTaskDescriptionException();
                    }
                    parts = parts[1].split("/from", 2);
                    if (parts.length < 2) {
                        throw new NoInputException("start time");
                    }
                    task = parts[0];
                    parts = parts[1].split("/to", 2);
                    if (parts.length < 2) {
                        throw new NoInputException("end time");
                    }
                    from = parts[0];
                    to = parts[1];
                    System.out.println(add(new Event(false, task, from, to)));
                    break;
                case "delete":
                    if (parts.length < 2) {
                        throw new NoTaskNumberException();
                    }
                    num = Integer.parseInt(parts[1]);
                    System.out.println(delete(num - 1));
                    break;
                default:
                    throw new NoInputException("instruction");
                }
            } catch (BinException e) {
                System.out.println(line + e.getMessage() + "\n" + line);
            }
            try {
                saveData();
            } catch (IOException e) {
                System.err.println("Failed to save data: " + e.getMessage());
            }
            input = scanner.nextLine();
        }
        System.out.println(exit());
    }
}
