package controller;

import java.util.List;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import model.Reserva;

public class ReservadoController {
	private ReservaDAO reservaDAO;
	
	public ReservadoController() {
		var factory = new ConnectionFactory();
		this.reservaDAO = new ReservaDAO(factory.RecuperarConexion());
	}
	
	public String guardar(Reserva reserva) {
		return reservaDAO.Guardar(reserva);
	}

	public List<Reserva> buscarReserva(int idReserva) {
		return reservaDAO.buscarReserva(idReserva);
	}
	
	public String Editar(Reserva reserva) {
		return reservaDAO.Editar(reserva);
	}
	
	public Integer Eliminar(Integer id) {
		return reservaDAO.Eliminar(id);
	}
}
