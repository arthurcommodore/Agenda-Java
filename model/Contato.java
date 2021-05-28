package model;

public class Contato {

    private int id;
    private Pessoa pessoa;
    
    public Contato(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Contato() {

    }

    public int getId() {
        return this.id;
    }
    
    public Pessoa getPessoa() {
        return this.pessoa;
    }    
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setId(int id) {
        this.id = id;
    }
}
