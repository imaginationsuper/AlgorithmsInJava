/* *
 * Pseudo-code:
 * 
 * SelectionSort(L, index, N):		
 * 		if index <=  N
 * 			minIndex = Min(L, index, N)
 * 			swap(L, index, minIndex)
 * 			index = index + 1
 * 			SelectionSort(L, index, N)
 * end Selection Sort
 * 
 * Min(L, index, N):
 * 		minIndex = index
 * 		for i = index to N do
 * 			if L[i] < L[minIndex] then
 * 				minIndex = i
 * 		return minIndex
 * end Min
 * 
 * *******************************************
 * Worst case performance: O(n^2) 
 * Best case performance: O(n^2) 
 * Average case performance: O(n^2) 
 * Worst case space complexity: O(n) total, O(1) auxilliary
 * *******************************************
 */
import java.util.Random;

public class selection_sort{
	private int[] list;
	
	public selection_sort(int[] input)
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
		if (index < endIndex)
		{
			int minIndex = min(L, index, endIndex);
			swap(L, index++, minIndex);
			ascend_sort(L, index, endIndex);
		}
	}
	
	private int min(int[] L, int index, int endIndex)
	{
		int minIndex = index;
		for (int i=index; i<=endIndex; i++)
		{
			minIndex = L[i]<L[minIndex]? i:minIndex;
		}
		return minIndex;
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
	
	public static void main(String[] args)
	{
		// To do for this Unit test
		int size = 100;
		int[] numbers = new int[size];
		Random rand = new Random();
		for (int i=0; i<size; i++)
		{
			numbers[i] = rand.nextInt(1000);
		}
		selection_sort ss = new selection_sort(numbers);
		ss.ascend_sort();
	}
}