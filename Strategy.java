// A interface Strategy declara operações comuns para todos os algoritmos suportados.
interface Strategy {
  public double calcularMulta(int diasAtraso);
}

// As classes ConcreteStrategy implementam o algoritmo seguindo a interface base Strategy.
class MultaNormal implements Strategy {
  public double calcularMulta(int diasAtraso) {
    return diasAtraso * 1.0; // multa de R$ 1,00 por dia de atraso
  }
}

class MultaEspecial implements Strategy {
  public double calcularMulta(int diasAtraso) {
    return diasAtraso * 0.5; // multa de R$ 0,50 por dia de atraso
  }
}

// A classe Context define a interface de interesse para os clientes.
class Emprestimo {
  private Strategy strategy; // referência para um dos objetos ConcreteStrategy
  private int diasAtraso;

  public Emprestimo(Strategy strategy, int diasAtraso) {
    this.strategy = strategy;
    this.diasAtraso = diasAtraso;
  }

  // O Context permite substituir um objeto Strategy em tempo de execução.
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  // O Context delega alguns trabalhos para o objeto Strategy.
  public double calcularMulta() {
    return strategy.calcularMulta(diasAtraso);
  }
}

// A classe Cliente cria e configura o objeto Context.
class Cliente {
  public static void main(String[] args) {
    // Criando um empréstimo com multa normal
    Emprestimo emprestimo1 = new Emprestimo(new MultaNormal(), 5);
    System.out.println("Multa do empréstimo 1: R$ " + emprestimo1.calcularMulta());

    // Criando um empréstimo com multa especial
    Emprestimo emprestimo2 = new Emprestimo(new MultaEspecial(), 10);
    System.out.println("Multa do empréstimo 2: R$ " + emprestimo2.calcularMulta());

    // Alterando a estratégia do empréstimo 1 para multa especial
    emprestimo1.setStrategy(new MultaEspecial());
    System.out.println("Multa do empréstimo 1 após mudança: R$ " + emprestimo1.calcularMulta());
  }
}