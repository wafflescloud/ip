package bin.task;

public class Todo extends Task{
    public Todo(Boolean isDone, String description) {
        super(isDone, description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
