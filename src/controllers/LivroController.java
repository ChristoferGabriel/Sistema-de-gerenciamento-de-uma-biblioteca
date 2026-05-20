package controllers;


import java.util.ArrayList;
import java.util.List;
import model.Livro;

    public class LivroController {

        private List<Livro> livros = new ArrayList<>();

        public LivroController(){
            livros = new ArrayList<>();
        }

        public void cadastrarLivro(Livro livro) {
            livros.add(livro);
        System.out.println("livro cadastrado com sucesso");
        }



        public void listarLivros() {

            for (Livro livro : livros) {
                System.out.println(livro.getTitulo());
            }
            
        }
    }