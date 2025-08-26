package bin.task;

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

    /**
     * returns message for list of tasks with keyword.
     *
     * @param keyword String of keyword.
     * @return list of tasks containing keyword.
     */
    public String search(String keyword) {
        List<Task> filtered = tasks.stream().filter(task -> task.contains(keyword)).toList();
        String result = "Here are the matching tasks in your list:\n";
        for (int i = 0; i < filtered.size(); i++) {
            Task task = filtered.get(i);
            int num = i + 1;
            result += "    " + num + "." + task.toString() + "\n";
        }
        return result;
    }
}
