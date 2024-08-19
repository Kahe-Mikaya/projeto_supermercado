package dao;

import model.Supermercado;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class SupermercadoDao {

    private File arquivo;

    public SupermercadoDao() {
        arquivo = new File("supermercados.ser");

        if(!arquivo.exists()){
            try{
                arquivo.createNewFile();
            }catch (IOException e){
                System.out.println("Falha ao criar arquivo");
            }
        }
    }

    public Set<Supermercado> getSupermercados(){
        if(arquivo.length()>0){
            //Há dados no arquivo, ler conjunto
            try{
                FileInputStream inputStream = new FileInputStream(arquivo); 
                // FileInputStream: Abre uma conexão com o arquivo para leitura de dados binários.
                
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);//ObjectInputStream: Deserializa os objetos do fluxo de entrada, ou seja converte os bytes lidos do arquivo de volta para objetos Java.
                
                Set<Supermercado> supermercados =
                        (Set<Supermercado>) objectInputStream.readObject();
                
                return supermercados;
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado");
            } catch (IOException e) {
                System.out.println("Falha ao ler arquivo");
            } catch (ClassNotFoundException e) {
                System.out.println("Falha ao ler arquivo");
            }
        }
        //Não há nada no arquivo, criar um novo conjunto
        return new HashSet<>();
    }

    public boolean salvar(Supermercado supermercado) {
        Set<Supermercado> supermercados = getSupermercados();
        if(supermercados.add(supermercado)){
            
            try{
                FileOutputStream outputStream = new FileOutputStream(arquivo);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(supermercados);
                return true;
            
            
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado");
            
            } catch (IOException e) {
                System.out.println("Falha ao escrever no arquivo");
            }
        }
        return false;
    }

    public boolean deletar(Supermercado supermercado) {
        Set<Supermercado> supermercados = getSupermercados();
        if(supermercados.remove(supermercado)){
            try{
                FileOutputStream fileOutputStream = new FileOutputStream(arquivo);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(supermercados);
                return true;
            }catch (FileNotFoundException e) {
                    System.out.println("Arquivo não encontrado");

            } catch (IOException e) {
                    System.out.println("Falha ao escrever no arquivo");
             }
        }
        return false;
    }

    public Supermercado buscarPorCnpj(String cnpj){
        Set<Supermercado> supermercados = getSupermercados();
        
        try{
            FileInputStream inputStream = new FileInputStream(arquivo); 
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        supermercados = (Set<Supermercado>) objectInputStream.readObject();
        }catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado");
        }catch(IOException e){
            System.out.println("Falha ao ler arquivo");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Classe não encontrada: ");
        }
        
        
        // convertendo o objeto para um conjunto de supermercados
        for(Supermercado supermercado : supermercados){
            if(supermercado.getCnpj().equals(cnpj)){
                return supermercado;
            }
          
        }
        return null;  
    }

}
