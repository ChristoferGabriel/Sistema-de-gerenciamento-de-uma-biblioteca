public class Usuarios extends Pessoa{
    private int id;
    private boolean EmpretivoAtivo;

    public Usuarios(boolean EmpretivoAtivo, int id, String email, String nome, String telefone, String endereco) {
        super(email, nome, telefone, endereco);
        this.EmpretivoAtivo = EmpretivoAtivo;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEmpretivoAtivo() {
        return EmpretivoAtivo;
    }

    public void setEmpretivoAtivo(boolean EmpretivoAtivo) {
        this.EmpretivoAtivo = EmpretivoAtivo;
    }
    
}
