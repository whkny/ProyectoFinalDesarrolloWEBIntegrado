package modelo;

public class Pedido {

    private String idVenta;
    private String nombreCliente;
    private String fechaVenta;
    private double totalVenta;
/*
    // Constructor
    public Pedido(int idVenta, String nombreCliente, String fechaVenta, double totalVenta) {
        this.idVenta = idVenta;
        this.nombreCliente = nombreCliente;
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
    }
*/
    // Getter y Setter para idVenta
    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    // Getter y Setter para nombreCliente
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    // Getter y Setter para fechaVenta
    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    // Getter y Setter para totalVenta
    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    // Método toString para mostrar la información
    @Override
    public String toString() {
        return "VentaCliente [idVenta=" + idVenta + ", nombreCliente=" + nombreCliente + 
               ", fechaVenta=" + fechaVenta + ", totalVenta=" + totalVenta + "]";
    }
}
