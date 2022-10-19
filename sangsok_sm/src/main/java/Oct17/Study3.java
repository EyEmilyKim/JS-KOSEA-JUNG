package Oct17;

class Hana{
	int i; int j; double k;
	Hana(int a, int b){i = a; j = b;}
	Hana(double c){k = c;}
}
class Dool extends Hana{
	Dool(int n1, int n2){super(n1,n2);}
	Dool(double d){super(d);}
}
class Seet extends Dool{
	Seet(double a){super(a);}
	Seet(int a, int b){super(a,b);}
}

public class Study3 {
	public static void main(String[] args) {
		Seet s = new Seet(3.14);
		Seet s2 = new Seet(100,200);
	}
}
