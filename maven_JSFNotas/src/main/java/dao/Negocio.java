package dao;
import modelo.*;
import util.MySQLConexion;
import java.sql.*;
import java.util.*;
public class Negocio {
  //listado de especialidad
   public List<Especial> LisEsp(){
    List<Especial> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
     String sql="Select idesp, nomesp from especialidad";   
     PreparedStatement st=cn.prepareStatement(sql);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       Especial p=new Especial();
       p.setCode(rs.getString(1));
       p.setNomesp(rs.getString(2));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }
    return lis;   
   } 
   //listado general de alumnos
   public List<Alumno> LisAlumno(){
    List<Alumno> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
     String sql="SElect idalumno, nomalumno,apealumno from Alumno";   
     PreparedStatement st=cn.prepareStatement(sql);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       Alumno p=new Alumno();
       p.setCoda(rs.getString(1));
       p.setApe(rs.getString(3));
       p.setNoma(rs.getString(2));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }
    return lis;   
   } 
   
   
  //listado de alumno pasando un codigo de especialidad
    public List<Alumno> LisAlumno(String id){
    List<Alumno> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
     String sql="SElect idalumno, nomalumno,apealumno from Alumno where idesp=?";   
     PreparedStatement st=cn.prepareStatement(sql);
     st.setString(1, id);
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       Alumno p=new Alumno();
       p.setCoda(rs.getString(1));
       p.setApe(rs.getString(3));
       p.setNoma(rs.getString(2));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }
    return lis;   
   } 
   //filtro por apellido o nombre
    public List<Alumno> filtrar(String id){
    List<Alumno> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
     String sql="SElect idalumno, nomalumno,apealumno from Alumno where apealumno like ? or nomalumno like ?";   
     PreparedStatement st=cn.prepareStatement(sql);
     st.setString(1, id+"%");
     st.setString(2, id+"%");
     
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       Alumno p=new Alumno();
       p.setCoda(rs.getString(1));
       p.setApe(rs.getString(3));
       p.setNoma(rs.getString(2));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }
    return lis;   
   }  
    
    
    
    
  //listado de pagos pasando un codigo de alumno
    public List<Pagos> select_pago(String id){
        List<Pagos> lis=new ArrayList();
        Connection cn = MySQLConexion.getConexion();        
        try {
            String sql="select ncuota, ciclo, fecha, monto FROM pagos where idalumno=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setString(1, id); //pasarelparametroid
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Pagos p=new Pagos();
                p.setNcuota(rs.getInt(1));
                p.setCiclo(rs.getString(2));                
                p.setFecha(rs.getString(3));               
                p.setMonto(rs.getDouble(4));
                lis.add(p);
            }
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lis;
    }
    
    
    
  //listado de notas pasando un codigo de alumno  
    public List<Notas> LisNotas(String id) {
        List<Notas> lis = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
          //  String sql = "Select c.idcurso,nomcurso, exaparcial, exafinal from notas n join curso c\n"
          //          + "on c.idcurso=n.idcurso where idalumno=?";
          String sql="{call spnota(?)}";
          //llamando a procedure
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, id); //pasarelparametroid
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Notas p = new Notas();
                p.setCodc(rs.getString(1));
                p.setNomcur(rs.getString(2));
                p.setExp(rs.getInt(3));
                p.setExf(rs.getInt(4));
                lis.add(p);
            }
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lis;
    }
