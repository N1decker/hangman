import java.util.Random;

public class RandomWordGenerator {

    private static final Random random = new Random();

    private static final String[] russianWords = {"выборы", "кольцо", "проблема", "добро", "апрель",
            "дверь", "беседа", "администрация", "формула", "президент", "ветер", "тень",
            "кровать", "разница", "опасность", "параметр", "роль", "предприятие", "еда",
            "мастер", "угроза", "практика", "мастер", "недостаток", "разница", "остаток",
            "министр", "гостиница", "потребность", "лето"};

    public static String generateWord() {
        long count = russianWords.length;
        return russianWords[random.nextInt((int) count)];
    }
}
