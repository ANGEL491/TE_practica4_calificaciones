<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Cursos</h1>
        <p><a href="inicio_cur?action=add">Nuevo Curso</a></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Descripción</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${cursos}">
                <tr>
                    <td>${item.id_curso}</td>
                    <td>${item.descripcion}</td>
                    <td><a href="inicio_cur?action=edit&id_curso=${item.id_curso}">Editar</a></td>
                    <td><a href="inicio_cur?action=delete&id_curso=${item.id_curso}"
                           onclick="return(confirm('Esta seguro'))">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
