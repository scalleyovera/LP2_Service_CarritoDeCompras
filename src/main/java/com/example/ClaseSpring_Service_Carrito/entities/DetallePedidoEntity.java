package com.example.ClaseSpring_Service_Carrito.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_detalle_pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DetallePedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detalleId;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private ProductoEntity productoEntity;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private PedidoEntity pedidoEntity;



}
