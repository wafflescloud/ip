package bin.ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UiTest {
    @Test
    public void greeting_success() {
        String expected = "  -----------------------------------------------\n"
                + "  _____    _\n"
                + " |  __  \\ |_|\n"
                + " | |__| / ___  ________\n"
                + " |  __  \\|   ||   __   |\n"
                + " | |__| ||   ||  |  |  |\n"
                + " |_____/ |___||__|  |__|\n"
                + "\n"
                + "    Hello! I'm Bin\n"
                + "    What can I do for you?\n"
                + "  -----------------------------------------------\n";
        assertEquals(expected, new Ui().greeting());
    }

    @Test
    public void showToUser_success() {
        String expected = "  -----------------------------------------------\n"
                + "bye"
                + "  -----------------------------------------------\n";
        assertEquals(expected, new Ui().showToUser("bye"));
    }
}
