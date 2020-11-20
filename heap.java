package assign2;

public class heap {

	public static void heapify(int arr[], int n, int i) 
    { 
        int smallest = i; // Initialize largest as root 
        int l = 2 * i + 1; // left = 2*i + 1 
        int r = 2 * i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] < arr[smallest]) 
            smallest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] < arr[smallest]) 
            smallest = r; 
  
        // If largest is not root 
        if (smallest != i) { 
            int swap = arr[i]; 
            arr[i] = arr[smallest]; 
            arr[smallest] = swap; 
        
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, smallest); 
        } 
    } 
  
    // Function to build a Min-Heap from the Array 
    static void buildHeap(int arr[], int n) 
    { 
  
        // Perform reverse level order traversal 
        // from last non-leaf node and heapify 
        // each node 
        for (int i = n; i >= 0; i--) { 
            heapify(arr, n, i); 
        } 
    } 
	
    static void printHeap(int arr[], int n) 
    { 
        System.out.println("Array representation of Heap is:"); 
  
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
  
        System.out.println(); 
    } 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = { 1, 3, 5, 4, 6, 13, 10, 
                 9, 8, 15, 17 }; 

		 int n = arr.length; 

   		buildHeap(arr, n); 

   		printHeap(arr, n); 
	}

}
