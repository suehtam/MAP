class Biblioteca {
    private List<Livro> livros;
    
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }
    
    public List<Livro> buscarLivrosPorAutor(String autor) {
        List<Livro> livrosDoAutor = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equals(autor)) {
                livrosDoAutor.add(livro);
            }
        }
        return livrosDoAutor;
    }
}

class Livro {
    private String titulo;
    private String autor;
    
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    
    public String getAutor() {
        return autor;
    }
}
/*Neste exemplo, a classe Biblioteca é o Information Expert para os livros, pois ela contém a lista de livros e tem o método 
buscarLivrosPorAutor que busca livros por autor.A classe Livro é uma simples classe de dados que contém informações sobre um livro.*/