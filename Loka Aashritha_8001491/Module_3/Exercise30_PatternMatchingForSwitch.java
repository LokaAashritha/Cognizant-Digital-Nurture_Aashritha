public class Exercise30_PatternMatchingForSwitch {

    public static void identifyObjectType(Object inputObjectValue) {

        String resultMessageValue = switch (inputObjectValue) {

            case Integer integerValue ->
                    "Integer Value: " + integerValue;

            case String textValue ->
                    "String Value: " + textValue;

            case Double decimalValue ->
                    "Double Value: " + decimalValue;

            case Long longNumberValue ->
                    "Long Value: " + longNumberValue;

            case null ->
                    "Null Value";

            default ->
                    "Unknown Object Type";
        };

        System.out.println(resultMessageValue);
    }

    public static void main(String[] args) {

        identifyObjectType(100);

        identifyObjectType("Java 21");

        identifyObjectType(99.99);

        identifyObjectType(5000L);

        identifyObjectType(null);
    }
}