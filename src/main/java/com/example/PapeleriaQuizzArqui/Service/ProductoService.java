package com.example.PapeleriaQuizzArqui.Service;

import com.example.PapeleriaQuizzArqui.Model.Producto;
import com.example.PapeleriaQuizzArqui.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Producto obtenerPorId(Integer id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizar(Integer id, Producto productoActualizado) {
        Producto productoExistente = obtenerPorId(id);
        productoExistente.setNombre(productoActualizado.getNombre());
        productoExistente.setDescripcion(productoActualizado.getDescripcion());
        productoExistente.setPrecio(productoActualizado.getPrecio());
        productoExistente.setStock(productoActualizado.getStock());
        productoExistente.setProveedor(productoActualizado.getProveedor());
        return productoRepository.save(productoExistente);
    }

    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }


    public List<Map<String, Object>> obtenerProductosPorProveedor(Integer proveedorId) {
        return productoRepository.listarProductosPorProveedor(proveedorId);
    }
}
