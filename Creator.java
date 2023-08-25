class Biblioteca {
    private List<Emprestimo> emprestimos;
    
    public Emprestimo criarEmprestimo(Usuario usuario, Livro livro) {
        Emprestimo emprestimo = new Emprestimo(usuario, livro);
        emprestimos.add(emprestimo);
        return emprestimo;
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

class Usuario {
    private String nome;
    
    public Usuario(String nome) {
        this.nome = nome;
    }
}

class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    
    public Emprestimo(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
    }
}
/*Neste exemplo, a classe Biblioteca é o Creator para a classe Emprestimo, pois ela tem o método criarEmprestimo que cria uma nova 
instância da classe Emprestimo. As classes Livro, Usuario e Emprestimo são simples classes de dados que contêm informações sobre livros, 
usuários e empréstimos, respectivamente.*/