    package controllers;


import interfaces.Gerenciavel;
    import java.util.ArrayList;
    import model.Livro;

    public class LivroController implements Gerenciavel {

        private ArrayList<Livro> livros = new ArrayList<>();

        public void cadastrarLivro(Livro livro) {
            livros.add(livro);
        }

        public void listarLivros() {

            for (Livro livro : livros) {
                System.out.println(livro.getTitulo());
            }
        }

    @Override
    public String cadastrar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String Remover() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String Buscar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    }