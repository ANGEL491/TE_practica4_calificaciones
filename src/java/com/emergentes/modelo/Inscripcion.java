package com.emergentes.modelo;

public class Inscripcion {
private int id_inscripcion ;
private int id_estu ;
private int id_c ;
private int nota_final;

    public int getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(int id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public int getId_estu() {
        return id_estu;
    }

    public void setId_estu(int id_estu) {
        this.id_estu = id_estu;
    }

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public int getNota_final() {
        return nota_final;
    }

    public void setNota_final(int nota_final) {
        this.nota_final = nota_final;
    }

}
