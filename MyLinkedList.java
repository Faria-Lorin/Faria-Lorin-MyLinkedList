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

 public boolean add(String value){
  Node a = new Node(value);
  a.setNext(null);
  if (size == 0){
    start = a;
    end = a;
    a.setPrev(null);
  }
 else {
   end.setNext(a);
   a.setPrev(end);
   end = a;
 }
 size++;
 return true;
}

 public void add(int index, String value){
  if (index >= size){
    throw new IndexOutOfBoundsException("Index" + index + "is out of bounds");
  }
 else {
   Node adding = new Node(value);
 }
}
  /*public String get(int index);
 public String set(int index, String value);
 public String toString();
 */
public static void main(String[] args) {
  MyLinkedList a = new MyLinkedList();
  MyLinkedList b = new MyLinkedList();
  for(int i = 0; i < 10; i++){
    if(i < 5){
      a.add(i+"");
    }else{
      b.add(i+"");
    }
  }
  System.out.println(a.size());
  System.out.println(b.size());
}
}
