// Interface Strategy
public interface EmprestimoStrategy {
  public void calcularEmprestimo();
}

// Classe Concreta 1
public class EmprestimoLivro implements EmprestimoStrategy {
  @Override
  public void calcularEmprestimo() {
      System.out.println("Calculando empréstimo para livro...");
  }
}

// Classe Concreta 2
public class EmprestimoRevista implements EmprestimoStrategy {
  @Override
  public void calcularEmprestimo() {
      System.out.println("Calculando empréstimo para revista...");
  }
}

// Classe Contexto
public class Biblioteca {
  private EmprestimoStrategy emprestimoStrategy;

  public Biblioteca(EmprestimoStrategy emprestimoStrategy) {
      this.emprestimoStrategy = emprestimoStrategy;
  }

  public void executarCalculoEmprestimo() {
      emprestimoStrategy.calcularEmprestimo();
  }
}

// Classe Principal
public class Main {
  public static void main(String[] args) {
      Biblioteca bibliotecaLivro = new Biblioteca(new EmprestimoLivro());
      bibliotecaLivro.executarCalculoEmprestimo();

      Biblioteca bibliotecaRevista = new Biblioteca(new EmprestimoRevista());
      bibliotecaRevista.executarCalculoEmprestimo();
  }
}