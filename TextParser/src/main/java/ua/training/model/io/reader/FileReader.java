package ua.training.model.io.reader;

import java.io.*;

public class FileReader implements IStringReader {

    private String string = "";
    private File file;

    private long lastModified;

    public FileReader(File file) {
        this.file = file;
    }

    private void read() {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            reader.lines().forEach(s -> string += s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getString() {
        if (lastModified != file.lastModified()) {
            read();
            lastModified = file.lastModified();
        }
        return string;
    }
}
