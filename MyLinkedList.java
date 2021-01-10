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
   size = count;
   return count;
 }

 public boolean add(String value){
  size();
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
  size();
  if (index >= size || index < 0){
    throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
  }
  else {
    Node temp = new Node(value);
    Node current = start;
    for (int i = 0; i < index + 1; i++){
     if (i == index){
       temp.setPrev(current.getPrev());
       temp.setNext(current);
       current.setPrev(temp);
       current.getPrev().setNext(temp);
     }
     current = current.getNext();
   }
 }
 size ++;
}
public String get(int index){
  String out = "";
  Node current = start;
  size();
  if (index >= size || index < 0){
    throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
  }
  else {
    for (int i = 0; i < index + 1; i++){
     if (i == index){
       out = current.getData();
     }
     current = current.getNext();
   }
 }
 return out;
}

 public String set(int index, String value){
   String out = "";
   Node current = start;
   size();
   if (index >= size || index < 0){
     throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
   }
   else {
     for (int i = 0; i < index + 1; i++){
      if (i == index){
        out = current.getData();
        current.setData(value);
      }
      current = current.getNext();
    }
  }
  return out;
 }
    /*public String toString();
 */
public static void main(String[] args) {
  MyLinkedList a = new MyLinkedList();
  MyLinkedList b = new MyLinkedList();
  for(int i = 0; i < 10; i++){
    if(i < 5){
      a.add(i+"h");
    }else{
      b.add(i+"");
    }
  }
  a.add(3, "9");
  System.out.println(a.get(3));
  System.out.println(a.set(3, "snow"));
  System.out.println(a.get(3));
  System.out.println(a.size());
  System.out.println(b.size());
}
}
