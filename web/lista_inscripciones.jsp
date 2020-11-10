<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Inscritos</h1>
        <p><a href="inicio_ins?action=add">Nueva inscripcion</a></p>
        <table border="1" cellspacing="4" cellpadding="3">
            <tr>
                <th>Id inscripcion</th>
                <th>Id estudiante</th>
                <th>Id curso</th>
                <th>Nota Final</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${inscripciones}">
                <tr>
                    <td>${item.id_inscripcion}</td>
                    <td>${item.id_estu}</td>
                    <td>${item.id_c}</td>
                    <td>${item.nota_final}</td>
                    <td><a href="inicio_ins?action=edit&id_inscripcion=${item.id_inscripcion}">Editar</a></td>
                    <td><a href="inicio_ins?action=delete&id_inscripcion=${item.id_inscripcion}"
                           onclick="return(confirm('Esta seguro'))">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
