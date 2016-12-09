package ua.training.view;

/**
 * Interface describes view with method to show string message.
 *
 * @see ConsoleView
 * @see FileView
 * @author Ivan Yakukhno
 */
public interface IView {

    /**
     * Shows string message.
     * @param str message to show
     */
    void showMessage(String str);

}
