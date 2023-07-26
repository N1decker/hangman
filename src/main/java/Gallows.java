public class Gallows {

    public static void initialGallowsState() {
        char[][] gallows = {
                {' ', '-', '-', '-', '-', '|'},
                {' ', '|'},
                {' ', '|'},
                {' ', '|'},
                {' ', '|'},
                {'_', '_', '_', '_', '_', '_'},
        };

        printGallowsState(gallows);
    }

    public static void secondMistakeGallowsState() {
        char[][] gallows = {
                {' ', '-', '-', '-', '|', '-'},
                {' ', '|', ' ', ' ', '○', ' '},
                {' ', '|', ' ', ' ', '|', ' '},
                {' ', '|'},
                {' ', '|'},
                {'_', '_', '_', '_', '_', '_'},
        };

        printGallowsState(gallows);
    }

    public static void thirdMistakeGallowsState() {
        char[][] gallows = {
                {' ', '-', '-', '-', '|', '-'},
                {' ', '|', ' ', ' ', '○', ' '},
                {' ', '|', ' ', ' ', '|', ' '},
                {' ', '|', ' ', ' ', ' ', '\\'},
                {' ', '|'},
                {'_', '_', '_', '_', '_', '_'},
        };

        printGallowsState(gallows);
    }

    public static void fourthMistakeGallowsState() {
        char[][] gallows = {
                {' ', '-', '-', '-', '|', '-'},
                {' ', '|', ' ', ' ', '○', ' '},
                {' ', '|', ' ', ' ', '|', ' '},
                {' ', '|', ' ', '/', ' ', '\\'},
                {' ', '|'},
                {'_', '_', '_', '_', '_', '_'},
        };

        printGallowsState(gallows);
    }

    public static void fifthMistakeGallowsState() {
        char[][] gallows = {
                {' ', '-', '-', '-', '|', '-'},
                {' ', '|', ' ', ' ', '○', ' '},
                {' ', '|', ' ', '/', '|', '\\'},
                {' ', '|', ' ', '/', ' ', '\\'},
                {' ', '|'},
                {'_', '_', '_', '_', '_', '_'},
        };

        printGallowsState(gallows);
    }

    private static void printGallowsState(char[][] gallows) {
        for (char[] chars : gallows) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.print("\n");
        }
    }
}
