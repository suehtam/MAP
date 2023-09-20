// Component
interface Livro {
    void exibirInformacoes();
}

// Concrete Component
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

// Decorator
abstract class Decorator implements Livro {
    protected Livro livroDecorado;

    public Decorator(Livro livroDecorado) {
        this.livroDecorado = livroDecorado;
    }

    @Override
    public void exibirInformacoes() {
        livroDecorado.exibirInformacoes();
    }
}

// Concrete Decorator
class LivroDigital extends Decorator {
    public LivroDigital(Livro livroDecorado) {
        super(livroDecorado);
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Formato: eBook");
    }
}

public class Main {
    public static void main(String[] args) {
        // Exemplo de uso do Decorator
        Livro livro = new LivroFisico("Dom Casmurro");
        
        // Adiciona o comportamento de livro digital ao livro físico existente
        livro = new LivroDigital(livro);

        livro.exibirInformacoes();
    }
}
