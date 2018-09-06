
import java.util.*;
public class MainProv {
	public static void main (String [] args){
		Scanner teclado = new Scanner(System.in);
		BaseDatos datosUsuario = new BaseDatos();
		System.out.println("BIENVENIDO!\n Porfavor ingrese la siguiente información: ");
		System.out.println("------------------Sign Up----------------------");
		//System.out.println("Seleccione la opcion (numero) en la que ingresara la cantidad: \n1.Log in \n2.Crear Usuario");
		//int opcion = scan.nextInt();
		System.out.println("Ingrese el nombre de Usuario: ");
		String nombreUsuario = teclado.nextLine();
		
		System.out.println("Ingrese su contrasenia: ");
		String contra = teclado.nextLine();
		datosUsuario.llenarBaseDatos(nombreUsuario, contra);
		System.out.println(datosUsuario.toStringUsuario());
	}
}
