
package tema2;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class tblGauss extends AbstractTableModel {

   private String[] fila = {"Itera","x1","x2","x3"};
    
    private ArrayList<CsGaussSeidel> lista =null;

    tblGauss(ArrayList<CsGaussSeidel> lista) {
        this.lista = lista;
    }

    

    

    @Override
    public int getRowCount() {
        return this.fila.length;
    }

    @Override
    public int getColumnCount() {
        return this.lista.size();
    }

    @Override
    public Object getValueAt(int fila, int i) {
        CsGaussSeidel filar = this.lista.get(i);
        
        switch(fila){
            case 0:
                return filar.getIteraciones();
            case 1:
                return filar.getX1(); 
            case 2: 
                return filar.getX2();
            case 3:
                return filar.getX3();
                
        }
        return null;
    }
    @Override
    public boolean isCellEditable(int i, int i1) {
        return true;
    }
    
}
