package interfaces;

import java.time.LocalDate;


public interface Gerenciavel {
    boolean estaDisponivel();
    void RegistrarEmprestimo(LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista);
    void RegistrarDevolucao(LocalDate dataDevolucaoEfetiva);
    String getCodigoIdentificador();    
    
}
