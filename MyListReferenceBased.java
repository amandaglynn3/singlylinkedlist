
/*
 * Purpose: Data Structure and Algorithms Lab 3 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 09/23/19
 * Submitted:  09/24/19
 * @author: Nick Setaro
 * @version: 2019.09.23
 */

public class MyListReferenceBased implements ListInterface
{
    // reference to linked list of items
    private Node head;

    public MyListReferenceBased()
    {
        head = null;
    }  // end default constructor

    public boolean isEmpty()
    {
        //check if the head is null
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }  // end isEmpty

    public int size()
    {
        int size = 0;
        Node t = head;
        //iterate through list to check for the next null reference
        while (t != null)
        {
            t = t.getNext();
            size++;
        }
        return size;
    }  // end size

    public boolean isValidIndex(int index) {
        //check if the index is valid using the size method
        if (index >= 0 && index <= size()) {
            return true;
        }
        return false;
    }

    public String toString() {
        String s = "";
        Node t = head;
        //iterate through the list and collect the items in one String
        while (t != null) {
            s = s + t.getItem().toString() + " ";
            t = t.getNext();
        }
        return s;
    }

    private Node find(int index)
    {
        Node curr = head;
        for (int skip = 0; skip < index; skip++)
        {
            curr = curr.getNext();
        } // end for
        return curr;
    } // end find

    public Object get(int index)
    throws ListIndexOutOfBoundsException
    {
        if (isValidIndex(index))
        {
            // get reference to node, then data in node
            Node curr = find(index);
            Object dataItem = curr.getItem();
            return dataItem;
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on get");
        } // end if
    } // end get

    public void add(int index, Object item)
    throws ListIndexOutOfBoundsException
    {
        if (isValidIndex(index))
        {
            if (index == 0)
            {
                // insert the new node containing item at
                // beginning of list
                Node newNode = new Node(item, head);
                head = newNode;
            }
            else
            {
                Node prev = find(index-1);
                // insert the new node containing item after
                // the node that prev references
                Node newNode = new Node(item, prev.getNext());
                prev.setNext(newNode);
            } // end if
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on add");
        } // end if
    }  // end add

    public void remove(int index)
    throws ListIndexOutOfBoundsException
    {
        if (isValidIndex(index))
        {
            if (index == 0)
            {
                // delete the first node from the list
                head = head.getNext();
            }
            else
            {
                Node prev = find(index-1);
                // delete the node after the node that prev
                // references, save reference to node
                Node curr = prev.getNext();
                prev.setNext(curr.getNext());
            } // end if
        } // end if
        else
        {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on remove");
        } // end if
    }   // end remove

    public void removeAll()
    {
        // setting head to null causes list to be
        // unreachable and thus marked for garbage
        // collection
        head = null;
    } // end removeAll

} // end ListReferenceBased
