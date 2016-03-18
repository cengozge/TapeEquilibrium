import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import conversion.Conversions;

public class TapeEquilibrium {

	public static void main(String[] args) {
		int[] A = {3,1,2,4,3};
		System.out.println(solution(A, 5));
	}
	
	public static int solution(int A[], int N){
		
		List<Integer> list = new ArrayList<Integer>();//collects differences
		
		List<Integer> arrayList = Conversions.fromArrayToList(A);
		
		//start point is 0th element and the rest of the array
		int sumRight = A[0];
		int sumLeft = arrayList.stream().mapToInt(Integer::intValue).sum()-sumRight;
		
		list.add(Math.abs(sumLeft-sumRight));
		
		for (int i = 1; i < A.length-1; i++) {
			sumRight += A[i];
			sumLeft -= A[i];
			list.add(Math.abs(sumLeft-sumRight));
		}
		
		return Collections.min(list);
	}
}
