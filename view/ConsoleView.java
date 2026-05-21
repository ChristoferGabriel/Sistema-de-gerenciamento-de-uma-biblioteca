package view;

import controllers.EmprestimoController;
import controllers.LivroController;
import java.util.ArrayList;
import java.util.Scanner;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

public class ConsoleView {
    private LivroController livroController;
    private EmprestimoController emprestimoController;
    private ArrayList<Usuario> usuarios;
    private Scanner scanner;

    public ConsoleView(LivroController livroController, EmprestimoController emprestimoController) {
        this.livroController = livroController;
        this.emprestimoController = emprestimoController;
        this.usuarios = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    public void adicionarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }
    private int lerOpcaoSegura() {
    while (!scanner.hasNextInt()) {
        System.out.println("Por favor, digite um número válido.");
        System.out.print("Escolha uma opção: ");
        scanner.next();
    }
    
    int valor = scanner.nextInt();
    scanner.nextLine();
    return valor;
}

    public void iniciar() {
    int opcao = -1;
    while (opcao != 0) {
        System.out.println("\n==================================");
        System.out.println("      SISTEMA DE BIBLIOTECA       ");
        System.out.println("==================================");
        System.out.println("1. Listar Livros");
        System.out.println("2. Realizar Empréstimo");
        System.out.println("3. Devolver Livro");
        System.out.println("4. Listar Todos os Empréstimos");
        System.out.println("5. Listar Atrasos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        opcao = lerOpcaoSegura();
        processarOpcao(opcao);
    }
    System.out.println("Encerrando o sistema...");
}

    private void processarOpcao(int opcao) {
        System.out.println();
        switch (opcao) {
            case 1:
                System.out.println("--- Acervo de Livros ---");
                livroController.listarLivros();
                break;

            case 2:
                System.out.println("--- Realizar Empréstimo ---");
                System.out.print("Digite o ID do Usuário: ");
                int idUsuario = Integer.parseInt(scanner.nextLine());
                Usuario usuarioEmprestimo = buscarUsuarioPorId(idUsuario);

                if (usuarioEmprestimo == null) {
                    System.out.println("Usuário não encontrado.");
                    break;
                }
                System.out.print("Digite o código do Livro: ");
                int codLivro = Integer.parseInt(scanner.nextLine());
                Livro livroEmprestimo = LivroController.BuscarPorcodigo();

                emprestimoController.RealizarEmprestimos(usuarioEmprestimo, livroEmprestimo);
                break;

            case 3:
                System.out.println("--- Devolver Livro ---");
                System.out.print("Digite o ID do Usuário que está devolvendo: ");
                int idDevolucao = Integer.parseInt(scanner.nextLine());
                Usuario usuarioDevolucao = buscarUsuarioPorId(idDevolucao);

                if (usuarioDevolucao == null) {
                    System.out.println("Usuário não encontrado.");
                    break;
                }

                Emprestimo emprestimo = emprestimoController.buscarEmprestimoAtivo(usuarioDevolucao);
                
                if (emprestimo != null) {
                    emprestimoController.devolverLivro(emprestimo);
                } else {
                    System.out.println("Nenhum empréstimo ativo encontrado para este usuário.");
                }
                break;

            case 4:
                System.out.println("--- Histórico de Empréstimos ---");
                emprestimoController.ListarEmprestimo();
                break;

            case 5:
                System.out.println("--- Relatório de Atrasos ---");
                emprestimoController.ListarAtrasos();
                break;

            case 0:
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    private Usuario buscarUsuarioPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }
}