import java.util.*;
public class UtilizeList{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		IntList ll = new IntList();	
		ll.massAddToStart();
		ll.displayContent();
		
		IntList ll2 = new IntList();
		ll.massAddToStart();
		ll.appendListsAndNullify(ll2);
		System.out.print("\nL6: ");
		ll.displayContent();
		System.out.print("L7: ");
		
		
		IntList ll3 = new IntList();
		ll3.massAddToStart();
		ll3.compressList();
		ll3.displayContent();
	// 9 3 3 3 5 9 2 2 9 17 19 4 4 4 4 7
		
		
		System.out.println("Compressed size: " + ll3.compressList());
		ll3.displayContent();
		System.out.println(ll3.insertBetween(15, 10, 12));
		ll3.displayContent();
		System.out.println(ll3.insertBetween(15, 12, 100));
		ll3.displayContent();
		System.out.println(ll3.insertBetween(15, 100, 1200));
		ll3.displayContent();
		
		IntList ll4 = new IntList();
		IntList ll5 = new IntList();
		
		ll4.massAddToStart();
		ll5.massAddToStart();
		
		ll5.appendListsAndNullify(ll4);
		
		
		IntList ll6 = new IntList();
		IntList ll7 = new IntList();
		IntList ll8 = new IntList();
		
		ll6.massAddToStart();
		ll7.massAddToStart();
		ll8.massAddToStart();
		
		ll6.displayContent();
		ll6.insertBetween(10, 20, 45);
		ll6.displayContent();
		ll7.displayContent();
		ll7.insertBetween(140, 20, 35);
		ll7.displayContent();
		ll8.displayContent();
		ll8.insertBetween(10, 30, 55);
		ll8.displayContent();
		scan.close();
	}
}

  class IntList{
	private Node head;	
	Scanner scan;
	public IntList() {
		head = null;
	}
	 class Node{
		private int value;
		private Node next;
		
		public Node(){
			value = 0;
			next = null;
		}
		
		public Node(int v, Node nxt) {
			value = v;
			next = nxt;
		}
	 }
		
		public void addToStart(int value) {
			head = new Node(value, head);
		}
		
		public void massAddToStart() {
			scan = new Scanner(System.in);
			System.out.print("Enter the number of nodes you want to enter: ");
			int size = scan.nextInt();
			for(int i = 0; i < size; i++) {
				addToStart(scan.nextInt());
			}
		}
		
		public void displayContent() {
			Node temp = head;
			while(temp != null) {
				System.out.print(temp.value + " ");
				temp = temp.next;
			}
			System.out.println();
		}
		
		public int compressList() {
			int sameNodes = 0;
			Node temp = head;
			while(temp!= null && temp.next != null) {
				if(temp.value == temp.next.value) {
					sameNodes += 1;
					temp.next = temp.next.next;
					continue;
				}
				temp = temp.next;
			}
			return sameNodes;
		}
		
		public boolean insertBetween(int a, int b, int c) {
			Node temp = head;
			while(temp != null && temp.next != null) {
				if(temp.value == a && temp.next.value == b) break;
				temp = temp.next;
			}
			if(temp == null || temp.next == null) return false;
			Node newNode = new Node();
			newNode.value = c;
			newNode.next = temp.next;
			temp.next = newNode;
			return true;
		}

		public void appendListsAndNullify(IntList l) {
			Node temp = this.head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = l.head;
			l.head = null;
		}
	}
