package model;

public class Telefone {
    private int id;
    private int numero;    
    
    public Telefone(int numero) {
        this.numero = numero;
    }

    public Telefone() {

    }

    public int getId() {
        return this.id;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setId(int id) {
        this.id = id;
    }
}
