import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Google Question
 * Let "t" be a good number if "t" can be written as sum of 2 
 * cubes in at least 2 distinct ways. 
 * Given n, write a method which prints all good numbers up to and including n.
 */
public class GoodNumbers {
	
	public static void goodNs(int N){
		List<Integer> lst = new ArrayList<Integer>();
		lst.add(0);
		lst.add(1);
		for(int i = 2; (i * i * i) < N; i++) lst.add(i * i * i);

		List<Integer> cubes = new ArrayList<Integer>();
		for(int i = 0; i < lst.size();i++){
			for(int j = i + 1; j < lst.size(); j++){
				cubes.add(lst.get(i) + lst.get(j));
			}
		}

		Set<Integer> set = new HashSet<Integer>();
		for(int cube : cubes){
			if(set.contains(cube)) System.out.println(cube);
			else set.add(cube);
		}
	}

	public static void main(String[] args){
		int N = 1729;
		goodNs(N);
	}
}
