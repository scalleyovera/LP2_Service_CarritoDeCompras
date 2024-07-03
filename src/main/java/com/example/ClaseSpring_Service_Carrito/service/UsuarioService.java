package com.example.ClaseSpring_Service_Carrito.service;

import com.example.ClaseSpring_Service_Carrito.entities.UsuarioEntity;
import com.example.ClaseSpring_Service_Carrito.repositories.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface UsuarioService  {

  void crearUsuario(UsuarioEntity usuario, Model model, MultipartFile foto);
  boolean validarUsuario(UsuarioEntity usuario, HttpSession sesion);
  UsuarioEntity buscarUsuarioPorCorreo(String correo);

}
