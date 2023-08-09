package test.frameworkdriversTest;

import main.frameworkdrivers.ScheduleManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScheduleManagerTest {

    private static final String TEST_SCHEDULE_FILE = "test_schedule.txt";

    private ScheduleManager scheduleManager;

    @BeforeEach
    public void setUp() {
        scheduleManager = new ScheduleManager();
        scheduleManager.setScheduleItems(new ArrayList<>());
    }


    @Test
    public void testSaveAndLoadEmptySchedule() throws IOException {
        // Save empty schedule
        scheduleManager.saveSchedule();

        // Load empty schedule
        scheduleManager.loadSchedule();

        List<String> loadedSchedule = scheduleManager.getScheduleItems();

        assertEquals(0, loadedSchedule.size());
    }


    @Test
    public void testErrorSavingSchedule() {
        // Set a read-only directory to simulate write error
        String readOnlyDirectory = "/tmp/read-only-dir/";
        System.setProperty("user.dir", readOnlyDirectory);

        // Attempt to save schedule
        List<String> testSchedule = new ArrayList<>();
        testSchedule.add("Item 1");
        scheduleManager.setScheduleItems(testSchedule);
        scheduleManager.saveSchedule();

        // Reset system property
        System.setProperty("user.dir", System.getProperty("user.home"));

        List<String> loadedSchedule = scheduleManager.getScheduleItems();

        assertEquals(1, loadedSchedule.size());
        assertEquals("Item 1", loadedSchedule.get(0));
    }
}

