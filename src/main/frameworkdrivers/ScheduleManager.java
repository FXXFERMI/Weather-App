package main.frameworkdrivers;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The ScheduleManager class is responsible for loading, saving, and managing a list of schedule items.
 * It provides methods to load the schedule from a file, save the schedule to a file, and access the
 * list of schedule items.
 */
public class ScheduleManager {

    private List<String> scheduleItems;
    /**
     * Initializes a new instance of the ScheduleManager class with an empty list of schedule items.
     */
    public ScheduleManager() {
        this.scheduleItems = new ArrayList<>();
    }
    /**
     * Loads the schedule items from a file named "schedule.txt". Each line in the file represents a schedule item.
     * Any existing schedule items will be cleared before loading.
     */
    public void loadSchedule() {
        try (BufferedReader reader = new BufferedReader(new FileReader("schedule.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                scheduleItems.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error loading schedule: " + e.getMessage());
        }
    }
    /**
     * Saves the schedule items to a file named "schedule.txt". Each schedule item is written as a
     * separate line in the file.
     */
    public void saveSchedule() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("schedule.txt"))) {
            for (String item : scheduleItems) {
                writer.write(item);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving schedule: " + e.getMessage());
        }
    }

    /**
     * Returns the list of schedule items.
     *
     * @return List of schedule items.
     */
    public List<String> getScheduleItems() {
        return scheduleItems;
    }
    /**
     * Sets the list of schedule items.
     *
     * @param scheduleItems List of schedule items to set.
     */
    public void setScheduleItems(List<String> scheduleItems) {
        this.scheduleItems = scheduleItems;
    }
}






