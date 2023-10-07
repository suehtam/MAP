// Interface antiga
interface BibliotecaAntiga {
    void emitirLivroAntigo();
}

// Classe antiga
class SistemaBibliotecaAntiga implements BibliotecaAntiga {
    public void emitirLivroAntigo() {
        System.out.println("Livro emitido pelo sistema antigo da biblioteca");
    }
}

// Interface nova
interface BibliotecaNova {
    void emitirLivro();
}

// Classe Adaptadora
class AdaptadorBiblioteca implements BibliotecaNova {
    BibliotecaAntiga bibliotecaAntiga;
    public AdaptadorBiblioteca(BibliotecaAntiga bibliotecaAntiga) {
        this.bibliotecaAntiga = bibliotecaAntiga;
    }
    public void emitirLivro() {
        bibliotecaAntiga.emitirLivroAntigo();
    }
}

// Classe principal
public class Principal {
    public static void main(String[] args) {
        BibliotecaAntiga bibliotecaAntiga = new SistemaBibliotecaAntiga();
        BibliotecaNova bibliotecaNova = new AdaptadorBiblioteca(bibliotecaAntiga);
        bibliotecaNova.emitirLivro();
    }
}
