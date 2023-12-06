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
                "it saves your payments gateways using the stack and queue magic :)",
                "",
                "Made with ❤️ by:",
                "- https://github.com/YazeedAlKhalaf",
                "- https://github.com/Mohammed-bu",
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

    private static void stackPush() {
        System.out.print("> Enter the name of the payment gateway to push: ");
        String name = input.nextLine();
        System.out.print("> Enter the fees per transaction of the payment gateway to push: ");
        double feesPerTx = input.nextDouble();

        PaymentGateway pg = new PaymentGateway(name, feesPerTx);
        stack.push(pg);
        System.out.println("'" + pg + "' has been pushed successfully!");
    }

    private static void stackPop() {
        PaymentGateway poppedElement =  stack.pop();
        if (poppedElement == null) {
            System.out.println("No element has been popped, please push an element first!");
            return;
        }

        System.out.println("'" + poppedElement + "' has been popped successfully!");
    }

    private static void stackTop() {
        PaymentGateway topElement = stack.top();
        if (topElement == null) {
            System.out.println("No element at top, please push an element first!");
            return;
        }

        System.out.println("'" + topElement + "' is the element at top!");
    }

    private static void stackIsEmpty() {
        System.out.println(stack.isEmpty() ? "The stack is empty." : "The stack is not empty.");
    }

    private static void stackSize() {
        System.out.println("The size of the stack is: " + stack.size());
    }

    private static void stackDisplay() {
        stack.display();
    }

      /////////////////
     // QUEUE STUFF //
    /////////////////

    private static void queueEnqueue() {
        System.out.print("> Enter the name of the payment gateway to enqueue: ");
        String name = input.nextLine();
        System.out.print("> Enter the fees per transaction of the payment gateway to enqueue: ");
        double feesPerTx = input.nextDouble();

        PaymentGateway pg = new PaymentGateway(name, feesPerTx);
        queue.enqueue(pg);
        System.out.println("'" + pg + "' has been enqueued successfully!");
    }

    private static void queueDequeue() {
        PaymentGateway poppedElement =  queue.dequeue();
        if (poppedElement == null) {
            System.out.println("No element has been dequeued, please enqueue an element first!");
            return;
        }

        System.out.println("'" + poppedElement + "' has been dequeued successfully!");
    }

    private static void queueFront() {
        PaymentGateway frontElement = queue.front();
        if (frontElement == null) {
            System.out.println("No element at top, please enqueue an element first!");
            return;
        }

        System.out.println("'" + frontElement + "' is the element at front!");
    }

    private static void queueIsEmpty() {
        System.out.println(queue.isEmpty() ? "The queue is empty." : "The queue is not empty.");
    }

    private static void queueSize() {
        System.out.println("The size of the queue is: " + queue.size());
    }

    private static void queueDisplay() {
        queue.display();
    }
}