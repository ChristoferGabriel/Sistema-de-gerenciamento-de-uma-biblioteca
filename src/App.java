import controllers.EmprestimoController;
import controllers.LivroController;
import model.Livro;
import model.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        import controllers.EmprestimoController;
import controllers.LivroController;
import model.Livro;
import model.Usuario;
import view.ConsoleView;

public class App {
    public static void main(String[] args) {
        
        LivroController livroController = new LivroController();
        EmprestimoController emprestimoController = new EmprestimoController();
        ConsoleView view = new ConsoleView(livroController, emprestimoController);
        Livro livro1 = new Livro(2008, "Robert C. Martin", "Clean Code", "Tecnologia", 101, 3);
        Livro livro2 = new Livro(1954, "J.R.R. Tolkien", "O Senhor dos Anéis", "Ficção", 102, 1);
        livroController.cadastrarLivro(livro1);
        livroController.cadastrarLivro(livro2);

        Usuario usuario1 = new Usuario(false, 1, "matheus@email.com", "Matheus Antoniele", "4199999999", "Curitiba - PR");
        Usuario usuario2 = new Usuario(false, 2, "joao@email.com", "João Silva", "1199999999", "São Paulo - SP");
        view.adicionarUsuario(usuario1);
        view.adicionarUsuario(usuario2);
        view.iniciar();
    }
}
    }
}
