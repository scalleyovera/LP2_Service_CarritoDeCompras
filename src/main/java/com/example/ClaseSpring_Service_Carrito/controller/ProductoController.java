package com.example.ClaseSpring_Service_Carrito.controller;

import com.example.ClaseSpring_Service_Carrito.entities.UsuarioEntity;
import com.example.ClaseSpring_Service_Carrito.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductoController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/menu")
    public String showMenu(HttpSession sesion, Model model){
        if(sesion.getAttribute("usuario") == null){
            return "redirect:/login";
        }
        String correo = sesion.getAttribute("usuario").toString();
        UsuarioEntity usuarioEncontrado = usuarioService.buscarUsuarioPorCorreo(correo);
        model.addAttribute("foto", usuarioEncontrado.getUrlImagen());
        return "menu";

    }

}
