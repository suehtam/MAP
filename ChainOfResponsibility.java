// A interface comum para todos os manipuladores
interface Handler {
  void setNext(Handler handler);
  void handle(String request);
}

// A classe abstrata que implementa a interface e define o método padrão para passar a solicitação
abstract class AbstractHandler implements Handler {
  private Handler next;

  public void setNext(Handler handler) {
    this.next = handler;
  }

  public void handle(String request) {
    if (this.next != null) {
      this.next.handle(request);
    }
  }
}

// Uma classe concreta que representa um funcionário da biblioteca que pode emprestar livros
class LoanHandler extends AbstractHandler {
  public void handle(String request) {
    if (request.equals("loan")) {
      System.out.println("Emprestando o livro...");
    } else {
      System.out.println("Não posso lidar com essa solicitação, passando para o próximo...");
      super.handle(request);
    }
  }
}

// Uma classe concreta que representa um funcionário da biblioteca que pode devolver livros
class ReturnHandler extends AbstractHandler {
  public void handle(String request) {
    if (request.equals("return")) {
      System.out.println("Devolvendo o livro...");
    } else {
      System.out.println("Não posso lidar com essa solicitação, passando para o próximo...");
      super.handle(request);
    }
  }
}

// Uma classe concreta que representa um funcionário da biblioteca que pode reservar livros
class ReserveHandler extends AbstractHandler {
  public void handle(String request) {
    if (request.equals("reserve")) {
      System.out.println("Reservando o livro...");
    } else {
      System.out.println("Não posso lidar com essa solicitação, passando para o próximo...");
      super.handle(request);
    }
  }
}

// Uma classe que cria a cadeia de manipuladores e executa a solicitação
class LibrarySystem {
  public static void main(String[] args) {
    // Criando os objetos manipuladores
    Handler loanHandler = new LoanHandler();
    Handler returnHandler = new ReturnHandler();
    Handler reserveHandler = new ReserveHandler();

    // Configurando a ordem da cadeia
    loanHandler.setNext(returnHandler);
    returnHandler.setNext(reserveHandler);

    // Executando uma solicitação de empréstimo
    loanHandler.handle("loan");
    // Saída: Emprestando o livro...

    // Executando uma solicitação de reserva
    loanHandler.handle("reserve");
    // Saída: Não posso lidar com essa solicitação, passando para o próximo...
    //        Não posso lidar com essa solicitação, passando para o próximo...
    //        Reservando o livro...

    // Executando uma solicitação inválida
    loanHandler.handle("buy");
    // Saída: Não posso lidar com essa solicitação, passando para o próximo...
    //        Não posso lidar com essa solicitação, passando para o próximo...
    //        Não posso lidar com essa solicitação, passando para o próximo...
  }
}