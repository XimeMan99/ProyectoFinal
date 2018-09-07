public class Asignaturas{
  private ArrayList<Asignatura> Anio = new ArrayList<Asignatura>();

  public Asignaturas(){
    private ArrayList<Asignatura> Anio;
  }

  public Asignaturas(ArrayList<Asignatura>Anio){
    this.Año = Anio;
  }

  public void setAnio(ArrayList<Asignatura>Anio){
    this.Anio = Anio;
  }

  public String getAnio(){
    return Anio;
  }

  public void llenarAsignatura(String Nombre, int Codigo, int Anio, int Semestre) {
	Asignatura curso = new Asignatura;
	curso.setNombre(Nombre);
	curso.setCodigo(Codigo),
	curso.setAnio(Anio);
	curso.setSemestre(Semestre);
	
	Anio.add(curso);
  }




}
