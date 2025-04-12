package com.example.PapeleriaQuizzArqui.Repository;

import com.example.PapeleriaQuizzArqui.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

    @Query(value = """
        SELECT 
            v.id_venta,
            v.fecha,
            c.nombre AS cliente_nombre,
            c.correo AS cliente_correo
        FROM venta v
        INNER JOIN cliente c ON v.cliente_id = c.id_cliente
        WHERE v.empleado_id = :empleadoId
        """, nativeQuery = true)
    List<Map<String, Object>> ventasConClientePorEmpleado(@Param("empleadoId") Integer empleadoId);



    @Query(value = """
        SELECT 
            v.id_venta,
            v.fecha,
            e.nombre AS empleado_nombre,
            c.nombre AS cliente_nombre,
            c.correo AS cliente_correo
        FROM venta v
        INNER JOIN empleado e ON v.empleado_id = e.id_empleado
        INNER JOIN cliente c ON v.cliente_id = c.id_cliente
        WHERE v.empleado_id = :empleadoId
        AND v.fecha BETWEEN :fechaInicio AND :fechaFin
        ORDER BY v.fecha
        """, nativeQuery = true)
    List<Map<String, Object>> listarVentasPorEmpleadoYFecha(
            @Param("empleadoId") Integer empleadoId,
            @Param("fechaInicio") String fechaInicio,
            @Param("fechaFin") String fechaFin
    );

}
