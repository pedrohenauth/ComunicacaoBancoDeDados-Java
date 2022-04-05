package main.java.com.projeto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDao extends Dao {

    public void incluirPessoa(Pessoa pessoa) throws Exception {
        open();
        preparedStatement = connection.prepareStatement("insert into pessoa values (?,?,?)");
        preparedStatement.setInt(1, pessoa.getIdpessoa());
        preparedStatement.setString(2, pessoa.getNomepessoa());
        preparedStatement.setString(3, pessoa.getEmail());
        preparedStatement.execute();
        preparedStatement.close();
        close();
    }

    public void alterarPessoa(Pessoa pessoa) throws Exception {
        open();
        preparedStatement = connection.prepareStatement("update pessoa nome = ?, email = ? where idpessoa = ?");
        preparedStatement.setString(1, pessoa.getNomepessoa());
        preparedStatement.setString(2, pessoa.getEmail());
        preparedStatement.setInt(3, pessoa.getIdpessoa());
        preparedStatement.execute();
        preparedStatement.close();
        close();
    }

    public void excluirPessoa(Pessoa pessoa) throws Exception {
        open();
        preparedStatement = connection.prepareStatement("delete from pessoa where idpessoa = ?");
        preparedStatement.setInt(1, pessoa.getIdpessoa());
        preparedStatement.execute();
        preparedStatement.close();
        close();
    }

    public Pessoa consultaPessoaIndividual(int cod) throws Exception {
        open();
        preparedStatement = connection.prepareStatement("select * from pessoa where idpessoa = ?");
        preparedStatement.setInt(1, cod);
        resultSet = preparedStatement.executeQuery();
        Pessoa p = null;

        if (resultSet.next()) {
            p = new Pessoa(1, "s", "s");
            p.setIdpessoa(resultSet.getInt("idPessoa"));
            p.setNomepessoa(resultSet.getString("nomePessoa"));
            p.setEmail(resultSet.getString("email"));
        } else {
            System.out.println("Registro não encontrado.");
        }
        close();
        return p;
    }

    public List<Pessoa> listarPessoas() {
        try {
            open();
            preparedStatement = connection.prepareStatement("select * from pessoas");
            resultSet = preparedStatement.executeQuery();
            List<Pessoa> listaPessoas = new ArrayList<>();

            while(resultSet.next()){
                Pessoa p = new Pessoa(1,"d", "s");
                p.setIdpessoa(resultSet.getInt("idPessoa"));
                p.setNomepessoa(resultSet.getString("nomePessoa"));
                p.setEmail(resultSet.getString("email"));
                listaPessoas.add(p);
            }
        close();

        }catch(Exception e){

        }

        return listarPessoas();
    }
}
