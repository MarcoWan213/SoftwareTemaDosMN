package Tema2;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class tblNewton extends AbstractTableModel {

    private String[] columnas = {"i", "xi", "fx", "f'x", "(x+1)-x", "Error"};
    private ArrayList<CsNewton> lista = null;

    public tblNewton(ArrayList<CsNewton> resultados) {
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
        CsNewton fila = this.lista.get(i);
        switch (columna) {
            case 0:
                return fila.getInteracion();
            case 1:
                return fila.getAprox();
            case 2:
                return fila.getFi();
            case 3:
                return fila.getFix();
            case 4:
                return fila.getTim();
            case 5:
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
