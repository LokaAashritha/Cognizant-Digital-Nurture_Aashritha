import java.util.Scanner;

public class Exercise14_ArraySumAndAverage {

    public static void main(String[] args) {

        Scanner arrayInputReader = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int totalElementCountValue = arrayInputReader.nextInt();

        int[] numberCollectionValue = new int[totalElementCountValue];

        int sumOfElementsValue = 0;

        for (int elementIndexValue = 0;
             elementIndexValue < totalElementCountValue;
             elementIndexValue++) {

            System.out.print("Enter element " + (elementIndexValue + 1) + ": ");

            numberCollectionValue[elementIndexValue] =
                    arrayInputReader.nextInt();

            sumOfElementsValue +=
                    numberCollectionValue[elementIndexValue];
        }

        double averageValue =
                (double) sumOfElementsValue / totalElementCountValue;

        System.out.println("Sum = " + sumOfElementsValue);
        System.out.println("Average = " + averageValue);

        arrayInputReader.close();
    }
}