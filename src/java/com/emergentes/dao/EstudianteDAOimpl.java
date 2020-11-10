package com.emergentes.dao;

import com.emergentes.modelo.Estudiante;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*se crea la implementacion de la inteface, al mismo tiempo la clase 
hereda se hereda de ConexionBD*/
public class EstudianteDAOimpl extends ConexionBD implements EstudianteDAO {

    // metodo para insertar un registro
    @Override
    public void insert(Estudiante estudiante) throws Exception {

        try {
            //conectar a la bd
            this.conectar();
            //para relizar la consulta sql y almacenamos en ps
            String sql = "insert into estudiantes(nombre,apellidos,correo) values(?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //ahora pasamos los parametros de ps
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getCorreo());
            //ejecutar la consulta
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Estudiante estudiante) throws Exception {
        try {
            //conectar a la bd
            this.conectar();
            //para realizar la consulta sql y almacenar en ps
            String sql = "update estudiantes set nombre= ?,apellidos= ?,correo= ? where id_estudiante= ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //ahora pasamos los parametros de ps 
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getCorreo());
            ps.setInt(4, estudiante.getId_estudiante());
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
            String sql = "delete from estudiantes where id_estudiante=?";
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
    public Estudiante getById(int id) throws Exception {
        Estudiante est = new Estudiante();
        try {
            this.conectar();
            String sql = "select * from estudiantes where id_estudiante=? limit 1";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //pasamos los datos
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            //verificamos si rs tiene registros
            if (rs.next()) {
                //obtenemos todos los datos
                est.setId_estudiante(rs.getInt("id_estudiante"));
                est.setNombre(rs.getString("nombre"));
                est.setApellidos(rs.getString("apellidos"));
                est.setCorreo(rs.getString("correo"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return est;
    }

    @Override
    public List<Estudiante> getAll() throws Exception {

        List<Estudiante> lista = null;
        try {
            this.conectar();
            String sql = "select * from estudiantes";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Estudiante>();
            System.out.println("kkk :"+lista);
            while (rs.next()) {
                Estudiante est = new Estudiante();
                //obtenemos los registros en est
                est.setId_estudiante(rs.getInt("id_estudiante"));
                est.setNombre(rs.getString("nombre"));
                est.setApellidos(rs.getString("apellidos"));
                est.setCorreo(rs.getString("correo"));
                lista.add(est);
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
