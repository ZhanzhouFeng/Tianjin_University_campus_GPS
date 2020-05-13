package gps;

public class forbidroad {
	int d[][];
	final int n=100000;
	
	public forbidroad(int[][] dist) {
		// TODO Auto-generated constructor stub
		d = dist;
		int a;
		int b;
		
		a=65;
		b=27;
		d[a][b]=n;d[b][a]=n;
		
		a=97;
		b=64;
		d[a][b]=n;d[b][a]=n;
		
		a=96;
		b=71;
		d[a][b]=n;d[b][a]=n;
		
		a=62;
		b=48;
		d[a][b]=n;d[b][a]=n;
		
		a=96;
		b=71;
		d[a][b]=n;d[b][a]=n;
		
		a=62;
		b=70;
		d[a][b]=n;d[b][a]=n;
		
		a=62;
		b=13;
		d[a][b]=n;d[b][a]=n;
		
		a=87;
		b=62;
		d[a][b]=n;d[b][a]=n;
		
		a=87;
		b=70;
		d[a][b]=n;d[b][a]=n;
		
		a=53;
		b=6;
		d[a][b]=n;d[b][a]=n;
		
	}

}
