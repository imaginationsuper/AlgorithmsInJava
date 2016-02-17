/* *
 * Pseudo-code:
 * 
 * BubbleSort(L, N):
 * 	repeat 
 * 		swapped = false
 * 		for i = 1 to N-1 do
 * 			if L[i-1] > L[i] then 
 * 				swap(L[i-1], L[i])
 * 				swapped = true
 * 			end if
 * 		end for
 * 	until swapped = true
 * 
 * *******************************************
 * Worst case performance: O(n^2)
 * Best case performance: O(n)
 * Average case performance: O(n^2)
 * *******************************************
 * */

import java.util.Random;

public class bubble_sort {
	private int[] list;
	
	public bubble_sort(int[] input)
	{
		list = input.clone();
		System.out.print("Original Array: ");
		printResult();
	}

	public void ascend_sort()
	{
		ascend_sort(list);
		System.out.print("Sorted Array: \t");
		printResult();
	}
	
	private void ascend_sort(int[] L)
	{
		boolean swapped = true;
		while (swapped == true)
		{
			swapped = false;
			for (int i=1; i<L.length; i++)
			{
				if (L[i-1] > L[i])
				{
					swap(L, i-1, i);
					swapped = true;
				}
			}
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
		bubble_sort bs = new bubble_sort(numbers);
		bs.ascend_sort();
	}

}
