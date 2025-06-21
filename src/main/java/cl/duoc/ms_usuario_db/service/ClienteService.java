package cl.duoc.ms_usuario_db.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import cl.duoc.ms_usuario_db.model.dto.ClienteDTO;
import cl.duoc.ms_usuario_db.model.entity.Cliente;
import cl.duoc.ms_usuario_db.model.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public ClienteDTO findClienteById(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        ClienteDTO clienteDTO = null;
        if(cliente.isPresent()){
            clienteDTO = translateEntityToDto(cliente.get());
        }
        return clienteDTO;
    }

    public ClienteDTO translateEntityToDto(Cliente cliente){
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setContrasena(cliente.getContrasena());
        dto.setDireccion(cliente.getDireccion());
        dto.setEmail(cliente.getEmail());
        dto.setTelefono(cliente.getTelefono());
        return dto;
    }


    public Cliente translateDtoToEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setId(dto.getId()); // en caso de update o si viene seteado
        cliente.setNombre(dto.getNombre());
        cliente.setContrasena(dto.getContrasena());
        cliente.setDireccion(dto.getDireccion());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefono(dto.getTelefono());
        return cliente;
    }

}
