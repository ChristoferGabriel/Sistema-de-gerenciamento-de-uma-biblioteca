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

        Livro livro = new Livro(
                2008,
                "robert martin",
                "tecnologia",
                "tecnologia",
                101,
                3);
            

        livroController.cadastrarLivro(livro);    

        Usuario usuario = new Usuario(
            false,
            1,
            "email@email.com",
            "Nome",
            "419999999",
            "Curitiba"
            );

        usuarioController.cadastrarUsuario(usuario);
    }
}
