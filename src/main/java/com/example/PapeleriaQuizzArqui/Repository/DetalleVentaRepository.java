package com.example.PapeleriaQuizzArqui.Repository;

import com.example.PapeleriaQuizzArqui.Model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {



    @Query(value = """
        SELECT 
            c.id_cliente,
            c.nombre AS cliente_nombre,
            c.correo AS cliente_correo,
            v.id_venta,
            v.fecha,
            p.nombre AS producto_nombre,
            dv.cantidad,
            dv.subtotal
        FROM cliente c
        INNER JOIN venta v ON c.id_cliente = v.cliente_id
        INNER JOIN detalle_venta dv ON v.id_venta = dv.venta_id
        INNER JOIN producto p ON dv.producto_id = p.id_producto
        ORDER BY c.id_cliente, v.id_venta
        """, nativeQuery = true)
    List<Map<String, Object>> listarClientesConDetalleVenta();

}