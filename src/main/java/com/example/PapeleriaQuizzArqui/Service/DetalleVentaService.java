package com.example.PapeleriaQuizzArqui.Service;

import com.example.PapeleriaQuizzArqui.Model.DetalleVenta;
import com.example.PapeleriaQuizzArqui.Repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public List<DetalleVenta> obtenerTodos() {
        return detalleVentaRepository.findAll();
    }

    public DetalleVenta obtenerPorId(Integer id) {
        return detalleVentaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleVenta no encontrado con ID: " + id));
    }

    public DetalleVenta guardar(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    public DetalleVenta actualizar(Integer id, DetalleVenta detalleActualizado) {
        DetalleVenta existente = obtenerPorId(id);
        existente.setVenta(detalleActualizado.getVenta());
        existente.setProducto(detalleActualizado.getProducto());
        existente.setCantidad(detalleActualizado.getCantidad());
        existente.setPrecioUnitario(detalleActualizado.getPrecioUnitario());

        return detalleVentaRepository.save(existente);
    }

    public void eliminar(Integer id) {
        detalleVentaRepository.deleteById(id);
    }

    public List<Map<String, Object>> obtenerClientesConDetalleVenta() {
        return detalleVentaRepository.listarClientesConDetalleVenta();
    }
}
