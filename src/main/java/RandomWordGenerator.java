import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomWordGenerator {

    public static String generateWord(String language, int wordLength) {
        return "Test";
    }

    public static List<String> splitGeneratedWord(String word) {
        return Arrays.stream(word.split("")).toList();
    }
}
