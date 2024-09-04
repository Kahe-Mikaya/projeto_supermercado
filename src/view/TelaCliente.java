package view;

import model.Client;
import model.Supermercado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaCliente extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table1;
    private JButton adicionarBotao;
    private Supermercado supermercado;
    public TelaCliente(Supermercado supermecado) {
        setContentPane(contentPane);
        setModal(true);
        pack();
        getRootPane().setDefaultButton(buttonOK);
        this.supermercado = supermecado;
        adicionarBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAdicionarCliente telaAdicionarCliente = new TelaAdicionarCliente(supermecado);
                telaAdicionarCliente.setVisible(true);
            }
        });
    }

    private void createUIComponents() {
        table1 = new JTable();
        preecherTabela();
        // TODO: place custom component creation code here
    }
    private  void preecherTabela(){
        String titulos[] = {"Cpf","Nome","Telefone","Email"};
        Set<Client> clientes = supermercado.getClientes();
        List<Client> clientesLista = clientes.stream().toList();
        String dados[][] = new String[supermercado.getClientes().size()][4];

        for (int i=0; i<clientes.size(); i++){
            dados[i][0] = clientesLista.get(i).getCpf();
            dados[i][1] = clientesLista.get(i).getNome();
            dados[i][2] = clientesLista.get(i).getTelefone();
            dados[i][3] = clientesLista.get(i).getEmail();

        }

        DefaultTableModel model = new DefaultTableModel(dados, titulos);
        table1.setModel(model);
    }
}
