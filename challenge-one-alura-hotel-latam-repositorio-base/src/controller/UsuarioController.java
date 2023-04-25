package controller;

import dao.UsuarioDAO;
import factory.ConnectionFactory;

public class UsuarioController {
	private UsuarioDAO usuarioDAO;
	
	public UsuarioController() {
		var factory = new ConnectionFactory();
		this.usuarioDAO = new UsuarioDAO(factory.RecuperarConexion());
	}
	public String seleccionar(String User, String Password) {
		return usuarioDAO.Select(User, Password);
	}
}
