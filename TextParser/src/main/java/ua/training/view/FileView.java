package ua.training.view;

import ua.training.model.io.writer.IStringWriter;

import java.io.File;
import ua.training.model.io.writer.FileWriter;

/**
 * Class has method to show string message in {@link File}.
 * Implements {@link IView} interface.
 *
 * @author Ivan Yakukhno
 */
public class FileView implements IView {

    /**
     * Writer.
     */
    private IStringWriter writer;

    /**
     * Constructor.
     * @param file file in which message shows.
     */
    public FileView(File file) {
        writer = new FileWriter(file);
    }

    /**
     * Shows string message in {@link File}.
     * @param str message to show
     */
    @Override
    public void showMessage(String str) {
        writer.writeString(str);
    }
}
