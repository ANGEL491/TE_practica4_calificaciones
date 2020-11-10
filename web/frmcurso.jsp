
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><c:if test="${curso.id_curso == 0}">Nuevo</c:if>
            <c:if test="${curso.id_curso != 0}">Editar</c:if>
                Curso
            </h1>
            <form action="inicio_cur" method="post">
                <input type="hidden" name="id_curso" value="${curso.id_curso}">
            <table>
                <tr>
                    <td>Descripción : </td>
                    <td><input type="text" name="descripcion" value="${curso.descripcion}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Registrar"></td>
                </tr>
            </table>
        </form>

    </body>
</html>
