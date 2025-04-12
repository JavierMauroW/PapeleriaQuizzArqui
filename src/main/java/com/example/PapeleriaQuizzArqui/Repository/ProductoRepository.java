package com.example.PapeleriaQuizzArqui.Repository;

import com.example.PapeleriaQuizzArqui.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {



    @Query(value = """
        SELECT 
            p.id_producto,
            p.nombre,
            p.precio,
            p.stock,
            pr.nombre AS proveedor_nombre,
            pr.correo AS proveedor_correo
        FROM producto p
        INNER JOIN proveedor pr ON p.proveedor_id = pr.id_proveedor
        WHERE p.proveedor_id = :proveedorId
        """, nativeQuery = true)
    List<Map<String, Object>> listarProductosPorProveedor(@Param("proveedorId") Integer proveedorId);

}