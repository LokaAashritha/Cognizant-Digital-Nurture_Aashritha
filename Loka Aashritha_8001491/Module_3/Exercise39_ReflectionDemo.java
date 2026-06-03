import java.lang.reflect.Method;

class DemoClass {

    public void showMessage() {
        System.out.println("Hello from DemoClass method!");
    }

    public void displayNumber(int numberValue) {
        System.out.println("Number = " + numberValue);
    }
}

public class Exercise39_ReflectionDemo {

    public static void main(String[] args) {

        try {

            Class<?> loadedClassValue =
                    Class.forName("DemoClass");

            System.out.println("Methods in DemoClass:");

            Method[] methodsArrayValue =
                    loadedClassValue.getDeclaredMethods();

            for (Method methodValue : methodsArrayValue) {

                System.out.println(
                        methodValue.getName()
                );
            }

            Object demoObjectValue =
                    loadedClassValue.getDeclaredConstructor().newInstance();

            Method methodToInvokeValue =
                    loadedClassValue.getMethod("showMessage");

            methodToInvokeValue.invoke(demoObjectValue);

            Method numberMethodValue =
                    loadedClassValue.getMethod("displayNumber", int.class);

            numberMethodValue.invoke(demoObjectValue, 100);

        } catch (Exception exceptionValue) {

            System.out.println("Reflection Error: " + exceptionValue.getMessage());
        }
    }
}