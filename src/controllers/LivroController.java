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

        if(BuscarPorcodigo(livro.getCodigo()) != null){
            System.out.println("Já existe um livro com esse codigo");
            return;
        }
        
            livros.add(livro);
        System.out.println("livro cadastrado com sucesso");
        }

        public Livro BuscarPorcodigo(int codigo){

            for(Livro livro: livros){
                if(livro.getCodigo() == codigo){
                    return livro;
                }
            }
            return null;
            
        }

        public boolean removerLivro(int codigo){

            Livro livro = BuscarPorcodigo(codigo);

            if (livro != null) {
                livros.remove(livro);
                return true;
            }
            return false;
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