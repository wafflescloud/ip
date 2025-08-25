import java.time.LocalDateTime;

public class Event extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;

    public Event(Boolean isDone, String description, String from, String to) {
        super(isDone, description);
        this.from = super.readDate(from);
        this.to = super.readDate(to);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from:" + from.format(super.format)
                + "to:" + to.format(super.format) + ")";
    }

    @Override
    public String addTask() {
        int num = isDone ? 1 : 0;
        return "E | " + num + " | " + description + " | " + from + " | " + to;
    }
}
