package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {
private Connection con;

public UsuarioDAO(Connection con) {
	this.con = con;
}

public String Select(String user, String password) {
	String resultado="";
	String sql ="SELECT count(*) as Conteo FROM Usuario WHERE User=? AND Password = ?;";
	try {
		final PreparedStatement statement = con.prepareStatement(sql);
		
		try(statement){
			statement.setString(1, user);
			statement.setString(2, password);
			
			final ResultSet resultSet  = statement.executeQuery();
			
			try(resultSet){
				while(resultSet.next()) {
					resultado = resultSet.getInt("Conteo")+"";
				}
			}
		}
	}catch (SQLException e) {
		resultado = e.toString();
	}
	return resultado;
}
}
