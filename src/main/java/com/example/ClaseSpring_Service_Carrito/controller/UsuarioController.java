package com.example.ClaseSpring_Service_Carrito.controller;

import com.example.ClaseSpring_Service_Carrito.Utils.Utilitarios;
import com.example.ClaseSpring_Service_Carrito.entities.UsuarioEntity;
import com.example.ClaseSpring_Service_Carrito.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registrar")
    public String showRegistrarUsuario(Model model){
        UsuarioEntity user = new UsuarioEntity();
        model.addAttribute("usuario", user);
        return "/registrar_usuario";
    }

    @PostMapping("/registrar")
    public String registrarUsuario(UsuarioEntity usuario,
                                   Model model, @RequestParam("foto") MultipartFile foto){
        usuarioService.crearUsuario(usuario, model, foto);
        return "registrar_usuario";
    }

    @GetMapping("/")
    public String showIndex(Model model){
        UsuarioEntity usuario = new UsuarioEntity();
        model.addAttribute("usuario", usuario);
        return "login";
    }

    @PostMapping("/login")
    public String login(UsuarioEntity usuario, Model model, HttpSession sesion){
        boolean usuarioValido = usuarioService.validarUsuario(usuario, sesion);

        if(usuarioValido){
            return "redirect:/menu";
        }
        model.addAttribute("usuario", new UsuarioEntity());
        model.addAttribute("loginInvalido", "No existe el usuario");

        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }


}
