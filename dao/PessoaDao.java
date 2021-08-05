package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import model.Pessoa;

public class PessoaDao {

    Connection con = ConnectionFactory.getConnection();
    PreparedStatement ps = null;

    public void create(Pessoa pessoa) {
        try {
            ps = con.prepareStatement("INSERT INTO Pessoa(PES_NOME) VALUES(?)");
        
            ps.setString(1, pessoa.getNome());
            ps.executeUpdate(); 

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void setId(Pessoa pessoa) {
        try {
            Statement stmt = con.createStatement();
            String SQL = "SELECT PES_ID, PES_NOME FROM Pessoa "
                        + "WHERE PES_NOME = " + "'" + pessoa.getNome() + "'";
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
            pessoa.setId(rs.getInt("PES_ID"));

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pessoa> getAll() {
        try {
            Statement stmt = con.createStatement();
            String SQL = "SELECT PES.PES_ID, PES_NOME " 
                        + "FROM Pessoa AS PES ";

            ResultSet rs = stmt.executeQuery(SQL);
            List<Pessoa> pessoas = new ArrayList<>();

            while(rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("PES_ID"));
                pessoa.setNome(rs.getString("PES_NOME"));
                
                pessoas.add(pessoa);
            }
            return pessoas;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
