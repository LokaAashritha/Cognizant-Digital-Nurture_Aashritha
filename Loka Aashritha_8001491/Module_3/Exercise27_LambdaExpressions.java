import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise27_LambdaExpressions {

    public static void main(String[] args) {

        List<String> cityNameCollectionValue =
                new ArrayList<>();

        cityNameCollectionValue.add("Delhi");
        cityNameCollectionValue.add("Mumbai");
        cityNameCollectionValue.add("Chennai");
        cityNameCollectionValue.add("Hyderabad");
        cityNameCollectionValue.add("Bengaluru");

        Collections.sort(
                cityNameCollectionValue,
                (firstCityValue, secondCityValue) ->
                        firstCityValue.compareTo(secondCityValue)
        );

        System.out.println("Sorted List:");

        cityNameCollectionValue.forEach(
                cityNameValue -> System.out.println(cityNameValue)
        );
    }
}