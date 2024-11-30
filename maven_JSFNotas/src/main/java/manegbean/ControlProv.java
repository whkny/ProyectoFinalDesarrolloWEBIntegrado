package manegbean;

import dao.Negocio;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Empresas;
import modelo.Productos;

@ManagedBean(name = "controlProv")
@ViewScoped

public class ControlProv {

    private String filtroNombre = ""; // Variable para almacenar el filtro
    private List<Empresas> listaProveedores; // Lista de proveedores
    private Empresas proveedor = new Empresas(); // Proveedor para agregar o modificar
    private List<Productos> listaProductos; // Lista de productos de un proveedor

    // Instancia de la clase Negocio para interactuar con la base de datos
    private Negocio negocio = new Negocio();

    // Método que actualiza la lista de proveedores filtrados
    public void filtrarProveedores() {
        listaProveedores = negocio.LisProvPorNombre(filtroNombre);
    }

    // Método para obtener la lista inicial (todos los proveedores)
    public List<Empresas> getListaProveedores() {
        if (listaProveedores == null) {
            listaProveedores = negocio.LisProvPorNombre(""); // Cargar todos los proveedores al inicio
        }
        return listaProveedores;
    }

    // Método para obtener la lista de productos de un proveedor
    public void obtenerProductosPorProveedor(String idProveedor) {
        // Llamar al método ListProd del DAO para obtener los productos del proveedor
        listaProductos = negocio.ListProd(idProveedor);
    }

    // Método para agregar un proveedor
    public void agregarProveedor() {
        negocio.agregarProveedor(proveedor); // Llamar al método que guarda el proveedor
        proveedor = new Empresas(); // Limpiar el formulario
        filtrarProveedores(); // Actualizar la lista con el filtro actual
    }

    public void editarProveedor() {
    try {
        // Llamar al método editarProveedor del servlet, puedes hacerlo usando la redirección o directamente el negocio
        negocio.modificarProveedor(proveedor);  // Usando el negocio directamente para editar el proveedor

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proveedor editado correctamente.", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        filtrarProveedores(); // Actualizar la lista con el filtro actual

    } catch (Exception e) {
        // Si ocurre una excepción, mostrar mensaje de advertencia
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al editar el proveedor.", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
    
    

    // Método para eliminar un proveedor por ID
    public void eliminarProveedor(String idProveedor) {
        FacesMessage message;

        try {
            // Llamar al método de eliminación en la clase Negocio
            negocio.eliminarProveedor(idProveedor);

            // Si no ocurre ninguna excepción, el proveedor fue eliminado exitosamente
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proveedor eliminado correctamente.", null);
            filtrarProveedores(); // Actualizar la lista con el filtro actual

        } catch (Exception e) {
            // Si ocurre una excepción, mostrar mensaje de advertencia
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "No se pudo eliminar el proveedor. " +
                    "Es posible que tenga productos asociados.", null);
        }

        // Mostrar el mensaje en la interfaz
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    // Getters y Setters
    public String getFiltroNombre() {
        return filtroNombre;
    }

    public void setFiltroNombre(String filtroNombre) {
        this.filtroNombre = filtroNombre;
    }

    public Empresas getProveedor() {
        return proveedor;
    }

    public void setProveedor(Empresas proveedor) {
        this.proveedor = proveedor;
    }

    public List<Productos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
