package recursividad;

public class ejemplo {

	public static void main(String[] args) {
		imprimir(0);

	}
	public static void imprimir(int n) {
		System.out.println(n);
		
		if(n<10) {
			imprimir(n++);
		}
	}

}
