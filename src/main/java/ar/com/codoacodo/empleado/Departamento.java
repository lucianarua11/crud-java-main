package ar.com.codoacodo.empleado;

public class Departamento {
	
	int id;
	String nombre;
	Departamento presupuesto;

    public Departamento(int id,String nombre,Departamento presupuesto) {
    	this.id = id;
    	this.nombre = nombre ;
    	this.presupuesto = presupuesto;
    	
    }
    
    //metodos
    	public void mostrarDatos() {
    		System.out.println("detallando Departamento..");
    		System.out.println("Id:" + id);
    		System.out.println("Nombre:" + nombre);
    		System.out.println("Departamento:" + presupuesto);
    
    		this.presupuesto.mostrarDatos();
    		
    		
    		
    	}
    	public void setPresupuesto(Departamento presupuesto) {
    		this.presupuesto = presupuesto;
    		
    	}
    	
  //    public void mostrarPresupuestoDeEmpleado() {
    //  	System.out.println("Presupuesto de Empleado:" + this.presupuesto.getPresupuestoNombreDepto());
      	
      }

//}
