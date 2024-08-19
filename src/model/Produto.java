package model;
import java.util.*;
import java.io.Serializable;

public class Produto implements Serializable{
  private int codigo;
  private String nome;
  private float preco;

  public Produto(int codigo, String nome, float preco){
    this.codigo = codigo;
    this.nome = nome;
    this.preco = preco;
  }

  public int getCodigo(){
    return codigo;
  }
  public String getNome(){
    return nome;
  }
  public float getPreco(){
    return preco;
  }

  
  public void setCodigo(int codigo){
    this.codigo = codigo;
  }
  public void setNome(String nome){
    this.nome = nome;
  }
  public void setPreco(float preco){
    this.preco = preco;
  }

  @Override
  public String toString(){
    return "Produto{" +
        "codigo=" + codigo +
        ", nome='" + nome + '\'' +
        ", preco=" + preco +
        '}';
  }

  @Override
  public boolean equals(Object o){
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Produto produto = (Produto) o;
    return codigo == produto.codigo ;
    }

  @Override
  public int hashCode(){
    return Objects.hash(codigo);
  }
}