import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    protected String description;
    protected boolean isDone;
    protected DateTimeFormatter format = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");

    public Task(Boolean isDone, String description) {
        this.description = description;
        this.isDone = isDone;
    }

    public LocalDateTime readDate(String str) {
        return LocalDateTime.parse(str, format);
    }

    public String addTask() {
        int num = isDone ? 1 : 0;
        return "T | " + num + " | " + description;
    }

    public String markAsDone() {
        this.isDone = true;
        return String.format("    Nice! I've marked this task as done:\n      %s\n", this.toString());
    }

    public String markAsNotDone() {
        this.isDone = false;
        return String.format("    OK, I've marked this task as not done yet:\n      %s\n", this.toString());
    }

    public String getStatusIcon() {
        return isDone
                ? "X"
                : " ";
    }

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }
}
