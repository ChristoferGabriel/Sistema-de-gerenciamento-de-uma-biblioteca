package controllers;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

public class EmprestimoController {
    private ArrayList<Emprestimo> emprestimos;

    public EmprestimoController(){
        emprestimos = new ArrayList<>();
    }

    public void RealizarEmprestimos(Usuario usuario, Livro livro){
        if (usuario.isEmpretivoAtivo()){

            System.out.println("Usuario ja possui um livro emprestado");
            return;
        }

        if(livro.getQuantDisponivel() <= 0){

        System.out.println("livro indisponivel");
            return;
        }

        livro.setQuantDisponivel(
            livro.getQuantDisponivel() - 1
        );
    
        usuario.setEmpretivoAtivo(true);

        Emprestimo emprestimo = new Emprestimo(livro, usuario);

        emprestimos.add(emprestimo);

        System.out.println("emprestimo realizado com sucesso.");
    }

    public void devolverLivro(Emprestimo emprestimo){
        if(emprestimo.isDevolvido()){

            System.out.println("Livro devolvido");
            return;
        } 

        emprestimo.devolverLivro();

        Livro livro = emprestimo.getLivro();

        livro.setQuantDisponivel(
            livro.getQuantDisponivel() + 1
        );

        Usuario usuario = emprestimo.getUsuario();

        usuario.setEmpretivoAtivo(false);

        long diasAtraso = 
            ChronoUnit.DAYS.between(
            emprestimo.getDataDevolucaoPrevista(),
            emprestimo.getDataDevolucaoEfetiva()
        );

        if(diasAtraso > 0){
            System.out.println("Livro foi devolvido com atraso de " + diasAtraso + "dias");

        } else {

            System.out.println("livro devolvido no prazo");

        }
    }

    public void ListarEmprestimo(){
        for( Emprestimo e : emprestimos){

            System.out.println("Livro: " + e.getLivro().getTitulo());
            System.out.println("Usuario: " + e.getUsuario().getNome());
            System.out.println("Previsto: " + e.getDataDevolucaoPrevista());
            System.out.println("=======================================");

        }
    }
}
