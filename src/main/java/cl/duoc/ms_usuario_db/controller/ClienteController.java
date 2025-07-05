package cl.duoc.ms_usuario_db.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.ms_usuario_db.model.dto.ClienteDTO;
import cl.duoc.ms_usuario_db.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
@RequestMapping("/cliente")
@Tag(name = "Cliente", description = "Operaciones relacionadas con la gestión de clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Operation(
        summary = "Obtener cliente por ID",
        description = "Retorna los datos de un cliente específico basado en su ID."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente encontrado",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ClienteDTO.class))),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado",
            content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable("id") Long id) {
        ClienteDTO clienteDTO = clienteService.findClienteById(id);
        return (clienteDTO != null) ? 
            new ResponseEntity<>(clienteDTO, HttpStatus.OK) :
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(
        summary = "Crear un nuevo cliente",
        description = "Registra un nuevo cliente y devuelve sus datos si la operación es exitosa."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cliente creado correctamente",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ClienteDTO.class))),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida",
            content = @Content)
    })
    @PostMapping("")
    public ResponseEntity<ClienteDTO> createCliente(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "DTO con los datos del nuevo cliente",
                required = true,
                content = @Content(schema = @Schema(implementation = ClienteDTO.class))
            )
            @RequestBody ClienteDTO clienteDTO) {

        ClienteDTO newClienteDTO = clienteService.createCliente(clienteDTO);

        if (newClienteDTO != null) {
            return new ResponseEntity<>(newClienteDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}