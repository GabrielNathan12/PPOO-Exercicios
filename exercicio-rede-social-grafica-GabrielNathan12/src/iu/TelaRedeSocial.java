package iu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import feed.FeedNoticias;
import feed.MensagemNaoEntradaExeption;
import feed.Publicacao;
import java.awt.Font;

/**
 * Classe criada para implementar a interface gráfica da Rede Social.
 * O objetivo dessa implementação é didático! 
 * - Exercitar e apresentar conceitos de GUIs (Interfaces Gráficas de Usuário) 
 *   e Tratamento de Exceções
 * 
 * @author Julio Cesar Alves
 * 
 */
public class TelaRedeSocial {
    // Janela da nossa tela
    private JFrame janela;
    // Caixa de texto para exibir o feed de noticiai    
    private JTextArea areaTextoFeed;    
    // Botão para postar uma mensagem no feed
    private JButton botaoPostarMensagem;
    // Botão para curtir uma mensagem do feed
    private JButton botaoCurtir;
    // Botão para comentar uma mensagem do feed
    private JButton botaoComentar;
    
    // Objeto que representa a Regra de Negócios (a lógica da Rede Social em si)
    private FeedNoticias feed;

    private JButton botaoAtualizar;

    private JScrollPane tamJanela;

    private JComboBox<String> caixaAutores;

    private boolean carregar;
    
    /**
     * Construtor da classe: cria o feed, os componentes e monta a tela.
    */
    public TelaRedeSocial() {
        feed = new FeedNoticias();
        carregar = false;
        construirJanela();
        
    }

    /**
     * Constroi os componentes e monta a janela
    */
    private void construirJanela() throws HeadlessException {
        janela = new JFrame("GUI - Rede Social");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        criarComponentes();
        
        montarJanela();
    }

    /**
     * Cria os componentes da tela e faz a inscrição nos eventos necessários
     */
    private void criarComponentes() {
        // criando os componentes
        areaTextoFeed = new JTextArea();
        areaTextoFeed.setFont(new Font("SansSerif",Font.ITALIC,15));

        botaoPostarMensagem = new JButton("Postar Mensagem");
        botaoCurtir = new JButton("Curtir");
        botaoComentar = new JButton("Comentar");
        botaoAtualizar = new JButton("Atualizar");
        tamJanela = new JScrollPane(areaTextoFeed);
        
        caixaAutores = new JComboBox<>();
        preencherCaixaAutores();
        

        // impede que o usuário edite a área de texto do feed
        areaTextoFeed.setEditable(false);
        
        // adiciona o método que tratará o evento de clique no botão Postar Mensagem
        botaoPostarMensagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                postarMensagem();
            }            
        });
        
        // adiciona o método que tratará o evento de clique no botão Curtir
        botaoCurtir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curtirMensagem();
            }
        });


        botaoComentar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                comentarMensagem();
            }
        });

        botaoAtualizar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atualizarAreaTextoFeed();
            }
        });

        caixaAutores.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(!carregar){
                    atualizarAreaTextoFeed();
                }
            }
        });
    }

    /**
     * Monta a janela
     */
    private void montarJanela() {
        janela.setSize(500, 600);
        
        janela.setLayout(new BorderLayout());
        
        JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new FlowLayout());
        painelSuperior.add(new JLabel("Feed de Notícias"));
        painelSuperior.add(caixaAutores);
        janela.add(painelSuperior, BorderLayout.NORTH);
        
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));
        painelCentral.add(tamJanela);
        janela.add(painelCentral, BorderLayout.CENTER);
        
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        painelBotoes.add(botaoPostarMensagem);
        painelBotoes.add(botaoCurtir);
        painelBotoes.add(botaoComentar);
        painelBotoes.add(botaoAtualizar);
        
        janela.add(painelBotoes, BorderLayout.SOUTH);
    }
    
    private void preencherCaixaAutores(){
        carregar = true;
        caixaAutores.removeAllItems();
        caixaAutores.addItem("Todos:");

        for(String a: feed.getListaAutores()){
            caixaAutores.addItem(a);
        }
        carregar = false;
    }
    /*
     * Exibe a tela da Rede Social
    */
    public void exibir() {
        janela.setVisible(true);
    }
    
    /**
     * Posta uma mensagem no feed. Solicita o autor e a mensagem ao usuário,
     * posta no Feed e atualiza a área de texto de exibição do feed.
     */
    private void postarMensagem() {
        String autor = JOptionPane.showInputDialog("Autor da mensagem");
        // Se o usuário digitou algum autor e confirmou
        if(autor != null) {
            String mensagem = JOptionPane.showInputDialog("Texto da mensagem");
            // Se o usuário digitou alguma mensagem e confirmou
            if (mensagem != null) {
                feed.postarMensagemTexto(autor, mensagem); 
                preencherCaixaAutores();       
                atualizarAreaTextoFeed();
            }
        }
    }
    
    /**
     * Curte uma mensagem. Solicita o identificador da mensagem ao usuário,
     * curte a mensagem e atualiza a área de texto de exibição do feed.
     */
    private void curtirMensagem() {
        if(feed.nroMensagens() != 0){
            try{
                int idMensagem = Integer.parseInt(JOptionPane.showInputDialog("Id da mensagem"));
                feed.curtir(idMensagem);
                atualizarAreaTextoFeed();
            }
            catch(MensagemNaoEntradaExeption e){
                JOptionPane.showMessageDialog(janela , "ID = " + e.getID() + "Nao existe ", " Erro inesperado ", JOptionPane.ERROR_MESSAGE);
            }
            
            catch(RuntimeException e){
                JOptionPane.showMessageDialog(janela, "Digite um valor valido", "", JOptionPane.ERROR_MESSAGE);
                curtirMensagem();
            }
        }
        else{
            JOptionPane.showMessageDialog(janela, "Ocorreu um erro, nenhuma mensagem publicada", "" ,JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void comentarMensagem(){
        int idMensagem = Integer.parseInt(JOptionPane.showInputDialog("Ida da mensagem"));
        String texto = JOptionPane.showInputDialog("Seu comentario: ");
        feed.comentar(idMensagem,texto);
        atualizarAreaTextoFeed();
    }

    /**
     * Atualiza a área de texto de exibição do Feed.
     */
    private void atualizarAreaTextoFeed() {  
        // Limpa a lista de publicações
        areaTextoFeed.setText("");

        // Obtém as publicações do feed de notícias
        List<Publicacao> publicacoes = feed.getPublicacoes();

        String autor = caixaAutores.getItemAt(caixaAutores.getSelectedIndex());

        if(autor.equals("Todos:")){
            publicacoes = feed.getPublicacoes();
        }else{
            publicacoes = feed.getPublicacoes(autor);
        }
        // Percorre a lista de publicações adicionando na área de texto o texto da publicação
        for (Publicacao publicacao : publicacoes) {
            areaTextoFeed.append(publicacao.getTextoExibicao());
        }
    }
}
