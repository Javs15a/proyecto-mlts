package com.mlts.store.Entity.Transaction;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpersona")
    private Integer id;

    @NotNull
    @Column(name = "tipo_persona")
    private String tipo; // cliente o proveedor

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "persona")
    private List<TransaccionEntity> transacciones;
}
