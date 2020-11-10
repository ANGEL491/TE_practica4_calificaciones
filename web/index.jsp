<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Calificación de estudiantes</h1>
        <p><a href="inicio_est">Lista de Estudiantes</a></p>
        <p><a href="inicio_cur">Cursos</a></p>
        <p><a href="inicio_ins">Lista de Inscripciones</a></p>


        <h1>Lista de estudiantes inscritos</h1>
        <table border="1" cellspacing="4" cellpadding="3">
            <tr>
                <th align="center">Nombre</th>
                <th align="center">Apellidos</th>
                <th align="center">Correo</th>
                <th align="center">Descripcion</th>
                <th align="center">Nota Final</th>

            </tr>
            <c:forEach var="item" items="${vistas}">
                <tr>
                    <td align="center">${item.nombre}</td>
                    <td align="center">${item.apellidos}</td>
                    <td align="center">${item.correo}</td>
                    <td align="center">${item.descripcion}</td>
                    <td align="center">${item.nota_final}</td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
