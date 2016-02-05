/* *
 * Pseudo-code:
 * 
 * HeapSort(L, N)
 * 		BuildHeap(L, N)
 * 		for i = N to 1 do 
 * 			swap(L[1], L[i])
 * 			N = N - 1
 *			Heapify(L, 1, N)
 * end HeapSort
 * 
 * BuildHeap(L, N)
 * 		for i = floor(N/2) to 1
 * 			Heapify(L, i, N)
 * end BuildHeap
 * 
 * Heapify(L, index, N)
 * 		maxIndex = index
 * 		left = 2*index
 * 		right = 2*index+1
 * 		if (left<=N) AND (L[left]>L[maxIndex]) then
 * 			maxIndex = left
 * 		if (right<=N) AND (L[right]>L[maxIndex]) then
 * 			maxIndex = right
 * 		if (maxIndex != index) then
 * 			swap(L, maxIndex, index)
 * 			Heapify(L, maxIndex, N)
 * end Heapify
 * 
 * *******************************************
 * Worst case performance: O(n*lgn) 
 * Best case performance: O(n*lgn) 
 * Average case performance: O(n*lgn) 
 * Worst case space complexity: O(n) total, O(1) auxilliary
 * *******************************************
 * */
import java.util.Random;

public class heap_sort {
	private int[] list;
	
	public heap_sort(int[] input)
	{
		list = input.clone();
		System.out.print("Original Array: ");
		printResult();
	}
	
	public void ascend_sort()
	{
		ascend_sort(list, 0, list.length-1);
		System.out.print("Sorted Array: \t");
		printResult();
	}
	
	private void ascend_sort(int[] L, int index, int endIndex)
	{
		build_heap(L, index, endIndex);
		for (int i=endIndex; i>=index; i--)
		{
			swap(L, index, i);
			heapify(L, index, i-1);
		}
	}
	
	private void build_heap(int[] L, int index, int endIndex)
	{
		int endLevel = Math.floorDiv(endIndex-1,2) + 1;
		for (int i=endLevel; i>=index; i--)
		{
			heapify(L, i, endIndex);
		}
	}
	
	private void heapify(int[] L, int index, int endIndex)
	{
		int left = 2*index + 1;
		int right = 2*(index + 1);
		int maxIndex = index;
		if ((left <= endIndex) && (L[left] > L[maxIndex]))
		{
			maxIndex = left;
		}
		if ((right <= endIndex) && (L[right] > L[maxIndex]))
		{
			maxIndex = right;
		}
		if (maxIndex != index)
		{
			swap(L, maxIndex, index);
			heapify(L, maxIndex, endIndex);
		}
	}
	
	private void swap(int[] L, int i, int j)
	{
		int tmp = L[i];
		L[i] = L[j];
		L[j] = tmp;
	}
	
	private void printResult()
	{
		for (int i=0; i<list.length; i++)
		{
			System.out.print(list[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 100;
		int[] numbers = new int[size];
		Random rand = new Random();
		for (int i=0; i<size; i++)
		{
			numbers[i] = rand.nextInt(1000);
		}
		heap_sort hs = new heap_sort(numbers);
		hs.ascend_sort();
	}
}
