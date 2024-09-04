package view;
import  dao.*;
import model.*;
import javax.swing.*;


public class Main {
  public static void main(String[] args) {
    String profissoes[] = {"carpinteiro","pedreiro"};
    JOptionPane.showMessageDialog(null, "Bem vindo ao Supermercado");

    JOptionPane.showOptionDialog(null,"minha mensagem","titulo",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,profissoes,profissoes[0]);

  }
}