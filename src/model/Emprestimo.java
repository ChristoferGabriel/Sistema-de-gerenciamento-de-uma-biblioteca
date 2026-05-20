package model; 

import java.time.LocalDate;

public class Emprestimo {
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoEfetiva;
    private int id;
    private boolean devolvido;
    private Livro livro;
    private Usuario usuario;

    public Emprestimo(LocalDate dataDevolucaoEfetiva, LocalDate dataDevolucaoPrevista, boolean devolvido, int id, Livro livro, Usuario usuario) {
        dataEmprestimo = LocalDate.now();
        this.dataDevolucaoEfetiva = dataDevolucaoEfetiva = null;
        this.dataDevolucaoPrevista = LocalDate.now().plusDays(14);
        this.devolvido = devolvido;
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
    }

    public Emprestimo(Livro livro2, Usuario usuario2) {
    }

    public void devolverLivro(){
        dataDevolucaoEfetiva = LocalDate.now();
        devolvido = true;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoEfetiva() {
        return dataDevolucaoEfetiva;
    }

    public void setDataDevolucaoEfetiva(LocalDate dataDevolucaoEfetiva) {
        this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
    }
}

