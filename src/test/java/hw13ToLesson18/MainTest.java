package hw13ToLesson18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MainTest {

    @Test
    void should_calculate_average() {
        List<Integer> list = new ArrayList<>();
        int size = 10;
        //expected
        double expectedAverage = 0;
        for (int i = 0; i < size; i++) {
            list.add(i);
            expectedAverage += i;
        }
        expectedAverage /= size;
        //actual
        double actualAverage = Main.getAverage(list);
        Assertions.assertEquals(expectedAverage, actualAverage);
    }

    @Test
    void should_change_collection() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("Yellow");

        //expected
        List<String> listExpected = new ArrayList<>();
        listExpected.add("APPLE");
        listExpected.add("YELLOW");

        //actual
        list = Main.changeCollection(list);

        Assertions.assertEquals(listExpected, list);
    }

    @Test
    void should_filter_collection() {
        List<String> listToFilter = new ArrayList<>();
        listToFilter.add("size");
        listToFilter.add("sIze");
        listToFilter.add("one");
        listToFilter.add("OnE");
        listToFilter.add("stream");
        listToFilter.add("Stream");

        //expected
        List<String> listExpected = new ArrayList<>();
        listExpected.add("size");

        //actual
        listToFilter = Main.filterCollection(listToFilter);

        Assertions.assertEquals(listExpected, listToFilter);
    }

}