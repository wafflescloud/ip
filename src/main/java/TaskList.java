import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public int size() {
        return this.tasks.size();
    }

    @Override
    public String toString() {
        String result = "    Here are the tasks in your list:\n";
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            int num = i + 1;
            result += "    " + num + "." + task.toString() + "\n";
        }
        return result;
    }

    public String mark(int i) {
        return tasks.get(i - 1).markAsDone();
    }

    public String unmark(int i) {
        return tasks.get(i - 1).markAsNotDone();
    }

    public String add(Task task) {
        tasks.add(task);
        return "    Got it. I've added this task:\n      " + task.toString() + "\n" +
                "    Now you have " + tasks.size() + " tasks in the list.\n";
    }

    public String delete(int i) {
        Task task = tasks.get(i);
        tasks.remove(i);
        return "    Noted. I've removed this task:\n      " + task.toString() + "\n" +
                "    Now you have " + tasks.size() + " tasks in the list.\n";
    }
}
