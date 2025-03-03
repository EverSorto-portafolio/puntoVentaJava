/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author everc
 */
public class Articulo {
    private int idArticulo;
    private int categoria_id;
    private  String categoria_nombre;
    private String codigo;
    private String nombre;
    private double precio_venta;
    private int stock ;
    private String desscriocion; 
    private String  imagen; 
    private boolean estado;

     public Articulo() {
    }

    public Articulo(int idArticulo, int categoria_id, String categoriaNombre, String codigo, String nombre, double precio_venta, int stock, String desscriocion, String imagen, boolean estado) {
        this.idArticulo = idArticulo;
        this.categoria_id = categoria_id;
        this.categoria_nombre = categoriaNombre;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio_venta = precio_venta;
        this.stock = stock;
        this.desscriocion = desscriocion;
        this.imagen = imagen;
        this.estado = estado;
    }

     public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDesscriocion() {
        return desscriocion;
    }

    public void setDesscriocion(String desscriocion) {
        this.desscriocion = desscriocion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

   
    public String getCategoriaNombre() {
        return categoria_nombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoria_nombre = categoriaNombre;
    }

    @Override
    public String toString() {
        return "Articulo{" + "idArticulo=" + idArticulo + ", categoria_id=" + categoria_id + ", categoriaNombre=" + categoria_nombre + ", codigo=" + codigo + ", nombre=" + nombre + ", precio_venta=" + precio_venta + ", stock=" + stock + ", desscriocion=" + desscriocion + ", imagen=" + imagen + ", estado=" + estado + '}';
    }
}

