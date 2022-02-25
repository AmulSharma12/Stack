// this problem is based on the extend version of nearest greater to left

// import javafx.util.Pair;  
import java.util.*;
import javafx.util.Pair;
//Solved CONFIRM
//list of price of stock is given in array we have to find all the consecutive smaller or equal to left part of index i
// 100 80 60 70 60 75 85
// 1    1  1  2  1  4  6
// actually we are finding when a largest element encounter but we have to make also record of index 
// so that difference of index - list(index) will give the all element lesser than or equal to tha element
public class L5_StockSpan
{
	public static void main(String[] args)
	{
		int[] arr = {100, 80, 60, 70, 60, 75, 85};
		List<Integer> ans = stockSpan(arr);
		System.out.println(ans);
	}



	public static List<Integer> stockSpan(int[] arr)
	{
		int n  = arr.length;

		Stack<Pair<Integer, Integer>> st =  new Stack<Pair<Integer,Integer>>();
		List<Integer> ans = new ArrayList<>();

		for(int i = 0; i<n; i++)
		{
			if(st.empty())
				ans.add(-1);
			else if(!st.isEmpty() && st.peek().getKey() > arr[i])
				ans.add(st.peek().getValue());
			else if(!st.isEmpty() &&  st.peek().getKey() <=arr[i])
			{
				while(!st.isEmpty() && st.peek().getKey() <= arr[i])
					st.pop();
				if(st.isEmpty())
					ans.add(-1);
				else 
					ans.add(st.peek().getValue());
			}


			st.push(new Pair<Integer,Integer>(arr[i],i));
			

		}

		List<Integer> result = new ArrayList<>();
		//now index- ans.get(index) will give the ans
			for(int i = 0; i<n; i++)
			{
				int element = i - ans.get(i);
				result.add(element);
			}


			return result;
		
	}
}