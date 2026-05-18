
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private LocalDate dataEmprestimo;
    private LocalDate datadevolucaoPrevista;
    private LocalDate datadevolucaoEfetiva;
    private int id;
    private boolean devolvido;
    private Livros livro;
    private Usuarios usuario;

    public Emprestimo(LocalDate dataEmprestimo, LocalDate datadevolucaoEfetiva, LocalDate datadevolucaoPrevista, boolean devolvido, int id, Livros livro, Usuarios usuario) {
        this.dataEmprestimo = LocalDate.now();
        this.datadevolucaoEfetiva = datadevolucaoEfetiva = null;
        this.datadevolucaoPrevista = LocalDate.now().plusDays(14);
        this.devolvido = devolvido;
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
    }

    public long CalcularAtraso(){
        LocalDate devolucao = datadevolucaoEfetiva != null
        ?datadevolucaoEfetiva: LocalDate.now();

        long dias = ChronoUnit.DAYS.between(datadevolucaoPrevista, devolucao);
        return dias > 0 ? dias : 0;
    }
}

