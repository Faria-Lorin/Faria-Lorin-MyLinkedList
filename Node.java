public class Node{
 private String data;
 private Node next,prev;

 public Node(String value){
   data = value;
   next = null;
   prev = null;
 }

 public String getData(){
   return data;
 }

 public Node getNext(){
   return next;
 }

 public Node getPrev(){
   return prev;
 }

 public String setData(String value){
   String replaced = data;
   data = value;
   return replaced;
 }

 public Node setNext(Node n){
   Node replaced = next;
   next = n;
   return replaced;
 }

 public Node setPrev(Node p){
   Node replaced = prev;
   prev = p;
   return replaced;
 }
}
