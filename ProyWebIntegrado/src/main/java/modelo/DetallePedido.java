package modelo;

public class DetallePedido {
    private String idVenta;
    private String nombreCliente;
    private String nombreProducto;
    private int cantidad;
    private double precioUnitario;
/*
    // Constructor
    public DetallePedido(String idVenta, String nombreCliente, String nombreProducto, int cantidad, double precioUnitario) {
        this.idVenta = idVenta;
        this.nombreCliente = nombreCliente;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
*/
    // Getters y Setters
    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    // Método toString para mostrar información
    @Override
    public String toString() {
        return "DetallePedido [idVenta=" + idVenta + ", nombreCliente=" + nombreCliente + ", nombreProducto="
                + nombreProducto + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + "]";
    }
}
