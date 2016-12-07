package ua.training.model.io.reader;

import java.io.*;

/**
 * Class reads data from file and return it in string.
 * Implements {@link IStringReader}.
 *
 * @author Ivan Yakukhno
 */
public class FileReader implements IStringReader {

    /**
     * String presentation of file data.
     */
    private String string = "";

    /**
     * File for reading.
     */
    private File file;

    /**
     * Time of last file modification.
     */
    private long lastModified;

    /**
     * Constructor.
     * @param file file for reading
     */
    public FileReader(File file) {
        this.file = file;
    }

    /**
     * Reads data from file in string.
     */
    private void read() {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            reader.lines().forEach(s -> string += s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns string presentation of file data. Checks for file modification.
     * @return string presentation of data in file
     */
    @Override
    public String getString() {
        if (lastModified != file.lastModified()) {
            read();
            lastModified = file.lastModified();
        }
        return string;
    }
}
