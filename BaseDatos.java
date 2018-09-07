
import java.util.ArrayList;
  public class BaseDatos {
	
	//atributos
	private Estudiante alumno;
	private String nombreUsuario;
	private String contra;
	 private ArrayList<Estudiante> usuarios;

	//constructor con parametros
	public BaseDatos(String nombreUusuario, String contra, Estudiante alumno,  ArrayList<Estudiante> usuarios) 
	{
		this.nombreUsuario = nombreUsuario;
		this.contra = contra;
		this.alumno = alumno;
		this.usuarios = usuarios;
	}
	
	//constructor sin parametros
	public BaseDatos() 
	{
		nombreUsuario = " ";
		contra = " ";
		alumno = new Estudiante();
		ArrayList<Estudiante>usuarios = new ArrayList<Estudiante>();
	}

	
	//sets y gets
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}
	public ArrayList getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(ArrayList<Estudiante>usuarios) {
		this.usuarios = usuarios;
	}

	//Llenar atributos de la clase
	public void llenarBaseDatos(String nombreUsuario, String contra) 
	{
		alumno.setNombreUsuario(nombreUsuario);
		alumno.setContra(contra);
	}
	public void llenarEsudiante(String nombre,int carnet,String correo, boolean estatus,String nombreUsuario,String contra) {
		alumno = new Estudiante();
		alumno.setNombre(nombre);
		alumno.setCarnet(carnet);
		alumno.setCorreo(correo);
		alumno.setEstatus(estatus);
		alumno.setNombreUsuario(nombreUsuario);
		alumno.setContra(contra);
		
		
		
	//Llenar atributos de la clase
 	public void llenarBaseDatos(String nombreUsuario, String contra) 
	{
		alumno.setNombreUsuario(nombreUsuario);
		alumno.setContra(contra);
	}
	
	public String toStringUsuario() 
	{
		String cadena1 = "Ha ingresado la siguiente informacion: ";
		String cadena2 = "Usuario: " + alumno.getNombreUsuario();
		String cadena3 = "Contrasenia: " + alumno.getContra();
		return cadena1+cadena2+cadena3;
	}

}



  
}
