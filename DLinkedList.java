package prj5;

import java.util.Arrays;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import list.ListInterface;

/**
 * The DLinkedList class is the linked implementation of a list.
 * The nodes that make up the list are doubly linked.  This list
 * can create an Iterator that returns the data within the list
 * as it iterates through.
 * 
 * @author Ethan Vu (ethanvu7)
 * @version 2015.11.15
 * @param <E>  The type of Objects held by this list.
 */
public class DLinkedList<E> implements ListInterface<E>, Iterable<E> {

    private Node<E> head;
    private Node<E> tail;
    private int length;
    
    /**
     * Creates an empty DLinkedList.
     */
    public DLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }
    
    /**
     * Adds a new entry to the end of the list.  Throws an
     * IllegalArgumentException if the generic argument is null.
     * 
     * @param newEntry  The entry to add to the list.
     * @throws IllegalArgumentException  If newEntry is null.
     */
    @Override
    public void add(E newEntry) {
        if (newEntry == null) {
            throw new IllegalArgumentException("Can't add null to list");
        }
        if (length == 0) {
            Node<E> node = new Node<E>(newEntry);
            head = node;
            tail = node;
            length++;
        }
        else {
            Node<E> node = new Node<E>(newEntry, tail, null);
            tail.setNext(node);
            tail = node;
            length++;
        }
    }
    
    /**
     * Adds a new entry to the beginning of the list.  Throws an
     * IllegalArgumentException if the generic argument is null.
     * 
     * @param newEntry  The entry to add to the list.
     * @throws IllegalArgumentException  If newEntry is null.
     */
    public void addBeginning(E newEntry) {
        if (newEntry == null) {
            throw new IllegalArgumentException("Can't add null to list");
        }
        if (length == 0) {
            Node<E> node = new Node<E>(newEntry);
            head = node;
            tail = node;
            length++;
        }
        else {
            Node<E> node = new Node<E>(newEntry, null, head);
            head.setPrevious(node);
            head = node;
            length++;
        }
    }

    /**
     * Adds a new entry at the specified position in the list.  The
     * new entry will push the entrys after it to the next position.
     * Throws an IndexOutOfBoundsException if the specified position
     * is less than 0 or greater than the length of the list.  Throws
     * an IllegalArgumentExecption if the generic argument is null.
     * 
     * @param index  The index to add the entry to.
     * @param newEntry  The entry to add to the list.
     * @throws IndexOutOfBoundsException  When index is less than 0 or
     *                                    greater than the length of the
     *                                    list.
     * @throws IllegalArgumentException  If newEntry is null.
     */
    @Override
    public void add(int index, E newEntry) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }
        if (newEntry == null) {
            throw new IllegalArgumentException("Can't add null to "
                    + "list");
        }
        if (index == length) {
            this.add(newEntry);
        }
        else if (index == 0) {
            this.addBeginning(newEntry);
        }
        else {
            Node<E> temp = this.getNode(index);
            Node<E> newNode = new Node<E>(newEntry, temp.getPrevious(),
                    temp);
            temp.getPrevious().setNext(newNode);
            temp.setPrevious(newNode);
            length++;
        }
    }
    
    /**
     * Gets the Node at the specified index.
     * 
     * @param index  The index of the Node to get.
     * @return The Node at the index.
     */
    private Node<E> getNode(int index) {
        Node<E> node = null;
        if (index < length / 2) {
            node = head;
            for (int x = 0; x < index; x++) {
                node = node.getNext();
            }
        }
        else { // index >= length / 2
            node = tail;
            for (int x = length - 1; x > index; x--) {
                node = node.getPrevious();
            }
        }
        return node;
    }

    /**
     * Clears every entry from the list.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        length = 0;
    }

    /**
     * Checks to see if the list contains the specified entry.
     * 
     * @param entry  The entry to check to see if it's in the list.
     * @return If the list contains the specified entry.
     */
    @Override
    public boolean contains(E entry) {
        boolean found = false;
        ListIterator<E> iter = this.iterator();
        while (!found && iter.hasNext()) {
            E currentEntry = iter.next();
            if (entry.equals(currentEntry)) {
                found = true;
            }
        }
        return found;
    }

    /**
     * Returns the entry at the specified index.  Throws an
     * IndexOutOfBoundsException if the index is less than 0 or
     * greater than the length of the list - 1
     * 
     * @param index  The index to retrieve the entry from.
     * @return The entry at the index.
     * @throws IndexOutOfBoundsException  If index is less than 0 or
     *                                    greater than length - 1.
     */
    @Override
    public E getEntry(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = this.getNode(index);
        return node.getData();
    }

    /**
     * Returns the current length of the list.
     * 
     * @return The current length of the list.
     */
    @Override
    public int getLength() {
        return length;
    }

    /**
     * Checks to see if the list is empty.
     * 
     * @return If the list is empty.
     */
    @Override
    public boolean isEmpty() {
        return length <= 0;
    }

    /**
     * Removes and returns the entry at the specified index.
     * 
     * @param index  The index to remove the entry form.
     * @return The entry that was removed.
     * @throws IndexOutOfBoundsException  When the index is less than
     *                                    0 or greater than length - 1.
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index > length - 1) {
            throw new IndexOutOfBoundsException();
        }
        E entry = null;
        if (index == 0) {
            entry = head.getData();
            head = head.getNext();
            length--;
        }
        else if (index == length - 1) {
            entry = tail.getData();
            tail = tail.getPrevious();
            length--;
        }
        else {
            Node<E> temp = this.getNode(index);
            entry = temp.getData();
            temp.getNext().setPrevious(temp.getPrevious());
            temp.getPrevious().setNext(temp.getNext());
            temp.setNext(null);
            temp.setPrevious(null);
            length--;
        }
        return entry;
    }

    /**
     * Replaces the entry at the specified index with the argument
     * entry.  Returns the replaced entry.  Throws an
     * IndexOutOfBoundsException if the index is less than 0 or
     * greater than the length of the list - 1.  Throws an
     * IllegalArgumentException if the generic argument is null.
     * 
     * @param index  The index of the entry to replace.
     * @param newEntry  The new entry that will replace the entry
     *                  at the index.
     * @return The entry that was replaced.
     * @throws IndexOutOfBoundsException  When the index is less than 0
     *                                    or greater than length - 1.
     * @throws IllegalArgumentException  If newEntry is null.
     */
    @Override
    public E replace(int index, E newEntry) {
        if (index < 0 || index > length - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (newEntry == null) {
            throw new IllegalArgumentException("Can't add null to list");
        }
        Node<E> temp = this.getNode(index);
        E replacedEntry = temp.getData();
        temp.setData(newEntry);
        return replacedEntry;
    }

    /**
     * Returns an Object array consisting of all the entrys in the
     * list, in the same order.
     * 
     * @return An Object array consisting of all the entrys in the
     *         list, in the same order
     */
    @Override
    public Object[] toArray() {
        Object[] listArray = new Object[length];
        ListIterator<E> iter = this.iterator();
        for (int i = 0; i < listArray.length; i++) {
            listArray[i] = iter.next();
        }
        return listArray;
    }

    /**
     * Returns the String representation of the list.  It has the
     * toString of each entry, separated by a comma and a space
     * enclosed by square brackets.
     * 
     * ex. A list containing Strings "1", "2", "3" will be
     * "[1, 2, 3]".
     * 
     * @return The String representation of the list.
     */
    @Override
    public String toString() {
        StringBuilder listString = new StringBuilder("[");
        ListIterator<E> iter = this.iterator();
        while (iter.hasNext()) {
            listString.append(iter.next().toString());
            if (iter.hasNext()) {
                listString.append(", ");
            }
        }
        listString.append("]");
        return listString.toString();
    }
    
    /**
     * Checks to see if the list equals the Object argument.  The
     * list will equal the Object when the Object is a DLinkedList
     * with equal entries in the same order.
     * 
     * @param obj  The Object the list will be compared to.
     * @return If the list equals the Object argument.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(DLinkedList.class)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        @SuppressWarnings("unchecked")
        DLinkedList<E> other = (DLinkedList<E>) obj;
        return Arrays.equals(this.toArray(), other.toArray());
    }
    
    /**
     * Returns the index of the first occurrence of the specified entry. 
     * If it isn't in the list, returns -1.
     * 
     * @param entry  The entry to get the index of.
     * @return The index of the data.
     */
    public int indexOf(E entry) {
        ListIterator<E> iter = this.iterator();
        int currentIndex = -1;
        while (iter.hasNext()) {
            currentIndex++;
            E currentEntry = iter.next();
            if (currentEntry.equals(entry)) {
                return currentIndex;
            }
        }
        return -1;
    }
    
    /**
     * Swaps the indices of two entries, given their indices.  Throws an
     * IndexOutOfBoundsException if either index is less than 0 or greater
     * than the length of the list minus 1.
     * 
     * @param first  The index of the first entry.
     * @param second  The index of the second entry.
     * @throws IndexOutOfBoundsException  If either index is less than
     *                                    0 or greater than length - 1.
     */
    public void swap(int first, int second) {
        // IndexOutOfBoundsException will be handled by the next two
        // calls of getEntry.
        E firstEntry = this.getEntry(first);
        E secondEntry = this.getEntry(second);
        this.replace(first, secondEntry);
        this.replace(second, firstEntry);
    }
    
    /**
     * Creates a new DLinkedListIterator at the beginning of the list.
     * 
     * @return A new DLinkedListIterator.
     */
    @Override
    public ListIterator<E> iterator() {
        return new DLinkedListIterator();
    }
    
    /**
     * A ListIterator moves in between the entries of the DLinkedList
     * class.  It can add, remove
     * 
     * @author Ethan Vu (ethanvu7)
     * @version 2015.11.16
     */
    private class DLinkedListIterator implements ListIterator<E> {

        private Node<E> nextNode;
        private int nextIndex;
        
        /**
         * Creates a new DLinkedListIterator at the beginning of the
         * list.
         */
        private DLinkedListIterator() {
            nextNode = head;
            nextIndex = 0;
        }
        
        /**
         * This method is unsupported.
         * 
         * @param entry  Does nothing.
         * @throws UnsupportedOperationException  Whenever this method
         *                                        is called.
         */
        @Override
        public void add(E entry) {
            throw new UnsupportedOperationException();
        }

        /**
         * Checks to see if there is an entry in the next index.
         * 
         * @return If there is an entry in the next index. 
         */
        @Override
        public boolean hasNext() {
            return nextIndex < length;
        }

        /**
         * Checks to see if there is an entry in the previous index.
         * 
         * @return If there is an entry in the previous index.
         */
        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        /**
         * Moves the iterator to the next index, if the next index
         * has an entry, and returns the entry at that index. If there
         * is no entry in the next index, this method throws a
         * NoSuchElementException.
         * 
         * @return The next entry.
         * @throws NoSuchElementException  If hasNext is false.
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = nextNode.getData();
            nextNode = nextNode.getNext();
            nextIndex++;
            return data;
        }

        /**
         * Returns the index of the element that would be returned
         * by a subsequent call to next(). Returns list size if
         * the list iterator is at the end of the list.
         * 
         * @return The next index.
         */
        @Override
        public int nextIndex() {
            return nextIndex;
        }

        /**
         * Moves the iterator to the previous index, if the previous index
         * has an entry, and returns the entry at that index.  If there is
         * no entry in the previous index, this method throws a
         * NoSuchElementException.
         * 
         * @return The previous entry.
         * @throws NoSuchElementException  If hasPrevious is false.
         */
        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            E data = null;
            if (nextNode == null) {
                data = tail.getData();
                nextNode = tail;
            }
            else {
                data = nextNode.getPrevious().getData();
                nextNode = nextNode.getPrevious();
            }
            nextIndex--;
            return data;
        }

        /**
         * Returns the index of the element that would be returned by
         * a subsequent call to previous(). Returns -1 if the list
         * iterator is at the beginning of the list.
         * 
         * @return The previous index.
         */
        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        /**
         * This method is unsupported.
         * 
         * @throws UnsupportedOperationException  Whenever this method
         *                                        is called.
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /**
         * This method is unsupported.
         * 
         * @param newEntry  Does nothing.
         * @throws UnsupportedOperationException  Whenever this method
         *                                        is called.
         */
        @Override
        public void set(E newEntry) {
            throw new UnsupportedOperationException();
        }
    }
    
    /**
     * Nodes make up the DLinkedList.  Nodes contain data and are
     * connected to a Node in the next position of the list and a
     * Node in the previous position in the list.
     * 
     * @author Ethan Vu (ethanvu7)
     * @version 2015.11.17
     * @param <E>  The type of data this Node holds.
     */
    private static class Node<E> {

        private Node<E> previousNode;
        private Node<E> nextNode;
        private E data;
        
        /**
         * Creates a new Node with the specified entry, that is
         * unlinked.
         * 
         * @param entry  The data connected to this Node.
         */
        private Node(E entry) {
            data = entry;
            previousNode = null;
            nextNode = null;
        }
        
        /**
         * Creates a new Node with the specified entry connected,
         * as well as two connected Nodes, one previous to this Node
         * and one next to this Node.
         * 
         * @param entry  The data connected to this Node.
         * @param prev  The previous Node connected to this Node.
         * @param next  The next Node connected to this Node.
         */
        private Node(E entry, Node<E> prev, Node<E> next) {
            data = entry;
            previousNode = prev;
            nextNode = next;
        }
        
        /**
         * Returns the data connected to this Node.
         * 
         * @return The data connected to this Node.
         */
        private E getData() {
            return data;
        }
        
        /**
         * Returns the next Node connected to this Node.
         * 
         * @return The next Node connected to this Node.
         */
        private Node<E> getNext() {
            return nextNode;
        }
        
        /**
         * Returns the previous Node connected to this Node.
         * 
         * @return The previous Node connected to this Node.
         */
        private Node<E> getPrevious() {
            return previousNode;
        }
        
        /**
         * Sets the data that is connected to this Node.
         * 
         * @param newEntry  The data to be connected to this Node.
         */
        private void setData(E newEntry) {
            data = newEntry;
        }
        
        /**
         * Sets the next Node that is connected to this Node.
         * 
         * @param newNextNode  The Node to be connected next to this Node.
         */
        private void setNext(Node<E> newNextNode) {
            nextNode = newNextNode;
        }
        
        /**
         * Sets the previous Node that is connected to this Node.
         * 
         * @param newPrevNode  The Node to be connected previous to this
         *                  Node.
         */
        private void setPrevious(Node<E> newPrevNode) {
            previousNode = newPrevNode;
        }
    }
}