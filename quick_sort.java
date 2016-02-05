/* *
 * Pseudo-code:
 * 
 * QuickSort(L, lo, hi)
 * 		if lo < hi then
 * 			pIndex = partition(L, lo, hi)
 * 			QuickSort(L, lo, pIndex-1)
 * 			QuickSort(L, pIndex+1, hi)
 * end QuickSort
 * 
 * Partition(L, lo, hi)
 * 		pivot = L[hi]
 * 		i = lo
 * 		for j = lo to hi-1 do
 * 			if L[j] <= pivot then
 * 				swap L[j] with L[i]
 * 				i = i + 1
 * 		swap L[i] with L[hi]
 * 		return i
 * end Partition
 * 
 * *******************************************
 * Worst case performance: O(n^2) 
 * Best case performance: O(n*lgn) 
 * Average case performance: O(n*lgn) 
 * Worst case space complexity: O(n) total, O(1) auxilliary
 * *******************************************
 * */

import java.util.Random;

public class quick_sort {
	private int[] list;
	
	public quick_sort(int[] input){
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
	
	private void ascend_sort(int[] L, int lo, int hi)
	{
		if (lo < hi)
		{
			int pIndex = partition(L, lo, hi);
			ascend_sort(L, lo, pIndex-1);
			ascend_sort(L, pIndex+1, hi);
		}
	}
	
	private int partition(int[] L, int lo, int hi)
	{
		int pivot = L[hi];
		int i = lo;
		for (int j=lo; j<hi-1; j++)
		{
			if (L[j] <= pivot)
			{
				swap(L, i, j);
				i++;
			}
		}
		swap(L, i, hi);
		return i;
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
		// To do for this Unit test
		int size = 100;
		int[] numbers = new int[size];
		Random rand = new Random();
		for (int i=0; i<size; i++)
		{
			numbers[i] = rand.nextInt(1000);
		}
		quick_sort qs = new quick_sort(numbers);
		qs.ascend_sort();
	}

}
