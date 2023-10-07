import java.util.ArrayList;
import java.util.List;

// Componente
interface Item {
    void imprimir();
}

// Composto
class Livro implements Item {
    private final String titulo;
    private final String autor;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    @Override
    public void imprimir() {
        System.out.println("Livro: " + titulo + " por " + autor);
    }
}

// Composto
class Prateleira implements Item {
    private final List<Item> itens = new ArrayList<>();

    public void adicionar(Item item) {
        itens.add(item);
    }

    @Override
    public void imprimir() {
        System.out.println("Prateleira:");
        for (Item item : itens) {
            item.imprimir();
        }
    }
}

// Decorador
class ItemEmprestavel implements Item {
    private final Item item;
    private String emprestadoPara;

    public ItemEmprestavel(Item item) {
        this.item = item;
    }

    public void emprestar(String emprestadoPara) {
        this.emprestadoPara = emprestadoPara;
    }

    @Override
    public void imprimir() {
        item.imprimir();
        if (emprestadoPara != null) {
            System.out.println("Emprestado para: " + emprestadoPara);
        }
    }
}

public class SistemaBiblioteca {
    public static void main(String[] args) {
        // Criando objetos usando o padrão Builder
        Item livro1 = new Livro("Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides");
        Item livro2 = new Livro("Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin");

        // Criando uma prateleira e adicionando livros
        Prateleira prateleira = new Prateleira();
        prateleira.adicionar(livro1);
        prateleira.adicionar(livro2);

        // Decorando os livros com a funcionalidade de empréstimo
        ItemEmprestavel livroEmprestavel1 = new ItemEmprestavel(livro1);
        ItemEmprestavel livroEmprestavel2 = new ItemEmprestavel(livro2);
        livroEmprestavel1.emprestar("Fulano");
        livroEmprestavel2.emprestar("Ciclano");

        // Criando uma prateleira e adicionando livros decorados
        Prateleira prateleiraDecorada = new Prateleira();
        prateleiraDecorada.adicionar(livroEmprestavel1);
        prateleiraDecorada.adicionar(livroEmprestavel2);

        // Imprimindo a prateleira
        prateleiraDecorada.imprimir();
    }
}
