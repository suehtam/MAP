import java.util.ArrayList;
import java.util.List;

// Component
interface Livro {
    void exibirInformacoes();
}

// Composite
class CategoriaLivro implements Livro {
    private String nome;
    private List<Livro> livros = new ArrayList<>();

    public CategoriaLivro(String nome) {
        this.nome = nome;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void removerLivro(Livro livro) {
        livros.remove(livro);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Categoria: " + nome);
        for (Livro livro : livros) {
            livro.exibirInformacoes();
        }
    }
}

// Leaf
class LivroFisico implements Livro {
    private String titulo;

    public LivroFisico(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Livro físico: " + titulo);
    }
}

public class Main {
    public static void main(String[] args) {
        // Exemplo de uso do Composite
        CategoriaLivro categoria = new CategoriaLivro("Romance");

        LivroFisico livro1 = new LivroFisico("Orgulho e Preconceito");
        LivroFisico livro2 = new LivroFisico("Romeu e Julieta");

        categoria.adicionarLivro(livro1);
        categoria.adicionarLivro(livro2);

        categoria.exibirInformacoes();
    }
}