public class BoxPrinter {
    private static final String ANSI_RESET = "\033[0m";
    // Color for the text
    private static final String ANSI_YELLOW = "\033[33m";
    // Color for the box border
    private static final String ANSI_CYAN = "\033[36m";


    public static void printBoxedText(String[] lines) {
        int maxLength = findMaxLineLength(lines);

        printLine(maxLength, ANSI_CYAN);
        for (String line : lines) {
            System.out.print(ANSI_CYAN + "| " + ANSI_RESET);
            System.out.print(ANSI_YELLOW + line + ANSI_RESET);
            for (int i = 0; i < maxLength - line.length(); i++) {
                System.out.print(" ");
            }
            System.out.println(ANSI_CYAN + " |" + ANSI_RESET);
        }
        printLine(maxLength, ANSI_CYAN);
    }

    private static int findMaxLineLength(String[] lines) {
        int maxLength = 0;
        for (String line : lines) {
            maxLength = Math.max(maxLength, line.length());
        }
        return maxLength;
    }

    private static void printLine(int length, String color) {
        System.out.print(color + "+");
        for (int i = 0; i < length + 2; i++) {
            System.out.print("-");
        }
        System.out.println("+" + ANSI_RESET);
    }
}