//lista de cursos
public List<Notas> LisCurso() {
        List<Notas> lis = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "Select idcurso,nomcurso from curso";
             PreparedStatement st=cn.prepareStatement(sql);
    
          //llamando a procedure
              ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Notas p = new Notas();
                p.setCodc(rs.getString(1));
                p.setNomcur(rs.getString(2));
               
                lis.add(p);
            }
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lis;
    }


  //lista de alumnos de un curso
  public List<Alumno> LisAluCurso(String id) {
        List<Alumno> lis = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select a.idalumno,apealumno,nomalumno,exaparcial,exafinal\n" +
     " from alumno a join notas n on a.idalumno=n.idalumno where idcurso=?";
   //  String sql="{call spcurso(?)}";            
CallableStatement st = cn.prepareCall(sql);
            st.setString(1, id); //pasarelparametroid
            ResultSet rs = st.executeQuery();
    while (rs.next()) {
                Alumno p = new Alumno();
                p.setCoda(rs.getString(1));
                p.setApe(rs.getString(2));
                p.setNoma(rs.getString(3));
                p.setExp(rs.getInt(4));
                p.setExf(rs.getInt(5));
                lis.add(p);
            }
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lis;
    }  
 //adicion de alumnos
  public void adicion(Alumno a){
      Connection cn=MySQLConexion.getConexion();
      String sql="{call spAdiAlu(?,?,?,?)}";
      try{
       CallableStatement st=cn.prepareCall(sql);
       st.setString(1, a.getApe() );
       st.setString(2, a.getNoma());
       st.setString(3, a.getCode());
       st.setString(4, a.getPro());
       st.executeUpdate();
      }catch(Exception ex){
          ex.printStackTrace();
      }
   }



//PROYECTO VENTAS



