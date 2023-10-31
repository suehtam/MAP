// A interface comum para todos os observadores
interface Observer {
    void update(String message);
  }
  
  // A classe abstrata que representa o sujeito que pode ter vários observadores
  abstract class Subject {
    private List<Observer> observers;
  
    public Subject() {
      this.observers = new ArrayList<>();
    }
  
    public void attach(Observer observer) {
      this.observers.add(observer);
    }
  
    public void detach(Observer observer) {
      this.observers.remove(observer);
    }
  
    public void notifyObservers(String message) {
      for (Observer observer : this.observers) {
        observer.update(message);
      }
    }
  }
  
  // Uma classe concreta que representa um livro na biblioteca
  class Book extends Subject {
    private String title;
    private String author;
    private boolean available;
  
    public Book(String title, String author, boolean available) {
      super();
      this.title = title;
      this.author = author;
      this.available = available;
    }
  
    public String getTitle() {
      return this.title;
    }
  
    public String getAuthor() {
      return this.author;
    }
  
    public boolean isAvailable() {
      return this.available;
    }
  
    public void setAvailable(boolean available) {
      this.available = available;
      // Notifica os observadores sobre a mudança de disponibilidade
      this.notifyObservers(this.title + " está " + (available ? "disponível" : "indisponível"));
    }
  }
  
  // Uma classe concreta que representa um usuário da biblioteca que pode observar os livros
  class User implements Observer {
    private String name;
  
    public User(String name) {
      this.name = name;
    }
  
    public String getName() {
      return this.name;
    }
  
    // Recebe a notificação do sujeito e imprime na tela
    public void update(String message) {
      System.out.println(this.name + " recebeu a notificação: " + message);
    }
  }
  
  // Uma classe que cria alguns objetos e testa o padrão
  class LibrarySystem {
    public static void main(String[] args) {
      // Criando alguns livros e usuários
      Book book1 = new Book("O Senhor dos Anéis", "J.R.R. Tolkien", true);
      Book book2 = new Book("Harry Potter e a Pedra Filosofal", "J.K. Rowling", false);
      User user1 = new User("Alice");
      User user2 = new User("Bob");
  
      // Adicionando os usuários como observadores dos livros
      book1.attach(user1);
      book1.attach(user2);
      book2.attach(user1);
  
      // Mudando a disponibilidade dos livros e verificando as notificações
      book1.setAvailable(false);
      // Saída: Alice recebeu a notificação: O Senhor dos Anéis está indisponível
      //        Bob recebeu a notificação: O Senhor dos Anéis está indisponível
  
      book2.setAvailable(true);
      // Saída: Alice recebeu a notificação: Harry Potter e a Pedra Filosofal está disponível
  
      book1.setAvailable(true);
      // Saída: Alice recebeu a notificação: O Senhor dos Anéis está disponível
      //        Bob recebeu a notificação: O Senhor dos Anéis está disponível
    }
  }  