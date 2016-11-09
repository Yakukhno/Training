package training.ua;

import java.lang.reflect.*;

public class App {

    public static void main(String[] args) {

        Note note = new Note("Petro", "Ivanov", "Sydorovich", 501234567,
                new Date(3, Month.JUNE, 1980));

        Class noteClass = note.getClass();
        Reflection reflection = new Reflection(noteClass);

        reflection.invokeAnnotatedMethods(Invoke.class, note); //only without params

        reflection.showConstructorsWithParameters();
        reflection.showMethods();
        reflection.showFields();
        reflection.showInterfaces();
        reflection.showClassModifiers();
        reflection.showPackageAndClassName();
        reflection.showSuperclassName();
        reflection.showClassAnnotations();

        INote proxyNote = (INote) Proxy.newProxyInstance(Note.class.getClassLoader(),
                Note.class.getInterfaces(), new ProxyHandler(note));

        System.out.println(proxyNote.getLastName());
        proxyNote.setPhoneNumber(4422);

    }

}
