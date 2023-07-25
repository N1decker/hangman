import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> quitFromApp = List.of("выход", "2", "нет");
    private static final List<String> startNewGame = List.of("новая игра", "1", "да");
    private static List<String> generatedWord;
    private static final ArrayList<String> usedChars = new ArrayList<>();
    private static String[] guessedWord;
    private static int mistakes = 0;
    private static String language = "ru";
    private static int wordLength = 5;
    private static boolean quitFromGame = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Начать новую игру или выйти из приложения?");
        System.out.println("да/нет, 1/2, новая игра/выход");
        String newGameOrQuit = scanner.next();

        if (quitFromApp.contains(newGameOrQuit.toLowerCase())) {
            System.out.println("Хорошо, тогда в следующий раз!)");
        } else if (startNewGame.contains(newGameOrQuit.toLowerCase())) {
            preGameMessages();
            preGameSettings(scanner);

            while (!quitFromGame) {
                generatedWord = RandomWordGenerator.splitGeneratedWord(RandomWordGenerator.generateWord(language, wordLength));

                guessedWord = new String[generatedWord.size()];
                for (int i = 0; i < guessedWord.length; i++) {
                    guessedWord[i] = "_";
                }

                printFormatGuessedWord(guessedWord);

                String nextChar = null;

                while (!isUserGuessed()) {
                    nextChar = scanner.next();
                    if (nextChar.length() > 1) {
                        System.out.println("Предлагайте только по одной букве");
                        continue;
                    }
                    checkAndPrintGuessedWord(nextChar);
                }
                afterGameMessages(scanner);
            }
        }
    }

    private static void afterGameMessages(Scanner scanner) {
        System.out.println("Хотите завершить игру или начать заново?");
        String quitFromGameAnswer = scanner.next();
        if (!startNewGame.contains(quitFromGameAnswer)) {
            System.out.println("Спасибо за игру!");
            quitFromGame = !quitFromGame;
        }
    }

    private static void printFormatGuessedWord(String[] guessedWord) {
        for (String s : guessedWord) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private static void checkAndPrintGuessedWord(String nextChar) {
        if (!usedChars.contains(nextChar)) {
            usedChars.add(nextChar);
        } else {
            System.out.println("Эта буква уже была предложена!");
        }

        for (int i = 0; i < guessedWord.length; i++) {
            if (generatedWord.get(i).equalsIgnoreCase(nextChar)) {
                guessedWord[i] = nextChar;
            }
        }

        printFormatGuessedWord(guessedWord);
    }

    private static boolean isUserGuessed() {
        for (int i = 0; i < guessedWord.length; i++) {
            if (!guessedWord[i].equalsIgnoreCase(generatedWord.get(i))) return false;
        }
        return true;
    }

    public static void preGameMessages() {
        System.out.println("Новая игра началась!");
        System.out.println("Давайте сначала настроим игру :)");
    }

    public static void preGameSettings(Scanner scanner) {
        System.out.println("На каком языке предпочитаете угадывать слова? (ru/en/it/es/de)");
        System.out.println("1. Русский (по-умолчанию)");
        System.out.println("2. Английский");
        System.out.println("3. Итальянский");
        System.out.println("4. Испанский");
        System.out.println("5. Немецкий");
        language = scanner.next();

        System.out.println("Так же, можно выбрать длину слов, но не меньше 2 и не больше 10 (по-умолчанию длина равна 5)");
        wordLength = scanner.nextInt();
    }
}
