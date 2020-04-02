package tema2;

public class CsJacobi {

    int maxIteracion;
    double[] resultados = new double[4];

    public double[] getResultados() {
        return resultados;
    }

    public void setResultados(double[] resultados) {
        this.resultados = resultados;
    }

    public int getMaxIteracion() {
        return maxIteracion;
    }

    public void setMaxIteracion(int maxIteracion) {
        this.maxIteracion = maxIteracion;
    }

    @Override
    public String toString() {
        return "CsJacobi{" + "maxIteracion=" + maxIteracion + ", resultados=" + resultados + '}';
    }

}
