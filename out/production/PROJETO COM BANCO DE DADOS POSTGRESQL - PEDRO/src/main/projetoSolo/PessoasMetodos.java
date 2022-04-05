package main.projetoSolo;

import main.java.com.projeto.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoasMetodos extends PessoasBanco{

    public void incluirPessoas(Pessoas pessoas) throws Exception{

        open();
        preparedStatement = connection.prepareStatement("insert into cadastrosPessoas values (?,?,?)");
        preparedStatement.setInt(1, pessoas.getIdPessoa());
        preparedStatement.setString(2, pessoas.getNome());
        preparedStatement.setInt(3, pessoas.getIdade());
        preparedStatement.execute();
        preparedStatement.close();
        close();
    }

    public void alterarPessoas(Pessoas p) throws Exception{

        open();
        preparedStatement = connection.prepareStatement("update cadastrosPessoas nome = ?, idade = ? where idPessoa = ?");
        preparedStatement.setString(1, p.getNome());
        preparedStatement.setInt(2, p.getIdade());
        preparedStatement.setInt(3, p.getIdPessoa());
        preparedStatement.execute();
        preparedStatement.close();
        close();
    }

    public void excluirPessoas (Pessoas p) throws Exception{
        open();
        preparedStatement = connection.prepareStatement("delete from cadastrosPessoas where idPessoa = ?");
        preparedStatement.setInt(1, p.getIdPessoa());
        preparedStatement.execute();
        preparedStatement.close();
        close();
    }

    public Pessoas consultarPessoas(int cod) throws Exception{

        open();
        preparedStatement = connection.prepareStatement("select * from cadastrosPessoas where idPessoa = ?");
        preparedStatement.setInt(1, cod);
        resultSet = preparedStatement.executeQuery();
        Pessoas p =  null;
        if(resultSet.next()){
            p = new Pessoas(p.getIdPessoa(), p.getNome(), p.getIdade());
            p.setIdPessoa(resultSet.getInt("idPessoa"));
            p.setNome(resultSet.getString("nome"));
            p.setIdade(resultSet.getInt("idade"));
        } else {
            System.out.println("Registro não encontrado!");
        }
        close();
        return p;
    }

    public List<Pessoas> ListarPessoas(){

        try{
            open();
            preparedStatement = connection.prepareStatement("select * from cadastrosPessoas order by idPessoa");
            resultSet = preparedStatement.executeQuery();
            List<Pessoas> listaPessoas =  new ArrayList<>();

            while(resultSet.next()){
                Pessoas p = null;
                p = new Pessoas(p.getIdPessoa(), p.getNome(), p.getIdade());
                p.setIdPessoa(resultSet.getInt("idPessoa"));
                p.setNome(resultSet.getString("nome"));
                p.setIdade(resultSet.getInt("idade"));
                listaPessoas.add(p);
            }
            close();
            return listaPessoas;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }





}
