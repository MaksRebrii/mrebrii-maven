package hw13ToLesson18;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Main {

    private Main() {
    }

    public static double getAverage(List<? extends Number> list) {
        return list.stream()
                .mapToDouble(Number::doubleValue)
                .average()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static List<String> changeCollection(List<String> list) {
        Predicate<String> startsWithVowel = o -> o.startsWith("a") || o.startsWith("e") || o.startsWith("i") || o.startsWith("o") || o.startsWith("u") || o.startsWith("y") ||
                o.startsWith("A") || o.startsWith("E") || o.startsWith("I") || o.startsWith("O") || o.startsWith("U") || o.startsWith("Y");
        return list.stream().
                filter(startsWithVowel)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static List<String> filterCollection(List<String> list) {
        return list.stream()
                .filter(str -> str.length() == 4 && str.equals(str.toLowerCase()))
                .collect(Collectors.toList());
    }

}
