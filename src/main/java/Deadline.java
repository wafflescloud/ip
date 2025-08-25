import java.io.FileWriter;
import java.io.IOException;

public class Deadline extends Task{
    protected String by;

    public Deadline(Boolean isDone, String description, String by) {
        super(isDone, description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by:" + by + ")";
    }

    @Override
    public String addTask() {
        int num = isDone ? 1 : 0;
        return "D | " + num + " | " + description + " | " + by;
    }
}
