import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise28_StreamAPI {

    public static void main(String[] args) {

        List<Integer> numberCollectionValue =
                Arrays.asList(10, 15, 22, 31, 48, 57, 64, 79, 80);

        List<Integer> evenNumberCollectionValue =
                numberCollectionValue.stream()
                        .filter(numberValue -> numberValue % 2 == 0)
                        .collect(Collectors.toList());

        System.out.println("Even Numbers:");

        evenNumberCollectionValue.forEach(
                evenNumberValue -> System.out.println(evenNumberValue)
        );
    }
}