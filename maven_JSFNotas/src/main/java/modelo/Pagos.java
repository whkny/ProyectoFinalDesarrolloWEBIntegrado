
package modelo;

public class Pagos {
  private String ciclo;
  private int  ncuota;
  private double monto;
  private String fecha;   

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public int getNcuota() {
        return ncuota;
    }

    public void setNcuota(int ncuota) {
        this.ncuota = ncuota;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
  
}
