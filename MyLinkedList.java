public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList(){
   start = null;
   end = null;
   size = 0;
 }
 public int size(){
   int count = 0;
   Node current = start;
   while (current != null){
     count++;;
     current = current.getNext();
   }
   return count;
 }

 /*
 public boolean add(String value);
 public void add(int index, String value);
 public String get(int index);
 public String set(int index, String value);
 public String toString();
 */

}
