package com.example.PapeleriaQuizzArqui.Service;

import com.example.PapeleriaQuizzArqui.Model.Cliente;
import com.example.PapeleriaQuizzArqui.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    public Cliente obtenerPorId(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente actualizar(Integer id, Cliente clienteActualizado) {
        Cliente clienteExistente = obtenerPorId(id);
        clienteExistente.setNombre(clienteActualizado.getNombre());
        clienteExistente.setCedula(clienteActualizado.getCedula());
        clienteExistente.setTelefono(clienteActualizado.getTelefono());
        clienteExistente.setCorreo(clienteActualizado.getCorreo());
        return clienteRepository.save(clienteExistente);
    }

    public void eliminar(Integer id) {
        clienteRepository.deleteById(id);
    }
}
