class MessagePrinterTask implements Runnable {

    private String threadMessageValue;

    public MessagePrinterTask(String threadMessageValue) {
        this.threadMessageValue = threadMessageValue;
    }

    @Override
    public void run() {

        for (int messageCounterValue = 1;
             messageCounterValue <= 5;
             messageCounterValue++) {

            System.out.println(
                    threadMessageValue
                    + " - Count: "
                    + messageCounterValue
            );

            try {
                Thread.sleep(500);
            } catch (InterruptedException interruptedErrorValue) {
                System.out.println("Thread interrupted.");
            }
        }
    }
}

public class Exercise26_ThreadCreation {

    public static void main(String[] args) {

        Thread firstThreadObject =
                new Thread(
                        new MessagePrinterTask("Thread One Running")
                );

        Thread secondThreadObject =
                new Thread(
                        new MessagePrinterTask("Thread Two Running")
                );

        firstThreadObject.start();
        secondThreadObject.start();
    }
}