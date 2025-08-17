public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String markAsDone() {
        this.isDone = true;
        return String.format("    Nice! I've marked this task as done:\n      [%s] %s\n",
                             this.getStatusIcon(), this.toString());
    }

    public String markAsNotDone() {
        this.isDone = false;
        return String.format("    OK, I've marked this task as not done yet:\n      [%s] %s\n",
                this.getStatusIcon(), this.toString());
    }

    public String getStatusIcon() {
        return isDone
                ? "X"
                : " ";
    }

    @Override
    public String toString() {
        return this.description;
    }
}
