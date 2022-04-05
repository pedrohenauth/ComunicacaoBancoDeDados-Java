package main.java.projetoSolo;

import main.java.projetoSolo.Principal;

import java.util.List;

public class Principal {
    public static void main(String[] args) throws Exception{

        PessoasMetodos pessoasMetodos = new PessoasMetodos();

        // INCLUIR UMA PESSOA:
        Pessoas person1 = new Pessoas(1, "Janderson", 14);
        Pessoas person2 = new Pessoas(2, "Romarinho Silva", 25);
        Pessoas person3 = new Pessoas(3, "Clovis Amaral", 26);

        try {         pessoasMetodos.incluirPessoas(person1);
            pessoasMetodos.incluirPessoas(person2);
            pessoasMetodos.incluirPessoas(person3);

        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        // ALTERAR UMA PESSOA
        Pessoas pes = pessoasMetodos.consultarPessoas(1);

        if(pes !=  null){
            pes.setIdade(3);
            //Chamando o método que tem o UPDATE
            pessoasMetodos.alterarPessoas(pes);

            //Listando todas as pessoas:
            List<Pessoas> listaPessoas = pessoasMetodos.ListarPessoas();
            for(Pessoas p : listaPessoas){
                System.out.println(p);
            }
        }

        // EXCLUINDO UMA PESSOA
        Pessoas pes2 = pessoasMetodos.consultarPessoas(2);
        pessoasMetodos.excluirPessoas(pes2);
        List<Pessoas> listaPessoas = pessoasMetodos.ListarPessoas();

        for(Pessoas p : listaPessoas){
            System.out.println(p);
        }



    }
}
