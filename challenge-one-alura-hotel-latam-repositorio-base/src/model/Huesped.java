package model;
import java.util.Date;
public class Huesped {
	private int Id;
	private String Nombre;
	private String Apellido;
	private Date FechaNacimiento;
	private int Nacionalidad;
	private int Telefono;
	private int IdReserva;
	
	public Huesped(Integer Id, String Nombre, String Apellido, Date FechaNacimiento, Integer Nacionalidad, Integer Telefono, Integer IdReserva) {
		this.Id=Id;
		this.Nombre=Nombre;
		this.Apellido=Apellido;
		this.FechaNacimiento=FechaNacimiento;
		this.Nacionalidad=Nacionalidad;
		this.Telefono=Telefono;
		this.IdReserva=IdReserva;
	}
	
	public Huesped(String Nombre, String Apellido, Date FechaNacimiento, Integer Nacionalidad, Integer Telefono, Integer IdReserva) {
		this.Nombre=Nombre;
		this.Apellido=Apellido;
		this.FechaNacimiento=FechaNacimiento;
		this.Nacionalidad=Nacionalidad;
		this.Telefono=Telefono;
		this.IdReserva=IdReserva;
		
		System.out.println("*******************");
		System.out.println(Nombre);
		System.out.println(Apellido);
		System.out.println(FechaNacimiento);
		System.out.println(Nacionalidad);
		System.out.println(Telefono);
		System.out.println(IdReserva);
		System.out.println("*******************");
	}
	
	public Integer getId() {
		return this.Id;
	}
	
	public String getNombre() {
		return this.Nombre;
	}
	
	public String getApellido() {
		return this.Apellido;
	} 
	
	public Date getFechaNacimiento() {
		return this.FechaNacimiento;
	}
	
	public Integer getNacionalidad() {
		return this.Nacionalidad;
	}
	
	public Integer getTelefono() {
		return this.Telefono;
	}
	
	public Integer getIdReserva() {
		return this.IdReserva;
	}
	
	public void setId(Integer Id) {
		this.Id=Id;
	}
	public void setNombre(String Nombre) {
		this.Nombre=Nombre;
	}
	public void setApellido(String Apellido) {
		this.Apellido=Apellido;
	}
	public void setFechaNacimiento(Date FechaNacimiento) {
		this.FechaNacimiento=FechaNacimiento;
	}
	public void setNacionalidad(int Nacionalidad) {
		this.Nacionalidad=Nacionalidad;
	}
	public void setTelefono(int Telefono) {
		this.Telefono=Telefono;
	}
	public void setIdReserva(int IdReserva) {
		this.IdReserva = IdReserva;
	}
}
