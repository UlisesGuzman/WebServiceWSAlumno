package mx.edu.utng.ws;

public class Alumno {

    private int cveUniversidad;
    private String matricula;
    private String notas;
    private String fechaAlta;
    private boolean becado;
    private String grupo;
    private int generacion;
    private String nombre;
	
	public Alumno(int cveUniversidad, String matricula, String notas, String fechaAlta, boolean becado, String grupo,
			int generacion, String nombre) {
		super();
		this.cveUniversidad = cveUniversidad;
		this.matricula = matricula;
		this.notas = notas;
		this.fechaAlta = fechaAlta;
		this.becado = becado;
		this.grupo = grupo;
		this.generacion = generacion;
		this.nombre = nombre;
	}
	
	public Alumno(){
		this(0,"","","",true,"",0,"");
	}

	public int getCveUniversidad() {
		return cveUniversidad;
	}

	public void setCveUniversidad(int cveUniversidad) {
		this.cveUniversidad = cveUniversidad;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public boolean isBecado() {
		return becado;
	}

	public void setBecado(boolean becado) {
		this.becado = becado;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getGeneracion() {
		return generacion;
	}

	public void setGeneracion(int generacion) {
		this.generacion = generacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Alumno [cveUniversidad=" + cveUniversidad + ", matricula=" + matricula + ", notas=" + notas
				+ ", fechaAlta=" + fechaAlta + ", becado=" + becado + ", grupo=" + grupo + ", generacion=" + generacion
				+ ", nombre=" + nombre + "]";
	}
	
	
	
	
}


