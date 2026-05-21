import controllers.EmprestimoController;
import controllers.LivroController;
import controllers.UsuarioController;
import utils.PreCarga;
import view.ConsoleView;

public class App {

    public static void main(String[] args) {

        LivroController livroController =
            new LivroController();

        UsuarioController usuarioController =
            new UsuarioController();

        EmprestimoController emprestimoController =
            new EmprestimoController();

        PreCarga.carregar(
            livroController,
            usuarioController
        );

        ConsoleView view =
            new ConsoleView(
                livroController,
                usuarioController,
                emprestimoController
            );

        view.iniciar();
    }
}