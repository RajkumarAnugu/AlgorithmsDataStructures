package searching;

import java.util.Arrays;
import java.util.Scanner;
import sorting.MergeSort;

public class BinarySearch {
	private static int nr=0;
	public static int search(int[] a, int value) {
		return search(a, 0, a.length - 1, value);
	}

	public static int search(int [] a, int low, int high, int value){
		nr++;
		if(low<=high){
			int mid=(low+high)/2;
			if(value==a[mid]){
				System.out.println("search in array:"+"\n"+Arrays.toString(a)+"\n"+"array length: "+a.length+"\n"+"search value: "+value+"\n"+"search times:"+nr);
				return mid;
			}else if(value>a[mid]){
				return search(a,mid+1,high,value);
			}
			else{
				return search(a,low,mid,value);
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int [] a = LinearSearch.randomIntArray(1, 100, 20);
		System.out.println(Arrays.toString(a));
		MergeSort.sort(a);
		System.out.println("sorted: \n"+Arrays.toString(a));
		Scanner in = new Scanner(System.in);
		boolean done=false;
		while(!done){
			System.out.println("Enter search number: (-1 to quit!)");
			int n= in.nextInt();
			if(n==-1){
				done=true;
				in.close();
				System.out.println("Program closed !");
			}else{
				int pos=BinarySearch.search(a, n);
				System.out.println("Found in position: "+pos);
			}
		}
	}
}
