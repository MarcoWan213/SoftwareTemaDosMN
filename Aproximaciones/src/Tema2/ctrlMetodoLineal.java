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

    public static void main(String[] args) {
        ctrlMetodoLineal prueba = new ctrlMetodoLineal();

        double[][] x = new double[4][5];

        x[0][0] = 10;
        x[0][1] = -1;
        x[0][2] = 2;
        x[0][3] = 0;
        x[0][4] = 6;

        x[1][0] = -1;
        x[1][1] = +11;
        x[1][2] = -1;
        x[1][3] = 3;
        x[1][4] = 25;

        x[2][0] = 2;
        x[2][1] = -1;
        x[2][2] = 10;
        x[2][3] = -1;
        x[2][4] = -11;

        x[3][0] = 0;
        x[3][1] = -3;
        x[3][2] = -1;
        x[3][3] = 8;
        x[3][4] = 15;

        prueba.Jacobi(x);

    }

}
