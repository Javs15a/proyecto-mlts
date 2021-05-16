package com.mlts.store.Entity.User;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

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

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "activo")
    private Boolean activo;

    @OneToMany(mappedBy = "rol")
    private List<UsuarioEntity> usuarios;
}
