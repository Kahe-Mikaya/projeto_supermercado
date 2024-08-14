package model;
import java.util.*;

public class Supermecado{
  private String cnpj;
  private String nome;
  private Set<Produto> produtos;
  private Set<Client> clientes;

  public Supermecado(String cnpj, String nome){
    this.cnpj = cnpj;
    this.nome = nome;
    this.produtos = new HashSet<>();
    this.clientes = new HashSet<>();
  }
  public String getCnpj(){
    return cnpj;
  }
  public String getNome(){
    return nome;
  }
  public Set<Produto> getProdutos(){
    return produtos;
  }
  public Set<Client> getClientes(){
    return clientes;
  }
  public void setCnpj(String cnpj){
    this.cnpj = cnpj;
  }
  public void setNome(String nome){
    this.nome = nome;
  }

  public boolean adicionarProduto(Produto produto){
    return produtos.add(produto);
    
  }
  public boolean removeProduto(Produto produto){
    return produtos.remove(produto);
  }
  public boolean containsProduto(Produto produto){
    return produtos.contains(produto);
  }

  public boolean adicionarCliente(Client cliente){
    return clientes.add(cliente);
  }

  public boolean removeCliente(Client cliente){
    return clientes.remove(cliente);
  }

  public boolean containsCliente(Client cliente){
    return clientes.contains(cliente);
  }
  
  

  @Override
  public String toString(){
    return "Supermecado{" +
        "cnpj='" + cnpj + '\'' +
        ", nome='" + nome + '\'' +
        ", produtos=" + produtos +
        ", clientes=" + clientes +
        '}';
  }
    
}