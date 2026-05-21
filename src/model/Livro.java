package model;

public class Livro extends ItemBiblioteca{
    private String autor, titulo;
    private int anoPublicacao, totalEmprestimos;


    public Livro(int anoPublicacao, String autor, String titulo, int totalEmprestimos, String categoria, int codigo, int quantDisponivel) {
        super(categoria, codigo, quantDisponivel);
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
        this.titulo = titulo;
        this.totalEmprestimos = totalEmprestimos;
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

    
    public int getTotalEmprestimos() {
        return totalEmprestimos;
    }

    public void setTotalEmprestimos(int totalEmprestimos) {
        this.totalEmprestimos = totalEmprestimos;
    }

    @Override
    public String toString() {
        return "Livro {autor = " + autor + 
                ", titulo = " + titulo + 
                ", anoPublicacao = " + anoPublicacao + 
                 "Codigo = " + getCodigo() + "}";
    }  

}
