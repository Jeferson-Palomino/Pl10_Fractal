package controlador;

import dao.ApoderadoImpl;
import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Apoderado;
import vista.ApoderadoView;

public class ApoderadoC implements Serializable {

    ApoderadoImpl dao;
    Apoderado cli;
    ApoderadoView vista;

    public ApoderadoC() {
        cli = new Apoderado();
    }

    public void registrar() {
        dao = new ApoderadoImpl();
        try {
            getDatos();
            dao.registrar(cli);
        } catch (Exception e) {
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() {
        dao = new ApoderadoImpl();
        try {
            getDatos();
            System.out.println("idCliente " + ApoderadoView.idCliente);
            dao.modificar(cli);
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar() {
        dao = new ApoderadoImpl();
        try {
            dao.eliminar(cli.getId());
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }

    public void listar(DefaultTableModel modelo, Integer tipo, String dato) {
        try {
            dao = new ApoderadoImpl();
            dao.listar(modelo, tipo, dato);
        } catch (Exception e) {
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void getDatos() {
        try {
            cli.setIdapo(ApoderadoView.txtId.getText());
            cli.setApeapo(ApoderadoView.txtApe.getText());
            cli.setNomapo(ApoderadoView.txtNom.getText());
            cli.setDniapo(ApoderadoView.txtDNI.getText());
            cli.setCelapo(ApoderadoView.txtCelular.getText());
            cli.setEmaapo(ApoderadoView.txtEmail.getText());
            cli.setUbiapo(ApoderadoView.txtUbicacion.getText());
            generos();
        } catch (Exception e) {
            System.out.println("Error en getDatos " + e.getMessage());
        }
    }

    public void generos() {
        if (ApoderadoView.optMasculino.isSelected() == true) {
            cli.setSexapo("M");
            System.out.println(cli.getSexapo());
        } else if (ApoderadoView.optFemenino.isSelected() == true) {
            cli.setSexapo("F");
            System.out.println(cli.getSexapo());
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un genero");
        }
    }

}
