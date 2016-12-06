package ua.training.model.io.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriter implements IStringWriter {

    private File file;

    public FileWriter(File file) {
        this.file = file;
    }

    @Override
    public void writeString(String string) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file))) {
            writer.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
