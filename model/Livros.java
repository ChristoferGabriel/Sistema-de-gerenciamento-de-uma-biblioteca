public class Livros extends ItemBiblioteca{
    private String autor, titulo;
    private int anoPublicacao;

    public Livros(int anoPublicacao, String autor, String titulo, String categoria, int codigo, int quantDisponivel) {
        super(categoria, codigo, quantDisponivel);
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
        this.titulo = titulo;
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
}
