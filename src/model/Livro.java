package model;

import java.time.LocalDate;

public class Livro extends ItemBiblioteca{
    private int anoPublicacao, totalEmprestimos;
    private String autor, titulo, categoria;

    public Livro(int anoPublicacao, String autor, String categoria, String titulo, int codigo, int quantDisponivel) {
        super(codigo, quantDisponivel);
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
        this.categoria = categoria;
        this.titulo = titulo;
        this.totalEmprestimos = 0;
    }

    public int getTotalEmprestimos() {
        return totalEmprestimos;
    }

    public void setTotalEmprestimos(int totalEmprestimos) {
        this.totalEmprestimos = totalEmprestimos;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    @Override
    public String toString() {
    return
        "Título: " + titulo +
        "\nAutor: " + autor +
        "\nCategoria: " + getCategoria() +
        "\nCódigo: " + getCodigo() +
        "\nDisponíveis: " + getQuantDisponivel();
    }

    @Override
    public boolean estaDisponivel() {
        return getQuantDisponivel() > 0;
    }

    @Override
    public void registrarEmprestimo(LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista) {
        if(getQuantDisponivel() > 0){
            setQuantDisponivel(getQuantDisponivel() - 1);
        }
    }

    @Override
    public void registrarDevolucao(LocalDate dataDevolucaoEfetiva) {
        setQuantDisponivel(getQuantDisponivel() + 1);
    }

    @Override
    public String getCodigoIdentificador() {
        return String.valueOf(getCodigo());
    }
    
}

