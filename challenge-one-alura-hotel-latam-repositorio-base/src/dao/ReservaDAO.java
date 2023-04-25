package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Reserva;

public class ReservaDAO {
private Connection con;

public ReservaDAO(Connection con) {
	this.con=con;
}
public String Guardar(Reserva reserva) {
	String idReserva="";
	try {
		PreparedStatement statement;
		statement = con.prepareStatement(
				"INSERT INTO RESERVA(FechaEntrada, FechaSalida, Valor, FormaPago) "
				+ "VALUES(?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
		
		try(statement){			
			statement.setDate(1, new java.sql.Date(reserva.getFechaEntrada().getTime()));
			statement.setDate(2, new java.sql.Date( reserva.getFechaSalida().getTime()));
			statement.setDouble(3, reserva.getValor());
			statement.setInt(4, reserva.getFormaPago());
			statement.execute();
			
			final ResultSet resulSet = statement.getGeneratedKeys();
			
			try(resulSet){
				while (resulSet.next()) {
					reserva.setId(resulSet.getInt(1));
					idReserva= String.valueOf(reserva.getId()) ;
					System.out.println(String.format("Fue insertado la reserva: %s", reserva.getId()));
				}
			}
		}
		return idReserva;
		
	}catch (SQLException e){
		return e.toString();
		//throw new RuntimeException(e);
	}
}

public List<Reserva> listar(){
	List<Reserva> resultado = new ArrayList<>();
	try {
		final PreparedStatement statement = con.prepareStatement("SELECT Id, FechaEntrada, FechaSalida, Valor, FormaPago FROM Reserva;");
		try(statement){
			statement.execute();
			final ResultSet resultSet = statement.getResultSet();
			
			try(resultSet){
				while(resultSet.next()) {
					resultado.add(new Reserva(resultSet.getInt("Id"),
							resultSet.getDate("FechaEntrada"),
							resultSet.getDate("FechaSalida"),
							resultSet.getDouble("Valor"),
							resultSet.getInt("FormaPago")
							));
				}
			}
		} 
	}catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return resultado;
}
public List<Reserva> buscarReserva(int idReserva) {
	List<Reserva> resultado = new ArrayList<>();
	try {
		String sql ="SELECT Id, FechaEntrada, FechaSalida, Valor, FormaPago FROM Reserva WHERE Id=?;";
		final PreparedStatement statement = con.prepareStatement(sql);
		
		try(statement){
			statement.setInt(1, idReserva);
			statement.execute();
			
			final ResultSet resulSet = statement.getResultSet();
			try(resulSet){
				while(resulSet.next()) {
					resultado.add(new Reserva(
							resulSet.getInt("Id"),
							resulSet.getDate("FechaEntrada"),
							resulSet.getDate("FechaSalida"),
							resulSet.getDouble("Valor"),
							resulSet.getInt("FormaPago")
							));
				}
			}
		}
		
	}catch(SQLException e) 
	{
		throw new RuntimeException(e);
	}
	return resultado;
}
public String Editar(Reserva reserva) {
try {
	final PreparedStatement statement = con.prepareStatement(
			"UPDATE Reserva SET FechaEntrada=?, FechaSalida=?, Valor=?, FormaPago=? WHERE Id=?;");
	
	try(statement){
		statement.setDate(1, new java.sql.Date(reserva.getFechaEntrada().getTime()));
		statement.setDate(2, new java.sql.Date(reserva.getFechaSalida().getTime()));
		statement.setDouble(3, reserva.getValor());
		statement.setInt(4, reserva.getFormaPago());
		statement.setInt(5, reserva.getId());
		statement.execute();
		System.out.println(statement);
		int UpdateCount = statement.getUpdateCount();
		System.out.println(">>> "+UpdateCount);
		return UpdateCount+"";
	}
}catch(SQLException e) {
	System.out.println(e.toString());
	return e.toString();
}
}
public Integer Eliminar(Integer id) {
	try {
		final PreparedStatement statement = con.prepareStatement("DELETE FROM Reserva WHERE Id=?;");
		
		try(statement){
			statement.setInt(1, id);
			System.out.println(statement);
			statement.execute();
			
			int updateCount = statement.getUpdateCount();
			return updateCount;
		}
	}catch(SQLException e) {
		throw new RuntimeException(e);
		
	}
}
}