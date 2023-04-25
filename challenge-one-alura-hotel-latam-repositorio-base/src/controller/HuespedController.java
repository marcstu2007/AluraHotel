package controller;

import java.util.List;

import dao.HuespedDAO;
import factory.ConnectionFactory;
import model.Huesped;

public class HuespedController {
	private HuespedDAO huespedDAO;
	
	public HuespedController() {
		var factory = new ConnectionFactory();
		this.huespedDAO = new HuespedDAO(factory.RecuperarConexion());
	}
	
	public String Guardar(Huesped huesped) {
		return huespedDAO.Guardar(huesped);
	}

	public List<Huesped> buscarApellido(String Apellido) {
		return this.huespedDAO.buscarApellido(Apellido);
	}
	public void apellido() {
		System.out.println("Casi...");
	}
	
	public String Editar(Huesped huesped) {
		return huespedDAO.Editar(huesped);
	}

	public int Eliminar(Integer id) {
		return huespedDAO.Eliminar(id);
	}
}
