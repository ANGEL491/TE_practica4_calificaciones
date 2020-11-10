package com.emergentes.dao;

import com.emergentes.modelo.Vista;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VistaDAOimpl extends ConexionBD implements VistaDAO {

    @Override
    public List<Vista> getAll() throws Exception {
        List<Vista> lista = null;
        String sql = "select e.nombre,e.apellidos,e.correo,c.descripcion,i.nota_final\n"
                + "    from inscripciones i left join estudiantes e on\n"
                + "    i.id_estudiante=e.id_estudiante left join curso c on\n"
                + "    i.id_curso=c.id_curso";
        System.out.println(sql);
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Vista>();

            while (rs.next()) {
                Vista v = new Vista();
                //obtenemos los registros en est
                v.setNombre(rs.getString("nombre"));
                v.setApellidos(rs.getString("apellidos"));
                v.setCorreo(rs.getString("correo"));
                v.setDescripcion(rs.getString("descripcion"));
                v.setNota_final(rs.getInt("nota_final"));
                lista.add(v);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

}
