package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import model.Pessoa;
import model.Telefone;

public class PessoaDao {

    Connection con = ConnectionFactory.getConnection();
    PreparedStatement ps = null;

    public void create(Pessoa pessoa) {
        try {
            ps = con.prepareStatement("INSERT INTO Pessoa(PES_NOME) VALUES(?)");
        
            ps.setString(1, pessoa.getNome());
            ps.executeUpdate(); 

            pessoa.setId(getId(pessoa.getNome()));
            ps = con.prepareStatement("INSERT INTO Telefone(TEL_NUMERO, PES_ID) VALUES(?, ?)");
            for(Telefone telefone : pessoa.getTelefones()) {
                ps.setInt(1, telefone.getNumero());
                ps.setInt(2, pessoa.getId());
            }
            ps.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getId(String nome) {
        try {
            Statement stmt = con.createStatement();
            String SQL = "SELECT PES.PES_ID, PES.PES_NOME "
                            + "FROM Pessoa AS PES "
                            + "WHERE PES.PES_NOME = " + "'" + nome + "'"; 

            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()) {
                return rs.getInt("PES_ID");
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
