package ua.training.model.io.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class writes string in file. Implements {@link IStringWriter}.
 *
 * @author Ivan Yakukhno
 */
public class FileWriter implements IStringWriter {

    /**
     * File for writing string.
     */
    private File file;

    /**
     * Constructor.
     * @param file file for writing string
     */
    public FileWriter(File file) {
        this.file = file;
    }

    /**
     * Writes string in file.
     * @param string string to write
     */
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
