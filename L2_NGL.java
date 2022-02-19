import java.util.*;


public class L2_NGL
{
	public static void main(String[] args)
	{
		int[] arr = {1, 3, 2, 4};
		List<Integer> ngl = ngl(arr);
		System.out.println(ngl);
	}


	public static List<Integer> ngl(int[] arr)
	{
		int n = arr.length;
		Stack<Integer> st = new Stack<Integer>();
		List<Integer> ans = new ArrayList<>();

		for(int i = 0; i<n; i++)
		{
			if(st.isEmpty())
				ans.add(-1);
			else if(!st.empty()  && st.peek() > arr[i])
				ans.add(st.peek());
			else if(!st.empty()  &&  st.peek() < arr[i])
			{
				while(!st.empty() && st.peek() <= arr[i])
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


		return ans;
	}
}