// LISTA PROVEEDORES
public List<Empresas> LisProv() {
    List<Empresas> lista = new ArrayList<>();
    Connection cn = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    try {
        // Obtener la conexión
        cn = MySQLConexion.getConexion();
        
        // SQL para obtener los proveedores
        String sql = "SELECT id_empresa, nombre_empresa, direccion, telefono, email FROM empresa";
        st = cn.prepareStatement(sql);
        
        // Ejecutar la consulta
        rs = st.executeQuery();

        // Iterar sobre los resultados
        while (rs.next()) {
            Empresas p = new Empresas();
            p.setCod_emp(rs.getString("id_empresa"));
            p.setNom_emp(rs.getString("nombre_empresa"));
            p.setDirec_emp(rs.getString("direccion"));
            p.setTelef_emp(rs.getString("telefono"));
            p.setEmail_emp(rs.getString("email"));

            lista.add(p);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        // Cerrar los recursos en el bloque finally
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return lista;
}


    // LISTA DE PRODUCTOS POR PROVEEDOR
public List<Productos> ListProd(String id) {
    List<Productos> lista = new ArrayList<>();
    Connection cn = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    try {
        // Obtener la conexión
        cn = MySQLConexion.getConexion();
        
        // SQL para obtener los productos del proveedor
        String sql = "SELECT id_producto, nombre_producto, descripcion, precio, stock, id_empresa, id_marca FROM producto WHERE id_empresa=?";
        st = cn.prepareStatement(sql);
        
        // Establecer el parámetro en la consulta
        st.setString(1, id);
        
        // Ejecutar la consulta
        rs = st.executeQuery();

        // Iterar sobre los resultados
        while (rs.next()) {
            Productos p = new Productos();
            p.setId_producto(rs.getString("id_producto"));
            p.setNombre_producto(rs.getString("nombre_producto"));
            p.setDescripcion(rs.getString("descripcion"));
            p.setPrecio(rs.getDouble("precio"));
            p.setStock(rs.getInt("stock"));
            p.setId_empresa(rs.getString("id_empresa"));
            p.setId_marca(rs.getString("id_marca"));
            lista.add(p);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        // Cerrar los recursos en el bloque finally
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return lista;
}


    
    // Método para agregar un nuevo proveedor
public void agregarProveedor(Empresas proveedor) {
    Connection cn = null;
    CallableStatement st = null;

    try {
        // Obtener la conexión a la base de datos
        cn = MySQLConexion.getConexion();
        
        // Preparar el SQL para llamar al procedimiento almacenado
        String sql = "{CALL AgregarProveedor(?, ?, ?, ?)}";
        st = cn.prepareCall(sql);
        
        // Establecer los parámetros para el procedimiento almacenado
        st.setString(1, proveedor.getNom_emp());  // Nombre de la empresa
        st.setString(2, proveedor.getDirec_emp()); // Dirección de la empresa
        st.setString(3, proveedor.getTelef_emp()); // Teléfono del proveedor
        st.setString(4, proveedor.getEmail_emp()); // Correo electrónico del proveedor
        
        // Ejecutar el procedimiento almacenado
        st.executeUpdate();  // Usamos executeUpdate() ya que modificamos datos en la base
        
        System.out.println("Proveedor agregado correctamente.");
        
    } catch (SQLException e) {
        System.err.println("Error al agregar proveedor: " + e.getMessage());
        e.printStackTrace();  // Mostrar cualquier error en la consola
    } catch (Exception e) {
        System.err.println("Error general: " + e.getMessage());
        e.printStackTrace();
    } finally {
        // Cerrar recursos en el bloque finally
        try {
            if (st != null) st.close();
            if (cn != null) cn.close();
        } catch (SQLException e) {
            System.err.println("Error al cerrar recursos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

    


    
// Método para modificar proveedor
public void modificarProveedor(Empresas proveedor) {
    Connection cn = null;
    CallableStatement st = null;

    try {
        // Obtener la conexión a la base de datos
        cn = MySQLConexion.getConexion();
        
        // Preparar la llamada al procedimiento almacenado
        String sql = "{CALL modificarProveedor(?, ?, ?, ?, ?)}";
        st = cn.prepareCall(sql);

        // Establecer los parámetros
        st.setString(1, proveedor.getCod_emp());  // Código de la empresa
        st.setString(2, proveedor.getNom_emp());  // Nombre de la empresa
        st.setString(3, proveedor.getDirec_emp()); // Dirección de la empresa
        st.setString(4, proveedor.getTelef_emp()); // Teléfono del proveedor
        st.setString(5, proveedor.getEmail_emp()); // Correo electrónico del proveedor
        
        // Ejecutar el procedimiento almacenado
        st.executeUpdate();
        System.out.println("Proveedor modificado correctamente.");
        
    } catch (SQLException e) {
        System.err.println("Error SQL al modificar proveedor: " + e.getMessage());
        e.printStackTrace();  // Mostrar el detalle del error
    } catch (Exception e) {
        System.err.println("Error general al modificar proveedor: " + e.getMessage());
        e.printStackTrace();  // Mostrar el detalle del error
    } finally {
        // Cerrar recursos en el bloque finally
        try {
            if (st != null) st.close();
            if (cn != null) cn.close();
        } catch (SQLException e) {
            System.err.println("Error al cerrar recursos: " + e.getMessage());
            e.printStackTrace();  // Mostrar el detalle del error
        }
    }
}



/*
// Método para borrar proveedor
public void borrarProveedor(String codEmp) {
 Connection cn = null;
    CallableStatement st = null;
    ResultSet rs = null;

    try {
        // Obtener la conexión a la base de datos
        cn = MySQLConexion.getConexion();

        // Preparar el SQL para llamar al procedimiento almacenado
        String sql = "{CALL eliminarProveedor(?)}";
        st = cn.prepareCall(sql);

        // Establecer el parámetro de entrada para el procedimiento almacenado
        st.setString(1, codEmp);  // ID del proveedor a eliminar

        // Ejecutar el procedimiento almacenado
        boolean hasResultSet = st.execute();  // Usamos execute() porque devuelve un ResultSet con el mensaje
        
        // Verificar si el procedimiento devuelve un conjunto de resultados
        if (hasResultSet) {
            rs = st.getResultSet();
            if (rs.next()) {
                // Obtener el mensaje del procedimiento almacenado
                String mensaje = rs.getString("Mensaje");
                System.out.println(mensaje);  // Mostrar el mensaje en la consola
            }
        }

    } catch (SQLException e) {
        System.err.println("Error al eliminar proveedor: " + e.getMessage());
        e.printStackTrace();  // Mostrar cualquier error en la consola
    } catch (Exception e) {
        System.err.println("Error general: " + e.getMessage());
        e.printStackTrace();
    } finally {
        // Cerrar recursos en el bloque finally
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (cn != null) cn.close();
        } catch (SQLException e) {
            System.err.println("Error al cerrar recursos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
*/


public void eliminarProveedor(String idEmpresa) {
    Connection cn = null;
    CallableStatement st = null;
    ResultSet rs = null;

    try {
        // Obtener la conexión a la base de datos
        cn = MySQLConexion.getConexion();

        // Preparar el SQL para llamar al procedimiento almacenado
        String sql = "{CALL eliminarProveedor(?)}";
        st = cn.prepareCall(sql);

        // Establecer el parámetro de entrada para el procedimiento almacenado
        st.setString(1, idEmpresa);  // ID del proveedor a eliminar

        // Ejecutar el procedimiento almacenado
        boolean hasResultSet = st.execute();  // Usamos execute() porque devuelve un ResultSet con el mensaje
        
        // Verificar si el procedimiento devuelve un conjunto de resultados
        if (hasResultSet) {
            rs = st.getResultSet();
            if (rs.next()) {
                // Obtener el mensaje del procedimiento almacenado
                String mensaje = rs.getString("Mensaje");
                System.out.println(mensaje);  // Mostrar el mensaje en la consola
            }
        }

    } catch (SQLException e) {
        System.err.println("Error al eliminar proveedor: " + e.getMessage());
        e.printStackTrace();  // Mostrar cualquier error en la consola
    } catch (Exception e) {
        System.err.println("Error general: " + e.getMessage());
        e.printStackTrace();
    } finally {
        // Cerrar recursos en el bloque finally
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (cn != null) cn.close();
        } catch (SQLException e) {
            System.err.println("Error al cerrar recursos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}



// LISTA Productos
    public List<Productos> ListProducto() {
        List<Productos> lista = new ArrayList<>();
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            cn = MySQLConexion.getConexion();
            String sql = "select p.id_producto, p.nombre_producto, p.descripcion, p.precio, p.stock, e.nombre_empresa, m.marca_producto  from producto p "
                    + "left join empresa e on e.id_empresa = p.id_empresa "
                    + "left join marca m on m.id_marca = p.id_marca";
            st = cn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                Productos p = new Productos();
                p.setId_producto(rs.getString("id_producto"));
                p.setNombre_producto(rs.getString("nombre_producto"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setNombreEmpresa(rs.getString("nombre_empresa"));
                p.setMarcaProducto(rs.getString("marca_producto"));

                lista.add(p);
            }
        } catch (SQLException ex) {
       } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    
   // GRAFICOS 
    
    
   public List<Integer> LisMes(int anio) {
        List<Integer> ventasPorMes = new ArrayList<>();
        String sql = "CALL spVentasPorMes(?)"; // Llamar al procedimiento almacenado

        try (Connection con = MySQLConexion.getConexion(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, anio);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                ventasPorMes.add(rs.getInt("total")); // Obtener total de ventas por mes
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventasPorMes;
    }

    
 // Nuevo método para obtener ventas por marca
public List<MarcaVenta> obtenerVentasPorMarca() {
    List<MarcaVenta> listaMarcas = new ArrayList<>();
    String sql = "CALL spVentasPorMarca()"; // Llamar al procedimiento almacenado

    try (Connection con = MySQLConexion.getConexion(); 
         PreparedStatement pst = con.prepareStatement(sql)) {
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {
            MarcaVenta marcaVenta = new MarcaVenta();
            marcaVenta.setMarca(rs.getString("marca"));
            marcaVenta.setTotal(rs.getDouble("total")); 
            listaMarcas.add(marcaVenta); 
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return listaMarcas; // Retornar la lista de ventas por marca
}

    

// FILTRAR 
// LISTA PROVEEDORES FILTRADOS POR NOMBRE
public List<Empresas> LisProvPorNombre(String nombre) {
    List<Empresas> lista = new ArrayList<>();
    Connection cn = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    try {
        // Obtener la conexión
        cn = MySQLConexion.getConexion();
        
        // SQL para obtener los proveedores filtrados por nombre
        String sql = "SELECT id_empresa, nombre_empresa, direccion, telefono, email FROM empresa WHERE nombre_empresa LIKE ?";
        
        // Preparar la sentencia SQL
        st = cn.prepareStatement(sql);
        
        // Establecer el parámetro para el filtro de nombre
        st.setString(1, "%" + nombre + "%");  // Usamos % para realizar una búsqueda que permita coincidencias parciales

        // Ejecutar la consulta
        rs = st.executeQuery();

        // Iterar sobre los resultados
        while (rs.next()) {
            Empresas p = new Empresas();
            p.setCod_emp(rs.getString("id_empresa"));
            p.setNom_emp(rs.getString("nombre_empresa"));
            p.setDirec_emp(rs.getString("direccion"));
            p.setTelef_emp(rs.getString("telefono"));
            p.setEmail_emp(rs.getString("email"));

            lista.add(p);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        // Cerrar los recursos en el bloque finally
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return lista;
}




// LISTA VENTAS
public List<Pedido> LisPedidos() {
    List<Pedido> lista = new ArrayList<>();
    Connection cn = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    try {
        
        cn = MySQLConexion.getConexion();
        String sql = "select v.id_venta, c.nombre, v.fecha_venta , v.total  from venta v left join cliente c on c.id_cliente = v.id_cliente";
        st = cn.prepareStatement(sql);
        
        // Ejecutar la consulta
        rs = st.executeQuery();

        // Iterar sobre los resultados
        while (rs.next()) {
            Pedido p = new Pedido();
            p.setIdVenta(rs.getString("id_venta"));
            p.setNombreCliente(rs.getString("nombre"));
            p.setFechaVenta(rs.getString("fecha_venta"));
            p.setTotalVenta(rs.getDouble("total"));
  

            lista.add(p);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        // Cerrar los recursos en el bloque finally
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return lista;
}
 
   // Método para obtener el detalle de un pedido por id_venta
    public List<DetallePedido> obtenerDetallePedido(String idVenta) {
        List<DetallePedido> listaDetalle = new ArrayList<>();
        Connection cn = MySQLConexion.getConexion();
        try {
            // Llamada al procedimiento almacenado
            String sql = "{call obtenerDetallePedido(?)}"; // Procedimiento almacenado con parámetro
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, idVenta); // Pasar el parámetro idVenta
            ResultSet rs = st.executeQuery(); // Ejecutar la consulta

            // Iterar sobre los resultados
            while (rs.next()) {
                DetallePedido detalle = new DetallePedido();
                detalle.setIdVenta(rs.getString("id_venta"));
                detalle.setNombreCliente(rs.getString("nombre_cliente"));
                detalle.setNombreProducto(rs.getString("nombre_producto"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setPrecioUnitario(rs.getDouble("precio_unitario"));

                // Añadir el objeto DetallePedido a la lista
                listaDetalle.add(detalle);
            }

            // Cerrar la conexión
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }

        return listaDetalle; // Retorna la lista de detalles del pedido
    }


   //filtro por Venta o Cliente
    public List<Pedido> filtrarVenta(String id){
    List<Pedido> lis=new ArrayList();
    Connection cn=MySQLConexion.getConexion();
    try{
     String sql="select v.id_venta, c.nombre, v.fecha_venta , v.total  from venta v left join cliente c on c.id_cliente = v.id_cliente  where v.id_venta like ? or c.nombre like ?";   
     PreparedStatement st=cn.prepareStatement(sql);
     st.setString(1, id+"%");
     st.setString(2, id+"%");
     
     ResultSet rs=st.executeQuery();
     while(rs.next()){
       Pedido p=new Pedido();
            p.setIdVenta(rs.getString("id_venta"));
            p.setNombreCliente(rs.getString("nombre"));
            p.setFechaVenta(rs.getString("fecha_venta"));
            p.setTotalVenta(rs.getDouble("total"));
       lis.add(p);
     }
    }catch(Exception ex){
      ex.printStackTrace();
    }
    return lis;   
   }  


}