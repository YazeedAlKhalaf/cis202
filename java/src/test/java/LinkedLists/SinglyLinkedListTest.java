package LinkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> testList;

    @BeforeEach
    void setup() {
        testList = new SinglyLinkedList<>();
    }

    @Test
    void getSize_shouldReturnSize() {
        assertEquals(0, testList.getSize());

        testList.addFirst(100);

        assertEquals(1, testList.getSize());
    }

    @Test
    void isEmpty_shouldReturnTrueWhenSizeIsZero() {
        assertEquals(true, testList.isEmpty());
    }

    @Test
    void isEmpty_shouldReturnFalseWhenSizeIsMoreThanZero() {
        testList.addFirst(80);

        assertEquals(false, testList.isEmpty());
    }

    @Test
    void first_shouldReturnNullWhenIsEmpty() {
        assertEquals(null, testList.first());
    }

    @Test
    void first_shouldReturnFirstElementWhenIsNotEmptyAndElementsAddedViaAddFirst() {
        testList.addFirst(90);
        testList.addFirst(80);
        testList.addFirst(70);

        assertEquals(70, testList.first());
    }

    @Test
    void first_shouldReturnFirstElementWhenIsNotEmptyAndElementsAddedViaAddLast() {
        testList.addLast(90);
        testList.addLast(80);
        testList.addLast(70);

        assertEquals(90, testList.first());
    }

    @Test
    void last_shouldReturnNullWhenIsEmpty() {
        assertEquals(null, testList.last());
    }

    @Test
    void last_shouldReturnLastElementWhenIsNotEmptyAndElementsAddedViaAddFirst() {
        testList.addFirst(90);
        testList.addFirst(80);
        testList.addFirst(70);

        assertEquals(90, testList.last());
    }

    @Test
    void last_shouldReturnLastElementWhenIsNotEmptyAndElementsAddedViaAddLast() {
        testList.addLast(90);
        testList.addLast(80);
        testList.addLast(70);

        assertEquals(90, testList.first());
    }

    @Test
    void addFirst_shouldAddFirstItemToListWhenListIsEmpty() {
        testList.addFirst(100);

        assertEquals(100, testList.first());
        assertEquals(100, testList.last());
    }

    @Test
    void addFirst_shouldAddTwoItemsUsingAddFirstToListWhenListIsEmpty() {
        testList.addFirst(100);
        assertEquals(100, testList.first());
        assertEquals(100, testList.last());

        testList.addFirst(90);
        assertEquals(90, testList.first());
        assertEquals(100, testList.last());
    }

    @Test
    void addLast_shouldAddLastItemToListWhenListIsEmpty() {
        testList.addLast(100);

        assertEquals(100, testList.first());
        assertEquals(100, testList.last());
    }

    @Test
    void addLast_shouldAddTwoItemsUsingAddLastToListWhenListIsEmpty() {
        testList.addLast(100);
        assertEquals(100, testList.first());
        assertEquals(100, testList.last());

        testList.addLast(90);
        assertEquals(90, testList.last());
        assertEquals(100, testList.first());
    }

    @Test
    void removeFirst_shouldRemoveTheFirstItemWhenTwoItemsExist() {
        testList.addFirst(100);
        assertEquals(100, testList.first());

        testList.addFirst(90);
        assertEquals(90, testList.first());

        testList.removeFirst();
        assertEquals(100, testList.first());

        testList.removeFirst();
        assertEquals(null, testList.first());
    }

    @Test
    void toString_verifyWhenOneItemIsAddedViaAddFirst() {
        testList.addFirst(100);
        assertEquals("[ 100, ]", testList.toString());
    }

    @Test
    void toString_verifyWhenTwoItemsAreAddedViaAddFirst() {
        testList.addFirst(100);
        testList.addFirst(200);
        assertEquals("[ 200, 100, ]", testList.toString());
    }

    @Test
    void toString_verifyWhenOneItemIsAddedViaAddFirstAndAnotherItemIsAddedViaAddLast() {
        testList.addFirst(100);
        testList.addLast(200);
        assertEquals("[ 100, 200, ]", testList.toString());
    }

    @Test
    void toString_verifyWhenOneItemIsAddedViaAddLast() {
        testList.addLast(100);
        assertEquals("[ 100, ]", testList.toString());
    }

    @Test
    void toString_verifyWhenTwoItemsAreAddedViaAddLast() {
        testList.addLast(100);
        testList.addLast(200);
        assertEquals("[ 100, 200, ]", testList.toString());
    }

    @Test
    void toString_verifyWhenOneItemIsAddedViaAddLastAndAnotherItemIsAddedViaAddFirst() {
        testList.addLast(200);
        testList.addFirst(100);
        assertEquals("[ 100, 200, ]", testList.toString());
    }
}