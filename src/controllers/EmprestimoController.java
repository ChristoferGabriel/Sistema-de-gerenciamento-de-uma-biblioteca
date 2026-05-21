package controllers;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

public class EmprestimoController {
    private ArrayList<Emprestimo> emprestimos;

    public EmprestimoController(){
        emprestimos = new ArrayList<>();
    }

    
    public void RealizarEmprestimos(Usuario usuario, Livro livro) {

    try {

        if (usuario == null) {
            throw new Exception("Usuário não encontrado.");
        }

        if (livro == null) {
            throw new Exception("Livro não encontrado.");
        }

        if (usuario.isEmpretivoAtivo()) {
            throw new Exception(
                "Usuário já possui empréstimo."
            );
        }

        if (livro.getQuantDisponivel() <= 0) {
            throw new Exception(
                "Livro indisponível."
            );
        }

        livro.setQuantDisponivel(
            livro.getQuantDisponivel() - 1
        );

        livro.setTotalEmprestimos(
            livro.getTotalEmprestimos() + 1
        );

        usuario.setEmpretivoAtivo(true);

            Emprestimo emprestimo =
                new Emprestimo(livro, usuario);

            emprestimos.add(emprestimo);

            System.out.println("Empréstimo realizado com sucesso.");

        } catch (Exception e) {

            System.out.println("Erro ao realizar empréstimo: " + e.getMessage());
        }
    }

    public void devolverLivro(Emprestimo emprestimo) {

    try {

        if (emprestimo == null) {
            throw new Exception("Empréstimo não encontrado.");
        }

        if (emprestimo.isDevolvido()) {
            throw new Exception("Livro já devolvido.");
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

        if (diasAtraso > 0) {

            System.out.println("Livro devolvido com atraso de " + diasAtraso + " dias.");

        } else {
            System.out.println("Livro devolvido no prazo.");
        }

        } catch (Exception e) {
            System.out.println("Erro na devolução: " + e.getMessage());
        }
    }

    public void livrosMaisPopulares(List<Livro> livros) {

        livros.sort((l1, l2) ->
            Integer.compare(
                l2.getTotalEmprestimos(),
                l1.getTotalEmprestimos()
            )
        );

        for (Livro l : livros) {
            System.out.println( l.getTitulo() + " - Empréstimos: " + l.getTotalEmprestimos());
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

    public void ListarAtrasos() {

        LocalDate hoje = LocalDate.now();

        emprestimos.sort((e1, e2) -> {

            long atraso1 =
                ChronoUnit.DAYS.between(
                    e1.getDataDevolucaoPrevista(),
                    hoje
                );

            long atraso2 =
                ChronoUnit.DAYS.between(
                    e2.getDataDevolucaoPrevista(),
                    hoje
                );

            return Long.compare(atraso2, atraso1);
        });

        for (Emprestimo e : emprestimos) {

            if (!e.isDevolvido()
                && hoje.isAfter(e.getDataDevolucaoPrevista())) {

                long atraso =
                    ChronoUnit.DAYS.between(
                        e.getDataDevolucaoPrevista(),
                        hoje
                    );

                System.out.println(
                    e.getUsuario().getNome() + " está com " + atraso + " dias de atraso.");
            }
        }
    }
    public Emprestimo buscarEmprestimoAtivo(Usuario usuario) {
        for (Emprestimo e : emprestimos) {
            if (e.getUsuario().getId() == usuario.getId() && !e.isDevolvido()) {
                return e;
            }
        }
        return null;
    }
}
