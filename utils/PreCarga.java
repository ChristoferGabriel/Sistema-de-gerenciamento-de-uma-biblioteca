package utils;

import controllers.LivroController;
import controllers.UsuarioController;

import model.Livro;
import model.Usuario;

public class PreCarga {

    public static void carregar(
        LivroController livroController,
        UsuarioController usuarioController
    ) {

        livroController.cadastrarLivro(
            new Livro(
                2008,
                "Robert Martin",
                "Clean Code",
                "Tecnologia",
                101,
                3
            )
        );

        usuarioController.cadastrarUsuario(
            new Usuario(
                false,
                1,
                "matheus@email.com",
                "Matheus",
                "419999999",
                "Curitiba"
            )
        );
    }
}