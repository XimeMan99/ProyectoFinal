
public class Estudiante {
	private String nombre;
	private int carnet;
	private String correo; 
	private boolean estatus; //true - es auxiliar; false - solo alumno
	private String nombreUsuario;
	private String contra;
	
	
	//constructor con parametros
	public Estudiante(String nombre, int carnet, String correo, boolean estatus, String nombreUsuario, String contra) {
		super();
		this.nombre = nombre;
		this.carnet = carnet;
		this.correo = correo;
		this.estatus = estatus;
		this.nombreUsuario = nombreUsuario;
		this.contra = contra;
	}
	
	//constructor sin parametros 
	public Estudiante() 
	{
		nombre = "";
		carnet = 0;
		correo = "";
		estatus = true;
		nombreUsuario = "";
		contra = "";
	}
	
	//sets y gets
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCarnet() {
		return carnet;
	}
	public void setCarnet(int carnet) {
		this.carnet = carnet;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public boolean isEstatus() {
		return estatus;
	}
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

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
	
	
}
