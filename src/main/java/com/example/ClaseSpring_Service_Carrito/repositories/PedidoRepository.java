package com.example.ClaseSpring_Service_Carrito.repositories;

import com.example.ClaseSpring_Service_Carrito.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
