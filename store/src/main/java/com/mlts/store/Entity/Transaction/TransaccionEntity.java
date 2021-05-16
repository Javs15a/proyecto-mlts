package com.mlts.store.Entity.Transaction;

import com.mlts.store.Entity.User.UsuarioEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "transaccion")
public class TransaccionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtransaccion")
    private Integer id;

    @NotNull
    @Column(name = "idpersona")
    private Integer personaRef;

    @ManyToOne
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona", insertable = false, updatable = false)
    private PersonaEntity persona;

    @NotNull
    @Column(name = "idusuario")
    private Integer usuarioRef;

    @ManyToOne
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario", insertable = false, updatable = false)
    private UsuarioEntity usuario;

    @NotNull
    @Column(name = "tipo_transaccion")
    private String tipoTransaccion; // compra o venta

    @Null
    @Column(name = "serie_comprobante")
    private String serieComprobante;

    @NotNull
    @Column(name = "num_comprobante")
    private String numeroComprobante;

    @NotNull
    @Column(name = "fecha")
    private Date fecha;

    @NotNull
    @Column(name = "impuesto")
    private Float impuesto;

    @NotNull
    @Column(name = "total")
    private Float total;

    @OneToMany(mappedBy = "transaccion")
    private List<DetalleEntity> detalle;
}
