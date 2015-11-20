package prj5;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import student.TestCase;

/**
 * Tests the DLinkedList class.
 * 
 * @author Ethan Vu (ethanvu7)
 * @version 2015.11.14
 */
public class DLinkedListTest extends TestCase{

    private DLinkedList<String> list;
    
    /**
     * Sets up the TestCase.
     */
    public void setUp() {
        list = new DLinkedList<String>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
    }
    
    /**
     * Tests the constructor.
     */
    public void testConstructor() {
        list = new DLinkedList<String>();
        assertEquals(0, list.getLength());
    }
    
    /**
     * Tests the add method that takes one generic argument and adds
     * it to a non-empty list.
     */
    public void testAddEArgNonEmptyList() {
        assertEquals(4, list.getLength());
        assertEquals("first", list.getEntry(0));
        assertEquals("second", list.getEntry(1));
        assertEquals("third", list.getEntry(2));
        assertEquals("fourth", list.getEntry(3));
    }
    
    /**
     * Tests the add method that takes one generic argument and adds
     * it to an empty list.
     */
    public void testAddEArgEmptyList() {
        list = new DLinkedList<String>();
        list.add("string");
        assertEquals(1, list.getLength());
        assertEquals("string", list.getEntry(0));
    }
    
    /**
     * Tests the add method that takes one generic argument when that
     * argument is null.
     */
    public void testAddEArgIsNull() {
        Exception thrown = null;
        try {
            list.add(null);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        assertEquals("Can't add null to list", thrown.getMessage());
    }
    
    /**
     * Tests the addBeginning method on a non-empty list.
     */
    public void testAddBeginningNonEmptyList() {
        list.addBeginning("zeroth");
        assertEquals(5, list.getLength());
        assertEquals("zeroth", list.getEntry(0));
        assertEquals("first", list.getEntry(1));
        assertEquals("second", list.getEntry(2));
        assertEquals("third", list.getEntry(3));
        assertEquals("fourth", list.getEntry(4));
    }
    
    /**
     * Tests the addBeginning method on an empty list.
     */
    public void testAddBeginningEmptyList() {
        list = new DLinkedList<String>();
        list.addBeginning("string");
        assertEquals(1, list.getLength());
        assertEquals("string", list.getEntry(0));
    }
    
    /**
     * Tests the addBeginning method when the argument is null.
     */
    public void testAddBeginningEArgIsNull() {
        Exception thrown = null;
        try {
            list.addBeginning(null);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        assertEquals("Can't add null to list", thrown.getMessage());
    }
    
    /**
     * Tests the add method that takes an int and a generic argument
     * and adds it to the lower half of a non-empty list.
     */
    public void testAddIntAndEArgLowHalfOfNonEmptyList() {
        list.add(1, "middle of first and second");
        assertEquals(5, list.getLength());
        assertEquals("first", list.getEntry(0));
        assertEquals("middle of first and second", list.getEntry(1));
        assertEquals("second", list.getEntry(2));
        assertEquals("third", list.getEntry(3));
        assertEquals("fourth", list.getEntry(4));
    }
    
    /**
     * Tests the add method that takes an int and a generic argument
     * and adds it to the higher half of a non-empty list.
     */
    public void testAddIntAndEArgHighHalfOfNonEmptyList() {
        list.add(2, "middle of second and third");
        assertEquals(5, list.getLength());
        assertEquals("first", list.getEntry(0));
        assertEquals("second", list.getEntry(1));
        assertEquals("middle of second and third", list.getEntry(2));
        assertEquals("third", list.getEntry(3));
        assertEquals("fourth", list.getEntry(4));
    }
    
    /**
     * Tests the add method that takes an int and a generic argument
     * and adds it to the beginning of a non-empty list.
     */
    public void testAddIntAndEArgBegOfNonEmptyList() {
        list.add(0, "new beginning");
        assertEquals(5, list.getLength());
        assertEquals("new beginning", list.getEntry(0));
        assertEquals("first", list.getEntry(1));
        assertEquals("second", list.getEntry(2));
        assertEquals("third", list.getEntry(3));
        assertEquals("fourth", list.getEntry(4));
    }
    
    /**
     * Tests the add method that takes an int and a generic argument
     * and adds it to the end of a non-empty list.
     */
    public void testAddIntAndEArgEndOfNonEmptyList() {
        list.add(4, "end");
        assertEquals(5, list.getLength());
        assertEquals("first", list.getEntry(0));
        assertEquals("second", list.getEntry(1));
        assertEquals("third", list.getEntry(2));
        assertEquals("fourth", list.getEntry(3));
        assertEquals("end", list.getEntry(4));
    }
    
    /**
     * Tests the add method that takes an int and a generic argument
     * and adds it to an empty list.
     */
    public void testAddIntAndEArgEmptyList() {
        list = new DLinkedList<String>();
        list.add(0, "not empty anymore");
        assertEquals(1, list.getLength());
        assertEquals("not empty anymore", list.getEntry(0));
    }
    
    /**
     * Tests the add method that takes an int and a generic argument
     * and tries to add it to a position that is greater than the size
     * of a list. 
     */
    public void testAddIntAndEArgAfterEndOfNonEmptyList() {
        Exception thrown = null;
        try {
            list.add(6, "error");
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * Tests the add method that takes an int and a generic argument
     * and tries to add it to a position that is less than 0.
     */
    public void testAddIntAndEArgBeforeBegOfNonEmptyList() {
        Exception thrown = null;
        try {
            list.add(-1, "error");
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    public void testAddIntAndEArgNullE() {
        Exception thrown = null;
        try {
            list.add(2, null);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        assertEquals("Can't add null to list", thrown.getMessage());
    }
    
    /**
     * Test the clear method on a non-empty list
     */
    public void testClearNonEmptyList() {
        list.clear();
        assertEquals(0, list.getLength());
    }
    
    /**
     * Test the clear method on an empty list
     */
    public void testClearEmptyList() {
        list = new DLinkedList<String>();
        list.clear();
        assertEquals(0, list.getLength());
    }
    
    /**
     * Tests the contains method for when the list does contain the
     * argument.
     */
    public void testContainsTrue() {
        assertTrue(list.contains("second"));
    }
    
    /**
     * Tests the contains method for when the list does not contain
     * the argument and the list is not empty.
     */
    public void testContainsNotInList() {
        assertFalse(list.contains("not in list"));
    }
    
    /**
     * Tests the contains method for when the list does not contain the
     * argument because that list is empty.
     */
    public void testContainsFalseCauseEmptyList() {
        list = new DLinkedList<String>();
        assertFalse(list.contains("this list is empty"));
    }
    
    /**
     * Tests the getEntry method to get the first entry.
     */
    public void testGetEntryAtFirst() {
        assertEquals("first", list.getEntry(0));
    }
    
    /**
     * Tests the getEntry method to get an entry in the middle of the
     * list.
     */
    public void testGetEntryAtMiddle() {
        assertEquals("third", list.getEntry(2));
    }
    
    /**
     * Tests the getEntry method to get the last entry.
     */
    public void testGetEntryAtEnd() {
        assertEquals("fourth", list.getEntry(3));
    }
    
    /**
     * Tests the getEntry method to get an entry that is greater than
     * the length of the list.
     */
    public void testGetEntryGreaterThanLastInList() {
        Exception thrown = null;
        try {
            list.getEntry(4);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * Tests the getEntry method to get an entry that is less than 0.
     */
    public void testGetEntryLessThanZero() {
        Exception thrown = null;
        try {
            list.getEntry(-1);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * Tests the getLength method.
     */
    public void testGetLength() {
        assertEquals(4, list.getLength());
    }
    
    /**
     * Tests the isEmpty method on a non-empty list.
     */
    public void testIsEmptyNotEmpty() {
        assertFalse(list.isEmpty());
    }
    
    /**
     * Tests the isEmpty method on an empty list.
     */
    public void testIsEmptyTrue() {
        list = new DLinkedList<String>();
        assertTrue(list.isEmpty());
    }
    
    /**
     * Tests the remove method to remove an element in the middle of
     * the list.
     */
    public void testRemoveMiddle() {
        assertEquals("third", list.remove(2));
        assertEquals(3, list.getLength());
        assertEquals("first", list.getEntry(0));
        assertEquals("second", list.getEntry(1));
        assertEquals("fourth", list.getEntry(2));
    }
    
    /**
     * Tests the remove method to remove an element from the end of
     * the list.
     */
    public void testRemoveEnd() {
        assertEquals("fourth", list.remove(3));
        assertEquals(3, list.getLength());
        assertEquals("first", list.getEntry(0));
        assertEquals("second", list.getEntry(1));
        assertEquals("third", list.getEntry(2));
    }
    
    /**
     * Tests the remove method to remove an element from the beginning
     * of the list.
     */
    public void testRemoveBeginning() {
        assertEquals("first", list.remove(0));
        assertEquals(3, list.getLength());
        assertEquals("second", list.getEntry(0));
        assertEquals("third", list.getEntry(1));
        assertEquals("fourth", list.getEntry(2));
    }
    
    /**
     * Tests the remove method to try and remove an element greater
     * than the length of the list.
     */
    public void testRemoveGreaterThanLength() {
        Exception thrown = null;
        try {
            list.remove(4);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * Tests the remove method to try and remove an element less than
     * 0.
     */
    public void testRemoveLessThanLength() {
        Exception thrown = null;
        try {
            list.remove(-1);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * Tests the replace method on an element in the middle of the list.
     */
    public void testReplaceMiddle() {
        assertEquals("third", list.replace(2, "new"));
        assertEquals(4, list.getLength());
        assertEquals("first", list.getEntry(0));
        assertEquals("second", list.getEntry(1));
        assertEquals("new", list.getEntry(2));
        assertEquals("fourth", list.getEntry(3));
    }
    
    /**
     * Tests the replace method on an element at the front of the list.
     */
    public void testReplaceFront() {
        assertEquals("first", list.replace(0, "new"));
        assertEquals(4, list.getLength());
        assertEquals("new", list.getEntry(0));
        assertEquals("second", list.getEntry(1));
        assertEquals("third", list.getEntry(2));
        assertEquals("fourth", list.getEntry(3));
    }
    
    /**
     * Tests the replace method on an element at the end of the list.
     */
    public void testReplaceEnd() {
        assertEquals("fourth", list.replace(3, "new"));
        assertEquals(4, list.getLength());
        assertEquals("first", list.getEntry(0));
        assertEquals("second", list.getEntry(1));
        assertEquals("third", list.getEntry(2));
        assertEquals("new", list.getEntry(3));
    }
    
    /**
     * Tests the replace method to try and replace at an index after
     * the length of the list.
     */
    public void testReplaceGreaterThanLength() {
        Exception thrown = null;
        try {
            list.replace(6, "error");
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * Tests the replace method to try and replace at an index before
     * 0.
     */
    public void testReplaceLessThan0() {
        Exception thrown = null;
        try {
            list.replace(-1, "error");
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * Tests the replace method to try and replace at an index with a
     * null object.
     */
    public void testReplaceWithNull() {
        Exception thrown = null;
        try {
            list.replace(1, null);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        assertEquals("Can't add null to list", thrown.getMessage());
    }
    
    /**
     * Tests the toArray method for a list whose length is greater than
     * one.
     */
    public void testToArrayGreaterThan1() {
        Object[] array = list.toArray();
        assertEquals(4, array.length);
        assertEquals("first", array[0]);
        assertEquals("second", array[1]);
        assertEquals("third", array[2]);
        assertEquals("fourth", array[3]);
    }
    
    /**
     * Tests the toArray method for a list whose length is one.
     */
    public void testToArrayLength1() {
        list = new DLinkedList<String>();
        list.add("one");
        Object[] array = list.toArray();
        assertEquals(1, array.length);
        assertEquals("one", array[0]);
    }
    
    /**
     * Tests the toArray method for a list whose length is zero.
     */
    public void testToArrayLength0() {
        list = new DLinkedList<String>();
        Object[] array = list.toArray();
        assertEquals(0, array.length);
    }
    
    /**
     * Tests the toString method for a list whose length is greater
     * than one.
     */
    public void testToStringGreaterThan1() {
        String string = "[first, second, third, fourth]";
        assertEquals(string, list.toString());
    }
    
    /**
     * Tests the toString method for a list whose length is one.
     */
    public void testToStringLength1() {
        list = new DLinkedList<String>();
        list.add("one");
        String string = "[one]";
        assertEquals(string, list.toString());
    }
    
    /**
     * Tests the toString method for a list whose length is zero.
     */
    public void testToStringLength0() {
        list = new DLinkedList<String>();
        String string = "[]";
        assertEquals(string, list.toString());
    }
    
    /**
     * Tests the equals method for when the argument points to the
     * same DLinkedList calling the method.
     */
    public void testEqualsSameObject() {
        DLinkedList<String> same = list;
        assertTrue(list.equals(same));
    }
    
    /**
     * Tests the equals method for when the argument points to a
     * null object.
     */
    public void testEqualsNull() {
        DLinkedList<String> nullObj = null;
        assertFalse(list.equals(nullObj));
    }
    
    /**
     * Tests the equals method for when the argument isn't a
     * DLinkedList object.
     */
    public void testEqualsNotDLinkedList() {
        Object not = new Object();
        assertFalse(list.equals(not));
    }
    
    /**
     * Tests the equals method for when the argument is a
     * DLinkedList object with a different line up of entries.
     */
    public void testEqualsDifferentElements() {
        DLinkedList<String> other = new DLinkedList<String>();
        other.add("deck");
        other.add("wolf");
        assertFalse(list.equals(other));
    }
    
    /**
     * Tests the equals method for when the argument is a
     * DLinkedList object with the same line up of elements.
     */
    public void testEqualsSameElements() {
        DLinkedList<String> other = new DLinkedList<String>();
        other.add("first");
        other.add("second");
        other.add("third");
        other.add("fourth");
        assertTrue(list.equals(other));
    }
    
    /**
     * Tests the iterator method.
     */
    public void testIterator() {
        ListIterator<String> iter = list.iterator();
        assertTrue(iter.hasNext());
        assertFalse(iter.hasPrevious());
    }
    
    // TODO test cases for iterator
    
    /**
     * Tests the Iterator's add method.
     */
    public void testIteratorAdd() {
        Exception thrown = null;
        ListIterator<String> iter = list.iterator();
        try {
            iter.add("error");
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof UnsupportedOperationException);
    }
    
    /**
     * Tests the Iterator's hasNext method for when there is a next.
     */
    public void testIteratorHasNextTrue() {
        ListIterator<String> iter = list.iterator();
        assertTrue(iter.hasNext());
    }
    
    /**
     * Tests the Iterator's hasNext method for when there is not a next.
     */
    public void testIteratorHasNextFalse() {
        ListIterator<String> iter = list.iterator();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        assertFalse(iter.hasNext());
    }
    
    /**
     * Tests the Iterator's hasPrevious method for when there is a
     * previous.
     */
    public void testIteratorHasPreviousTrue() {
        ListIterator<String> iter = list.iterator();
        iter.next();
        assertTrue(iter.hasPrevious());
    }
    
    /**
     * Tests the Iterator's hasPrevious method for when there is not
     * a previous.
     */
    public void testIteratorHasPreviousFalse() {
        ListIterator<String> iter = list.iterator();
        assertFalse(iter.hasPrevious());
    }
    
    /**
     * Tests the Iterator's next method for when there is a next.
     */
    public void testIteratorNextHasNext() {
        ListIterator<String> iter = list.iterator();
        assertEquals("first", iter.next());
        assertEquals("second", iter.next());
        assertEquals("third", iter.next());
        assertEquals("fourth", iter.next());
    }
    
    /**
     * Tests the Iterator's next method for when there is not a next.
     */
    public void testIteratorNextDoesntHasNext() {
        list = new DLinkedList<String>();
        ListIterator<String> iter = list.iterator();
        Exception thrown = null;
        try {
            iter.next();
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof NoSuchElementException);
    }
    
    /**
     * Tests the Iterator's nextIndex method while at the beginning of
     * the list.
     */
    public void testIteratorNextIndexBeginning() {
        ListIterator<String> iter = list.iterator();
        assertEquals(0, iter.nextIndex());
    }
    
    /**
     * Tests the Iterator's nextIndex method while at the middle of
     * the list.
     */
    public void testIteratorNextIndexMiddle() {
        ListIterator<String> iter = list.iterator();
        iter.next();
        assertEquals(1, iter.nextIndex());
        iter.next();
        assertEquals(2, iter.nextIndex());
    }
    
    /**
     * Tests the Iterator's nextIndex method while at the end of
     * the list.
     */
    public void testIteratorNextIndexEnd() {
        ListIterator<String> iter = list.iterator();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        assertEquals(4, iter.nextIndex());
    }
    
    /**
     * Tests the Iterator's previous method for when there is a previous.
     */
    public void testIteratorPreviousHasPrevious() {
        ListIterator<String> iter = list.iterator();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        assertEquals("fourth", iter.previous());
        assertEquals("third", iter.previous());
        assertEquals("second", iter.previous());
        assertEquals("first", iter.previous());
    }
    
    /**
     * Tests the Iterator's next method for when there is not a next.
     */
    public void testIteratorPreviousDoesntHasPrevious() {
        ListIterator<String> iter = list.iterator();
        Exception thrown = null;
        try {
            iter.previous();
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof NoSuchElementException);
    }
    
    /**
     * Tests the Iterator's previousIndex method while at the beginning
     * of the list.
     */
    public void testIteratorPreviousIndexBeginning() {
        ListIterator<String> iter = list.iterator();
        assertEquals(-1, iter.previousIndex());
    }
    
    /**
     * Tests the Iterator's previousIndex method while at the middle of
     * the list.
     */
    public void testIteratorPreviousIndexMiddle() {
        ListIterator<String> iter = list.iterator();
        iter.next();
        assertEquals(0, iter.previousIndex());
        iter.next();
        assertEquals(1, iter.previousIndex());
    }
    
    /**
     * Tests the Iterator's previousIndex method while at the end of
     * the list.
     */
    public void testIteratorPreivousIndexEnd() {
        ListIterator<String> iter = list.iterator();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        assertEquals(3, iter.previousIndex());
    }
    
    /**
     * Tests the Iterator's remove method.
     */
    public void testIteratorRemove() {
        Exception thrown = null;
        ListIterator<String> iter = list.iterator();
        try {
            iter.remove();
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof UnsupportedOperationException);
    }
    
    /**
     * Tests the Iterator's set method.
     */
    public void testIteratorSet() {
        Exception thrown = null;
        ListIterator<String> iter = list.iterator();
        try {
            iter.set("error");    
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof UnsupportedOperationException);
    }
}