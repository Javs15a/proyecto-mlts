package com.mlts.store.Entity.User;

import com.mlts.store.Entity.Transaction.TransaccionEntity;
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
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idrol", referencedColumnName = "idrol", nullable = false)
    private RolEntity rol;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @Null
    @Column(name = "telefono")
    private String telefono;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "password")
    private String password;

    @ColumnDefault(value = "true")
    @Column(name = "activo")
    private Boolean activo;

    @OneToMany(mappedBy = "usuario")
    private Set<TransaccionEntity> transacciones;
}
