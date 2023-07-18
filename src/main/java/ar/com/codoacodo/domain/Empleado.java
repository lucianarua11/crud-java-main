package ar.com.codoacodo.domain;

public class Empleado {
	private Long dni; // private actua como public para la clase misma, pero invisible para el resto
	private String nombre;
	private String apellido;
	private Long dpto_id;
	
	// alt +shift +s para generar automaticamente los get y set y tambien el constructor y el tostring de forma automatica
	
	
	
	public Empleado (Long dni, String nombre, String apellido, Long dpto_id) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dpto_id = dpto_id;
	}


	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getDpto_id() {
		return dpto_id;
	}

	public void setDpto_id (Long dpto_id) {
		this.dpto_id = dpto_id;
	}

	@Override
	public String toString() {
		return "Empleado [dni=' + dni + ', nombre=' + nombre + ', apellido=' + apellido + ', dpto_id=' + dpto_id + ']";
	}
	

}
