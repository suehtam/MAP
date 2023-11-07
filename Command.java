// Interface Comando
public interface Comando {
    void executar();
}

// Classe ComandoConcreto
public class EmprestarLivroComando implements Comando {
    private Biblioteca biblioteca;
    private Livro livro;

    public EmprestarLivroComando(Biblioteca biblioteca, Livro livro) {
        this.biblioteca = biblioteca;
        this.livro = livro;
    }

    @Override
    public void executar() {
        biblioteca.emprestarLivro(livro);
    }
}

// Classe Receptor
public class Biblioteca {
    public void emprestarLivro(Livro livro) {
        System.out.println("Emprestando o livro: " + livro.getTitulo());
    }
}

// Classe Cliente
public class UsuarioBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("O Senhor dos Anéis");
        Comando emprestar = new EmprestarLivroComando(biblioteca, livro);

        emprestar.executar();
    }
}
