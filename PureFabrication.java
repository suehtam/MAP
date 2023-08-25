class Biblioteca {
    private List<Livro> livros;
    private Armazenamento armazenamento;
    
    public Biblioteca(Armazenamento armazenamento) {
        this.armazenamento = armazenamento;
    }
    
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        armazenamento.salvarLivro(livro);
    }
}

class Livro {
    private String titulo;
    private String autor;
    
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
}

interface Armazenamento {
    void salvarLivro(Livro livro);
}

class ArmazenamentoEmArquivo implements Armazenamento {
    
    @Override
    public void salvarLivro(Livro livro) {
        // Salva o livro em um arquivo
    }
}

class ArmazenamentoEmBancoDeDados implements Armazenamento {
    
    @Override
    public void salvarLivro(Livro livro) {
        // Salva o livro em um banco de dados
    }
}
/*Neste exemplo, a classe Biblioteca tem uma lista de livros e um objeto de armazenamento. Ela tem um método adicionarLivro que adiciona 
um livro à lista e chama o método salvarLivro no objeto de armazenamento para salvar o livro. A interface Armazenamento define um método 
salvarLivro que deve ser implementado por classes que implementam a interface. As classes ArmazenamentoEmArquivo e 
ArmazenamentoEmBancoDeDados implementam a interface Armazenamento e fornecem suas próprias implementações do método salvarLivro. 
Isso é um exemplo de Pure Fabrication, onde a responsabilidade de salvar livros é delegada a uma classe separada (ou classes) que não 
faz parte do domínio do problema (biblioteca), mas é criada especificamente para lidar com essa responsabilidade.*/