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
  if (index > size || index < 0){
    throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
  }
  else {
    Node temp = new Node(value);
    Node current = start;
    for (int i = 0; i <= index; i++){
     if (i == index){
       if (size == 0 || index == size){
         add(value);
       }
       else if (index == 0){
          start.setPrev(temp);
          temp.setPrev(null);
          temp.setNext(start);
          start = temp;
       }
       else {
         Node toNext = current;
         Node toPrev = current.getPrev();
         toPrev.setNext(temp);
         current.setPrev(temp);
         temp.setPrev(toPrev);
         temp.setNext(toNext);
       }
     }
    else current = current.getNext();
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

 public String toString(){
   size();
   String out = "[";
   Node current = start;
   for(int i = 0; i < size; i++){
     if (i == size - 1){
       out += current.getData();
     }
     else{
       out += current.getData() + ", ";
     }
     current = current.getNext();
   }
   out += "]";
   return out;
 }

 public String toStringReversed(){
   size();
   String out = "[";
   Node current = end;
   for(int i = size; i > 0; i--){
     if (i == 1){
       out += current.getData();
     }
     else{
       out += current.getData() + ", ";
     }
     current = current.getPrev();
   }
   out += "]";
   return out;
 }

 public String remove(int index){
   size();
   String out = "";
   if (index >= size || index < 0){
     throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
   }
   else {
     Node toRemove = start;
     for (int i = 0; i <= index; i++){
      if (i == index){
        out += toRemove.getData();
        if (size == 1){
           start = null;
           end = null;
        }
        else if (index == 0){
           start = toRemove.getNext();
           toRemove.setNext(null);
           start.setPrev(null);
        }
        else if (index == size - 1){
           end = toRemove.getPrev();
           toRemove.setPrev(null);
           end.setNext(null);
        }
        else {
          Node nextToRemove = toRemove.getNext();
          Node prevToRemove = toRemove.getPrev();
          prevToRemove.setNext(nextToRemove);
          nextToRemove.setPrev(prevToRemove);
          toRemove.setPrev(null);
          toRemove.setNext(null);
        }
      }
     else toRemove = toRemove.getNext();
    }
  }
  size --;
  return out;
 }
 public void extend(MyLinkedList other){
   this.size = this.size() + other.size();
   this.end.setNext(other.start);
   this.end = other.end;
   other.end = null;
   other.start = null;
 }
 public static void main(String[] args) {
      MyLinkedList words = new MyLinkedList();
      MyLinkedList size1 = new MyLinkedList();
      size1.add("hi");
      //add 0-9 in order
      for(int i = 0; i < 10; i++){
        words.add(i+"");
      }
      //insert 0x - 9x before each value 0-9
      for(int i = 0; i < 10; i++){
        words.add(2*i,i+"x");
      }
      //check the head/tail add
      words.add(0,"head");
      words.add(words.size(),"tail");

      try{
        words.add(-1,"");
        System.out.println("ERROR! Added to negative index");
      }catch(IndexOutOfBoundsException e){

      }

      try{
        words.add(words.size()+1,"");
        System.out.println("ERROR! Added to (size + 1) index");
      }catch(IndexOutOfBoundsException e){

      }
      System.out.println(size1.toString());
      words.extend(size1);
      words.remove(0);

      System.out.println(size1.toString() + size1.size());
      System.out.println("Your result:\n"+words+" "+words.size());
      System.out.println("expected:\n[head, 0x, 0, 1x, 1, 2x, 2, 3x, 3, 4x, 4, 5x, 5, 6x, 6, 7x, 7, 8x, 8, 9x, 9, tail] 22");
      System.out.println("\nYour result:\n"+words.toStringReversed()+" "+words.size());
      System.out.println("expected:\n[tail, 9, 9x, 8, 8x, 7, 7x, 6, 6x, 5, 5x, 4, 4x, 3, 3x, 2, 2x, 1, 1x, 0, 0x, head] 22");

    }
}
