// Interface Visitor
public interface Visitor {
    void visit(Livro livro);
}

// Classe ConcreteVisitor
public class BibliotecaVisitor implements Visitor {
    @Override
    public void visit(Livro livro) {
        System.out.println("Visitando o livro: " + livro.getTitulo());
    }
}

// Classe Element
public class Livro {
    private String titulo;

    public Livro(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Classe Cliente
public class UsuarioBiblioteca {
    public static void main(String[] args) {
        Livro livro = new Livro("O Senhor dos Anéis");
        Visitor visitor = new BibliotecaVisitor();

        livro.accept(visitor);
    }
}
