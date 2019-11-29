
public class ejemploparametrosvariables {
	
	public static void main(String[] args) {
		sumar(3,5,67,3);
	}
	public static int sumar(Integer... enteros) {
		int suma = 0;
		for (Integer e : enteros) {
			suma += e;
		}
		return suma;
	}

}
