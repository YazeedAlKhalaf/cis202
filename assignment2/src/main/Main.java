import java.util.Scanner;

public class Main {
    private static LinkedList<PaymentGateway> menuList = new LinkedList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        printHeader();
        System.out.println();

        String operation = getOperation();
        do {
            System.out.println("========");
            switch (operation) {
                case "1": insertAtFirst(); break;
                case "2": insertAtLast(); break;
                case "3": deleteAtFirst(); break;
                case "4": deleteAtLast(); break;
                case "5": search(); break;
                case "6": insertBeforeElement(); break;
                case "7": insertAfterElement(); break;
                case "8": display(); break;
                case "9": isEmpty(); break;
                case "10": countMaximum(); break;
                case "11": countAverage(); break;
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

            operation = getOperation();
        } while(true);
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

    private static String getOperation() {
        System.out.println("The LinkedList menu:");
        System.out.println("1) Insert at first");
        System.out.println("2) Insert at last");
        System.out.println("3) Delete at first");
        System.out.println("4) Delete at last");
        System.out.println("5) Search");
        System.out.println("6) Insert before element");
        System.out.println("7) Insert after element");
        System.out.println("8) Display");
        System.out.println("9) Is empty?");
        System.out.println("10) Count maximum");
        System.out.println("11) Count average");
        System.out.println("q) Exit");
        System.out.print("> Choose an operation: ");

        return input.nextLine();
    }

    private static void insertAtFirst() {
        System.out.print("> Enter the name of the payment gateway to add: ");
        String name = input.nextLine();
        System.out.print("> Enter the fees per transaction of the payment gateway to add: ");
        double feesPerTx = input.nextDouble();

        PaymentGateway pg = new PaymentGateway(name, feesPerTx);
        menuList.insertAtFirst(pg);
        System.out.println("'" + pg + "' has been inserted at first successfully!");
    }

    private static void insertAtLast() {
        System.out.print("> Enter the name of the payment gateway to add: ");
        String name = input.nextLine();
        System.out.print("> Enter the fees per transaction of the payment gateway to add: ");
        double feesPerTx = input.nextDouble();

        PaymentGateway pg = new PaymentGateway(name, feesPerTx);
        menuList.insertAtLast(pg);
        System.out.println("'" + pg + "' has been inserted at last successfully!");
    }

    private static void deleteAtFirst() {
        PaymentGateway deletedElement =  menuList.deleteAtFirst();
        if (deletedElement == null) {
            System.out.println("No element has been deleted, please add an element first!");
            return;
        }

        System.out.println("'" + deletedElement + "' has been deleted at first successfully!");
    }

    private static void deleteAtLast() {
        PaymentGateway deletedElement =  menuList.deleteAtLast();
        if (deletedElement == null) {
            System.out.println("No element has been deleted, please add an element first!");
            return;
        }

        System.out.println("'" + deletedElement + "' has been deleted at last successfully!");
    }

    private static void search() {
        System.out.print("> Enter the name of the payment gateway to search for: ");
        String searchWord = input.nextLine();

        LinkedList.SearchFunction<PaymentGateway> searchCondition = (PaymentGateway pg) -> {
            return pg.getName().equals(searchWord);
        };

        LinkedList.Node<PaymentGateway> result = menuList.search(searchCondition);
        if (result == null) {
            System.out.println("We didn't find any payment gateway matching the name you provided: " + searchWord);
            return;
        }

        System.out.println("We found the payment gateway you searched for: " + result.getElement());
    }

    private static void insertBeforeElement() {
        System.out.print("> Enter the name of the payment gateway to add the new payment gateway before: ");
        String searchWord = input.nextLine();

        LinkedList.SearchFunction<PaymentGateway> searchCondition = (PaymentGateway pg) -> {
            return pg.getName().equals(searchWord);
        };

        System.out.print("> Enter the name of the payment gateway to add: ");
        String name = input.nextLine();
        System.out.print("> Enter the fees per transaction of the payment gateway to add: ");
        double feesPerTx = input.nextDouble();

        PaymentGateway pg = new PaymentGateway(name, feesPerTx);

        boolean isSuccess = menuList.insertBeforeElement(searchCondition, pg);
        if (isSuccess) {
            System.out.println("The new payment gateway '" + pg + "' has been added before '" + searchWord + "' payment gateway.");
        } else {
            System.out.println("We couldn't add the payment gateway for you, something went wrong! Check the spelling of the payment gateway to add before.");
        }
    }

    private static void insertAfterElement() {
        System.out.print("> Enter the name of the payment gateway to add the new payment gateway after: ");
        String searchWord = input.nextLine();

        LinkedList.SearchFunction<PaymentGateway> searchCondition = (PaymentGateway pg) -> {
            return pg.getName().equals(searchWord);
        };

        System.out.print("> Enter the name of the payment gateway to add: ");
        String name = input.nextLine();
        System.out.print("> Enter the fees per transaction of the payment gateway to add: ");
        double feesPerTx = input.nextDouble();

        PaymentGateway pg = new PaymentGateway(name, feesPerTx);

        boolean isSuccess = menuList.insertAfterElement(searchCondition, pg);
        if (isSuccess) {
            System.out.println("The new payment gateway '" + pg + "' has been added after '" + searchWord + "' payment gatway");
        } else {
            System.out.println("We couldn't add the element for you, something went wrong! Check the spelling of the menu item to add before.");
        }
    }

    private static void display() {
        menuList.display();
    }

    private static void isEmpty() {
        System.out.println(menuList.isEmpty() ? "The list is empty." : "The list is not empty.");
    }

    private static void countMaximum() {
        // this is cuz some limitation of lambda in JAVA.
        final double[] maximum = {0};
        menuList.forEach((PaymentGateway pg) -> {
            if (pg.getFeesPerTx() > maximum[0]) { maximum[0] = pg.getFeesPerTx(); }
            return null;
        });

        System.out.println("The maximum fees per transaction is: " + maximum[0]);
    }

    private static void countAverage() {
        double sum = menuList.fold(0.0, (oldValue, pg) ->  oldValue + pg.getFeesPerTx());
        double average = sum / menuList.countOfNodes();

        System.out.println("The average of fees per transaction is: " + average);
    }
}
