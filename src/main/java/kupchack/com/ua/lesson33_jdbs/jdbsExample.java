package kupchack.com.ua.lesson33_jdbs;

import java.sql.*;

public class jdbsExample {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATA_BASE = "jdbs:mysql://localhost/online_shop";
    static final String LOGIN = "IgorKupchack";
    static final String PASSWORD = "igorko777";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
		PreparedStatement prstm = null;
		CallableStatement clstm = null;
		
		
		/*
		Statement - 
			execute(query) - true/false - CREATE TABLE 
			executeQuery(query) - ResultSet - SELECT 
			executeUpdate(query) - amount of records -  INSERT/UPDATE/DELETE
			
			
			
			Result Set 
			a b c 
			------
			1 2 3
			4 5 6
			
		
		*/

        try {
			//#1 - Creating connection
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to dataBase... ");
            connection = DriverManager.getConnection(DATA_BASE, LOGIN, PASSWORD);
			//#2 - Getting statement 
            System.out.println("Creating statement... ");
            statement = connection.createStatement();
			//#3 - Run query
            String sql_query = "SELECT exercis_id, ex_name, description, created FROM exercises";
            ResultSet resultSet = statement.executeQuery(sql_query);

            System.out.println("ID\tNAME\tDESCRIPTION\tCREATED");

			//#4 - Parse result set
            while (resultSet.next()){
                int id = resultSet.getInt("exercis_id");
                String name = resultSet.getString("ex_name");
                String desc = resultSet.getString("description");
                String created = resultSet.getString("created");

                System.out.println(id + "\t" + name + "\t" + desc + "\t" + created);
            }

			//#5 - Closing 
            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Error: unable to load driver class");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
			try{
				if(statement!=null){
				statement.close();
			}
			if(connection!=null){
				connection.close();
			}
			}catch(SQLException obj){
				//LOG will be here
			}
			
			
			
        }
    }
}
