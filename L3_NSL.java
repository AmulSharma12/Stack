import java.util.Scanner;
import java.util.*;


public class L3_NSL
{
	public static void main(String[] args)
	{
		int[] arr = {4, 5, 2, 10, 8};
		List<Integer> nsl = nsl(arr);
		System.out.println(nsl);

	}



	public static List<Integer> nsl(int[] arr)
	{
		int n = arr.length;
		Stack<Integer> st = new Stack<>();
		List<Integer> ans = new ArrayList<>();


		for(int i = 0; i<n; i++)
		{
			if(st.isEmpty())
				ans.add(-1);

			else if(!st.isEmpty() && st.peek()<arr[i])
				ans.add(st.peek());

			else if(!st.isEmpty() && st.peek() >= arr[i])
			{
				while(!st.isEmpty() && st.peek() >= arr[i]) st.pop();
				if(st.isEmpty())	ans.add(-1);
				else 				ans.add(st.peek());
			}

			st.push(arr[i]);

		}
		return ans;
	}



}