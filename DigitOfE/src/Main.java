public class Main {
 
	public static void main(String args[]){
	int N=19000,n=N,a[]=new int[N],x=0;
	StringBuilder eSB = new StringBuilder(N+2);
	
	while(--n!=0)
		a[n]=1+1/n;
	for(;N>9;eSB.append(x))
		for(n=N--;--n!=0;
		a[n]=x%n,
		x=10*a[n-1]+x/n);
	eSB.insert(1, '.');
	System.out.print(eSB);
	}
	
} 