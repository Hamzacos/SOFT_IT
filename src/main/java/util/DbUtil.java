package util;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.cj.jdbc.Driver;

public class DbUtil {
	
	 private static ComboPooledDataSource cpds = null;

	    static {
	        cpds = new ComboPooledDataSource("mysql");
	    }

	    public static Connection getConnection() {
	        Connection connection = null;
	        try {
	            connection = cpds.getConnection();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return connection;
	    }
}
