package Experiments;
import java.util.Scanner;

class MergeSort
{
	void merge(int a[],int low, int mid, int high)
	{
		int n1=mid-low+1;
		int n2=high-mid;
		int l[]=new int[n1];
		int r[]=new int[n2];
		for(int i=0;i<n1;i++)
			l[i]=a[low+i];
		for(int j=0;j<n2;j++)
			r[j]=a[mid+1+j];
		int i=0, j=0, k=low;
		while(i<n1 && j<n2)
		{
			if(l[i]<=r[j])
			{
				a[k]=l[i];
				i++;
			}
			else
			{
				a[k]=r[j];
				j++;
			}
			k++;
		}
		while(i<n1)
		{
			a[k]=l[i];
			i++;
			k++;
		}
		while(j<n2)
		{
			a[k]=r[j];
			j++;
			k++;
		}
		printArray(a);
	}
	void sort(int a[],int low, int high)
	{
		if(low<high)
		{
			int mid=(low+high)/2;
			sort(a,low,mid);
			sort(a,mid+1,high);
			merge(a,low,mid,high);
		}
	}
	void printArray(int a[])
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");	
		System.out.println();
	}
}

public class _2MergeSort 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of elements : ");
		int n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("Enter array elements : ");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		MergeSort ob=new MergeSort();
		System.out.println("Given Array : ");
		ob.printArray(a);
		System.out.println();
		long start=System.nanoTime();
		ob.sort(a, 0, a.length-1);
		System.out.println();
		System.out.println("Sorted Array : ");
		ob.printArray(a);
		System.out.println();
		long end=System.nanoTime();
		System.out.println("Time Complexity = "+(end-start)+" nano seconds");
		sc.close();
	}
}
