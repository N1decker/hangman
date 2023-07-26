import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> quitFromApp = List.of("выход", "2", "нет");
    private static final List<String> startNewGame = List.of("новая игра", "1", "да");
    private static List<String> splitGeneratedWord;
    private static final ArrayList<String> usedChars = new ArrayList<>();
    private static String[] guessedWord;
    private static int mistakes = 0;
    private static boolean quitFromGame = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Начать новую игру или выйти из приложения?");
        System.out.println("да/нет, 1/2, новая игра/выход");
        String newGameOrQuit = scanner.next();

        if (quitFromApp.contains(newGameOrQuit.toLowerCase())) {
            System.out.println("Хорошо, тогда в следующий раз!)");
        } else if (startNewGame.contains(newGameOrQuit.toLowerCase())) {
            preGameMessage();

            while (!quitFromGame) {
                String generatedWord = RandomWordGenerator.generateWord();
                splitGeneratedWord = RandomWordGenerator.splitGeneratedWord(generatedWord);
                guessedWord = new String[splitGeneratedWord.size()];
                Arrays.fill(guessedWord, "_");

                printFormatGuessedWord(guessedWord);

                String nextChar;
                while (!isUserGuessed()) {
                    nextChar = scanner.next();
                    if (nextChar.length() > 1) {
                        System.out.println("Предлагайте только по одной букве");
                        continue;
                    }
                    checkAndPrintGuessedWord(nextChar);
                    if (mistakes >= 5) {
                        System.out.printf("Вы проиграли! Было загадано слово '%s'%n", generatedWord);
                        break;
                    }
                }
                afterGameMessage(scanner);
            }
        }
    }


    private static void checkAndPrintGuessedWord(String nextChar) {
        if (!usedChars.contains(nextChar)) {
            usedChars.add(nextChar);
        } else {
            System.out.println("Эта буква уже была предложена!");
        }

        if (!splitGeneratedWord.contains(nextChar)) {
            mistakes += 1;
        } else {
            for (int i = 0; i < guessedWord.length; i++) {
                if (splitGeneratedWord.get(i).equalsIgnoreCase(nextChar)) {
                    guessedWord[i] = nextChar;
                }
            }
        }

        printMistakes();
        printFormatGuessedWord(guessedWord);
    }

    private static void printMistakes() {

        switch (mistakes) {
            case 1 -> initialGallowsState();
            case 2 -> secondMistakeGallowsState();
            case 3 -> thirdMistakeGallowsState();
            case 4 -> fourthMistakeGallowsState();
            case 5 -> fifthMistakeGallowsState();
        }
    }

    private static void printMistakesCount() {
        System.out.print("Ошибки (" + mistakes + "): ");
        for (String usedChar : usedChars) {
            System.out.print(usedChar + " ");
        }
        System.out.println();
    }

    private static void printFormatGuessedWord(String[] guessedWord) {
        System.out.print("Слово: ");
        for (String s : guessedWord) {
            System.out.print(s + " ");
        }
        System.out.println();
        printMistakesCount();
    }

    private static boolean isUserGuessed() {
        for (int i = 0; i < guessedWord.length; i++) {
            if (!guessedWord[i].equalsIgnoreCase(splitGeneratedWord.get(i))) return false;
        }
        return true;
    }

    public static void preGameMessage() {
        System.out.println("Новая игра началась!");
    }

    private static void afterGameMessage(Scanner scanner) {
        System.out.println("Хотите начать заново или завершить игру?");
        String quitFromGameAnswer = scanner.next();
        if (!startNewGame.contains(quitFromGameAnswer)) {
            System.out.println("Спасибо за игру!");
            quitFromGame = true;
        } else {
            mistakes = 0;
            usedChars.clear();
        }
    }

    private static void initialGallowsState() {
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

    private static void secondMistakeGallowsState() {
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

    private static void thirdMistakeGallowsState() {
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

    private static void fourthMistakeGallowsState() {
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

    private static void fifthMistakeGallowsState() {
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
