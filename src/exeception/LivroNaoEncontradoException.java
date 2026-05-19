package exception;

public class LivroNaoEncontradoException extends RuntimeException {
    public LivroNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public LivroNaoEncontradoException(int codigo) {
        super("Livro com código " + codigo + " não encontrado.");
    }
}
