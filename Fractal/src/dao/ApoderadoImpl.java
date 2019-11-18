package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Apoderado;

public class ApoderadoImpl extends Conexion implements ICRUD<Apoderado> {

    // idcli	nomcli	apecli	sexcli	dnicli	naccli
    @Override
    public void registrar(Apoderado apoderado) throws Exception {
        String sql = "insert into apoderado (idapo,nomapo,apeapo,dniapo,celapo,emaapo,ubiapo,sexapo) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, apoderado.getIdapo());
            ps.setString(2, apoderado.getNomapo());
            ps.setString(3, apoderado.getApeapo());
            ps.setString(4, apoderado.getDniapo());
            ps.setString(5, apoderado.getCelapo());
            ps.setString(6, apoderado.getEmaapo());
            ps.setString(7, apoderado.getUbiapo());
            ps.setString(8, apoderado.getSexapo());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en registrarD " + e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void modificar(Apoderado apoderado) throws Exception {

        String sql = "update apoderado set nomcli= ?,apecli=?,dnicli=?,sexcli=?,naccli=? where idcli =?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, apoderado.getNomapo());
            ps.setString(2, apoderado.getApeapo());
            ps.setString(3, apoderado.getDniapo());
            ps.setString(4, apoderado.getSexapo());
            ps.setString(5, apoderado.getCelapo());
            ps.setString(6, apoderado.getEmaapo());
            ps.setString(7, apoderado.getUbiapo());
            ps.setInt(8, apoderado.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en registrarD " + e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void eliminar(int codigo) throws Exception {
        String sql = "delete from apoderado where idapo =?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en registrarD " + e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    public void listar(DefaultTableModel modelo, Integer tipo, String dato) throws Exception {
        String sql = "";
        switch (tipo) {
            case 1:
                sql = "select * from apoderado";
                break;
            case 2:
                sql = "select * from apoderado where nomcli like '%" + dato + "%'";
                break;
            case 3:
                sql = "select * from apoderado where apecli like '%" + dato + "%'";
                break;
            case 4:
                sql = "select * from apoderado where sexcli like '%" + dato + "%'";
                break;
            case 5:
                sql = "select * from apoderado where dnicli like '%" + dato + "%'";
                break;
        }
        String datos[] = new String[6];
        Statement st = this.conectar().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            for (int i = 0; i < 6; i++) {
                datos[i] = rs.getString(i + 1);
            }
            modelo.addRow(datos);
        }
        rs.close();
        st.close();
    }

}
