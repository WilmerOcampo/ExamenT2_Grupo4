package com.WAEC2GRUPO4.ExamenT2.model.bd;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;



@NoArgsConstructor
@Entity
@Data
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;
    @NotEmpty(message = "Este campo es obligatorio")
    private String nomusuario;
    @NotEmpty(message = "Este campo es obligatorio")
    private String email;
    @NotEmpty(message = "Este campo es obligatorio")
    private String password;
    @NotEmpty(message = "Este campo es obligatorio")
    private String nombres;
    @NotEmpty(message = "Este campo es obligatorio")
    private String apellidos;
    private Boolean activo;

    @ManyToMany(cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol",
            joinColumns = @JoinColumn(name = "idusuario"),
            inverseJoinColumns = @JoinColumn(name = "idrol"))
    private Set<Rol> roles;
}



