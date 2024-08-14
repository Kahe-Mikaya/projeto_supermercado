package view;
import model.*;
public class Main {
  public static void main(String[] args) {
    Supermecado supermecado = new Supermecado("123456789", "Supermercado do zé");
    supermecado.adicionarCliente(new Client("123456789", "Zé", "999999999", "qpmzj@example.com"));
    System.out.println(supermecado.adicionarCliente(new Client("123456789", "Zé", "999999999", "qpmzj@example.com")));
    
  }

}