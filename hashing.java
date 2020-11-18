package assign2;
import java.util.*;
public class hashing {
//	array = {2, 7, 8, 13, 104, 52, 26, 77, 100}
//	hashtable of size = 13, h(x) = (array[i]%13 + 7)
//	which index has the maximum collisions after hashing.
//	[0, 1, 0, 0, 0, 0, 0, 4, 0, 1, 0, 0, 0]
	public static void main(String[] args) {
		int[] nums = {2, 7, 8, 13, 104, 52, 26, 77, 100};
		int[] hashtable = new int[13];
		int maxCollisions = -1;
		int index = -1;
		for(int i = 0; i < nums.length; i++) {
			int hash = (nums[i] + 7) % 13;
			hashtable[hash]++;
			if(hashtable[hash] > maxCollisions) {
				maxCollisions = hashtable[hash];
				index = hash;
			}
		}
		System.out.println(Arrays.toString(hashtable));
		System.out.println("index with max collisions: " + index + " with " + maxCollisions + " collisions.");
	}
}
