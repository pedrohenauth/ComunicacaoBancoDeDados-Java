package main.java.com.projeto;

import java.net.ConnectException;
import java.sql.*;

//CLASSE REFERENTE A CONEXÃO COM O BANCO DE DADOS:
public class Dao {

    Connection connection; // Conexão com o banco de dados;
    PreparedStatement preparedStatement; // Acesso a tabela (INSERT, UPDATE...);
    ResultSet resultSet; // Consulta a tabela (Select - registro);
    CallableStatement callableStatement; // Call dos procedure e functions.

    public void open() throws Exception{
        String url = "jdbc:postgresql://localhost:5432/cadastros";
        String user = "postgres";
        String password = "pedro2000";

        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch(SQLException | ClassNotFoundException exception) {
            System.out.println("Erro ao conectar com o banco de dados.");
        }
    }

    public void close() throws Exception{
        connection.close();
    }

}
