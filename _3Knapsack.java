package Experiments;
import java.util.*;

public class _3Knapsack 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of objects : ");
		int object=sc.nextInt();
		int weight[]=new int[object];
		int profit[]=new int[object];
		for(int i=0;i<object;i++)
		{
			System.out.print("Enter weight of object - "+(i+1)+" : ");
			weight[i]=sc.nextInt();
			System.out.print("Enter profit of object - "+(i+1)+" : ");
			profit[i]=sc.nextInt();
		}
		System.out.print("Enter Knapsack capacity : ");
		int m=sc.nextInt();
		double p_w[]=new double[object];
		for(int i=0;i<object;i++)
			p_w[i]=(double)profit[i]/(double)weight[i];
		System.out.println();
		System.out.println("-----DataSet--------");
		System.out.print("Objects    ");
		for(int i=1;i<=object;i++)
			System.out.print(i+"	");
		System.out.println();
		System.out.print("Profits    ");
		for(int i=0;i<object;i++)
			System.out.print(profit[i]+"	");
		System.out.println();
		System.out.print("Weights    ");
		for(int i=0;i<object;i++)
			System.out.print(weight[i]+"	");
		System.out.println();
		System.out.print("P/W        ");
		for(int i=0;i<object;i++)
			System.out.print(p_w[i]+"	");
		System.out.println();
		long a=System.nanoTime();
		for(int i=0;i<object-1;i++)
		{
			for(int j=i+1;j<object;j++)
			{
				if(p_w[i]<p_w[j])
				{
					double temp=p_w[j];
					p_w[j]=p_w[i];
					p_w[i]=temp;
					int temp1=profit[j];
					profit[j]=profit[i];
					profit[i]=temp1;
					int temp2=weight[j];
					weight[j]=weight[i];
					weight[i]=temp2;
				}
			}
		}
		long b=System.nanoTime();
		long c=b-a;
		System.out.println();
		System.out.println("-------After arranging-------");
		System.out.print("Objects    ");
		for(int i=1;i<=object;i++)
			System.out.print(i+"	");
		System.out.println();
		System.out.print("Profits    ");
		for(int i=0;i<object;i++)
			System.out.print(profit[i]+"	");
		System.out.println();
		System.out.print("Weights    ");
		for(int i=0;i<object;i++)
			System.out.print(weight[i]+"	");
		System.out.println();
		System.out.print("P/W        ");
		for(int i=0;i<object;i++)
			System.out.print(p_w[i]+"	");
		System.out.println();
		int k=0;
		double sum=0;
		System.out.println();
		long d=System.nanoTime();
		while(m>0)
		{
			if(weight[k]<m)
			{
				sum+=1*profit[k];
				m=m-weight[k];
			}
			else
			{
				double x4=m*profit[k];
				double x5=weight[k];
				double x6=x4/x5;
				sum+=x6;
				m=0;
			}
			k++;
		}
		long e=System.nanoTime();
		long f=e-d;
		System.out.println("Final profit is : "+sum);
		System.out.println("Time Complexity = "+(c+f)+" nanoseconds");
		sc.close();
	}
}
