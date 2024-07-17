package com.alura.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreAutor;
    private Integer fechaDeNacimiento;
    private Integer fechaDeFallecimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libro_id")
    private Libro libro;

    public Autor() {}

    public Autor(DatosAutor datosAutor) {
        this.nombreAutor = datosAutor.nombre();
        this.fechaDeNacimiento = datosAutor.fechaNacimiento();
        this.fechaDeFallecimiento = datosAutor.fechaFallecimiento();
    }

    public Autor(String nombreAutor, Integer fechaDeNacimiento, Integer fechaDeFallecimiento) {
        this.nombreAutor = nombreAutor;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.fechaDeFallecimiento = fechaDeFallecimiento;
    }

    @Override
    public String toString() {
        return "*********** Autor ***********\n" +
                "Nombre: " + nombreAutor + "\n" +
                "Año de nac: " + fechaDeNacimiento + "\n" +
                "Año de deceso: " + fechaDeFallecimiento + "\n" +
                "Libro: " + libro + "\n";
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public Integer getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Integer fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getFechaDeFallecimiento() {
        return fechaDeFallecimiento;
    }

    public void setFechaDeFallecimiento(Integer fechaDeFallecimiento) {
        this.fechaDeFallecimiento = fechaDeFallecimiento;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}