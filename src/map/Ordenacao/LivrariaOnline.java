package map.Ordenacao;

import java.util.*;

public class LivrariaOnline {
  private Map<String, Livro> livros;

  public LivrariaOnline() {
    this.livros = new HashMap<>();
  }

  public void adicionarLivro(String link, Livro livro) {
    livros.put(link, livro);
  }

  public void removerLivro(String titulo) {
    List<String> chavesRemover = new ArrayList<>();
    for (Map.Entry<String, Livro> entry : livros.entrySet()) {
      if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
        chavesRemover.add(entry.getKey());
      }
    }
    for (String chave : chavesRemover) {
      livros.remove(chave);
    }
  }

  public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
    List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livros.entrySet());

    Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());

    Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

    for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
      livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
    }

    return livrosOrdenadosPorPreco;
  }

  public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {
    List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livros.entrySet());

    Collections.sort(livrosParaOrdenarPorAutor, new ComparatorPorAutor());

    Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();

    for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorAutor) {
      livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
    }

    return livrosOrdenadosPorAutor;
  }

  public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
    Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();
    for (Map.Entry<String, Livro> entry : livros.entrySet()) {
      Livro livro = entry.getValue();
      if (livro.getAutor().equals(autor)) {
        livrosPorAutor.put(entry.getKey(), livro);
      }
    }
    return livrosPorAutor;
  }

  public List<Livro> obterLivroMaisCaro() {
    List<Livro> livrosMaisCaros = new ArrayList<>();
    double precoMaisAlto = Double.MIN_VALUE;

    if (!livros.isEmpty()) {
      for (Livro livro : livros.values()) {
        if (livro.getPreco() > precoMaisAlto) {
          precoMaisAlto = livro.getPreco();
        }
      }
    } else {
      throw new NoSuchElementException("A livraria está vazia!");
    }

    for(Map.Entry<String, Livro> entry: livros.entrySet()) {
      if(entry.getValue().getPreco() == precoMaisAlto) {
        Livro livroComPrecoMaisAlto = livros.get(entry.getKey());
        livrosMaisCaros.add(livroComPrecoMaisAlto);
      }
    }
    return livrosMaisCaros;
  }

  public List<Livro> obterLivroMaisBarato() {
    List<Livro> livrosMaisBaratos = new ArrayList<>();
    double precoMaisBaixo = Double.MAX_VALUE;

    if (!livros.isEmpty()) {
      for (Livro livro : livros.values()) {
        if (livro.getPreco() < precoMaisBaixo) {
          precoMaisBaixo = livro.getPreco();
        }
      }
    } else {
      throw new NoSuchElementException("A livraria está vazia!");
    }

    for(Map.Entry<String, Livro> entry: livros.entrySet()) {
      if(entry.getValue().getPreco() == precoMaisBaixo) {
        Livro livroComPrecoMaisBaixo = livros.get(entry.getKey());
        livrosMaisBaratos.add(livroComPrecoMaisBaixo);
      }
    }
    return livrosMaisBaratos;
  }

  public static void main(String[] args) {
    LivrariaOnline livrariaOnline = new LivrariaOnline();
    // Adiciona os livros à livraria online
    livrariaOnline.adicionarLivro("https://www.amazon.com.br/Harry-Potter-As-Rel%C3%ADquias-Morte/dp/8532522610", new Livro("Harry Potter e as Relíquias da Morte", "J.K. Rowling", 59d));
    livrariaOnline.adicionarLivro("https://www.amazon.com.br/T%C3%A1tica-Mente-Explicada-Pranchetas-Treinadores/dp/8578883446", new Livro("TáticaMente", "Paulo Vinícius Coelho", 21.88d));
    livrariaOnline.adicionarLivro("https://www.amazon.com.br/Sutil-Arte-Ligar-Se/dp/855100249X", new Livro("A Sutil Arte de Ligar o F*da-Se: Uma estratégia inusitada para uma vida melhor.", "Mark Manson", 42.82d));
    livrariaOnline.adicionarLivro("https://www.amazon.com.br/Simplesmente-Helena-Carolina-Kotscho/dp/8576652544", new Livro("Simplesmente Helena", "Carolina Kotscho", 39d));
    livrariaOnline.adicionarLivro("https://www.amazon.com.br/%C3%A1rvore-que-dava-dinheiro/dp/8516061434", new Livro("A Árvore que Dava Dinheiro ", "Domingos Pellegrini", 55.77d));
    livrariaOnline.adicionarLivro("https://www.amazon.com.br/Escola-brasileira-futebol-Vin%C3%ADcius-Coelho/dp/8547000577", new Livro("Escola Brasileira de Futebol", "Paulo Vinícius Coelho", 49d));

    // Exibe todos os livros ordenados por preço
    System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

    //Exibe todos os livros ordenados por autor
    System.out.println("Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorAutor());

    // Pesquisa livros por autor
    String autorPesquisa = "Paulo Vinícius Coelho";
    livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa);

    // Obtém e exibe o livro mais caro
    System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

    // Obtém e exibe o livro mais barato
    System.out.println("Livro mais barato: " + livrariaOnline.obterLivroMaisBarato());

    // Remover um livro pelo título
    livrariaOnline.removerLivro("Harry Potter e as Relíquias da Morte");
    System.out.println(livrariaOnline.livros);

  }
}
