package com.example.PapeleriaQuizzArqui.Service;

import com.example.PapeleriaQuizzArqui.Model.Empleado;
import com.example.PapeleriaQuizzArqui.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll();
    }

    public Empleado obtenerPorId(Integer id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + id));
    }

    public Empleado guardar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado actualizar(Integer id, Empleado empleadoActualizado) {
        Empleado empleadoExistente = obtenerPorId(id);
        empleadoExistente.setNombre(empleadoActualizado.getNombre());
        empleadoExistente.setCargo(empleadoActualizado.getCargo());

        return empleadoRepository.save(empleadoExistente);
    }

    public void eliminar(Integer id) {
        empleadoRepository.deleteById(id);
    }
}
