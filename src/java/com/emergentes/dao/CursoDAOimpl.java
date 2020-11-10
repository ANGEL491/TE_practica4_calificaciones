package com.emergentes.dao;

import com.emergentes.modelo.Curso;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOimpl extends ConexionBD implements CursoDAO {

    @Override
    public void insert(Curso curso) throws Exception {
        try {
            //conectar a la bd
            this.conectar();
            //para relizar la consulta sql y almacenamos en ps
            String sql = "insert into curso(descripcion) values(?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //ahora pasamos los parametros de ps
            ps.setString(1, curso.getDescripcion());
            //ejecutar la consulta
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

    }

    @Override
    public void update(Curso curso) throws Exception {
        try {
            //conectar a la bd
            this.conectar();
            //para realizar la consulta sql y almacenar en ps
            String sql = "update curso set descripcion= ? where id_curso= ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //ahora pasamos los parametros de ps 
            ps.setString(1, curso.getDescripcion());
            ps.setInt(2, curso.getId_curso());
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
            String sql = "delete from curso where id_curso=?";
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
    public Curso getById(int id) throws Exception {
        Curso cur = new Curso();
        try {
            this.conectar();
            String sql = "select * from curso where id_curso=? limit 1";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //pasamos los datos
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            //verificamos si rs tiene registros
            if (rs.next()) {
                //obtenemos todos los datos
                cur.setId_curso(rs.getInt("id_curso"));
                cur.setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return cur;

    }

    @Override
    public List<Curso> getAll() throws Exception {
        List<Curso> lista = null;
        try {
            this.conectar();
            String sql = "select * from curso";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Curso>();
            while (rs.next()) {
                Curso cur = new Curso();
                //obtenemos los registros en est
                cur.setId_curso(rs.getInt("id_curso"));
                cur.setDescripcion(rs.getString("descripcion"));
                
                lista.add(cur);
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
