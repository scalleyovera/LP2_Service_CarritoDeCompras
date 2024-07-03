package com.example.ClaseSpring_Service_Carrito.repositories;

import com.example.ClaseSpring_Service_Carrito.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {

    public UsuarioEntity findByCorreo(String correo);
}
