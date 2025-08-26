import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    protected String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public List<Task> load() throws BinException {
        File f = new File(this.filePath);
        Scanner s = null;
        List<Task> tasks = new ArrayList<>();
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException e) {
            String[] parts = filePath.split("/");
            String dirName = parts[0];
            String name = parts[1];
            File dir = new File(dirName);
            dir.mkdir();
            new File(dir, name);
            throw new BinException("No current file");
        }
        while (s.hasNext()) {
            String task = s.nextLine();
            String[] parts = task.split("\\s*\\|\\s*");
            Boolean isDone = parts[1].equals("1");
            switch (parts[0]) {
            case "T":
                tasks.add(new Todo(isDone, parts[2]));
                break;
            case "D":
                tasks.add(new Deadline(isDone, parts[2], parts[3]));
                break;
            case "E":
                tasks.add(new Event(isDone, parts[2], parts[3], parts[4]));
                break;
            }
        }
        return tasks;
    }

    public void save(TaskList tasks) {
        try {
            FileWriter fw = new FileWriter(filePath, false);
            tasks.getTasks().forEach(task -> {
                try {
                    fw.write(task.addTask() + System.lineSeparator());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            fw.close();
        } catch (IOException e) {
            System.err.println("Failed to save data: " + e.getMessage());
        }
    }
}
