package view;

import dao.SupermercadoDao;
import model.Client;
import model.Supermercado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAdicionarCliente extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField cpfInput;
    private JTextField nomeInput;
    private JTextField telefoneInput;
    private JTextField emailInput;
    private Supermercado supermercado;
    private SupermercadoDao dao;

    public TelaAdicionarCliente(Supermercado supermecado) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        this.supermercado = supermecado;
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfInput.getText();
                String nome = nomeInput.getText();
                String telefone = telefoneInput.getText();
                String email = emailInput.getText();
                Client cliente = new Client(cpf,nome,telefone,email);
                supermecado.adicionarCliente(cliente);

                if(dao.atualizar(supermercado)){
                    JOptionPane.showMessageDialog(contentPane,"Sucesso ao salvar");
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(contentPane,"error ao salvar","error",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}
