package Experiments;
import java.util.*;

public class _6AllPairsShortest 
{
	void flyd(int[][] w,int n)
	{
		for(int k=1;k<=n;k++)
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
					w[i][j]=Math.min(w[i][j], w[i][k]+w[k][j]);
	}
	
	public static void main(String[] args) 
	{
		int a[][]=new int[10][10];
		System.out.print("Enter the number of vertices : ");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println("Enter the weighted matrix");
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				a[i][j]=sc.nextInt();
		_6AllPairsShortest f=new _6AllPairsShortest();
		f.flyd(a, n);
		System.out.println("The shortest path matrix is");
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
		sc.close();
	}
}
