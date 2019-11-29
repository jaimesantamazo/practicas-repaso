package calculadora;

public class calculadora1 implements calculadora{
	
	public int a;
	public int b;
	
	public int sumar(int a, int b) {
		return a+b;
	}
	
	public int restar(int a, int b) {
		return a-b;
	}
	
	public int multiplicar(int a, int b) {
		return a*b;
	}
	
	public boolean esPar(int a) {
		if(a%2==0) {
			return true;
		}else
			return false;
	}
	
	public double cuadrado(int a) {
		return a*a;
	}

	

}
