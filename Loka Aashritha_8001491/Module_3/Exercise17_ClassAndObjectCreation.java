class Car {

    String manufacturerNameValue;
    String modelNameValue;
    int manufacturingYearValue;

    public Car(String manufacturerNameValue,
               String modelNameValue,
               int manufacturingYearValue) {

        this.manufacturerNameValue = manufacturerNameValue;
        this.modelNameValue = modelNameValue;
        this.manufacturingYearValue = manufacturingYearValue;
    }

    public void displayDetails() {

        System.out.println("Make: " + manufacturerNameValue);
        System.out.println("Model: " + modelNameValue);
        System.out.println("Year: " + manufacturingYearValue);
        System.out.println();
    }
}

public class Exercise17_ClassAndObjectCreation {

    public static void main(String[] args) {

        Car firstCarObject = new Car(
                "Toyota",
                "Camry",
                2022);

        Car secondCarObject = new Car(
                "Honda",
                "City",
                2023);

        firstCarObject.displayDetails();
        secondCarObject.displayDetails();
    }
}