package ua.training.model.text.parser;

import ua.training.model.text.composite.*;
import ua.training.model.text.element.Code;
import ua.training.model.text.element.Symbol;
import ua.training.model.text.element.SymbolFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompositeElementParser implements IParser {

    private String codeExp = "(((package|import(\\s+static)?)\\s+\\w+" +
            "(\\s*\\.\\s*\\w+)*\\s*;)" +
            "|(public\\s+)?((abstract|final)\\s+)?" +
            "class\\s+\\w+((\\s+extends\\s+\\w+(\\s*,\\s*\\w*)*)?" +
            "(\\s+implements\\s+\\w+(\\s*,\\s*\\w*)*)?)" +
            "\\s*\\{).*?}(\\w+\\s+\\w+\\s+)";

    private String sentenceInTextExp = ".*?(\\?!|[.?!](\\.\\.)?)(?!\\d)";

    private String textExp = codeExp + "|" + sentenceInTextExp;

    private String wordInSentenceExp = "^[а-яА-яЁёA-Za-z\\-']+$";

    private String numberInSentenceExp = "^\\d+(\\.*\\d+)?$";

    private String punctuationInSentenceExp = "[.,?!\\[\\]—\\-()«»'\":;]";

    private String sentenceExp = "[а-яА-яЁё\\w\\-.']+(?=\\s|" + punctuationInSentenceExp +
            ")|" + punctuationInSentenceExp;

    private String letterExp = "[а-яА-яЁёA-Za-z]";

    private String punctuationInWordExp = "['\\-]";

    private String wordExp = letterExp + "|" + punctuationInSentenceExp;

    private String digitExp = "\\d";

    private String punctuationExp = "\\.";

    private String numberExp = digitExp + "|" + punctuationExp;

    public ICompositeElement parseText(String stringElement) {
        Pattern pattern = Pattern.compile(textExp);
        Matcher matcher = pattern.matcher(stringElement.replaceAll("\n", " "));
        ICompositeElement text = new CompositeElement(CompositeElement.Type.TEXT);
        while (matcher.find()) {
            String element = matcher.group();
            if (element.matches(codeExp)) {
                text.addComponent(new Code(element));
            } else if (element.matches(sentenceInTextExp)) {
                text.addComponent(parseSentence(element));
            } else {
                System.err.print("Error - " + element);
            }
        }
        return text;
    }

    public ICompositeElement parseSentence(String string) {
        Pattern pattern = Pattern.compile(sentenceExp);
        Matcher matcher = pattern.matcher(string);
        ICompositeElement sentence
                = new CompositeElement(CompositeElement.Type.SENTENCE);
        while (matcher.find()) {
            String element = matcher.group();
            if (element.matches(wordInSentenceExp)) {
                sentence.addComponent(parseWord(element));
            } else if (element.matches(numberInSentenceExp)) {
                sentence.addComponent(parseNumber(element));
            } else if (element.matches(punctuationInSentenceExp)) {
                sentence.addComponent(SymbolFactory.getSymbol(element.charAt(0),
                        Symbol.Type.PUNCTUATION_MARK));
            } else {
                System.err.print("Error - " + element);
            }
        }
        return sentence;
    }

    public ICompositeElement parseWord(String string) {
        Pattern pattern = Pattern.compile(wordExp);
        Matcher matcher = pattern.matcher(string);
        ICompositeElement word = new CompositeElement(CompositeElement.Type.WORD);
        while (matcher.find()) {
            String element = matcher.group();
            if (element.matches(letterExp)) {
                word.addComponent(SymbolFactory.getSymbol(element.charAt(0),
                        Symbol.Type.LETTER));
            } else if (element.matches(punctuationInWordExp)) {
                word.addComponent(SymbolFactory.getSymbol(element.charAt(0),
                        Symbol.Type.PUNCTUATION_MARK));
            } else {
                System.err.print("Error - " + element);
            }
        }
        return word;
    }

    public ICompositeElement parseNumber(String string) {
        Pattern pattern = Pattern.compile(numberExp);
        Matcher matcher = pattern.matcher(string);
        ICompositeElement number = new CompositeElement(CompositeElement.Type.NUMBER);
        while (matcher.find()) {
            String element = matcher.group();
            if (element.matches(digitExp)) {
                number.addComponent(SymbolFactory.getSymbol(element.charAt(0),
                        Symbol.Type.DIGIT));
            } else if (element.matches(punctuationExp)) {
                number.addComponent(SymbolFactory.getSymbol(element.charAt(0),
                        Symbol.Type.PUNCTUATION_MARK));
            } else {
                System.err.print("Error - " + element);
            }
        }
        return number;
    }
}
