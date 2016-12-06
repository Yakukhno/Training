package ua.training.model.io.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter implements IStringWriter {

    private File file;

    public FileWriter(File file) {
        this.file = file;
    }

    @Override
    public void writeString(String string) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(
                new java.io.FileWriter(file, true)))) {
            writer.println(string);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
