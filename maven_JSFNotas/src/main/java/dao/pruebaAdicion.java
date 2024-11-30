
package dao;
import java.util.List;
import modelo.*;
public class pruebaAdicion {

    
   // public static void main(String[] args) {
   //    Alumno a=new Alumno("","Perez","Grabriel","E02","P");
   //    new Negocio().adicion(a);
   // }
    
/*

    public static void main(String[] args) {
        Negocio negocio = new Negocio();
        List<Empresas> proveedores = negocio.LisProv();
        
        for (Empresas proveedor : proveedores) {
            System.out.println("ID: " + proveedor.getCod_emp() + ", Nombre: " + proveedor.getNom_emp() + ", getString: " + proveedor.getDirec_emp());
        }
    }
*/

    
        
 /* public static void main(String[] args) {
  Empresas p=new Empresas("", "Perez","Grabriel","123456789","prueba@gmail.com");
   new Negocio().agregarProveedor(p);
 
  
  
  }*/
   /* 
    public static void main(String[] args) {
        // Instancia de la clase que contiene el método LisProvPorNombre
        Negocio negocio = new Negocio();
        
        // Definir el nombre del proveedor que deseas filtrar
        String nombreProveedor = "Fashion";  // Ejemplo de nombre para búsqueda

        // Llamar al método LisProvPorNombre para obtener los proveedores que coincidan con el nombre
        List<Empresas> proveedores = negocio.LisProvPorNombre(nombreProveedor);
        
        // Verificar los resultados
        if (proveedores.isEmpty()) {
            System.out.println("No se encontraron proveedores con el nombre: " + nombreProveedor);
        } else {
            // Mostrar los resultados
            for (Empresas proveedor : proveedores) {
                System.out.println("ID: " + proveedor.getCod_emp());
                System.out.println("Nombre: " + proveedor.getNom_emp());
                System.out.println("Dirección: " + proveedor.getDirec_emp());
                System.out.println("Teléfono: " + proveedor.getTelef_emp());
                System.out.println("Email: " + proveedor.getEmail_emp());
                System.out.println("-------------------------------");
            }
        }
    }



*/
    
 /*   
    public static void main(String[] args) {
        // Crear un objeto de la clase Negocio
        Negocio negocio = new Negocio();
        
        // Definir el id de la empresa (proveedor) para probar
        String idEmpresa = "EMP001"; // Asegúrate de que este id exista en la base de datos
        
        // Llamar al método ListProd para obtener los productos de ese proveedor
        List<Productos> productos = negocio.ListProd(idEmpresa);
        
        // Imprimir los resultados
        if (productos.isEmpty()) {
            System.out.println("No se encontraron productos para el proveedor con id: " + idEmpresa);
        } else {
            for (Productos p : productos) {
                System.out.println("ID Producto: " + p.getId_producto());
                System.out.println("Nombre Producto: " + p.getNombre_producto());
                System.out.println("Descripción: " + p.getDescripcion());
                System.out.println("Precio: " + p.getPrecio());
                System.out.println("Stock: " + p.getStock());
                System.out.println("ID Marca: " + p.getId_marca());
                System.out.println("-------------------------------------------------");
            }
        }
    }

*/

    
  /*  public static void main(String[] args) {
        // Crear una instancia de la clase Negocio
        Negocio negocio = new Negocio();

        // ID del proveedor a eliminar
        String idEmpresa = "EMP022";  // Cambiar según sea necesario

        // Llamar al método eliminarProveedor
        negocio.eliminarProveedor(idEmpresa);

        System.out.println("Proceso de eliminación finalizado.");
    }
    */
    
    /*
        public static void main(String[] args) {
        // Crear una instancia de la clase Negocio donde está el método LisPedidos
        Negocio negocio = new Negocio();

        // Llamar al método LisPedidos para obtener la lista de pedidos
        List<Pedido> listaPedidos = negocio.LisPedidos();

        // Imprimir los pedidos
        for (Pedido pedido : listaPedidos) {
            System.out.println(pedido);  // Esto usará el método toString de la clase Pedido
        }
    }

*/
   /*     public static void main(String[] args) {
        // Crear una instancia de la clase Negocio donde está el método ListProducto
        Negocio negocio = new Negocio();

        // Llamar al método ListProducto para obtener la lista de productos
        List<Productos> listaProductos = negocio.ListProducto();

        // Imprimir los productos
        for (Productos producto : listaProductos) {
            System.out.println("ID Producto: " + producto.getId_producto());
            System.out.println("Nombre: " + producto.getNombre_producto());
            System.out.println("Descripción: " + producto.getDescripcion());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Stock: " + producto.getStock());
            System.out.println("Empresa: " + producto.getNombreEmpresa());
            System.out.println("Marca: " + producto.getMarcaProducto());
            System.out.println("-------------------------------------------------");
        }
    }

*/
    
    
      public static void main(String[] args) {
        // Crear una instancia de la clase Negocio
        Negocio negocio = new Negocio();

        // Llamar al método obtenerDetallePedido pasando el id de venta que deseas consultar
        List<DetallePedido> detalles = negocio.obtenerDetallePedido("VEN002");

        // Imprimir los detalles obtenidos
        for (DetallePedido detalle : detalles) {
            System.out.println(detalle.toString());
        }
    }
        
        
        
        
        
}
    



    
        
    