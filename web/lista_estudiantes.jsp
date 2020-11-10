<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de estudiantes</h1>
        <p><a href="inicio_est?action=add">Nuevo Estudiante</a></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Correo</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${estudiantes}">
                <tr>
                    <td>${item.id_estudiante}</td>
                    <td>${item.nombre}</td>
                    <td>${item.apellidos}</td>
                    <td>${item.correo}</td>
                    <td><a href="inicio_est?action=edit&id_estudiante=${item.id_estudiante}">Editar</a></td>
                    <td><a href="inicio_est?action=delete&id_estudiante=${item.id_estudiante}"
                           onclick="return(confirm('Esta seguro'))">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
