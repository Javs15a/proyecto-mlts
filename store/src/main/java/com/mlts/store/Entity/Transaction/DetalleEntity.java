package com.mlts.store.Entity.Transaction;

import com.mlts.store.Entity.Product.ArticuloEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Getter
@Setter
@Entity
@Table(name = "detalle")
public class DetalleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetalle")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idtransaccion", referencedColumnName = "idtransaccion")
    private TransaccionEntity transaccion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idarticulo", referencedColumnName = "idarticulo")
    private ArticuloEntity articulo;

    @NotNull
    @Column(name = "cantidad")
    private Integer cantidad;

    @NotNull
    @Column(name = "precio")
    private Float precio; // cantidad * precio_venta (articulo)

    @Null
    @Column(name = "descuento")
    private Float descuento;
}
