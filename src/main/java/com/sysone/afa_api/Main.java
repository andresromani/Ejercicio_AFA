package com.sysone.afa_api;

import com.DTOs.EquipoDTO;
import com.DTOs.HistorialDTO;
import com.DTOs.JugadorDTO;
import com.exception.ServiceException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import com.services.EquipoServiceImpl;
import com.services.HistorialServiceImpl;
import com.services.JugadorServiceImpl;
import com.model.Posicion;

public class Main {
    
    public static void main(String[] args) throws ServiceException {
        Scanner sc = new Scanner(System.in);
        
//        Services
        EquipoServiceImpl eservice = new EquipoServiceImpl();
        JugadorServiceImpl jservice = new JugadorServiceImpl();
        HistorialServiceImpl hservice = new HistorialServiceImpl();
        
//        LISTAR POR ID

//        Equipo
//        System.out.println(eservice.listarPorCuit(12345678));

//        Jugadores
//        System.out.println(jservice.listarPorDNI(147852));

//        Historiales
//        hservice.listarPorDNI(123456).forEach(System.out::println);
//        System.out.println("");
//        hservice.listarPorCUIT(12345678).forEach(System.out::println);


//        LISTAR

//        Equipos
        List<EquipoDTO> listado_equipos = eservice.listar();
//        eservice.listar().forEach(System.out::println);

//        Jugadores
        List<JugadorDTO> listado_jugadores = jservice.listar();
//        jservice.listar().forEach(System.out::println);


//        INSERTAR

//        Equipo
//        EquipoDTO edto = new EquipoDTO();
//        System.out.println("\nInsertar nuevo equipo:");
//        System.out.print("CUIT: ");
//        edto.setCuit(sc.nextInt());
//        System.out.print("Nombre: ");
//        sc.nextLine();
//        edto.setNombre(sc.nextLine());
//        System.out.print("Categoría actual: ");
//        edto.setCategoria_actual(sc.next());
//        System.out.println(eservice.insertar(edto));

//        Jugadores
//        JugadorDTO jdto = new JugadorDTO();
//        System.out.println("\nInsertar nuevo jugador:");
//        System.out.print("DNI: ");
//        jdto.setDni(sc.nextInt());
//        System.out.print("Nombre: ");
//        sc.nextLine();
//        jdto.setNombre(sc.nextLine());
//        System.out.print("Apellido: ");
//        jdto.setApellido(sc.nextLine());
//        System.out.println(jservice.insertar(jdto));

//        Historial
//        HistorialDTO hdto = new HistorialDTO();
//        hdto.setDni_jugador(147852);
//        hdto.setCuit_equipo(18293827);
//        hdto.setFecha_inicio(LocalDate.of(2014, 4, 17));
//        hdto.setFecha_fin(LocalDate.of(2016, 4, 16));
//        hdto.setPosicion_jugador(Posicion.DEFENSOR);
//        System.out.println(hservice.insertar(hdto));
////        System.out.println(hservice.listarPorCUIT(87654321));


//        EDITAR

//        Equipo
//        EquipoDTO edtoEdit = eservice.listarPorCuit(18293827);
//        edtoEdit.setNombre("Rosario Central");
//        System.out.println(eservice.editar(edtoEdit));

//        Jugadores
//        JugadorDTO jdtoEdit = jservice.listarPorDNI(111213);
//        jdtoEdit.setNombre("Pablo Daniel");
//        System.out.println(jservice.editar(jdtoEdit));

//        Historial
//        List<HistorialDTO> listado_historiales_edit = hservice.listarPorDNI(147852);
//        listado_historiales_edit.get(1).setFecha_fin(LocalDate.of(2018, 1, 1));
//        System.out.println(hservice.editar(listado_historiales_edit.get(1)));

//        ELIMINAR

//        Equipo
//        System.out.println(eservice.delete(78458754));

//        Jugadores
//        System.out.println(jservice.delete(111213));

        

//        Agregar jugadores a cada equipo según su historial
        listado_equipos.forEach(e -> {
            e.setListado_jugadores(new ArrayList());
            listado_jugadores.forEach(j -> {
                if (j.getListado_historiales() != null) {
                    j.getListado_historiales().forEach(h -> {
                        if (h.getCuit_equipo().equals(e.getCuit())) {
                            e.agregarJugador(j);
                        }
                    });
                }
            });
        });
        
//        Cuantos jugadores tiene cada equipo? Ordenados alfabéticamente los equipos
        Collections.sort(listado_equipos, (EquipoDTO e1, EquipoDTO e2) -> e1.getNombre().compareTo(e2.getNombre()));
        listado_equipos.forEach(e -> {
            List<JugadorDTO> listado = eservice.contarJugadoresPorEquipo(e);
            if (listado != null && listado.size() > 0) {
                System.out.println("\n" + e.getNombre() + " tiene " + listado.size() + " jugadores:");
                listado.forEach(System.out::println);
            }
        });
        
//        Cuántos defensores tiene cada equipo?        
        listado_equipos.forEach(e -> {
            List<JugadorDTO> listado = eservice.contarJugadorPorPosicion(e, Posicion.DEFENSOR);
            if (listado != null && listado.size() > 0) {
                System.out.println("\n" + e.getNombre() + " tiene " + listado.size() + " defensores:");
                listado.forEach(System.out::println);
            }
        });
        
//        Cuantos jugadores jugaron durante una fecha
        listado_equipos.forEach(e -> {
            LocalDate fecha = LocalDate.of(2019, 1, 1);
            List<JugadorDTO> listado = eservice.cuantosJugadoresJugabanDuranteUnaFecha(e, fecha);
            if (listado != null && listado.size() > 0) {
                System.out.println("\nDurante " + fecha + " jugaron " + listado.size() + " jugadores en " + e.getNombre() + ":");
                listado.forEach(System.out::println);
            }
        });
    }
    
}
