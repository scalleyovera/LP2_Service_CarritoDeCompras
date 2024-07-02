package com.example.ClaseSpring_Service_Carrito.repositories;

import com.example.ClaseSpring_Service_Carrito.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

}
