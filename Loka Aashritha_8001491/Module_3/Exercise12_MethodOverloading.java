public class Exercise12_MethodOverloading {

    public static int add(int firstIntegerValue, int secondIntegerValue) {
        return firstIntegerValue + secondIntegerValue;
    }

    public static double add(double firstDecimalValue, double secondDecimalValue) {
        return firstDecimalValue + secondDecimalValue;
    }

    public static int add(int firstNumberValue,
                          int secondNumberValue,
                          int thirdNumberValue) {
        return firstNumberValue + secondNumberValue + thirdNumberValue;
    }

    public static void main(String[] args) {

        System.out.println("Sum of Two Integers: "
                + add(10, 20));

        System.out.println("Sum of Two Doubles: "
                + add(15.5, 24.5));

        System.out.println("Sum of Three Integers: "
                + add(5, 10, 15));
    }
}