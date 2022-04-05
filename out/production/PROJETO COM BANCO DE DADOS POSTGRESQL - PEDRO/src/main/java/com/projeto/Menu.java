package main.java.com.projeto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    public static void main(String[] args) throws Exception {

        PessoaDao pessoaDao = new PessoaDao();

        Pessoa pessoa1 =  new Pessoa(1, "Pedro Henauth", "pedro_henauth_@hotmail.com");
        Pessoa pessoa2 =  new Pessoa(2, "Romário Ronaldo", "romario_ronaldo_@hotmail.com");
        Pessoa pessoa3 =  new Pessoa(3, "Diego Souza", "diegosouza87@gmail.com");

        // INCLUINDO UMA PESSOA: INCLUIR UMA NOVA PESSOA FORA DO TRY and CATCH

        try {
            pessoaDao.incluirPessoa(pessoa1);
            pessoaDao.incluirPessoa(pessoa2);
            pessoaDao.incluirPessoa(pessoa3);
        }catch (Exception e){
            System.out.println("Pessoa já existente.");
        }

        // ALTERANDO UMA PESSOA:

            Pessoa alterarpessoa1 = pessoaDao.consultaPessoaIndividual(1);
            if(alterarpessoa1 != null){
                alterarpessoa1.setEmail("rodrigão@gmail.com");
                pessoaDao.alterarPessoa(alterarpessoa1);
            }

        // LISTANDO UMA PESSOA:

        List<Pessoa> listaPessoas = new ArrayList<>();
            for(Pessoa p : listaPessoas){
                System.out.println(p);
            }

        // EXCLUINDO UMA PESSOA:

        Pessoa pes = pessoaDao.consultaPessoaIndividual(1);
            pessoaDao.excluirPessoa(pes);
            List<Pessoa> list = pessoaDao.listarPessoas();

            for(Pessoa pe : list){
                System.out.println(pe);
            }



    }
}
