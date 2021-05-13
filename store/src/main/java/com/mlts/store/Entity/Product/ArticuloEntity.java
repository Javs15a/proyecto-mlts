package com.mlts.store.Entity.Product;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

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

    @ManyToOne
    @JoinColumn(name = "idcategoria", nullable = false, referencedColumnName = "idcategoria")
    private CategoriaEntity categoria;

    @Null
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

    @Null
    @Column(name = "descripcion")
    private String descripcion;

    @Null
    @Column(name = "url_path")
    private String img;

    @ColumnDefault(value = "true")
    @Column(name = "activo")
    private Boolean activo;
}
