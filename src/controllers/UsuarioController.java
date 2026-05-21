package controllers;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioController {

    private List<Usuario> usuarios;

    public UsuarioController() {
        usuarios = new ArrayList<>();
    }

    public void cadastrarUsuario(Usuario usuario) {

        if (buscarUsuarioPorId(usuario.getId()) != null) {
            System.out.println("Usuário já cadastrado.");
            return;
        }

        usuarios.add(usuario);

        System.out.println("Usuário cadastrado.");
    }

    public Usuario buscarUsuarioPorId(int id) {

        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }

        return null;
    }

    public void listarUsuarios() {

        for (Usuario u : usuarios) {
            System.out.println("====================");
            System.out.println("Nome: " + u.getNome());
            System.out.println("Email: " + u.getEmail());
            System.out.println("Telefone: " + u.getTelefone());
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}