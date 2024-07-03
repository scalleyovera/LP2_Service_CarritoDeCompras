package com.example.ClaseSpring_Service_Carrito.service.impl;

import com.example.ClaseSpring_Service_Carrito.Utils.Utilitarios;
import com.example.ClaseSpring_Service_Carrito.entities.UsuarioEntity;
import com.example.ClaseSpring_Service_Carrito.repositories.UsuarioRepository;
import com.example.ClaseSpring_Service_Carrito.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    @Override
    public void crearUsuario(UsuarioEntity usuario, Model model, MultipartFile foto) {

        String nombreFoto = Utilitarios.guardarImagen(foto);
        usuario.setUrlImagen(nombreFoto);

        String passwordHash = Utilitarios.extraerHash(usuario.getPassword());
        usuario.setPassword(passwordHash);

        repo.save(usuario);

        // responder  a la vista
        model.addAttribute("registroCorrecto", "Registro correcto");
        model.addAttribute("usuario", new UsuarioEntity());

    }

    @Override
    public boolean validarUsuario(UsuarioEntity usuario, HttpSession sesion) {
        UsuarioEntity usuarioEncontradoPorCorreo = repo.findById(usuario.getCorreo()).get();

        if(usuarioEncontradoPorCorreo == null){
            return false;
        }

        if (!Utilitarios.verificarPassword(usuario.getPassword(), usuarioEncontradoPorCorreo.getPassword())){
            return false;
        }
        sesion.setAttribute("usuario", usuarioEncontradoPorCorreo.getCorreo());
        return true;
    }

    @Override
    public UsuarioEntity buscarUsuarioPorCorreo(String correo) {
        return repo.findByCorreo(correo);
    }
}
