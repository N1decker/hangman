import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final int ERROR_MAX = 6;
    private static final Scaffold[] scaffoldStates = Scaffold.values();
    private static final ArrayList<String> usedChars = new ArrayList<>();
    private static String word;
    private static String wordView;
    private static int mistakes = 0;
    private static boolean quitFromGame = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Начать новую игру - y/Y, или выйти из приложения - n/N?");
        String newGameOrQuit = scanner.next();

        if (newGameOrQuit.matches("[nNтТ]")) {
            System.out.println("Хорошо, тогда в следующий раз!)");
        } else if (newGameOrQuit.matches("[yYнН]")) {
            preGameMessage();
            gameLoop(scanner);
        } else {
            System.out.println("Раз нет такого варианта, завершаю игру!");
        }
    }

    private static void gameLoop(Scanner scanner) {
        while (!quitFromGame) {
            word = RandomWordGenerator.generateWord();
            wordView = "_".repeat(word.length());

            printWordView(wordView);
            printMistakes();
            gameRound(scanner, word);
            newGameOrQuitMessage(scanner);
        }
    }

    private static void gameRound(Scanner scanner, String word) {
        String nextChar;
        while (!isUserGuessed()) {
            nextChar = scanner.next();
            if (nextChar.length() > 1) {
                System.out.println("Предлагайте только по одной букве");
                continue;
            }
            checkAndPrintGuessedWord(nextChar);
            if (mistakes >= ERROR_MAX) {
                System.out.printf("Вы проиграли! Было загадано слово '%s'%n", word);
                break;
            }
        }
    }


    private static void checkAndPrintGuessedWord(String nextChar) {
        char[] charWord = word.toCharArray();
        char[] charWordView = wordView.toCharArray();
        if (!usedChars.contains(nextChar) && !word.contains(nextChar)) {
            usedChars.add(nextChar);
        } else if (usedChars.contains(nextChar)) {
            System.out.println("Эта буква уже была предложена!");
        }

        if (!word.contains(nextChar)) {
            mistakes += 1;
        } else {
            for (int i = 0; i < wordView.length(); i++) {
                if (charWord[i] == nextChar.charAt(0)) {
                    charWordView[i] = charWord[i];
                }
            }
            wordView = new String(charWordView);
        }
        printScaffoldState(mistakes);
        printWordView(wordView);
        printMistakes();
    }

    private static void printWordView(String wordView) {
        System.out.println("Слово: " + wordView);
    }

    private static void printScaffoldState(int mistakes) {
        System.out.println(scaffoldStates[mistakes]);
    }

    private static void printMistakes() {
        System.out.print("Ошибки (" + mistakes + "): ");
        for (String usedChar : usedChars) {
            System.out.print(usedChar + " ");
        }
        System.out.println();
    }

    private static boolean isUserGuessed() {
        for (int i = 0; i < wordView.length(); i++) {
            if (wordView.charAt(i) != (word.charAt(i))) return false;
        }

        if (Objects.equals(word, wordView)) {
            System.out.println("Вы выиграли!");
            return true;
        }
        return true;
    }

    public static void preGameMessage() {
        System.out.println("Новая игра началась!");
    }

    private static void newGameOrQuitMessage(Scanner scanner) {
        System.out.println("Хотите начать заново - (y/Y) или завершить игру(любая клавиша)?");
        String quitFromGameAnswer = scanner.next();
        if (!quitFromGameAnswer.matches("[yYнН]")) {
            System.out.println("Спасибо за игру!");
            quitFromGame = true;
        } else {
            mistakes = 0;
            usedChars.clear();
        }
    }
}
