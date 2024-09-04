package view;

import dao.SupermercadoDao;
import model.Client;
import model.Supermercado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
    private SupermercadoDao dao;
    public TelaCliente(Supermercado supermercado) {
        this.supermercado = supermercado;
        setContentPane(contentPane);
        setModal(true);
        pack();
        getRootPane().setDefaultButton(buttonOK);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {
                preecherTabela();
                pack();
            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });



        adicionarBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAdicionarCliente telaAdicionarCliente = new TelaAdicionarCliente(supermercado);
                telaAdicionarCliente.setVisible(true);
            }
        });
    }

    private void createUIComponents() {
        System.out.println(supermercado.getClientes());
        table1 = new JTable();
        preecherTabela();
        // TODO: place custom component creation code here
    }
    private  void preecherTabela(){
        dao = new SupermercadoDao();
        String cnpj = supermercado.getCnpj();
        supermercado = dao.buscarPorCnpj(cnpj);
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
