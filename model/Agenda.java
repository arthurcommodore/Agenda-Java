package model;

import java.util.List;
import java.util.ArrayList;

public class Agenda {
    List<Contato> contatos = new ArrayList<>();

    public List<Contato> getContatos() {
        return this.contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }



}
