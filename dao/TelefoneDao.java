package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Pessoa;
import model.Telefone;

public class TelefoneDao {

    Connection con = ConnectionFactory.getConnection();
    PreparedStatement ps = null;

    public void create(Telefone telefone, Pessoa pessoa) {
        try {
            ps = con.prepareStatement("INSERT INTO Telefone(TEL_NUMERO, PES_ID) VALUES(?,?)");

            ps.setInt(1, telefone.getNumero());
            ps.setInt(2, pessoa.getId());

            ps.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
