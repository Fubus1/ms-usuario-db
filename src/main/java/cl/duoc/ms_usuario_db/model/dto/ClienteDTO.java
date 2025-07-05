package cl.duoc.ms_usuario_db.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description = "DTO que representa a un cliente en el sistema")
public class ClienteDTO {

    @JsonProperty("id_cliente")
    @Schema(description = "ID único del cliente", example = "101")
    private Long id;

    @JsonProperty("nombre")
    @Schema(description = "Nombre completo del cliente", example = "Juan Pérez")
    private String nombre;

    @JsonProperty("contrasena")
    @Schema(description = "Contraseña del cliente para autenticación", example = "MiClaveSegura123!")
    private String contrasena;

    @JsonProperty("direccion")
    @Schema(description = "Dirección de residencia del cliente", example = "Av. Libertador 1234, Santiago")
    private String direccion;

    @JsonProperty("email")
    @Schema(description = "Correo electrónico del cliente", example = "juan.perez@example.com")
    private String email;

    @JsonProperty("telefono")
    @Schema(description = "Número de teléfono del cliente", example = "+56912345678")
    private String telefono;
}