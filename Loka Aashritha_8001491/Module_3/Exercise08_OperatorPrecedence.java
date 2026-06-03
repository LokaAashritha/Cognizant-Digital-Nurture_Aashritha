public class Exercise08_OperatorPrecedence {

    public static void main(String[] args) {

        int firstExpressionResultValue = 10 + 5 * 2;

        int secondExpressionResultValue = (10 + 5) * 2;

        int thirdExpressionResultValue = 20 / 4 + 3 * 2;

        int fourthExpressionResultValue = 20 / (4 + 1);

        System.out.println("Result 1 = " + firstExpressionResultValue);

        System.out.println("Result 2 = " + secondExpressionResultValue);

        System.out.println("Result 3 = " + thirdExpressionResultValue);

        System.out.println("Result 4 = " + fourthExpressionResultValue);
    }
}