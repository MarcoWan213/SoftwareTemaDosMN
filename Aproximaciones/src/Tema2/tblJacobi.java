package tema2;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class tblJacobi extends AbstractTableModel {

    private String[] columnas = {"x1", "x2", "x3", "x4"};
    private ArrayList<CsJacobi> lista = null;

    public tblJacobi(ArrayList<CsJacobi> resultados) {
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
    public Object getValueAt(int i, int i1) {
        CsJacobi fila = this.lista.get(i);
        switch (i1) {
            case 0:
                return fila.getResultados()[0];
            case 1:
                return fila.getResultados()[1];
            case 2:
                return fila.getResultados()[2];
            case 3:
                return fila.getResultados()[3];
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
