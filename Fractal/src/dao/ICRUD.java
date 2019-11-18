package dao;

import java.util.List;
import javax.swing.table.DefaultTableModel;

public interface ICRUD<Generic> {

    void registrar(Generic object) throws Exception;

    void modificar(Generic object) throws Exception;

    void eliminar(int codigo) throws Exception;

//    List<Generic> listarTodos(DefaultTableModel modelo, Integer tipo, String dato) throws Exception;
}
