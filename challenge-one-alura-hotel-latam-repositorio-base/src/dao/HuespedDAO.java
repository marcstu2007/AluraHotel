package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Huesped;

public class HuespedDAO {
private Connection con;

public HuespedDAO(Connection con) {
	this.con=con;
}

public String Guardar(Huesped huesped) {
	
	String idReserva="";
	try {
		PreparedStatement statement;
		statement = con.prepareStatement("INSERT INTO HUESPED(Nombre, Apellido, FechaNacimiento, Nacionalidad, Telefono, IdReserva) "
				+ "VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
		
		try(statement){
			statement.setString(1, huesped.getNombre());
			statement.setString(2, huesped.getApellido());
			statement.setDate(3, new java.sql.Date(huesped.getFechaNacimiento().getTime()));
			statement.setInt(4, huesped.getNacionalidad());
			statement.setInt(5, huesped.getTelefono());
			statement.setInt(6, huesped.getIdReserva());
			statement.execute();
			
			System.out.println("==>"+huesped.getId());
			
			final ResultSet resulSet = statement.getGeneratedKeys();
			
			try(resulSet){
				while(resulSet.next()) {
					huesped.setId(resulSet.getInt(1));
					idReserva = String.valueOf(huesped.getId());
					System.out.println(String.format("Fue insertado el huesped: %s", huesped.getId()));
				}
			}
		}
		return idReserva;
		
	} catch (SQLException e) {
		return e.toString();
		// TODO Auto-generated catch block
		//e.printStackTrace();
		//return e.toString();
	}
}

public List<Huesped> buscarApellido(String apellido) {
	List<Huesped> resultado = new ArrayList<>();
	  try {
          String sql = "SELECT Id, Nombre, Apellido, FechaNacimiento, Nacionalidad, Telefono, IdReserva FROM Huesped WHERE Apellido LIKE ?";
          
          System.out.println(sql);
          
          final PreparedStatement statement = con
                  .prepareStatement(sql);

          try (statement) {
        	  statement.setString(1, apellido+"%");
        	  statement.execute();
        	  
              final ResultSet resultSet = statement.getResultSet();

              try (resultSet) {
                  while (resultSet.next()) {
                      resultado.add(new Huesped(
                              resultSet.getInt("Id"),
                              resultSet.getString("Nombre"),
                              resultSet.getString("Apellido"),
                              resultSet.getDate("FechaNacimiento"),
                              resultSet.getInt("Nacionalidad"),
                              resultSet.getInt("Telefono"),
                              resultSet.getInt("IdReserva")
                              ));
                  }
              }
          }
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }

      return resultado;

}

public String Editar(Huesped huesped) {
	try {
		final PreparedStatement statement = con.prepareStatement(
				"UPDATE Huesped SET  Nombre=?, Apellido=?, FechaNacimiento=?, Nacionalidad=?, Telefono=?, IdReserva=? WHERE Id=?;");
		try(statement){
			statement.setString(1, huesped.getNombre());
			statement.setString(2, huesped.getApellido());
			statement.setDate(3, new java.sql.Date(huesped.getFechaNacimiento().getTime()));
			statement.setInt(4, huesped.getNacionalidad());
			statement.setInt(5, huesped.getTelefono());
			statement.setInt(6, huesped.getIdReserva());
			statement.setInt(7, huesped.getId());
			statement.execute();
			System.out.println(statement);
			int UpdateCount = statement.getUpdateCount();
			return UpdateCount +"";
		}
	}catch(SQLException e) {
		return e.toString();
	}
}

public int Eliminar(Integer id) {
	
	try {
		final PreparedStatement statement = con.prepareStatement("DELETE FROM Huesped WHERE Id=?;");
		
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
