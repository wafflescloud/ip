public class Duke {
    private static final String greeting = "Hello! I'm Bin\nWhat can I do for you?\n";
    private static final String line = " ___________________________________________\n";
    public static void main(String[] args) {
        String logo = "  _____    _  \n"
                    + " |  __  \\ |_|\n"
                    + " | |__| / ___  ________\n"
                    + " |  __  \\|   ||   __   |\n"
                    + " | |__| ||   ||  |  |  |\n"
                    + " |_____/ |___||__|  |__|\n"
                    + "\n";
        System.out.println(line + logo + greeting + line);
    }
}
