public abstract class ItemBiblioteca {
    private int quantDisponivel, codigo;
    private String categoria;

    public ItemBiblioteca(String categoria, int codigo, int quantDisponivel) {
        this.categoria = categoria;
        this.codigo = codigo;
        this.quantDisponivel = quantDisponivel;
    }

    public void setQuantDisponivel(int quantDisponivel) {
        this.quantDisponivel = quantDisponivel;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantDisponivel() {
        return quantDisponivel;
    }

    public int getCodigo() {
        return codigo;
    }

}
