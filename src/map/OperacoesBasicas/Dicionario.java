package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
  private Map<String, String> dicionario;

  public Dicionario() {
    this.dicionario = new HashMap<>();
  }

  public void adicionarPalavra(String palavra, String definicao) {
    dicionario.put(palavra, definicao);
  }

  public void removerPalavra(String palavra) {
    if (!dicionario.isEmpty()) {
      dicionario.remove(palavra);
    } else {
      System.out.println("O dicionário está vazio.");
    }
  }

  public String pesquisarPorPalavra(String palavra) {
    String definicao = dicionario.get(palavra);
    if (definicao != null) {
      return definicao;
    }
    return "Time não encontrada no dicionário.";
  }

  public void exibirPalavras() {
    if (!dicionario.isEmpty()) {
      System.out.println(dicionario);
    } else {
      System.out.println("O dicionário está vazio.");
    }
  }

  public static void main(String[] args) {
    Dicionario dicionario = new Dicionario();

    // Adicionar palavras (Times De Futebol Paulistas)
    dicionario.adicionarPalavra("santos", "Time localizado na cidade de Santos-SP.");
    dicionario.adicionarPalavra("palmeiras", "Time localizado na cidade de São Paulo-SP.");
    dicionario.adicionarPalavra("mirassol", "Time localizado na cidade de Mirassol-SP. ");

    // Exibir todas as palavras
    dicionario.exibirPalavras();

    // Pesquisar palavras
    String definicaoSantos = dicionario.pesquisarPorPalavra("santos");
    System.out.println("Definição do time 'santos': " + definicaoSantos);

    String definicaoMirassol = dicionario.pesquisarPorPalavra("mirassol");
    System.out.println(definicaoMirassol);

    // Remover uma palavra
    dicionario.removerPalavra("corinthians");
    dicionario.exibirPalavras();
  }
}
