package com.example.PapeleriaQuizzArqui.Service;

import com.example.PapeleriaQuizzArqui.Model.Venta;
import com.example.PapeleriaQuizzArqui.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> obtenerTodas() {
        return ventaRepository.findAll();
    }

    public Venta obtenerPorId(Integer id) {
        return ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + id));
    }

    public Venta guardar(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Venta actualizar(Integer id, Venta ventaActualizada) {
        Venta ventaExistente = obtenerPorId(id);
        ventaExistente.setFecha(ventaActualizada.getFecha());
        ventaExistente.setCliente(ventaActualizada.getCliente());
        ventaExistente.setEmpleado(ventaActualizada.getEmpleado());
        // No se actualizan directamente los detalles aquí
        return ventaRepository.save(ventaExistente);
    }

    public void eliminar(Integer id) {
        ventaRepository.deleteById(id);
    }

    public List<Map<String, Object>> obtenerVentasConClientePorEmpleado(Integer empleadoId) {
        return ventaRepository.ventasConClientePorEmpleado(empleadoId);
    }
    public List<Map<String, Object>> obtenerVentasPorEmpleadoYFecha(Integer empleadoId, String fechaInicio, String fechaFin) {
        return ventaRepository.listarVentasPorEmpleadoYFecha(empleadoId, fechaInicio, fechaFin);
    }
}
