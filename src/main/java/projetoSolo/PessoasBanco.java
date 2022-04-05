package main.java.projetoSolo;

import java.sql.*;

public class PessoasBanco {

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    CallableStatement callableStatement;

    public void open() throws Exception{
        String url = "jdbc:postgresql://localhost:5432/lista";
        String user = "postgres";
        String password = "pedro2000";

        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        }catch(SQLException | ClassNotFoundException exception){
            System.out.println("Erro ao conectar no banco de dados.");
        }
    }

    public void close() throws Exception{
        connection.close();
    }
}
