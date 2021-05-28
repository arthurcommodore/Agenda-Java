package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;

import model.Pessoa;
import model.Contato;

public class ContatoDao {

    Connection con = ConnectionFactory.getConnection();
    PreparedStatement ps = null;

    public void create(Contato contato) {

        try {
            Date data = new Date(System.currentTimeMillis());
            ps = con.prepareStatement("INSERT INTO Contato(PES_ID, CON_DATA) VALUES(?, ?)");
            ps.setInt(1, contato.getPessoa().getId());
            ps.setDate(2, data);
            ps.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
