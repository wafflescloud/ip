package bin.task;

public class Todo extends Task{

    /**
     * Constructor for Todo type of task.
     */
    public Todo(Boolean isDone, String description) {
        super(isDone, description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Todo other) {
            return super.equals(other);
        }
        return false;
    }
}
