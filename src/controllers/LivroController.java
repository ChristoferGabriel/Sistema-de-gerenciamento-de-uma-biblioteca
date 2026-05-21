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

        public List<Livro> buscarPorTitulo(String titulo) {

            List<Livro> encontrados = new ArrayList<>();

            for (Livro livro : livros) {
                if (livro.getTitulo().toLowerCase()
                .contains(titulo.toLowerCase())) {

                    encontrados.add(livro);
                }
            }

            return encontrados;
        }

        public List<Livro> buscarPorAutor(String autor) {

        List<Livro> encontrados = new ArrayList<>();

            for (Livro livro : livros) {
                if (livro.getAutor().toLowerCase()
                .contains(autor.toLowerCase())) {

                encontrados.add(livro);
                }
            }

            return encontrados;
        }
        public List<Livro> buscarPorCategoria(String categoria) {

        List<Livro> encontrados = new ArrayList<>();

        for (Livro livro : livros) {

            if (livro.getCategoria().toLowerCase()
                .contains(categoria.toLowerCase())) {

                encontrados.add(livro);
                }
            }

            return encontrados;
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