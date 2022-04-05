package main.java.com.projeto;
// CLASSE CONTENDO ATRIBUTOS, ENCAPSULAMENTO, E ETC...
public class Pessoa {

     private int idpessoa;
     private String nomepessoa;
     private String email;

    public Pessoa(String nomepessoa, String email) {
        super(); // É NECESSÁRIO PARA UTILIZAR NO BANDO DE DADOS
        this.nomepessoa = nomepessoa;
        this.email = email;
    }

    public Pessoa(int idpessoa, String nomepessoa, String email){
        super(); // É NECESSÁRIO PARA UTILIZAR NO BANDO DE DADOS
        this.idpessoa = idpessoa;
        this.nomepessoa = nomepessoa;
        this.email = email;
    }


    public int getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }

    public String getNomepessoa() {
        return nomepessoa;
    }

    public void setNomepessoa(String nomepessoa) {
        this.nomepessoa = nomepessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

