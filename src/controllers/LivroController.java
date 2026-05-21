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

        public void BuscarPorId(){
            
        }

        public void listarLivros() {

            for (Livro livro : livros) {
                System.out.println("==================");
                System.out.println("Titulo: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Codigo: " + livro.getCodigo());
                System.out.println("Quantidade disponivel" + livro.getQuantDisponivel());

            }
            
        }
    }