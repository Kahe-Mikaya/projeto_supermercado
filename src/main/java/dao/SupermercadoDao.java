package dao;
import model.Supermecado;
import java.util.*;
  public class SupermercadoDao{
    private Set<Supermecado> supermercados;

    public SupermercadoDao(){
      supermercados = new HashSet<>();
    }
    public boolean adicionarSupermercado(Supermecado supermercado){
      return supermercados.add(supermercado);
    }
    public boolean removeSupermercado(Supermecado supermercado){
      return supermercados.remove(supermercado);
    }
    public Supermecado buscarPorCnpj(String cnpj){
      for(Supermecado supermercado : supermercados){
        if(supermercado.getCnpj().equals(cnpj)){
          return supermercado;
        }
      }
      return null;
      
    }
    
  }