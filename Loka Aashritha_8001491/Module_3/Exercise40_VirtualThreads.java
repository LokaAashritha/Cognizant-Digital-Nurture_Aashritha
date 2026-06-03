public class Exercise40_VirtualThreads {

    public static void main(String[] args) {

        System.out.println("Starting Virtual Threads...");

        for (int taskCounterValue = 1; taskCounterValue <= 100_000; taskCounterValue++) {

            int finalTaskIdValue = taskCounterValue;

            Thread.startVirtualThread(() -> {

                System.out.println(
                        "Virtual Thread Task: " + finalTaskIdValue
                );
            });
        }

        System.out.println("All virtual threads started.");
    }
}