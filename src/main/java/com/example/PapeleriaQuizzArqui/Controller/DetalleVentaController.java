package com.example.PapeleriaQuizzArqui.Controller;

import com.example.PapeleriaQuizzArqui.Model.DetalleVenta;
import com.example.PapeleriaQuizzArqui.Service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/detalles")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    public List<DetalleVenta> obtenerTodos() {
        return detalleVentaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> obtenerPorId(@PathVariable Integer id) {
        DetalleVenta detalle = detalleVentaService.obtenerPorId(id);
        return ResponseEntity.ok(detalle);
    }

    @PostMapping
    public ResponseEntity<DetalleVenta> crearDetalle(@RequestBody DetalleVenta detalle) {
        DetalleVenta nuevo = detalleVentaService.guardar(detalle);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleVenta> actualizarDetalle(@PathVariable Integer id, @RequestBody DetalleVenta detalle) {
        DetalleVenta actualizado = detalleVentaService.actualizar(id, detalle);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalle(@PathVariable Integer id) {
        detalleVentaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Map<String, Object>>> obtenerClientesConDetalleVenta() {
        List<Map<String, Object>> resultados = detalleVentaService.obtenerClientesConDetalleVenta();
        return ResponseEntity.ok(resultados);
    }
}
