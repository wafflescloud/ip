public class Bin {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Bin(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (BinException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    private void runCommandUntilExit() {
        String command = ui.getUserCommand();
        while(!command.equals("bye")) {
            Parser parser = new Parser(command, this.tasks);
            ui.showToUser(parser.parseCommand());
            storage.save(tasks);
            command = ui.getUserCommand();
        }
    }

    public void run() {
        ui.greeting();
        this.runCommandUntilExit();
        ui.exit();
    }

    public static void main(String[] args) {
        new Bin("data/bin.txt").run();
    }
}
