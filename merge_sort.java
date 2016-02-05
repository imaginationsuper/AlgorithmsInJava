/* *
 * Pseudo-code:
 * 
 * MergeSort(L)
 * 		if L is empty then return L
 * 		else if rest(L) then return first(L)
 * 		else return Merge(MergeSort(firstHalf(L)), MergeSort(secondHalf(L)))
 * end MergeSort
 * 
 * Merge(L1, L2)
 * 		if L1 is empty then return L2
 * 		else if L2 is empty then return L1
 * 		else if first(L1) < first(L2) then return first(L1)+Merge(rest(L1), L2)
 * 		else return first(L2)+Merge(L1, rest(L2))
 * end Merge
 * 
 * *******************************************
 * Worst case performance: O(n*lgn) 
 * Best case performance: O(n*lgn) typical
 * Average case performance: O(n*lgn) comparisons and swaps
 * Worst case space complexity: O(n) total, O(n) auxilliary
 * *******************************************
 * */
import java.util.Random;


public class merge_sort {
	private int[] list;
	
	public merge_sort(int[] input)
	{
		list = input.clone();
		System.out.print("Original Array: ");
		printResult();
	}
	
	public void ascend_sort()
	{
		list = ascend_sort(list);
		System.out.print("Sorted Array: \t");
		printResult();
	}
	
	private int[] ascend_sort(int[] L)
	{
		if (L.length == 0)
		{
			return L;
		}
		else if (rest(L).length == 0)
		{
			return new int[]{L[0]};
		}
		else
		{
			return merge(ascend_sort(firstHalf(L)), ascend_sort(secondHalf(L)));
		}
	}
	
	private int[] merge(int[] L1, int[] L2)
	{
		if (L1.length == 0) return L2;
		else if (L2.length == 0) return L1;
		else if (L1[0] < L2[0])
		{
			int[] result = new int[L1.length + L2.length];
			result[0] = L1[0];
			int[] combine = merge(rest(L1), L2);
			for (int i=0; i<combine.length; i++)
			{
				result[i+1] = combine[i];
			}
			return result;
		}
		else 
		{
			int[] result = new int[L1.length + L2.length];
			result[0] = L2[0];
			int[] combine = merge(L1, rest(L2));
			for (int i=0; i<combine.length; i++)
			{
				result[i+1] = combine[i];
			}
			return result;
		}
	}
	
	private int[] rest(int[] L)
	{
		int[] result = new int[L.length-1];
		for (int i=1; i<L.length; i++)
		{
			result[i-1] = L[i];
		}
		return result;
	}
	
	private int[] firstHalf(int[] L)
	{
		int[] result = new int[L.length/2];
		for (int i=0; i<L.length/2; i++)
		{
			result[i] = L[i];
		}
		return result;
	}
	
	private int[] secondHalf(int[] L)
	{
		int[] result = new int[L.length-L.length/2];
		for (int i=L.length/2; i<L.length; i++)
		{
			result[i-L.length/2] = L[i];
		}
		return result;
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
		merge_sort ms = new merge_sort(numbers);
		ms.ascend_sort();
	}
}
