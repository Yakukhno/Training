package ua.training.controller;

import ua.training.model.text.IComponent;
import ua.training.model.text.composite.ICompositeElement;
import ua.training.model.text.parser.ITextProcessor;
import ua.training.model.text.parser.TextProcessor;
import ua.training.model.io.reader.IStringReader;
import ua.training.view.IView;

import java.util.Map;

/**
 * Class describes controller between textProcessor and view.
 * Implements {@link IController} interface.
 *
 * @author Ivan Yakukhno
 */
public class TextController implements IController {

    /**
     * View.
     */
    private IView view;

    /**
     * Text processor.
     */
    private ITextProcessor textProcessor;

    /**
     * Words reader.
     */
    private IStringReader textReader;

    /**
     * Words reader.
     */
    private IStringReader wordsReader;

    /**
     * Constructor.
     * @param view view
     * @param textProcessor text processor to process text
     * @param textReader reader of text
     * @param wordsReader reader of words
     */
    public TextController(IView view, ITextProcessor textProcessor,
                          IStringReader textReader, IStringReader wordsReader) {
        this.view = view;
        this.textProcessor = textProcessor;
        this.textReader = textReader;
        this.wordsReader = wordsReader;
    }

    /**
     * Invokes parse methods on textProcessor.
     * Transmit results of parsing in view.
     */
    public void execute() {
        textProcessor.setText(textReader.getString());

        view.showMessage(componentToString(textProcessor.getText(), ""));

        view.showMessage(textProcessor.getWordsOccurrencesInEachSentence(
                wordsReader.getString()).toString());

        Map<IComponent, Integer> map = textProcessor
                .getWordsOccurrencesInAllSentences(wordsReader.getString());
        view.showMessage(textProcessor.sortWords(map, textProcessor
                .wordsByOccurrencesComparator(map).reversed()).toString());
    }

    /**
     * Creates string presentation of component.
     * @param component component to string presentation
     * @param tabulation tabulation
     * @return string presentation of component
     */
    String componentToString(IComponent component, String tabulation) {
        StringBuilder string = new StringBuilder();
        string.append("\n").append(tabulation).append(component.toString());
        if (component instanceof ICompositeElement) {
            for (IComponent loopComponent
                    : ((ICompositeElement)component).getComponents()) {
                string.append(componentToString(loopComponent, tabulation + "\t"));
            }
        }
        return string.toString();
    }

    void setTextProcessor(ITextProcessor textProcessor) {
        this.textProcessor = textProcessor;
    }
}
