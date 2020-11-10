<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><c:if test="${inscripcion.id_inscripcion==0}">Nueva</c:if>
            <c:if test="${inscripcion.id_inscripcion!=0}">Editar</c:if>
                Inscripcion
            </h1>
            <form action="inicio_ins" method="post">
                <input type="hidden" name="id_inscripcion" value="${inscripcion.id_inscripcion}">
            <table>
                <tr>
                    <td>Id estudiante</td>
                    <td><input type="number" name="id_estu" value="${inscripcion.id_estu}"></td>
                </tr>
                <tr>
                    <td>Id Curso</td>
                    <td><input type="number" name="id_c" value="${inscripcion.id_c}"></td>
                </tr>
                <tr>
                    <td>Nota Final</td>
                    <td><input type="number" name="nota_final" value="${inscripcion.nota_final}"></td>
                </tr>
                <tr>
                    <td>Id estudiante</td>
                    <td><input type="submit" value="Guardar"></td>
                </tr>
            </table>
        </form>


    </body>
</html>
