class Livro {
    private String autor;
    private String titulo;
    private int anoPublicacao;
  
    private Livro(Builder builder) {
        this.autor = builder.autor;
        this.titulo = builder.titulo;
        this.anoPublicacao = builder.anoPublicacao;
    }
  
    // Getters
  
    static class Builder {
        private String autor;
        private String titulo;
        private int anoPublicacao;
  
        Builder setAutor(String autor) {
            this.autor = autor;
            return this;
        }
  
        Builder setTitulo(String titulo) {
            this.titulo = titulo;
            return this;
        }
  
        Builder setAnoPublicacao(int anoPublicacao) {
            this.anoPublicacao = anoPublicacao;
            return this;
        }
  
        Livro build() {
            return new Livro(this);
        }
    }
  }
  
  public class Main {
    public static void main(String[] args) {
        // Exemplo de uso do Builder
        Livro livro = new Livro.Builder()
                .setAutor("Machado de Assis")
                .setTitulo("Dom Casmurro")
                .setAnoPublicacao(1899)
                .build();
  
        System.out.println(livro.getTitulo());
    }
  }
  