
public class ejemplosenunms {
	
	private static Estacion estacion;
	
	enum Estacion{primavera, verano, otoño, invierno};
	
	public static void main(String[] args) {
		for(Estacion e : Estacion.values()) {
			System.out.println(e);
		}
		Estacion e =Estacion.valueOf("inviern");
	}
	

}
