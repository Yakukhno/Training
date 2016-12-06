package ua.training.view;

import ua.training.model.io.writer.IStringWriter;

import java.io.File;
import ua.training.model.io.writer.FileWriter;

public class FileView implements IView {

    private IStringWriter writer;

    public FileView(File file) {
        writer = new FileWriter(file);
    }

    @Override
    public void showMessage(String str) {
        writer.writeString(str);
    }
}
