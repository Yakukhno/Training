package ua.training.view;

/**
 * Class has method to show string message in {@link java.io.Console}.
 * Implements {@link IView} interface.
 *
 * @author Ivan Yakukhno
 */
public class ConsoleView implements IView {

    /**
     * Shows string message in {@link java.io.Console}.
     * @param str message to show
     */
    public void showMessage(String str) {
        System.out.println(str);
    }

}
