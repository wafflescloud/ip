public class Bin {
    private static final String greeting = "Hello! I'm Bin\nWhat can I do for you?\n";
    private static final String line = " ___________________________________________\n";
    private static final String logo = "  _____    _  \n"
                                    + " |  __  \\ |_|\n"
                                    + " | |__| / ___  ________\n"
                                    + " |  __  \\|   ||   __   |\n"
                                    + " | |__| ||   ||  |  |  |\n"
                                    + " |_____/ |___||__|  |__|\n"
                                    + "\n";
    private static final String exit = "Bye. Hope to see you again soon!\n";
    public static String greeting() {
        return line + logo + greeting;
    }

    public static String exit() {
        return line + exit + line;
    }
    public static void main(String[] args) {

        System.out.println(greeting() + exit());
    }
}
