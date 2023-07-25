import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<String> quitFromApp = List.of("выход", "2", "нет");
    private static List<String> startNewGame = List.of("новая игра", "1", "да");
    private static String language = "ru";
    private static int wordLength = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Начать новую игру или выйти из приложения?");
        System.out.println("да/нет, 1/2, новая игра/выход");
        String newGameOrQuit = scanner.nextLine();

        if (quitFromApp.contains(newGameOrQuit.toLowerCase())) {
            System.out.println("Хорошо, тогда в следующий раз!)");
        } else if (startNewGame.contains(newGameOrQuit.toLowerCase())) {
            preGameMessages();
            preGameSettings(scanner);


        }
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
        language = scanner.nextLine();

        System.out.println("Так же, можно выбрать длину слов (по-умолчанию длина равна 5)");
        wordLength = scanner.nextInt();
    }
}
