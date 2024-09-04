package view;

import dao.SupermercadoDao;
import model.Supermercado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame {
    private JPanel contentPane;
    private JButton deletarBotao;
    private JButton AdicionarBotao;
    private JTextField cnpjInput;
    private JButton buscarBotao;
    private JTextField nomeInput;
    private JButton AddProduto;
    private JButton salvarBotao;
    private JLabel cnpjLabel;
    private JLabel nomeLabel;
    private SupermercadoDao dao;

    public Tela() {
        dao = new SupermercadoDao();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(contentPane);
        setTitle("Supermercados");
        getRootPane().setDefaultButton(deletarBotao);
        ImageIcon imageicon = new ImageIcon("IMG/mercado.png");
        setIconImage(imageicon.getImage());


        salvarBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicou em Salvar");
                String cnpj = cnpjInput.getText();
                String nome = nomeInput.getText();

                Supermercado supermercado = new Supermercado(cnpj,nome);
                if(dao.salvar(supermercado)){
                    JOptionPane.showMessageDialog(contentPane,"sucesso em salvar") ;
                    limparFormulario();
                }
                else{
                    JOptionPane.showMessageDialog(contentPane,"Erro em salvar", "erro",JOptionPane.ERROR_MESSAGE) ;
                }


            }
        });
        buscarBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cnpj = cnpjInput.getText();
                String nome = nomeInput.getText();
                Supermercado supermercado = dao.buscarPorCnpj(cnpj);
                if(supermercado != null){
                    nomeInput.setText(supermercado.getNome());

                }
                else {
                    JOptionPane.showMessageDialog(contentPane,"Supermercado não encontrado","mensagem de erro",JOptionPane.ERROR_MESSAGE);
                }


            }
        });
        deletarBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cnpj = cnpjInput.getText();
                String nome = nomeInput.getText();
                Supermercado supermercado = new Supermercado(cnpj,nome);


                if(dao.deletar(supermercado)){
                    JOptionPane.showMessageDialog(contentPane,"sucesso em deletar") ;
                    limparFormulario();
                }
                else {
                    JOptionPane.showMessageDialog(contentPane,"Supermercado não encontrado","mensagem de erro",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        AdicionarBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cnpj = cnpjInput.getText();
                Supermercado supermercado = dao.buscarPorCnpj(cnpj);
                if(supermercado != null){
                    TelaCliente cadastroCliente = new TelaCliente(supermercado);
                    cadastroCliente.setVisible(true);
                }
            }
        });
    }
    private void limparFormulario(){
        nomeInput.setText("");
        cnpjInput.setText("");
    }
    public static void main(String[] args) {
        Tela dialog = new Tela();
        dialog.pack();
        dialog.setVisible(true);
    }
}
