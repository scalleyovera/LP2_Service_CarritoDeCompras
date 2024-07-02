package com.example.ClaseSpring_Service_Carrito.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "tb_pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PedidoEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long pedidoId;

    private LocalDate fechaCompra;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "pedidoEntity", cascade = CascadeType.ALL)
    private List<DetallePedidoEntity>detallePedido;




}
