package Experiments;
import java.util.*;

public class _4JobSequencing 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of jobs : ");
		int n=sc.nextInt();
		String a[]=new String[n];
		int b[]=new int[n];
		int c[]=new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter name of the job : ");
			a[i]=sc.next();
			System.out.print("Enter profit of "+a[i]+" : ");
			b[i]=sc.nextInt();
			System.out.print("Enter deadline of "+a[i]+" : ");
			c[i]=sc.nextInt();
		}
		System.out.println();
		System.out.println("----Arranged Order----");
		System.out.print("Jobs     : ");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		System.out.print("Profit   : ");
		for(int i=0;i<n;i++)
			System.out.print(b[i]+" ");
		System.out.println();
		System.out.print("Deadline : ");
		for(int i=0;i<n;i++)
			System.out.print(c[i]+"  ");
		System.out.println();
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(b[i]<b[j])
				{
					int temp=b[i];
					b[i]=b[j];
					b[j]=temp;
					int temp1=c[i];
					c[i]=c[j];
					c[j]=temp1;
					String temp2=a[i];
					a[i]=a[j];
					a[j]=temp2;
				}
			}
		}
		System.out.println();
		System.out.println("------Sorted Order------");
		System.out.print("Jobs     : ");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		System.out.print("Profit   : ");
		for(int i=0;i<n;i++)
			System.out.print(b[i]+" ");
		System.out.println();
		System.out.print("Deadline : ");
		for(int i=0;i<n;i++)
			System.out.print(c[i]+"  ");
		System.out.println("\n");
		int max=c[0];
		for(int i=0;i<n;i++)
		{
			if(c[i]>max)
				max=c[i];
		}
		String x[]=new String[max];
		int profit=0;
		for(int i=0;i<n;i++)
		{
			int pp=c[i];
			pp--;
			if(x[pp]==null)
			{
				x[pp]=a[i];
				profit+=b[i];
			}
			else
			{
				while(pp!=-1)
				{
					if(x[pp]==null)
					{
						x[pp]=a[i];
						profit+=b[i];
						break;
					}
					pp--;
				}
			}
		}
		System.out.print("Sequence of jobs : "+x[0]);
		for(int i=1;i<max;i++)
			System.out.print(" --> "+x[i]);
		System.out.println("\n");
		System.out.println("Profit Earned : "+profit);
		sc.close();
	}
}