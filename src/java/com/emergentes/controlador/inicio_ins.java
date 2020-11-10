package com.emergentes.controlador;

import com.emergentes.dao.InscripcionDAO;
import com.emergentes.dao.InscripcionDAOimpl;
import com.emergentes.modelo.Inscripcion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "inicio_ins", urlPatterns = {"/inicio_ins"})
public class inicio_ins extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            InscripcionDAO dao = new InscripcionDAOimpl();
            int id_inscripcion;
            Inscripcion ins = new Inscripcion();
            String action = "view";
            action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("inscripcion", ins);
                    request.getRequestDispatcher("frminscripcion.jsp").forward(request, response);
                    break;
                case "edit":
                    id_inscripcion = Integer.parseInt(request.getParameter("id_inscripcion"));
                    ins = dao.getById(id_inscripcion);
                    System.out.println("aqui!!" + ins);

                    request.setAttribute("inscripcion", ins);
                    request.getRequestDispatcher("frminscripcion.jsp").forward(request, response);
                    break;
                case "delete":
                    id_inscripcion = Integer.parseInt(request.getParameter("id_inscripcion"));
                    dao.delete(id_inscripcion);
                    response.sendRedirect(request.getContextPath() + "/inicio_ins");
                    break;
                case "view":
                    List<Inscripcion> lista = dao.getAll();
                    request.setAttribute("inscripciones", lista);
                    request.getRequestDispatcher("lista_inscripciones.jsp").forward(request, response);
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

        int id_inscripcion = Integer.parseInt(request.getParameter("id_inscripcion"));
        int id_estu = Integer.parseInt(request.getParameter("id_estu"));
        int id_c = Integer.parseInt(request.getParameter("id_c"));
        int nota_final = Integer.parseInt(request.getParameter("nota_final"));

        Inscripcion ins = new Inscripcion();
        ins.setId_inscripcion(id_inscripcion);
        ins.setId_estu(id_estu);
        ins.setId_c(id_c);
        ins.setNota_final(nota_final);
        if (id_inscripcion == 0) {
            try {
                InscripcionDAO dao = new InscripcionDAOimpl();
                dao.insert(ins);
                response.sendRedirect(request.getContextPath() + "/inicio_ins");
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        } else {
            try {
                InscripcionDAO dao = new InscripcionDAOimpl();
                dao.update(ins);
                response.sendRedirect(request.getContextPath() + "/inicio_ins");
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }
    }

}
