package Duke;

import java.io.File;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


public abstract class Task {

    public static final String TICK = "✓";
    public static final String CROSS = "✘";

    String workingDir = System.getProperty("user.dir");
    java.nio.file.Path folderPath = java.nio.file.Paths.get(workingDir, "Save");
    java.nio.file.Path filePath = java.nio.file.Paths.get(workingDir, "Save", "data.txt");


    protected String description;
    protected String date;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.date = "";
        this.isDone = false;
    }

    public Task(String description, String date) {
        this.description = description;
        this.date = date;
        this.isDone = false;
    }

    public String getDate() {
        return date;
    }
    public boolean getStatus() {
        return isDone;
    }

    public String getStatusIcon() {
        return (isDone ? TICK : CROSS); //return tick or X symbols
    }

    public String getDescription() {
        return description;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String getTaskType() {
        return null;
    }

    public void printAddDetails(int taskCounter) {
        System.out.println("The following task has been added:\n[" + getTaskType() +"][" + getStatusIcon() + "] " + getDescription());
        System.out.println("\nYou've got " + taskCounter + " task(s) in the list!\n");
    }

    public abstract void printListDetails(int count);

}
