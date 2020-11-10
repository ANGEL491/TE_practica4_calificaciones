package com.emergentes.dao;

import com.emergentes.modelo.Estudiante;
import java.util.List;

public interface EstudianteDAO {

    //metodos de la interface crud (create, read,update ,delete)
    //creamos los metodos que lanzaran un (THROWS) en caso de existir una(excepcion)error 
    public void insert(Estudiante estudiante) throws Exception;

    public void update(Estudiante estudiante) throws Exception;

    public void delete(int id) throws Exception;

    public Estudiante getById(int id) throws Exception;

    //metodo que devuelve una coleccion de tipo estudiante
    public List<Estudiante> getAll() throws Exception;
}
/*se crea la interfaz para implemetar el crud de la tabla estudiante 
   luego vamos a implemetar la interface creando la clase EsdianteDAOimpl*/
