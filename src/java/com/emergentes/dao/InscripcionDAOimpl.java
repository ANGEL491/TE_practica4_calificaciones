package com.emergentes.dao;

import com.emergentes.modelo.Inscripcion;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InscripcionDAOimpl extends ConexionBD implements InscripcionDAO {

    @Override
    public void insert(Inscripcion inscripcion) throws Exception {

        try {
            //conectar a la bd
            this.conectar();
            //para relizar la consulta sql y almacenamos en ps
            String sql = "insert into inscripciones(id_estudiante,id_curso,nota_final) values(?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //ahora pasamos los parametros de ps
            ps.setInt(1, inscripcion.getId_estu());
            ps.setInt(2, inscripcion.getId_c());
            ps.setInt(3, inscripcion.getNota_final());
            //ejecutar la consulta
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Inscripcion inscripcion) throws Exception {
        try {
            //conectar a la bd
            this.conectar();
            //para realizar la consulta sql y almacenar en ps
            String sql = "update inscripciones set id_estudiante= ?,id_curso= ?,nota_final= ? where id_inscripcion= ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //ahora pasamos los parametros de ps 
            ps.setInt(1, inscripcion.getId_estu());
            ps.setInt(2, inscripcion.getId_c());
            ps.setInt(3, inscripcion.getNota_final());
            ps.setInt(4, inscripcion.getId_inscripcion());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from inscripciones where id_inscripcion=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

    }

    @Override
    public Inscripcion getById(int id) throws Exception {
        Inscripcion ins = new Inscripcion();
        try {
            this.conectar();
            String sql = "select * from inscripciones where id_inscripcion=? limit 1";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //pasamos los datos
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            //verificamos si rs tiene registros
            if (rs.next()) {
                //obtenemos todos los datos
                ins.setId_inscripcion(rs.getInt("id_inscripcion"));
                ins.setId_estu(rs.getInt("id_estudiante"));
                ins.setId_c(rs.getInt("id_curso"));
                ins.setNota_final(rs.getInt("nota_final"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return ins;

    }

    @Override
    public List<Inscripcion> getAll() throws Exception {
        List<Inscripcion> lista = null;
        try {
            this.conectar();
            String sql = "select * from inscripciones";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Inscripcion>();
            while (rs.next()) {
                Inscripcion ins = new Inscripcion();
                //obtenemos los registros en
                ins.setId_inscripcion(rs.getInt("id_inscripcion"));
                ins.setId_estu(rs.getInt("id_estudiante"));
                ins.setId_c(rs.getInt("id_curso"));
                ins.setNota_final(rs.getInt("nota_final"));

                lista.add(ins);
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
