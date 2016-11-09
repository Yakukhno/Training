package training.ua;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Reflection {

    private Class clazz;

    public Reflection(Class clazz) {
        this.clazz = clazz;
    }

    public void invokeAnnotatedMethods(Class annotation, Object object) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotation)) {
                try {
                    if (method.getParameterTypes().length == 0) {
                        System.out.println(method.invoke(object));
                    } else {
                        return;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void showConstructorsWithParameters() {
        Constructor[] constructors = clazz.getDeclaredConstructors();

        System.out.println("Constructors : ");
        for (Constructor constructor : constructors) {
            System.out.print("\tConstructor params : ");
            for (Class parameterType : constructor.getParameterTypes()) {
                System.out.print(parameterType.getSimpleName() + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    public void showMethods() {
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Methods : ");
        for (Method method : methods) {
            int modifiers = method.getModifiers();

            showModifiers(modifiers);
            System.out.print(method.getName() + " params : ");

            if (method.getParameterTypes().length != 0) {
                for (Class parameterType : method.getParameterTypes()) {
                    System.out.print(parameterType.getSimpleName() + " ");
                }
            } else {
                System.out.print("no params");
            }

            Annotation[] annotations = method.getAnnotations();
            if (annotations.length != 0) {
                System.out.print("  @annotated by ");
                for (Annotation annotation : annotations) {
                    System.out.print(annotation.annotationType().
                            getSimpleName() + " ");
                }
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    public void showFields() {
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("Fields : ");
        for (Field field : fields) {
            int modifiers = field.getModifiers();

            showModifiers(modifiers);
            System.out.println(field.getType().getSimpleName() + " " +
                    field.getName());

            Annotation[] annotations = field.getAnnotations();
            if (annotations.length != 0) {
                System.out.print("  @annotated by ");
                for (Annotation annotation : annotations) {
                    System.out.print(annotation.annotationType().
                            getSimpleName() + " ");
                }
            }
        }
        System.out.println("--------------------");
    }

    public void showInterfaces() {
        Class[] interfaces = clazz.getInterfaces();

        System.out.print("Interfaces : ");
        for (Class clazz : interfaces) {
            System.out.print(clazz.getName() + " ");
        }
        System.out.println("\n--------------------");
    }

    public void showClassModifiers() {
        int modifiers = clazz.getModifiers();

        System.out.print("Class modifiers : ");
        if (Modifier.isPublic(modifiers)) {
            System.out.print("public ");
        }
        if (Modifier.isAbstract(modifiers)) {
            System.out.print("abstract ");
        } else if (Modifier.isFinal(modifiers)) {
            System.out.print("final ");
        }
        System.out.println("\n--------------------");
    }

    public void showPackageAndClassName() {
        System.out.println(clazz.getPackage() + " | class "
                + clazz.getSimpleName() + "\n--------------------");
    }

    public void showSuperclassName() {
        System.out.println("Superclass : " + clazz.getSuperclass().getSimpleName()
                + "\n--------------------");
    }

    public void showClassAnnotations() {
        Annotation[] annotations = clazz.getAnnotations();

        System.out.print("Annotations : ");
        for (Annotation annotation : annotations) {
            System.out.print(annotation.annotationType().getSimpleName() + " ");
        }
        System.out.println("\n--------------------");
    }

    private void showModifiers(int modifiers) {
        if (Modifier.isPublic(modifiers)) {
            System.out.print("\tpublic ");
        } else if (Modifier.isProtected(modifiers)) {
            System.out.print("\tprotected ");
        } else if (Modifier.isPrivate(modifiers)) {
            System.out.print("\tprivate ");
        }
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}
