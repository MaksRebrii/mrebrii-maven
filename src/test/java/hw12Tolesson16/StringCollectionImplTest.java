package hw12Tolesson16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StringCollectionImplTest {
    private StringCollectionImpl collection;
    private int initializationSize = 10;
    private int collectionSizeAfterAddingNewElement = initializationSize + 1;

    @BeforeEach
    void setUp(){
        collection = formCollection();
    }

    @Test
    void when_added_10_elements_then_size_must_be_10() {
        Assertions.assertEquals(initializationSize, collection.size());
    }

    @Test
    void get_4th_element(){
        //expected
        String expectedElement = "String4";

        //actual
        String actualElement = collection.get(4);

        Assertions.assertEquals(expectedElement, actualElement);
    }

    @Test
    void when_added_new_element_size_must_increase(){
        String newValue = "String10";
        collection.add(newValue);

        //actual
        int currentSize = collection.size();
        String addedValue = collection.get(collectionSizeAfterAddingNewElement - 1);

        Assertions.assertEquals(collectionSizeAfterAddingNewElement, currentSize);
        Assertions.assertEquals(newValue, addedValue);
    }

    @Test
    void add_element_in_the_middle(){
        String newValue = "checkElement";
        int indexOfNewElement = 5;
        collection.add(indexOfNewElement, newValue);

        //actual
        int getCollectionSize = collection.size();
        String getAddedElement = collection.get(indexOfNewElement);

        Assertions.assertEquals(collectionSizeAfterAddingNewElement, getCollectionSize);
        Assertions.assertEquals(newValue, getAddedElement);
    }

    @Test
    void when_delete_element_size_should_decrease(){
        String elementToDelete = "String9";
        collection.delete(elementToDelete);

        //expected
        int expectedSize = 9;

        //actual
        int actualSize = collection.size();

        Assertions.assertEquals(expectedSize, actualSize);
    }

    @Test
    void when_check_containing_contains_object_then_result_must_be_true(){
        String checkedValue = "Test123";
        collection.add(checkedValue);
        Assertions.assertTrue(collection.contains(checkedValue));

    }

    @Test
    void when_check_uncontaining_object_then_result_must_be_false(){
        String addedValue = "Test123";
        String checkedValue = "Test321";
        collection.add(addedValue);
        Assertions.assertFalse(collection.contains(checkedValue));

    }

    @Test
    void  when_clear_collection_then_size_must_be_zero(){
        collection.clear();
        Assertions.assertEquals(0, collection.size());
    }

    @Test
    void check_equals(){
        StringCollectionImpl colectionToCheck = formCollection();

        Assertions.assertTrue(collection.equals(colectionToCheck));
    }

    private StringCollectionImpl formCollection(){
        StringCollectionImpl result = new StringCollectionImpl();
        for (int i = 0; i < initializationSize; i++) {
            result.add("String" + i);
        }
        return result;
    }
}