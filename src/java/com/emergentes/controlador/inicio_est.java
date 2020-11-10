package com.emergentes.controlador;

import com.emergentes.dao.EstudianteDAO;
import com.emergentes.dao.EstudianteDAOimpl;
import com.emergentes.modelo.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "inicio_est", urlPatterns = {"/inicio_est"})
public class inicio_est extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            EstudianteDAO dao = new EstudianteDAOimpl();
            int id_estudiante;
            Estudiante est = new Estudiante();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("estudiante", est);
                    request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                    break;
                case "edit":
                    id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
                    est = dao.getById(id_estudiante);
                    System.out.println("aqui!!" + est);

                    request.setAttribute("estudiante", est);
                    request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                    break;
                case "delete":
                    id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
                    dao.delete(id_estudiante);
                    response.sendRedirect(request.getContextPath() + "/inicio_est");
                    break;
                case "view":
                    List<Estudiante> lista = dao.getAll();
                    request.setAttribute("estudiantes", lista);
                    request.getRequestDispatcher("lista_estudiantes.jsp").forward(request, response);
                    break;

                default:
                    break;

            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String correo = request.getParameter("correo");

        Estudiante est = new Estudiante();
        est.setId_estudiante(id_estudiante);
        est.setNombre(nombre);
        est.setApellidos(apellidos);
        est.setCorreo(correo);
        if (id_estudiante == 0) {
            try {
                EstudianteDAO dao = new EstudianteDAOimpl();
                dao.insert(est);
                response.sendRedirect(request.getContextPath() + "/inicio_est");
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        } else {
            try {
                EstudianteDAO dao = new EstudianteDAOimpl();
                dao.update(est);
                response.sendRedirect(request.getContextPath() + "/inicio_est");
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }
    }
}
