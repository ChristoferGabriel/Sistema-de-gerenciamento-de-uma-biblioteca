package interfaces;

import java.time.LocalDate;

public interface Gerenciavel {

    boolean estaDisponivel();
    void registrarEmprestimo(LocalDate dataEmprestimo,LocalDate dataDevolucaoPrevista);
    void registrarDevolucao(LocalDate dataDevolucaoEfetiva);
    String getCodigoIdentificador();
}
