import java.util.Scanner;

public class Main {
    private static Stack<PaymentGateway> stack = new Stack<>();
    private static Queue<PaymentGateway> queue = new Queue<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        printHeader();
        System.out.println();

        String operation = getFirstLevelOperations();
        do {
            boolean goBack = false;

            switch (operation) {
                case "1":
                    String stackOperation = getStackOperations();
                    do {
                        switch (stackOperation) {
                            case "1": stackPush(); break;
                            case "2": stackPop(); break;
                            case "3": stackTop(); break;
                            case "4": stackIsEmpty(); break;
                            case "5": stackSize(); break;
                            case "6": stackDisplay(); break;
                            case "b": goBack = true; break;
                            default:
                                System.out.println("Sorry! We don't know how to handle this request, please try again.");
                                break;
                        }

                        if (goBack) break;

                        System.out.print("Click enter to continue...");
                        input.nextLine();
                        System.out.println("========");


                        stackOperation = getStackOperations();
                    } while(true);
                    goBack = false;
                    break;
                case "2":
                    String queueOperation = getQueueOperations();
                    do {
                        switch (queueOperation) {
                            case "1": queueEnqueue(); break;
                            case "2": queueDequeue(); break;
                            case "3": queueFront(); break;
                            case "4": queueIsEmpty(); break;
                            case "5": queueSize(); break;
                            case "6": queueDisplay(); break;
                            case "b": goBack = true; break;
                            default:
                                System.out.println("Sorry! We don't know how to handle this request, please try again.");
                                break;
                        }

                        if (goBack) break;

                        System.out.print("Click enter to continue...");
                        input.nextLine();
                        System.out.println("========");


                        queueOperation = getQueueOperations();
                    } while(true);
                    goBack = false;
                    break;
                case "q":
                    System.out.println("Good Bye!");
                    System.out.println("========");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Sorry! We don't know how to handle this request, please try again.");
                    break;
            }

            System.out.print("Click enter to continue...");
            input.nextLine();
            System.out.println("========");

            operation = getFirstLevelOperations();
        } while (true);
    }

    private static void printHeader() {
        String[] headerText = new String[]{
                "You just launched the most powerful menu app,",
                "it saves your payments gateways using the linked list magic :)",
                "",
                "Made with ❤️ by https://github.com/YazeedAlKhalaf",
        };
        BoxPrinter.printBoxedText(headerText);
    }

    private static String getFirstLevelOperations() {
        System.out.println("Choose Stack or Queue:");
        System.out.println("1) Stack");
        System.out.println("2) Queue");
        System.out.println("q) Exit");
        System.out.print("> Choose an operation: ");

        return input.nextLine();
    }

    private static String getStackOperations() {
        System.out.println("Choose Stack Operation:");
        System.out.println("1) Push");
        System.out.println("2) Pop");
        System.out.println("3) Top");
        System.out.println("4) IsEmpty");
        System.out.println("5) Size");
        System.out.println("6) Display");
        System.out.println("b) Back");
        System.out.print("> Choose an operation: ");

        return input.nextLine();
    }

    private static String getQueueOperations() {
        System.out.println("Choose Queue Operation:");
        System.out.println("1) Enqueue");
        System.out.println("2) Dequeue");
        System.out.println("3) Front");
        System.out.println("4) IsEmpty");
        System.out.println("5) Size");
        System.out.println("6) Display");
        System.out.println("b) Back");
        System.out.print("> Choose an operation: ");

        return input.nextLine();
    }

      /////////////////
     // STACK STUFF //
    /////////////////

    private static void stackPush() {}

    private static void stackPop() {}

    private static void stackTop() {}

    private static void stackIsEmpty() {}

    private static void stackSize() {}

    private static void stackDisplay() {}

      /////////////////
     // QUEUE STUFF //
    /////////////////

    private static void queueEnqueue() {}

    private static void queueDequeue() {}

    private static void queueFront() {}

    private static void queueIsEmpty() {}

    private static void queueSize() {}

    private static void queueDisplay() {}
}