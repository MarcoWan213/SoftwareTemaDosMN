
package tema2;

/**
 *
 * @author Eliel Novelo
 */
public class CsBiseccion {
    int interacion;
    double xi,xs,xr,fxi,fxr,producto,error;

    public int getInteracion() {
        return interacion;
    }

    public double getXi() {
        return xi;
    }

    public double getXs() {
        return xs;
    }

    public double getXr() {
        return xr;
    }

    public double getFxi() {
        return fxi;
    }

    public double getFxr() {
        return fxr;
    }

    public double getProducto() {
        return producto;
    }

    public double getError() {
        return error;
    }

    public void setInteracion(int interacion) {
        this.interacion = interacion;
    }

    public void setXi(double xi) {
        this.xi = xi;
    }

    public void setXs(double xs) {
        this.xs = xs;
    }

    public void setXr(double xr) {
        this.xr = xr;
    }

    public void setFxi(double fxi) {
        this.fxi = fxi;
    }

    public void setFxr(double fxr) {
        this.fxr = fxr;
    }

    public void setProducto(double producto) {
        this.producto = producto;
    }

    public void setError(double error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "CsBiseccion{" + "interacion=" + interacion + ", xi=" + xi + ", xs=" + xs + ", xr=" + xr + ", fxi=" + fxi + ", fxr=" + fxr + ", producto=" + producto + ", error=" + error + '}';
    }
    
    
}
