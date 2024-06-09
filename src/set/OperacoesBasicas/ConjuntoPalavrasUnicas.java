package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
  //atributos
  private Set<String> palavrasUnicasSet;

  public ConjuntoPalavrasUnicas() {
    this.palavrasUnicasSet = new HashSet<>();
  }

  public void adicionarPalavra(String palavra) {
    palavrasUnicasSet.add(palavra);
  }

  public void removerPalavra(String palavra) {
    if (!palavrasUnicasSet.isEmpty()) {
      if (palavrasUnicasSet.contains(palavra)) {
        palavrasUnicasSet.remove(palavra);
      } else {
        System.out.println("Palavra não encontrada no conjunto!");
      }
    } else {
      System.out.println("O conjunto está vazio!");
    }
  }

  public boolean verificarPalavra(String palavra) {
    return palavrasUnicasSet.contains(palavra);
  }

  public void exibirPalavrasUnicas() {
    if(!palavrasUnicasSet.isEmpty()) {
      System.out.println(palavrasUnicasSet);
    } else {
      System.out.println("O conjunto está vazio!");
    }
  }

  public static void main(String[] args) {
    // Criando uma instância da classe ConjuntoPalavrasUnicas
    ConjuntoPalavrasUnicas conjuntoTimesPaulistas = new ConjuntoPalavrasUnicas();

    // Adicionando times de futebol únicos ao conjunto
    conjuntoTimesPaulistas.adicionarPalavra("Santos");
    conjuntoTimesPaulistas.adicionarPalavra("Palmeiras");
    conjuntoTimesPaulistas.adicionarPalavra("São Paulo");
    conjuntoTimesPaulistas.adicionarPalavra("Corinthians");
    conjuntoTimesPaulistas.adicionarPalavra("Bragantino");
    conjuntoTimesPaulistas.adicionarPalavra("Portuguesa");

    // Exibindo os times no conjunto
    conjuntoTimesPaulistas.exibirPalavrasUnicas();

    // Removendo um time do conjunto
    conjuntoTimesPaulistas.removerPalavra("Corinthians");
    conjuntoTimesPaulistas.exibirPalavrasUnicas();

    // Removendo um time inexistente
    conjuntoTimesPaulistas.removerPalavra("Flamengo");

    // Verificando se um time está no conjunto
    System.out.println("O Time 'Santos' está no conjunto? " + conjuntoTimesPaulistas.verificarPalavra("Santos"));
    System.out.println("O Time 'Portuguesa' está no conjunto? " + conjuntoTimesPaulistas.verificarPalavra("Portuguesa"));

    // Exibindo os times únicos atualizadas no conjunto
    conjuntoTimesPaulistas.exibirPalavrasUnicas();
  }
}
