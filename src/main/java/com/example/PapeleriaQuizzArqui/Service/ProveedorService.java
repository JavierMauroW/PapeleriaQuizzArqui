package com.example.PapeleriaQuizzArqui.Service;

import com.example.PapeleriaQuizzArqui.Model.Proveedor;
import com.example.PapeleriaQuizzArqui.Repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> obtenerTodos() {
        return proveedorRepository.findAll();
    }

    public Proveedor obtenerPorId(Integer id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con ID: " + id));
    }

    public Proveedor guardar(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor actualizar(Integer id, Proveedor proveedorActualizado) {
        Proveedor proveedorExistente = obtenerPorId(id);
        proveedorExistente.setNombre(proveedorActualizado.getNombre());
        proveedorExistente.setTelefono(proveedorActualizado.getTelefono());
        proveedorExistente.setCorreo(proveedorActualizado.getCorreo());
        return proveedorRepository.save(proveedorExistente);
    }

    public void eliminar(Integer id) {
        proveedorRepository.deleteById(id);
    }
}
