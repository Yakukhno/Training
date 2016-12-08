package ua.training.model.text.element;

import ua.training.model.text.IComponent;

import java.util.Map;
import java.util.WeakHashMap;

public final class SymbolFactory {

    private static final Map<Character, IComponent> map = new WeakHashMap<>();

    private SymbolFactory(){}

    public static IComponent getSymbol(char element, Symbol.Type type) {
        if (map.get(element) != null) {
            return map.get(element);
        }
        IComponent newSymbol = new Symbol(element, type);
        map.put(element, newSymbol);
        return newSymbol;
    }

}
