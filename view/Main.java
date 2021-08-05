package view;

import java.util.List;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import dao.*;
import model.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) {
        int option;
        do {
            Main.menu();
            option = sc.nextInt();

            switch(option) {
                case 1:
                    Main.insertPessoa();
                    break;
                case 4:
                    PessoaDao pessoaDao = new PessoaDao();
                    List<Pessoa> pessoas = pessoaDao.getAll();
                    for (Pessoa pessoa : pessoas) {
                       System.out.println(pessoa.getNome()); 
                    }
            }

        }while(option != 5);
    }

    public static void menu() {
            System.out.println("Escolha as seguintes opções");
            System.out.println("1- Cadastrar contato na agenda");
            System.out.println("2- Alterar um registro");
            System.out.println("3- Deletar um registro");
            System.out.println("4- Mostrar Contatos");
            System.out.println("5- Sair do systema");
    }

    public static void insertPessoa() {
        PessoaDao pessoaDao = new PessoaDao();      
        Pessoa pessoa = new Pessoa();
        // List<Telefone> telefones = new ArrayList<>();

        System.out.println("Digite o nome: ");
        pessoa.setNome(sc.next());
        
        pessoaDao.create(pessoa);
        insertTelefone(pessoa, pessoaDao);
        insertContato(pessoa);
    }

    public static void insertTelefone(Pessoa pessoa, PessoaDao pessoaDao) {
        TelefoneDao telefoneDao = new TelefoneDao();
        Telefone telefone = new Telefone();

        System.out.println("Digite o número");
        telefone.setNumero(sc.nextInt());
        pessoaDao.setId(pessoa); 

        telefoneDao.create(telefone, pessoa);
    }

    public static void insertContato(Pessoa pessoa) {
        ContatoDao contatoDao = new ContatoDao();
        Contato contato = new Contato();
        contato.setPessoa(pessoa);
        contatoDao.create(contato);
    }

    public static void insertAgenda(Contato contato) {
        AgendaDao agendaDao = new AgendaDao();
        Agenda agenda = new Agenda();
        agenda.getContatos().add(contato);
        agendaDao.create(agenda);
    }
}