// Classes do subsistema
public class Livro {
    private String titulo;

    public Livro(String titulo) {
        this.titulo = titulo;
    }

    public void exibir() {
        System.out.println("Exibindo o livro: " + titulo);
    }
}

public class Usuario {
    private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public void exibir() {
        System.out.println("Usuário: " + nome);
    }
}

// Classe Facade
public class BibliotecaFacade {
    private Livro livro;
    private Usuario usuario;

    public BibliotecaFacade(String tituloLivro, String nomeUsuario) {
        this.livro = new Livro(tituloLivro);
        this.usuario = new Usuario(nomeUsuario);
    }

    public void exibirLivroUsuario() {
        livro.exibir();
        usuario.exibir();
    }
}

// Classe Cliente
public class Cliente {
    public static void main(String[] args) {
        BibliotecaFacade biblioteca = new BibliotecaFacade("O Senhor dos Anéis", "João");
        
        // A complexidade do subsistema é escondida pela fachada
        biblioteca.exibirLivroUsuario();
    }
}