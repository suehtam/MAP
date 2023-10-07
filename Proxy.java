// Interface comum para RealObject e Proxy
public interface Livro {
    void exibir();
}

// Classe RealObject
public class LivroReal implements Livro {
    private String titulo;

    public LivroReal(String titulo) {
        this.titulo = titulo;
        carregarDoDisco();
    }

    private void carregarDoDisco() {
        System.out.println("Carregando o livro " + titulo);
    }

    @Override
    public void exibir() {
        System.out.println("Exibindo o livro " + titulo);
    }
}

// Classe Proxy
public class ProxyLivro implements Livro {
    private LivroReal livroReal;
    private String titulo;

    public ProxyLivro(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void exibir() {
        if (livroReal == null) {
            livroReal = new LivroReal(titulo);
        }
        livroReal.exibir();
    }
}

// Classe Cliente
public class Cliente {
    public static void main(String[] args) {
        Livro livro1 = new ProxyLivro("O Senhor dos Anéis");
        Livro livro2 = new ProxyLivro("Harry Potter");
        
        // O livro é carregado e exibido apenas quando o método exibir é chamado
        livro1.exibir();
        livro2.exibir();
    }
}