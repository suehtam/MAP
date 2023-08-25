class Item {
    private String titulo;
    
    public Item(String titulo) {
        this.titulo = titulo;
    }
    
    public String getTipo() {
        return "Item";
    }
}

class Livro extends Item {
    private String autor;
    
    public Livro(String titulo, String autor) {
        super(titulo);
        this.autor = autor;
    }
    
    @Override
    public String getTipo() {
        return "Livro";
    }
}

class Revista extends Item {
    private String editora;
    
    public Revista(String titulo, String editora) {
        super(titulo);
        this.editora = editora;
    }
    
    @Override
    public String getTipo() {
        return "Revista";
    }
}

class Biblioteca {
    private List<Item> itens;
    
    public void adicionarItem(Item item) {
        itens.add(item);
    }
    
    public void imprimirItens() {
        for (Item item : itens) {
            System.out.println(item.getTipo() + ": " + item.getTitulo());
        }
    }
}
/*Neste exemplo, a classe Item é uma classe base para as classes Livro e Revista, que são subclasses de Item. A classe Item tem um 
método getTipo que retorna o tipo do item como uma string. As classes Livro e Revista sobrescrevem o método getTipo para retornar seus 
próprios tipos como strings. Isso é um exemplo de polimorfismo, onde o mesmo método é implementado de maneiras diferentes em diferentes 
classes. A classe Biblioteca tem uma lista de itens e um método adicionarItem para adicionar itens à lista. Ela também tem um método 
imprimirItens que imprime os tipos e títulos dos itens na lista. Quando este método é chamado, ele chama o método getTipo em cada item 
da lista. Devido ao polimorfismo, o método correto getTipo é chamado para cada item, dependendo do tipo real do item.*/