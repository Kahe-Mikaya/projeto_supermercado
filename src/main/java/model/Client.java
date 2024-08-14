package model;

import java.util.*;
public class Client{
  private String cpf;
  private String nome;
  private String telefone;
  private String email;

  public Client(String cpf, String nome, String telefone, String email){
    this.cpf = cpf;
    this.nome = nome;
    this.telefone = telefone;
    this.email = email;
  }

  public String getCpf(){
    return cpf;
  }
  public String getNome(){
    return nome;
  }
  public String getTelefone(){
    return telefone;
  }

  public String getEmail(){
    return email;
  }
  public void setCpf(String cpf){
    this.cpf = cpf;
  }
  public void setNome(String nome){
    this.nome = nome;
  }
  public void setTelefone(String telefone){
    this.telefone = telefone;
  }
  public void setEmail(String email){
    this.email = email;
  }

  @Override
  public String toString(){
    return "Cliente{" +
        "cpf='" + cpf + '\'' +
        ", nome='" + nome + '\'' +
        ", telefone='" + telefone + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
  @Override
  public boolean equals(Object o){
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Client client = (Client) o;
    return Objects.equals(cpf, client.cpf);
  }
  
  
}