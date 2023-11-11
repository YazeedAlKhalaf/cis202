import java.util.Scanner;

public class Main {
    private static LinkedList<String> menuList = new LinkedList<>();
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
                case "10": countOfNodes(); break;
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
                "it saves your items using the linked list magic :)",
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
        System.out.println("10) Count of nodes");
        System.out.println("q) Exit");
        System.out.print("> Choose an operation: ");

        return input.nextLine();
    }

    private static void insertAtFirst() {
        System.out.print("> Enter the name of the menu item to add: ");
        String userInput = input.nextLine();
        menuList.insertAtFirst(userInput);
        System.out.println("'" + userInput + "' has been inserted at first successfully!");
    }

    private static void insertAtLast() {
        System.out.print("> Enter the name of the menu item to add: ");
        String newElement = input.nextLine();
        menuList.insertAtLast(newElement);
        System.out.println("'" + newElement + "' has been inserted at last successfully!");
    }

    private static void deleteAtFirst() {
        String deletedElement =  menuList.deleteAtFirst();
        if (deletedElement == null) {
            System.out.println("No element has been deleted, please add an element first!");
            return;
        }

        System.out.println("'" + deletedElement + "' has been deleted at first successfully!");
    }

    private static void deleteAtLast() {
        String deletedElement =  menuList.deleteAtLast();
        if (deletedElement == null) {
            System.out.println("No element has been deleted, please add an element first!");
            return;
        }

        System.out.println("'" + deletedElement + "' has been deleted at last successfully!");
    }

    private static void search() {
        System.out.print("> Enter the name of the menu item to search for: ");
        String searchWord = input.nextLine();

        LinkedList.Node<String> result = menuList.search(searchWord);
        if (result == null) {
            System.out.println("We didn't find any element matching the name you provided: " + searchWord);
            return;
        }

        System.out.println("We found the element you searched for: " + result.getElement());
    }

    private static void insertBeforeElement() {}

    private static void insertAfterElement() {}

    private static void display() {
        menuList.display();
    }

    private static void isEmpty() {
        System.out.println(menuList.isEmpty() ? "The list is empty." : "The list is not empty.");
    }

    private static void countOfNodes() {
        System.out.println("The count of nodes in the menu is: " + menuList.countOfNodes());
    }
}
