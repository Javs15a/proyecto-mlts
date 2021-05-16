package com.mlts.store.Entity.Product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categoria",
        uniqueConstraints = @UniqueConstraint(columnNames = {"nombre"}))
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategoria")
    private Integer id;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "activo")
    private Boolean activo;

    @OneToMany(mappedBy = "categoria")
    private List<ArticuloEntity> articulos;
}
