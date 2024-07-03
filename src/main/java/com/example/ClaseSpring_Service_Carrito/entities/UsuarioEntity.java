package com.example.ClaseSpring_Service_Carrito.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioEntity {

   @Id
   private String correo;
   private String nombre;
   private String celular;
   private String password;
   private String urlImagen;

}
