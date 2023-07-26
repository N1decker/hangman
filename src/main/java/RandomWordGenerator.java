import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomWordGenerator {

    private static final Random random = new Random();

    private static final String[] russianWords = {"выборы", "кольцо", "проблема", "добро", "апрель",
            "дверь", "беседа", "администрация", "формула", "президент", "ветер", "тень",
            "кровать", "разница", "опасность", "параметр", "роль", "предприятие", "еда",
            "мастер", "угроза", "практика", "мастер", "недостаток", "разница", "остаток",
            "министр", "гостиница", "потребность", "лето"};

    public static String generateWord() {
        int randomInt;

        long count = russianWords.length;
        randomInt = random.nextInt((int) count);
        return russianWords[randomInt];

    }

    public static List<String> splitGeneratedWord(String word) {
        return Arrays.stream(word.split("")).toList();
    }
}
