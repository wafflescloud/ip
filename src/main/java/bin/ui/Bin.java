package bin.ui;


import bin.exception.BinException;
import bin.parser.Parser;
import bin.storage.Storage;
import bin.task.TaskList;

public class Bin {
    private Storage storage;
    private TaskList tasks;

    public Bin(String filePath) {
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (BinException e) {
            tasks = new TaskList();
        }
    }

    public String getResponse(String command) {
        Parser parser = new Parser(command, this.tasks);
        storage.save(tasks);
        return parser.parseCommand();
    }
}
