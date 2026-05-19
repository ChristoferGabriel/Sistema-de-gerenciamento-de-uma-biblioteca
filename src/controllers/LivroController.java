    package controllers;


    import java.util.ArrayList;
    import model.Livro;

    public class LivroController {

        private ArrayList<Livro> livros = new ArrayList<>();

        public void cadastrarLivro(Livro livro) {
            livros.add(livro);
        }

        public void listarLivros() {

            for (Livro livro : livros) {
                System.out.println(livro.getTitulo());
            }
        }
    }