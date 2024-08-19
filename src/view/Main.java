package view;
import dao.*;
import model.*;
public class Main {
  public static void main(String[] args) {
    SupermercadoDao supermercadoDao = new SupermercadoDao();

    Supermercado supermercado = new Supermercado("111",
            "Mercadinho da esquina");

    if(supermercadoDao.salvar(supermercado)){
        System.out.println("Salvo com sucesso!");
    }else{
        System.out.println("Falha ao salvar");
    }
    
    System.out.println(supermercadoDao.buscarPorCnpj("111"));

  }

}