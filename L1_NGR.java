import java.util.*;
import java.util.ArrayList;

public class L1_NGR
{
	public static void main(String[] args)
	{
		int[] arr = {1, 3, 2, 4};   // ans is 3 4 4 -1

		List<Integer> ngr = nextGreatestRight(arr);
		System.out.println(ngr);		
	}




	public static List<Integer> nextGreatestRight(int[] arr)
	{
		int n = arr.length; 
		Stack<Integer> st = new Stack<Integer>();
		List<Integer> ans = new ArrayList<>();


		for(int i = n-1; i>=0; i--)
		{
			if(st.empty())
				ans.add(-1);

			else if(!st.empty() && st.peek()>arr[i])
			{
				ans.add(st.peek());
			}

			else if(!st.empty() &&  st.peek()<arr[i])
			{
				while(!st.empty()  && st.peek() <= arr[i])
				{
					st.pop();
				}

				if(st.empty())
					ans.add(-1);
				else
					ans.add(st.peek());
			}


			st.push(arr[i]);
		}


		

		//reverse will give the answer
		 Collections.reverse(ans);

		 return ans;
		
	}
}