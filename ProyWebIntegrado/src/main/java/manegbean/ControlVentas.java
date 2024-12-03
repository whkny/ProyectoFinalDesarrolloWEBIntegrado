package manegbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import modelo.*;
import dao.Negocio;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class ControlVentas implements Serializable {

    private Pedido pedido;
    private List<Pedido> listaPedidos;
    private List<DetallePedido> listaDetallePedidos;
    private String texto;
    private double total;
    private String nombreCliente;
    private List<SelectItem> listaClientes;

    public ControlVentas() {
        texto = "";
        pedido = new Pedido();
        listaPedidos = new ArrayList<>();
        listaDetallePedidos = new ArrayList<>();
    }

    // Este método se ejecuta cuando se carga la página
    @PostConstruct
    public void filtrar() {
        listaPedidos = new Negocio().filtrarVenta(texto);
    }

    // Ver el detalle de un pedido
    public void verDetalle(Pedido p) {
        listaDetallePedidos = new Negocio().obtenerDetallePedido(p.getIdVenta());
        total = 0;
        for (DetallePedido detalle : listaDetallePedidos) {
            total += detalle.getPrecioUnitario() * detalle.getCantidad(); // Calcula el total
        }
    }

    // Métodos getter y setter
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public List<DetallePedido> getListaDetallePedidos() {
        return listaDetallePedidos;
    }

    public void setListaDetallePedidos(List<DetallePedido> listaDetallePedidos) {
        this.listaDetallePedidos = listaDetallePedidos;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public List<SelectItem> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<SelectItem> listaClientes) {
        this.listaClientes = listaClientes;
    }
}
