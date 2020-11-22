package es.uclm.esi.utilities;
/**
 * Ejemplo de uso de la clase PoliticaContraSegura
 * @author German
 */
public class EjemploUsoPoliticaContra {

	public static void ej(String[] args) {
		String contrasenaejemplo = "ContrasenaSIGET2";
		if(!PoliticaContraSegura.caracteres(contrasenaejemplo)) {
			System.out.println("La contraseña debe contener, al menos, 8 caracteres");
		} else if(!PoliticaContraSegura.minuscula(contrasenaejemplo)) {
			System.out.println("La contraseña debe contener, al menos, una letra minúscula");
		} else if(!PoliticaContraSegura.mayuscula(contrasenaejemplo)) {
			System.out.println("La contraseña debe contener, al menos, una letra mayúscula");
		} else if(!PoliticaContraSegura.numero(contrasenaejemplo)) {
			System.out.println("La contraseña debe contener, al menos, un número");
		} else if(!PoliticaContraSegura.alfanum(contrasenaejemplo)) {
			System.out.println("La contraseña debe estar formada por caracteres alfanuméricos (a-Z 0-9)");
		} else {
			System.out.println("La contraseña es segura");
		}
	}
}