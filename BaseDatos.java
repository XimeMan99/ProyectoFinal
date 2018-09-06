
public class BaseDatos {
  public class BaseDatos {
	
	//atributos
	private Estudiante alumno;
	private String nombreUsuario;
	private String contra;

	//constructor con parametros
	public BaseDatos(String nombreUusuario, String contra, Estudiante alumno) 
	{
		this.nombreUsuario = nombreUsuario;
		this.contra = contra;
		this.alumno = alumno;
	}
	
	//constructor sin parametros
	public BaseDatos() 
	{
		nombreUsuario = " ";
		contra = " ";
		alumno = new Estudiante();
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
