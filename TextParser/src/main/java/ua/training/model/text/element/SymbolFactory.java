package ua.training.model.text.element;

import ua.training.model.text.IComponent;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Class describes factory of symbol objects.
 *
 * @author Ivan Yakukhno
 */
public final class SymbolFactory {

    /**
     * Map with unique {@link IComponent} objects.
     */
    private static final Map<Character, IComponent> map = new WeakHashMap<>();

    /**
     * Private constructor.
     */
    private SymbolFactory(){}

    /**
     * Return {@link IComponent} object. If map consists required symbol,
     * returns this symbol from map.
     * @param element char presentation of {@link IComponent}
     * @param type type of {@link IComponent}
     * @return {@link IComponent} object, which presents char element
     */
    public static IComponent getSymbol(char element, Symbol.Type type) {
        if (map.get(element) != null) {
            return map.get(element);
        }
        IComponent newSymbol = new Symbol(element, type);
        map.put(element, newSymbol);
        return newSymbol;
    }

}
