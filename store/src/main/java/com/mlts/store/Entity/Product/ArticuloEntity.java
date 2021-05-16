package com.mlts.store.Entity.Product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "articulo",
        uniqueConstraints = @UniqueConstraint(columnNames = {"nombre"}))
public class ArticuloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idarticulo")
    private Integer id;

    @NotNull
    @Column(name = "idcategoria")
    private Integer categoriaRef;

    @ManyToOne
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria", insertable = false, updatable = false)
    private CategoriaEntity categoria;

    @Column(name = "codigo")
    private String codigo;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "precio_venta")
    private Float precio;

    @NotNull
    @Column(name = "stock")
    private Integer stock;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "url_path")
    private String img;

    @Column(name = "activo")
    private Boolean activo;
}
