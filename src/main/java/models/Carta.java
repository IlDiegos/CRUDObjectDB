/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author diegu
 */
@Entity
public class Carta implements Serializable {

    // int id, string nombre, double precio
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nombre;
    private double precio;

    @OneToMany(mappedBy = "carta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     private List<Pedido> pedido;

    public Carta() {

    }

    public Carta(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
     public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }


    @Override
    public String toString() {
        return "Carta{" + "id= " + id + ", nombre= " + nombre + ", precio= " + precio + '}';
    }

}
