package LinkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedList4Test {
    private SinglyLinkedList4<Integer> testList;

    @BeforeEach
    void setUp() {
        testList = new SinglyLinkedList4<>();
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

    @Test
    void shouldGetEmptyListWhenTwoItemsAreAddedAndThenRemoveFirstIsCalledTwoTimes() {
        testList.addFirst(5000);
        testList.addFirst(10000);
        assertEquals(2, testList.getSize());

        testList.removeFirst();
        assertEquals(1, testList.getSize());

        testList.removeFirst();
        assertEquals(0, testList.getSize());

        assertEquals(null, testList.first());
        assertEquals(null, testList.last());

        assertEquals("[ ]", testList.toString());
    }

    @Test
    void shouldGetEmptyListWhenTwoItemsAreAddedAndThenRemoveFirstIsCalledThreeTimes() {
        testList.addFirst(5000);
        testList.addFirst(10000);
        assertEquals(2, testList.getSize());

        testList.removeFirst();
        assertEquals(1, testList.getSize());

        testList.removeFirst();
        assertEquals(0, testList.getSize());

        testList.removeFirst();
        assertEquals(0, testList.getSize());

        assertEquals(null, testList.first());
        assertEquals(null, testList.last());

        assertEquals("[ ]", testList.toString());
    }

    @Test
    void shouldVerifyToStringResultWhenAddFirstAndAddLastAreCalledManyTimes() {
        testList.addFirst(400);
        testList.addFirst(475);
        testList.addLast(3045);
        testList.addFirst(375);
        testList.addLast(624);
        testList.addFirst(405);
        testList.addLast(7852);
        testList.addLast(285);
        testList.addFirst(195);

        assertEquals("[ 195, 405, 375, 475, 400, 3045, 624, 7852, 285, ]", testList.toString());
    }
}