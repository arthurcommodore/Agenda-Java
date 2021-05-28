package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;

import model.Agenda;
import model.Contato;

public class AgendaDao {

    public void create(Agenda agenda) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO Agenda(CON_ID) VALUES(?)");
            for(Contato contato : agenda.getContatos()) {
                ps.setInt(1, contato.getId());
            }
            ps.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
