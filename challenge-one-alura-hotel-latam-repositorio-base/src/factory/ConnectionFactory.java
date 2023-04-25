package factory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	private DataSource dataSource;
	
	public ConnectionFactory() {
		var comboPooleDataSource = new ComboPooledDataSource();	
		comboPooleDataSource.setJdbcUrl("jdbc:mysql://localhost/HOTEL?useTimeZone=true&serverTimeZone=UTC");
		comboPooleDataSource.setUser("root");
		comboPooleDataSource.setPassword("201122934");
		comboPooleDataSource.setMaxPoolSize(10);
		
		this.dataSource=comboPooleDataSource;
	}
	
	public Connection RecuperarConexion(){
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
