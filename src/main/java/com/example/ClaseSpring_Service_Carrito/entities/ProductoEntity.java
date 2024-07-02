package com.example.ClaseSpring_Service_Carrito.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_producto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long productoId;


    private String nombre;
    private Integer stock;
    private Double precio;

    @Column(name = "url_imagen")
    private String urlImagen;
}
