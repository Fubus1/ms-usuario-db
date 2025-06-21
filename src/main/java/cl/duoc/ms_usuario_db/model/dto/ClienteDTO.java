package cl.duoc.ms_usuario_db.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ClienteDTO {

    @JsonProperty("id_cliente")
    private Long id;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("contrasena")
    private String contrasena;

    @JsonProperty("direccion")
    private String direccion;

    @JsonProperty("email")
    private String email;

    @JsonProperty("telefono")
    private String telefono;
}
