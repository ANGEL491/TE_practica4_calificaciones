package com.emergentes.controlador;

import com.emergentes.dao.CursoDAO;
import com.emergentes.dao.CursoDAOimpl;
import com.emergentes.modelo.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "inicio_cur", urlPatterns = {"/inicio_cur"})
public class inicio_cur extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            CursoDAO dao = new CursoDAOimpl();
            int id_curso;
            Curso cur = new Curso();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("curso", cur);
                    request.getRequestDispatcher("frmcurso.jsp").forward(request, response);
                    break;
                case "edit":
                    id_curso = Integer.parseInt(request.getParameter("id_curso"));
                    cur = dao.getById(id_curso);
                    System.out.println("aqui!!" + cur);

                    request.setAttribute("curso", cur);
                    request.getRequestDispatcher("frmcurso.jsp").forward(request, response);
                    break;
                case "delete":
                    id_curso = Integer.parseInt(request.getParameter("id_curso"));
                    dao.delete(id_curso);
                    response.sendRedirect(request.getContextPath() + "/inicio_cur");
                    break;
                case "view":
                    List<Curso> lista = dao.getAll();
                    request.setAttribute("cursos", lista);
                    request.getRequestDispatcher("lista_cursos.jsp").forward(request, response);

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
        int id_curso = Integer.parseInt(request.getParameter("id_curso"));
        String descripcion = request.getParameter("descripcion");

        Curso cur = new Curso();
        cur.setId_curso(id_curso);
        cur.setDescripcion(descripcion);

        if (id_curso == 0) {
            try {
                CursoDAO dao = new CursoDAOimpl();
                dao.insert(cur);
                response.sendRedirect(request.getContextPath() + "/inicio_cur");
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        } else {
            try {
                CursoDAO dao = new CursoDAOimpl();
                dao.update(cur);
                response.sendRedirect(request.getContextPath() + "/inicio_cur");
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }
    }

}
