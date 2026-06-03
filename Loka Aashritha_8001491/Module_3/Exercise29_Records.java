import java.util.List;

record PersonRecordValue(String personNameValue, int personAgeValue) {
}

public class Exercise29_Records {

    public static void main(String[] args) {

        PersonRecordValue firstPersonValue =
                new PersonRecordValue("Ravi", 22);

        PersonRecordValue secondPersonValue =
                new PersonRecordValue("Priya", 17);

        PersonRecordValue thirdPersonValue =
                new PersonRecordValue("Kiran", 25);

        System.out.println(firstPersonValue);
        System.out.println(secondPersonValue);
        System.out.println(thirdPersonValue);

        List<PersonRecordValue> personCollectionValue =
                List.of(
                        firstPersonValue,
                        secondPersonValue,
                        thirdPersonValue
                );

        System.out.println("\nPersons age 18 and above:");

        personCollectionValue.stream()
                .filter(personValue ->
                        personValue.personAgeValue() >= 18)
                .forEach(System.out::println);
    }
}