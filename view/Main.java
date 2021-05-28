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
        List<Telefone> telefones = new ArrayList<>();

        System.out.println("Digite o nome: ");
        pessoa.setNome(sc.next());
        do {
            System.out.println("Número de telefone ou celular: ");
            telefones.add(new Telefone(sc.nextInt()) );

            System.out.println("Deseja cadastrar mais um número ? (s/n)");
        }while((sc.next().toLowerCase() == "s")  ? true :  false);

        pessoa.setTelefones(telefones);
        pessoaDao.create(pessoa);

        Contato contato = new Contato(pessoa);
        Main.insertContato(contato);
    }

    public static void insertContato(Contato contato) {
        ContatoDao contatoDao = new ContatoDao();
        contatoDao.create(contato);
        Main.insertAgenda(contato);
    }

    public static void insertAgenda(Contato contato) {
        AgendaDao agendaDao = new AgendaDao();
        Agenda agenda = new Agenda();
        agenda.getContatos().add(contato);
        agendaDao.create(agenda);
    }
}