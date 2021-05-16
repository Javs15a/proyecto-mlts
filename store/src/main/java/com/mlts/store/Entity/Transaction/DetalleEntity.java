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

    @NotNull
    @Column(name = "idtransaccion")
    private Integer transaccionRef;

    @ManyToOne
    @JoinColumn(name = "idtransaccion", referencedColumnName = "idtransaccion", insertable = false, updatable = false)
    private TransaccionEntity transaccion;

    @NotNull
    @Column(name = "idarticulo")
    private Integer articuloRef;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idarticulo", referencedColumnName = "idarticulo", insertable = false, updatable = false)
    private ArticuloEntity articulo;

    @NotNull
    @Column(name = "cantidad")
    private Integer cantidad;

    @NotNull
    @Column(name = "monto_total")
    private Float monto; // cantidad * precio_venta (articulo)

    @Column(name = "descuento")
    private Float descuento;
}
