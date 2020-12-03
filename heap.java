package assign2;
import java.util.*;
public class heap {

	public static void heapify(List<Integer> heap, int n, int i) 
    { 
        int smallest = i; // Initialize largest as root 
        int l = 2 * i + 1; // left = 2*i + 1 
        int r = 2 * i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && heap.get(l) < heap.get(smallest)) 
            smallest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && heap.get(r) < heap.get(smallest)) 
            smallest = r; 
  
        // If largest is not root 
        if (smallest != i) { 
            int swap = heap.get(i); 
            heap.set(i, heap.get(smallest)); 
            heap.set(smallest, swap);  
            heapify(heap, n, smallest); 
        } 
    } 
  
    // Function to build a Min-Heap from the Array 
    static void buildHeap(List<Integer> heap, int n) 
    { 
  
        // Perform reverse level order traversal 
        // from last non-leaf node and heapify 
        // each node 
        for (int i = n; i >= 0; i--) { 
            heapify(heap, n, i); 
        } 
    } 
	
    static void printHeap(List<Integer> heap, int n) 
    { 
        System.out.println("Array representation of Heap is:"); 
  
        for (int i = 0; i < n; ++i) 
            System.out.print(heap.get(i) + " "); 
  
        System.out.println(); 
    }
    
    static void insert(List<Integer> heap, int element) {
    	heap.add(element);
    	buildHeap(heap, heap.size());
    }
    
    static int remove(List<Integer> heap) {
    	int elementToRemove = heap.remove(0);
    	buildHeap(heap, heap.size());
    	return elementToRemove;
    }
    
	public static void main(String[] args) {
		 List<Integer> heap = new ArrayList<>();
		 heap.add(7);
		 heap.add(6);
		 heap.add(5);
		 heap.add(4);
		 heap.add(3);
		 heap.add(2);
   		buildHeap(heap, heap.size()); 
   		printHeap(heap, heap.size()); 
   		insert(heap , 1);
   		printHeap(heap, heap.size()); 
   		remove(heap);
   		printHeap(heap, heap.size());
	}

}
