// Implementação
interface LivroAPI {
    void emitirLivro(String nomeDoLivro);
}

// Implementação Concreta
class LivroAPIImplementacao implements LivroAPI {
    public void emitirLivro(String nomeDoLivro) {
        System.out.println("Emitindo o livro: " + nomeDoLivro);
    }
}

// Abstração
abstract class Biblioteca {
    protected LivroAPI livroAPI;
    protected Biblioteca(LivroAPI livroAPI) {
        this.livroAPI = livroAPI;
    }
    public abstract void emitir(String nomeDoLivro);
}

// Abstração Refinada
class SistemaDaBiblioteca extends Biblioteca {
    protected SistemaDaBiblioteca(LivroAPI livroAPI) {
        super(livroAPI);
    }
    public void emitir(String nomeDoLivro) {
        System.out.println("Sistema da biblioteca emitindo o livro: " + nomeDoLivro);
        livroAPI.emitirLivro(nomeDoLivro);
    }
}

// Classe principal
public class Principal {
    public static void main(String[] args) {
        LivroAPI livroAPI = new LivroAPIImplementacao();
        Biblioteca biblioteca = new SistemaDaBiblioteca(livroAPI);
        biblioteca.emitir("O Senhor dos Anéis");
    }
}
