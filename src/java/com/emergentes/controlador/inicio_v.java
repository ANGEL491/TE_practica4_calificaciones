package com.emergentes.controlador;

import com.emergentes.dao.VistaDAO;
import com.emergentes.dao.VistaDAOimpl;
import com.emergentes.modelo.Vista;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "inicio_v", urlPatterns = {"/inicio_v"})
public class inicio_v extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            VistaDAO dao = new VistaDAOimpl();
            
            String action ="view";
            switch (action) {
                
                case "view":
                    List<Vista> lista = dao.getAll();
                    request.setAttribute("vistas", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
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
        
    }

}
