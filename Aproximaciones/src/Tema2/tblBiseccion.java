package tema2;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class tblBiseccion extends AbstractTableModel {

    private String[] columnas = {"i", "xi", "xs", "xr", "fxi", "fxr", "producto", "Error"};
    private ArrayList<CsBiseccion> lista = null;

    public tblBiseccion(ArrayList<CsBiseccion> resultados) {
        this.lista = resultados;
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnas.length;
    }

    @Override
    public Object getValueAt(int i, int columna) {
        CsBiseccion fila = this.lista.get(i);
        switch (columna) {
            case 0:
                return fila.getInteracion();
            case 1:
                return fila.getXi();
            case 2:
                return fila.getXs();
            case 3:
                return fila.getXr();
            case 4:
                return fila.getFxi();
            case 5:
                return fila.getFxr();
            case 6:
                return fila.getProducto();
            case 7:
                return fila.getError();

        }
        return null;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return true;
    }

    @Override
    public String getColumnName(int i) {
        return this.columnas[i];
    }

}
