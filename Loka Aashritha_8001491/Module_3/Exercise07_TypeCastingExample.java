public class Exercise07_TypeCastingExample {

    public static void main(String[] args) {

        double originalDecimalValue = 98.76;

        int convertedIntegerValue = (int) originalDecimalValue;

        System.out.println("Original Double Value: " + originalDecimalValue);
        System.out.println("Converted Int Value: " + convertedIntegerValue);

        int originalWholeNumberValue = 45;

        double convertedDoubleValue = (double) originalWholeNumberValue;

        System.out.println("Original Int Value: " + originalWholeNumberValue);
        System.out.println("Converted Double Value: " + convertedDoubleValue);
    }
}