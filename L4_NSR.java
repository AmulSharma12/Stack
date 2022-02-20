import java.util.Scanner;

public class L4_NSR
{
	public static void main(String[] args)
	{
		int[] arr = {4, 5, 2, 10, 8};   // 2 2 -1 8 -1
		List<Integer> ans = nsr(arr);
		System.out.println(ans);
	}


	public static List<Integer> nsr(int[] arr)
	{
		int n = arr.length;
		Stack<Integer> st = new Stack<>();
		List<Integer> ans = new ArrayList<>();


		for(int i = n-1; i>=0; i--)
		{
			if(st.isEmpty())
				ans.add(-1);


			else if(!st.isEmtpy()  && st.peek > arr[i])
				ans.add(st.peek());

			else if(!st.isEmpty() && st.peek <= arr[i])
			{
				while(!st.isEmpty()  && st.peek <= arr[i])
					st.pop();
				if(st.isEmpty())
					ans.add(-1);
				else ans.add(st.peek());
			}


			st.push(arr[i]);
		}

		Collections.reverse(ans);
		return ans;
	}
}