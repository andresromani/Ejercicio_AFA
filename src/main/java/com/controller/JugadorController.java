package com.controller;

import com.DTOs.JugadorDTO;
import com.exception.ServiceException;
import com.services.JugadorServiceImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JugadorController extends HttpServlet {

    JugadorServiceImpl jservice = new JugadorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        String dniStr = req.getParameter("dni");
        JugadorDTO jdto = new JugadorDTO();
        List<JugadorDTO> listado_jugadores = new ArrayList();

        if (dniStr != null) {
            Integer dni = Integer.parseInt(dniStr);
            try {
                jdto = jservice.listarPorDNI(dni);
            } catch (ServiceException ex) {
                out.print(ex.getMessage());
            }
        } else {
            try {
                listado_jugadores = jservice.listar();
            } catch (ServiceException ex) {
                out.println(ex.getMessage());
            }
        }

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Jugadores</title>");
        out.println("</head>");
        out.println("<body>"
                + "<table border=\"1\">");
        out.println(
                "<tr>"
                + "<th>DNI</th>"
                + "<th>Nombre</th>"
                + "<th>Apellido</th>"
                + "</tr>");
        if (listado_jugadores != null & listado_jugadores.size() > 0) {
            listado_jugadores.forEach(j -> {
                out.println("<tr>");
                out.println("<td>" + j.getDni() + "</td>");
                out.println("<td>" + j.getNombre() + "</td>");
                out.println("<td>" + j.getApellido() + "</td>");
                out.println("</tr>");
            });
        } else {
            out.println("<tr>");
            out.println("<td>" + jdto.getDni() + "</td>");
            out.println("<td>" + jdto.getNombre() + "</td>");
            out.println("<td>" + jdto.getApellido() + "</td>");
            out.println("</tr>");
        }
        out.println("<table>"
                + "</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer dni = Integer.parseInt(req.getParameter("dni"));
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");

        JugadorDTO j = new JugadorDTO();
        j.setDni(dni);
        j.setNombre(nombre);
        j.setApellido(apellido);

        PrintWriter out = resp.getWriter();

        try {
            jservice.insertar(j);

            out.println("<h3>Jugador insertado</h3>");
            out.println(dni);
            out.println(nombre);
            out.println(apellido);
        } catch (ServiceException ex) {
            out.println(ex.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));

        String data = br.readLine();

        PrintWriter out = resp.getWriter();

        String[] datos = data.split("&");

        Integer dni = Integer.parseInt(datos[0].split("=")[1]);
        String nombre = datos[1].split("=")[1];
        String apellido = datos[2].split("=")[1];

        JugadorDTO j = new JugadorDTO();
        j.setDni(dni);
        j.setNombre(nombre);
        j.setApellido(apellido);

        try {
            jservice.editar(j);

            out.println("<h3>Jugador editado</h3>");
            out.println(dni);
            out.println(nombre);
            out.println(apellido);
        } catch (ServiceException ex) {
            out.println(ex.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));

        String data = br.readLine();

        PrintWriter out = resp.getWriter();

        String[] datos = data.split("&");

        Integer dni = Integer.parseInt(datos[0].split("=")[1]);

        try {
            jservice.delete(dni);
            out.println("<h3>Recurso eliminado</h3>");
        } catch (ServiceException ex) {
            out.println(ex.getMessage());
        }
    }

}
