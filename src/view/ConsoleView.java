package view;

import controllers.EmprestimoController;
import controllers.LivroController;
import controllers.UsuarioController;
import java.util.List;
import java.util.Scanner;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

public class ConsoleView {

    private LivroController livroController;
    private UsuarioController usuarioController;
    private EmprestimoController emprestimoController;

    private Scanner scanner;

    public ConsoleView(
        LivroController livroController,
        UsuarioController usuarioController,
        EmprestimoController emprestimoController
    ) {

        this.livroController = livroController;
        this.usuarioController = usuarioController;
        this.emprestimoController = emprestimoController;

        scanner = new Scanner(System.in);
    }

    private void pausar() {

            System.out.println("\nPressione ENTER para continuar...");
            scanner.nextLine();
        }

        private void limparTela() {

            for (int i = 0; i < 40; i++) {
            System.out.println();
            }
        }

    public void iniciar() {

    int opcao = -1;

    while (opcao != 0) {

        limparTela();

        System.out.println("================================");
        System.out.println("     SISTEMA DE BIBLIOTECA");
        System.out.println("================================");

        System.out.println("1 - Listar livros");
        System.out.println("2 - Buscar livro por título");
        System.out.println("3 - Buscar livro por autor");
        System.out.println("4 - Buscar livro por categoria");
        System.out.println("5 - Realizar empréstimo");
        System.out.println("6 - Devolver livro");
        System.out.println("7 - Listar empréstimos");
        System.out.println("8 - Listar atrasos");
        System.out.println("9 - Livros mais populares");
        System.out.println("10 - Listar usuários");
        System.out.println("11 - Cadastrar usuário");
        System.out.println("12 - Cadastrar livro");
        System.out.println("0 - Sair");

        System.out.print("\nEscolha: ");

        try {

            opcao = Integer.parseInt(scanner.nextLine());

            limparTela();

            switch (opcao) {

                case 1:
                    livroController.listarLivros();
                    break;

                case 2:
                    buscarPorTitulo();
                    break;

                case 3:
                    buscarPorAutor();
                    break;

                case 4:
                    buscarPorCategoria();
                    break;

                case 5:
                    realizarEmprestimo();
                    break;

                case 6:
                    devolverLivro();
                    break;

                case 7:
                    emprestimoController.ListarEmprestimo();
                    break;

                case 8:
                    emprestimoController.ListarAtrasos();
                    break;

                case 9:
                    emprestimoController.livrosMaisPopulares(
                        livroController.getLivros()
                    );
                    break;

                case 10:
                    usuarioController.listarUsuarios();
                    break;

                case 11:
                    cadastrarUsuario();
                break;      

                case 12:
                    cadastrarLivro();
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

            if (opcao != 0) {
                pausar();
            }

        } catch (NumberFormatException e) {

            System.out.println("Digite apenas números.");
            pausar();

        } catch (Exception e) {

            System.out.println("Erro: " + e.getMessage());
                pausar();
            }
        }
    }

    private void buscarPorTitulo() {

        System.out.print("Digite o título: ");

        String titulo = scanner.nextLine();

        List<Livro> livros =
            livroController.buscarPorTitulo(titulo);

        mostrarLivros(livros);
    }

    private void buscarPorAutor() {

        System.out.print("Digite o autor: ");

        String autor = scanner.nextLine();

        List<Livro> livros =
            livroController.buscarPorAutor(autor);

        mostrarLivros(livros);
    }

    private void buscarPorCategoria() {

        System.out.print("Digite a categoria: ");

        String categoria = scanner.nextLine();

        List<Livro> livros =
            livroController.buscarPorCategoria(categoria);

        mostrarLivros(livros);
    }

    private void mostrarLivros(List<Livro> livros) {

        if (livros.isEmpty()) {

            System.out.println("Nenhum livro encontrado.");
            return;
        }

        for (Livro livro : livros) {

            System.out.println("======================");
            System.out.println(livro);
        }
    }

    private void realizarEmprestimo() {

        try {

            System.out.print("ID do usuário: ");

            int idUsuario =
                Integer.parseInt(scanner.nextLine());

            Usuario usuario =
                usuarioController.buscarUsuarioPorId(idUsuario);

            System.out.print("Código do livro: ");

            int codigoLivro =
                Integer.parseInt(scanner.nextLine());

            Livro livro =
                livroController.BuscarPorcodigo(codigoLivro);

            emprestimoController.RealizarEmprestimos(
                usuario,
                livro
            );

        } catch (NumberFormatException e) {

            System.out.println("Digite apenas números.");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    private void devolverLivro() {

        try {

            System.out.print("ID do usuário: ");

            int idUsuario =
                Integer.parseInt(scanner.nextLine());

            Usuario usuario =
                usuarioController.buscarUsuarioPorId(idUsuario);

            Emprestimo emprestimo =
                emprestimoController.buscarEmprestimoAtivo(usuario);

            emprestimoController.devolverLivro(emprestimo);

        } catch (Exception e) {
            System.out.println("Erro na devolução: "+ e.getMessage());
        }
    }

    private void cadastrarUsuario() {

    try {

        System.out.println("===== CADASTRO DE USUÁRIO =====");

        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        Usuario usuario = new Usuario(
            false,
            id,
            email,
            nome,
            telefone,
            endereco
        );

        usuarioController.cadastrarUsuario(usuario);

        } catch (NumberFormatException e) {

            System.out.println("Digite um ID válido.");

        } catch (Exception e) {

        System.out.println("Erro ao cadastrar usuário: "+ e.getMessage());
        }
    }

    private void cadastrarLivro() {

    try {

        System.out.println("===== CADASTRO DE LIVRO =====");

        System.out.print("Código: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        System.out.print("Ano de publicação: ");
        int ano = Integer.parseInt(scanner.nextLine());

        System.out.print("Quantidade disponível: ");
        int quantidade = Integer.parseInt(scanner.nextLine());

        Livro livro = new Livro(
            ano,
            autor,
            titulo,
            categoria,
            codigo,
            quantidade
        );

            livroController.cadastrarLivro(livro);

        } catch (NumberFormatException e) {

        System.out.println("Digite apenas números nos campos numéricos.");

        } catch (Exception e) {

        System.out.println("Erro ao cadastrar livro: "+ e.getMessage());
        }
    }
}