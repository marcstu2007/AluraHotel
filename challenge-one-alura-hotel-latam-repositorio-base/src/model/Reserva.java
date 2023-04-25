package model;

import java.util.Date;
public class Reserva {
	private int Id;
	private Date FechaEntrada;
	private Date FechaSalida;
	private double Valor ;
	private int FormaPago;
	
	
	public Reserva(Integer Id, Date FechaEntrada, Date FechaSalida, double Valor, Integer FormaPago) {
		this.Id=Id;
		this.FechaEntrada=FechaEntrada;
		this.FechaSalida=FechaSalida;
		this.Valor=Valor;
		this.FormaPago=FormaPago;
	}
	
	public Reserva(Date FechaEntrada, Date FechaSalida, double Valor, Integer FormaPago) {
		this.FechaEntrada=FechaEntrada;
		this.FechaSalida=FechaSalida;
		this.Valor=Valor;
		this.FormaPago=FormaPago;
		System.out.println("*******************");
		System.out.println(FechaEntrada);
		System.out.println(FechaSalida);
		System.out.println(Valor);
		System.out.println(FormaPago);
		System.out.println("*******************");
	}
	
	public Integer getId() {
		return this.Id;
	}

	public Date getFechaEntrada() {
		return this.FechaEntrada;
	}

	public Date getFechaSalida() {
		return this.FechaSalida;
	}

	public Double getValor() {
		return this.Valor;
	}

	public int getFormaPago() {
		return this.FormaPago;
	}

	public void setId(int id) {
		this.Id=id;
	}
	
}
