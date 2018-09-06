
public class Estudiante {
	private String nombre;
	private int carnet;
	private String correo; 
	private boolean estatus; //true - es auxiliar; false - solo alumno
	
	//constructor con parametros
	public Estudiante(String nombre, int carnet, String correo, boolean estatus) {
		super();
		this.nombre = nombre;
		this.carnet = carnet;
		this.correo = correo;
		this.estatus = estatus;
	}
	
	//constructor sin parametros 
	public Estudiante() 
	{
		nombre = "";
		carnet = 0;
		correo = "";
		estatus = true;
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
	
	
}