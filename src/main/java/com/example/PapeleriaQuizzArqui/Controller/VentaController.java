package com.example.PapeleriaQuizzArqui.Controller;

import com.example.PapeleriaQuizzArqui.Model.Venta;
import com.example.PapeleriaQuizzArqui.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> obtenerTodas() {
        return ventaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerPorId(@PathVariable Integer id) {
        Venta venta = ventaService.obtenerPorId(id);
        return ResponseEntity.ok(venta);
    }

    @PostMapping
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta venta) {
        Venta nuevaVenta = ventaService.guardar(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable Integer id, @RequestBody Venta venta) {
        Venta actualizada = ventaService.actualizar(id, venta);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Integer id) {
        ventaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/empleado/{id}/ventas-clientes")
    public ResponseEntity<List<Map<String, Object>>> obtenerVentasConCliente(@PathVariable Integer id) {
        List<Map<String, Object>> resultados = ventaService.obtenerVentasConClientePorEmpleado(id);
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/empleado/{id}/rango-fechas")
    public ResponseEntity<List<Map<String, Object>>> obtenerVentasPorEmpleadoYFecha(
            @PathVariable Integer id,
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin
    ) {
        List<Map<String, Object>> resultados = ventaService.obtenerVentasPorEmpleadoYFecha(id, fechaInicio, fechaFin);
        return ResponseEntity.ok(resultados);
    }

}
