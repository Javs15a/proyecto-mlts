package com.mlts.store.Entity.User;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "rol")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private Integer id;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @Null
    @Column(name = "descripcion")
    private String descripcion;

    @ColumnDefault(value = "true")
    @Column(name = "activo")
    private Boolean activo;

    @OneToMany(mappedBy = "rol")
    private Set<UsuarioEntity> usuarios;
}
