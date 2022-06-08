package Experiments;
import java.util.*;

public class _1BSearch 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the size of array : ");
		int n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("Enter elements into array : ");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		Arrays.sort(a);
		System.out.println("Sorted Array is : ");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		System.out.println("\n");
		System.out.println("Search by\n1.Iteration\t2.Recursion\n");
		System.out.print("Enter your choice : ");
		int op=sc.nextInt();
		int key;
		switch(op)
		{
			case 1:System.out.print("Enter element to search : ");
				key=sc.nextInt();
				iterativeSearch(a,n,key);
				break;
			case 2:System.out.print("Enter element to search : ");
				key=sc.nextInt();
				recursiveSearch(a,0,n-1,key);
				break;
			default:System.out.println("Invalid input");
		}
		sc.close();
	}
	static void iterativeSearch(int a[],int n, int key)
	{
		long start=System.nanoTime();
		int low=0, high=n-1;
		while(low<=high)
		{
			int mid=(low+high)/2;
			if(key>a[mid])
				low=mid+1;
			else if(key<a[mid])
				high=mid-1;
			else
			{	
				System.out.println("Element found at "+mid+" index");
				long end=System.nanoTime();
				System.out.println("Time Complexity for iteration= "+(end-start)+" nano seconds");
				return;
			}
		}
		System.out.println("Element not found");
		long end=System.nanoTime();
		System.out.println("Time Complexity = "+(end-start)+" nano seconds");
	}
	static void recursiveSearch(int a[],int low,int high,int key)
	{
		long start=System.nanoTime();
		if(low<=high)
		{
			int mid=(low+high)/2;
			if(key==a[mid])
			{
				System.out.println("ELement found at "+mid+" index");
				
				long end=System.nanoTime();
				System.out.println("Time Complexity for recursion = "+(end-start)+" nano seconds");
				return;
			}
			else if(key>a[mid])
				recursiveSearch(a,mid+1,high,key);
			else
				recursiveSearch(a,low,mid-1,key);
		}
		else
		{
			System.out.println("Element not found");
			long end=System.nanoTime();
			System.out.println("Time Complexity = "+(end-start)+" nano seconds");
			return;
		}
	}
}
