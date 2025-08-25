import java.io.FileWriter;
import java.io.IOException;

public class Event extends Task {
    protected String from;
    protected String to;

    public Event(Boolean isDone, String description, String from, String to) {
        super(isDone, description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from:" + from + "to:" + to + ")";
    }

    @Override
    public String addTask() {
        int num = isDone ? 1 : 0;
        return "E | " + num + " | " + description + " | " + from + " | " + to;
    }
}
