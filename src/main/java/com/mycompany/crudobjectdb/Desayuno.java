/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudobjectdb;


import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import models.Carta;
import models.Pedido;

/**
 *
 * @author diegu
 */
public class Desayuno {

    private static EntityManagerFactory emf;

    Scanner sc = new Scanner(System.in);

   java.util.Date ahora = new java.util.Date();
   java.sql.Date sqlDate = new java.sql.Date(ahora.getTime());

    static {
        emf = Persistence.createEntityManagerFactory("db.odb");
    }

    public void guardaCarta(Carta c) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
    }

    public void creaPedido() {
        Pedido p = new Pedido();
        Carta c = new Carta();

        System.out.println("Introduce un nombre para el pedido: ");
        String nombre = sc.next();
        p.setNombre_pedido(nombre);
        p.setFecha(sqlDate);

        System.out.println("Introduce un id de producto: ");
        Long i = sc.nextLong();
        c.setId(i);

        if (i > 0) {
            System.out.println("Su pedido se ha realizado con éxito.");
        } else {
            System.out.println("Pedido no realizado.");
        }
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    public void imprimeCarta() {

        /*
        ArrayList para posteriormente imprimir la carta mediante una sentencia SQL
         */
        EntityManager em = emf.createEntityManager();

        /*
        Query para imprimir la carta 
         */
        TypedQuery<Carta> q = em.createQuery("SELECT c from Carta c", Carta.class);

        var carta = q.getResultList();
        em.close();

        carta.forEach((aa) -> System.out.println(aa));

    }

    /*
    Me ha parecido más óptimo y fácil realizar el input de id desde esta clase, ya que es menos lioso que ir haciendolo en el main
     */
    public void borrarPedido() {
        Pedido p = new Pedido();

        EntityManager em = emf.createEntityManager();
        System.out.println("¿Qué pedido deseas borrar?");

        TypedQuery<Pedido> q = em.createQuery("SELECT p from Pedido p", Pedido.class);

        var pedido = q.getResultList();

        pedido.forEach((aa) -> System.out.println(aa));

        System.out.println("Selecciona el pedido a borrar: ");
        Long id = sc.nextLong();
        p = em.find(Pedido.class, id);

        System.out.println("Pedido con id: " + p.getId() + " borrado");

        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        em.close();

        
    }

    public void marcarPedido() {
        Pedido p = new Pedido();
        EntityManager em = emf.createEntityManager();
        
        
        
        TypedQuery<Pedido> q = em.createQuery("SELECT p from Pedido p", Pedido.class);
        
        
        var pedido = q.getResultList();
        
        if(pedido != null){

        pedido.forEach((aa) -> System.out.println(aa));

        System.out.println("Selecciona un pedido para marcar: ");
        Long id = sc.nextLong();
        p = em.find(Pedido.class, id);
        
        p.setRecogido(true);
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        
        }else{
            System.out.println("No hay pedidos para marcar.");
        }
       
        
        

        
        //static final String RECOGIDO = "UPDATE pedidos set recogido=1 where id=?";

        /*
        System.out.println("Selecciona el pedido que quieres marcar: ");
        co.listarPendientes().forEach(e -> System.out.println(e));
        pedido.setId(sc.nextInt());
        co.marcar(pedido.getId());
         */
    }

    public void mostrarPedido() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Pedido> p = em.createQuery("SELECT p from Pedido p", Pedido.class);

        var pedido = p.getResultList();
        em.close();

        pedido.forEach((aa) -> System.out.println(aa));
    }
    
    public void mostrarHoy(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Pedido> p = em.createQuery("SELECT p FROM Pedido p WHERE fecha = :fecha and recogido=false", Pedido.class);
        p.setParameter("fecha", sqlDate);
        var pedido = p.getResultList();
        if(pedido != null){
        em.close();

        pedido.forEach((aa) -> System.out.println(aa));
        }else{
            System.out.println("No hay pedidos que mostrar.");
        }
    }

    public void mostrarCarta() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Carta> c = em.createQuery("SELECT c from Carta c", Carta.class);

        var carta = c.getResultList();
        em.close();

        carta.forEach((aa) -> System.out.println(aa));
    }

}
