package com.mlts.store.Entity.Transaction;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona")
    private Integer id;

    @NotNull
    @Column(name = "tipo_persona")
    private String tipo; // cliente o proveedor

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @Null
    @Column(name = "direccion")
    private String direccion;

    @Null
    @Column(name = "telefono")
    private String telefono;

    @Null
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "persona")
    private Set<TransaccionEntity> transacciones;
}
