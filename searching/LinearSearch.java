package searching;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {
	
	public static int search(int  [] a, int value){
		int nr=0;
		for (int i = 0; i < a.length; i++) {
			nr=i;
			if(a[i]==value){
				System.out.println("search in array:"+"\n"+Arrays.toString(a)+"\n"+"array length: "+a.length+"\n"+"search value: "+value+"\n"+"search times:"+nr);
				return i;}
		}
		System.out.println("search array:"+"\n"+Arrays.toString(a)+"\n"+"search value: "+value+"\n"+"search times:"+nr);
		return -1;
	}
	
	public static void main(String[] args) {
		int [] a = LinearSearch.randomIntArray(1, 50, 20);
		//System.out.println(MergeSort.toString(a));
		System.out.println(Arrays.toString(a));
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
				int pos=LinearSearch.search(a, n);
				System.out.println("Found in position: "+pos);
			}
		}
	}
	
	public static int [] randomIntArray(int valueFrom, int valueTo, int arrayLength){
		int [] a=new int [arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			a[i]=(int) (Math.random()*(valueTo-valueFrom))+valueFrom;
		}
		return a;
	}
}
