package com.example.PapeleriaQuizzArqui.Model;


import jakarta.persistence.*;

@Entity
public class Proovedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProovedor;

    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;

    public Proovedor() {}

    public Proovedor(String nombre, String telefono, String correo, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    public int getIdProovedor() { return idProovedor; }
    public void setIdProovedor(int idProveedor) { this.idProovedor = idProveedor; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    @Override
    public String toString() {
        return "Proveedor{" +
                "idProovedorr=" + idProovedor +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
