package sequential;

import java.util.Iterator;
import util.Util;

/**
 * @author Andres Gutierrez
 * @param <T> Type of the list
 */
public class ArrayList<T> implements List<T> {

  private Object[] list;
  private int size;

  /** Empty constructor, start with an initial capacity of 10 elements */
  public ArrayList() {
    this(10);
  }

  /**
   * Initialize the array and the quantity of the elements
   *
   * @param capacity initial size of the bucket
   */
  public ArrayList(int capacity) {
    this.list = new Object[capacity];
    this.size = 0;
  }

  /**
   * @param e element to add at the end of the array
   */
  @Override
  public void add(T e) {
    this.add(this.size, e);
  }

  /**
   * @param index index where the element is going to be added
   * @param e value of the element to be added in a specific position
   */
  @Override
  public void add(int index, T e) {
    Util.checkIndexOpen(index, this.size);
    // We need to double the size of the array
    if (this.size == this.list.length) {
      Object[] temp = this.list;
      this.list = new Object[this.list.length * 2];
      for (int i = 0; i < temp.length; i++) {
        this.list[i] = temp[i];
      }
    }

    // We need to move to the right the elements
    for (int i = this.size - 1; i >= index; i--) {
      this.list[i + 1] = this.list[i];
    }
    this.list[index] = e;
    this.size++;
  }

  /** Remove all the elements of the list */
  @Override
  public void clear() {
    this.list = new Object[list.length];
    this.size = 0;
  }

  /**
   * Indicate if the list contains the element
   *
   * @param e element to seek in the array
   * @return true if the element exist in the array, otherwise return false
   */
  @Override
  public boolean contains(T e) {
    return this.indexOf(e) != -1;
  }

  /**
   * Check if the index is valid, otherwise throw an exception
   *
   * @param index index of the element to return
   * @return element in a specific position
   */
  @Override
  public T get(int index) {
    Util.checkIndexClose(index, this.size);
    return (T) this.list[index];
  }

  /**
   * If the element is not the list -1 is returned
   *
   * @param e element to seek in the array
   * @return return the index where the element is located.
   */
  @Override
  public int indexOf(T e) {
    for (int i = 0; i < this.size; i++) {
      if (((T) this.list[i]).equals(e)) return i;
    }
    return -1;
  }

  /**
   * @return true if the list is empty, otherwise false
   */
  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * Check if the index is valid
   *
   * @param index index to remove the element
   * @return element which was deleted
   */
  @Override
  public T remove(int index) {
    T e = this.get(index);
    // We need to move the elements to the left
    for (int i = index + 1; i < this.size; i++) {
      this.list[i - 1] = this.list[i];
    }
    // Optional because the size is the variable that controls the quantity of the elements
    // Although we assign null to indicate that there is no element in that position
    this.list[this.size--] = null;
    return e;
  }

  /**
   * We reuse the logic to know if an element is in the list, if the element is found, we got the
   * index and use the method to remove using an index
   *
   * @param e element to be deleted
   * @return true if the element is found in the list, false otherwise
   */
  @Override
  public boolean remove(T e) {
    int index = this.indexOf(e);
    if (index == -1) return false;
    this.remove(index);
    return true;
  }

  /**
   * @return quantity of elements that the list has
   */
  @Override
  public int size() {
    return this.size;
  }

  /**
   * @return iterator to be able of iterating the list with a foreach or while
   */
  @Override
  public Iterator<T> iterator() {
    int size = this.size;
    Object[] list = this.list;
    return new Iterator<T>() {
      int i = 0;

      @Override
      public boolean hasNext() {
        return i < size;
      }

      @Override
      public T next() {
        return (T) list[i++];
      }
    };
  }

  /**
   * @return String representation of the list
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < this.size; i++) {
      sb.append(this.list[i]);
      if (i != this.size - 1) {
        sb.append(",");
      }
    }
    sb.append("]");
    return sb.toString();
  }
}
