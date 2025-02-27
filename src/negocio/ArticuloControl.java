/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datosDAO.ArticuloDAO;
import entidades.Articulo;
import entidades.Categoria;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

public class ArticuloControl {

    private final ArticuloDAO DATOS;
    private Articulo obj;
    private DefaultTableModel tModel;
    public int registrosMostrados;

    public ArticuloControl() {
        this.DATOS = new ArticuloDAO();
        this.obj = new Articulo();
    }

    public DefaultTableModel listar(
            String texto,
            int totalPorpagina,
            int numpagina
        ){
        List<Articulo> lista = new ArrayList();
        lista.addAll(DATOS.getAll(texto, totalPorpagina, numpagina));
        String[] titulos
                = {"id", "categoria_id", "codigo", "nombre","precio_venta","stock",
                        "descripcion","imagen","estado"
                };
        this.tModel = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[9];
        this.registrosMostrados = 0;
        for (Articulo item : lista) {
            if (item.isEstado()) {
                estado = "activo";
            } else {
                estado = "Inactivo";
            }

            registro[0] = Integer.toString(item.getIdArticulo());
            registro[1] = Integer.toString(item.getCategoria_id());
            registro[2] = item.getCodigo();
            registro[3] = item.getNombre();
            registro[4] = Double.toString(item.getPrecio_venta());
            registro[5] = Integer.toString(item.getStock());
            registro[6] = item.getDesscriocion();
            registro[7] = item.getImagen();
            registro[8] = Boolean.toString( item.isEstado());
            this.registrosMostrados = this.registrosMostrados + 1;
            this.tModel.addRow(registro);
        }
        return this.tModel;
    }

    public String Insertar(
            int categoria_id, 
            String codigo, 
            String nombre, 
            double precio, 
            int stock,
            String descripcion,
            String imagen
    ) {
        if (DATOS.exist(nombre)) {
            return "Registro ya existe";
        } else {
            obj.setNombre(nombre);
            obj.setCategoria_id(categoria_id);
            obj.setCodigo(codigo);
            obj.setNombre(nombre);
            obj.setPrecio_venta(precio);
            obj.setDesscriocion(descripcion);
            obj.setImagen(imagen);
            if (DATOS.insert(obj)) {
                return "OK";
            } else {
                return "Error en el registro ";
            }
        }
    }

    public String actualizar(
           int articulo_id,
             int categoria_id, 
            String codigo, 
            String nombre, 
            String nombreAnterior,
            double precio, 
            int stock,
            String descripcion,
            String imagen
    ) {

        if (!nombre.equals(nombreAnterior)) {
           
            obj.setIdArticulo(articulo_id);
            obj.setNombre(nombre);
            obj.setCategoria_id(categoria_id);
            obj.setCodigo(codigo);
            obj.setNombre(nombre);
            obj.setPrecio_venta(precio);
            obj.setDesscriocion(descripcion);
            obj.setImagen(imagen);
            
            
            
            // Primero verificamos si el nombre ya existe en la base de datos
            if (DATOS.exist(nombre)) {
                return "El objeto ya existe";
            }
            // Si no existe, actualizamos el objeto
            
           
           
        } else {
            // Si el nombre no ha cambiado, simplemente actualizamos la descripción
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setDescripcion(descripcion);
           
            if (DATOS.update(obj)) {
                return "OK";
            } else {
                return "Error en la actualización";
            }
        }

    }

    public String desactivar(int id) {
        if (DATOS.offVaraible(id)) {
            return "OK";
        } else {
            return "No se puede desactivar el registro";
        }

    }

    public String activar(int id) {
        if (DATOS.onVariable(id)) {
            return "OK";
        } else {
            return "No se puede activar el registro";
        }
    }

    public int total() {
        return DATOS.total();
    }

    public int totalMostrados() {
        return this.registrosMostrados;
    }
}
