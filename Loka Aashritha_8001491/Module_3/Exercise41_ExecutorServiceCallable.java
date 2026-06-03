import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exercise41_ExecutorServiceCallable {

    public static void main(String[] args) {

        ExecutorService threadPoolValue =
                Executors.newFixedThreadPool(3);

        List<Callable<Integer>> taskListValue =
                new ArrayList<>();

        for (int taskCounterValue = 1;
             taskCounterValue <= 5;
             taskCounterValue++) {

            int finalTaskValue = taskCounterValue;

            taskListValue.add(() -> {

                int resultValue = finalTaskValue * finalTaskValue;

                System.out.println(
                        "Task " + finalTaskValue
                                + " computed by "
                                + Thread.currentThread().getName()
                );

                return resultValue;
            });
        }

        try {

            List<Future<Integer>> futureListValue =
                    threadPoolValue.invokeAll(taskListValue);

            for (Future<Integer> futureValue : futureListValue) {

                System.out.println(
                        "Result = " + futureValue.get()
                );
            }

        } catch (InterruptedException | ExecutionException exceptionValue) {

            System.out.println("Error: " + exceptionValue.getMessage());
        }

        threadPoolValue.shutdown();
    }
}