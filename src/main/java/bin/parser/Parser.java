package bin.parser;

import bin.exception.BinException;
import bin.exception.NoInputException;
import bin.exception.NoTaskDescriptionException;
import bin.exception.NoTaskNumberException;
import bin.task.Deadline;
import bin.task.Event;
import bin.task.TaskList;
import bin.task.Todo;

public class Parser {
    private TaskList tasks;
    private final String command;
    private String action;
    private String description;
    private String from;
    private String to;
    private String by;

    public Parser(String command, TaskList tasks) {
        this.command = command;
        this.tasks = tasks;
    }

    /**
     * Parses user input into command for execution.
     *
     * @return String to be displayed after completion of command
     */
    public String parseCommand() {
        String message = "";
        try {
            String[] parts = command.split("\\s+", 2);
            action = parts[0];
            switch (action) {
            case "list":
                message = tasks.toString();
            break;
            case "mark":
                if (parts.length < 2) {
                    throw new NoTaskNumberException();
                }
                int num = Integer.parseInt(parts[1]);
                if (num > tasks.size()) {
                    throw new NoTaskNumberException();
                }
                message = tasks.mark(num);
                break;
            case "unmark":
                if (parts.length < 2) {
                    throw new NoTaskNumberException();
                }
                num = Integer.parseInt(parts[1]);
                if (num > tasks.size()) {
                    throw new NoTaskNumberException();
                }
                message = tasks.unmark(num);
                break;  
            case "todo":
                if (parts.length < 2) {
                    throw new NoTaskDescriptionException();
                }
                description = parts[1];
                Todo task = new Todo(false, description);
                if (this.tasks.checkDuplicate(task)) {
                    message = tasks.add(task);
                }
                break;
            case "deadline":
                if (parts.length < 2) {
                    throw new NoTaskDescriptionException();
                }
                parts = parts[1].split("/by", 2);
                if (parts.length < 2) {
                    throw new NoInputException("deadline");
                }
                description = parts[0];
                by = parts[1];
                Deadline deadline = new Deadline(false, description, by);
                if (this.tasks.checkDuplicate(deadline)) {
                    message = tasks.add(deadline);
                }

                break;
            case "event":
                if (parts.length < 2) {
                    throw new NoTaskDescriptionException();
                }
                parts = parts[1].split("/from", 2);
                if (parts.length < 2) {
                    throw new NoInputException("start time");
                }
                description = parts[0];
                parts = parts[1].split("/to", 2);
                if (parts.length < 2) {
                    throw new NoInputException("end time");
                }
                from = parts[0];
                to = parts[1];
                Event event = new Event(false, description, from, to);
                if (this.tasks.checkDuplicate(event)) {
                    message = tasks.add(event);
                }
                break;
            case "delete":
                if (parts.length < 2) {
                    throw new NoTaskNumberException();
                }
                num = Integer.parseInt(parts[1]);
                if (num > tasks.size()) {
                    throw new NoTaskNumberException();
                }
                message = tasks.delete(num);
                break;
            case "find":
                if (parts.length < 2) {
                    throw new NoTaskDescriptionException();
                }
                String keyword = parts[1];
                message = tasks.search(keyword);
                break;
            default:
                throw new NoInputException("instruction");
            }
        } catch (BinException e) {
            return e.getMessage();
        }
        return message;
    }
}
