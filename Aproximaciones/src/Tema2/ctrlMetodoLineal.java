package tema2;

import java.util.ArrayList;
import java.util.Arrays;

public class ctrlMetodoLineal {

    public static final int MAX_ITERATIONS = 100;//maximo iteraciones
    private double[][] M;//matris    

    public tblJacobi Jacobi(double[][] ecua) {

        M = ecua;
        ArrayList<CsJacobi> lista = null;
        tblJacobi tabla;

        int iteraccion = 0;
        int n = M.length;
        double epsilon = 1e-15;

        double[] X = new double[n];
        double[] P = new double[n];
        Arrays.fill(X, 0);
        Arrays.fill(P, 0);

        lista = new ArrayList<CsJacobi>();
        CsJacobi fila = new CsJacobi();

        while (iteraccion < MAX_ITERATIONS) {

            for (int i = 0; i < n; i++) {
                double sum = M[i][n];
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum -= M[i][j] * P[j];
                    }
                }
                X[i] = 1 / M[i][i] * sum;

            }

            fila.setResultados(X);

            boolean detener = true;
            for (int i = 0; i < n && detener; i++) {
                if (Math.abs(X[i] - P[i]) > epsilon) {

                    detener = false;
                    //return tabla;
                }
            }

            if (detener) {
                //return tabla;
                break;
            }

            P = (double[]) X.clone();
            lista.add(fila);
            iteraccion++;
        }
        tabla = new tblJacobi(lista);
        return tabla;
    }

    public tblGauss Gauss(int [][]A, int [] b, int iteraciones)
    {
    ArrayList<CsGaussSeidel> lista = null;
    tblGauss tabla; 
    int cont = 0;
   
    double x1Anterior = 0, x2Anterior = 0, x3Anterior=0;
    
    
    lista = new ArrayList<CsGaussSeidel> ();                        
            while(cont != iteraciones){
                CsGaussSeidel fila = new CsGaussSeidel();
                fila.setIteraciones(cont + 1);
                fila.setX1(((- A[0][1]*x2Anterior) - (A[0][2] * x3Anterior) + b[0])/A[0][0]);
                fila.setX2(((-A[1][0]*x1Anterior) - (A[1][2]*x3Anterior) + b[1])/A[1][1]);
                fila.setX3(((-A[2][0]*x1Anterior)-(A[2][1] * x2Anterior) + b[2])/A[2][2]);
                
                x1Anterior = fila.getX1();
                x2Anterior = fila.getX2();
                x3Anterior = fila.getX3();
                
                lista.add(fila);
                cont++;
            }          
            tabla = new tblGauss(lista);            
            return tabla;        
    }

}
