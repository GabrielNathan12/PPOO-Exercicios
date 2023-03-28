package br.ufla.gac106.s2022_2.sirios.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridLayout;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.ufla.gac106.javaWikiAPI.PaginaWiki;
import br.ufla.gac106.javaWikiAPI.Wiki;
import br.ufla.gac106.s2022_2.sirios.controller.TimesController;
import br.ufla.gac106.s2022_2.sirios.controller.UserController;
import br.ufla.gac106.s2022_2.sirios.times.Time;
import br.ufla.gac106.s2022_2.sirios.userFactory.TiposUser;
import br.ufla.gac106.s2022_2.sirios.userFactory.User;
/**Classe GUI, que monta a interface de usuario */

public class Gui implements Executar {
    private TelaSistema telaPrincial;
    private UserController controladorUser;
    private TelaCadastro telaCadastro;
    
    private JFrame janela;
    private JTextArea campoLogin;
    private JPasswordField campoSenha;
    private JButton botaoLogin;
    private JButton botaoCadastro;
    
    public Gui(){
        controladorUser = new UserController();
        telaCadastro = new TelaCadastro();
        telaPrincial = new TelaSistema();
        construirJanela();
    }
    /**controi o JFrame */
    private void construirJanela() throws HeadlessException {
        janela = new JFrame("Times - Clubes e Selecao");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        criarComponentes();

        montarJanela();
    }
    /**mostra a janela */
    public void executar(){
        janela.setVisible(true);
        
    }
    /**cria os componentes da janela */
    private void criarComponentes(){
        campoLogin = new JTextArea();
        campoSenha = new JPasswordField();
        botaoLogin = new JButton("Logar");
        botaoCadastro = new JButton("Cadastrar");

        campoLogin.setPreferredSize(new Dimension(150, 20));
        campoSenha.setPreferredSize(new Dimension(150, 20));

        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                logar();
               
            }
        });

        botaoCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                cadastro();
            }
        });
    }

    private void executarTelaPrincipal(){ 
        janela.setVisible(false);
        telaPrincial.executarTela();
    }

    private void logar(){
        String username;
        String senha;
        username = campoLogin.getText();
        senha = new String(campoSenha.getPassword());
        if(controladorUser.verificaUsername(username)){
            if(controladorUser.verificaSenha(senha, username)){
                JOptionPane.showMessageDialog(janela, "Login efetuado com Sucesso");;
                executarTelaPrincipal();

            }
            else{
                JOptionPane.showMessageDialog(janela, "Senha invalida");
            }
        }
        else{
            JOptionPane.showMessageDialog(janela, "Usuario invalido");
        }
    }   

    /**cadastrar usuario */
    private void cadastro(){
        telaCadastro.executarTelaCadastro();
        //janela.setVisible(true);
    }
    /**monta a janela */
    private void montarJanela(){
        janela.setSize(500,900);
        janela.setLayout(new GridLayout(3, 2));
        
        JPanel painelUsuario = new JPanel();
        painelUsuario.setLayout(new FlowLayout());
        painelUsuario.add(new JLabel("Usuario"));
        painelUsuario.add(campoLogin);
        janela.add(painelUsuario);
        
        JPanel painelSenha = new JPanel();
        painelSenha.setLayout(new FlowLayout());
        painelSenha.add(new JLabel("Senha"));
        painelSenha.add(campoSenha);
        janela.add(painelSenha);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        painelBotoes.add(botaoLogin);
        painelBotoes.add(botaoCadastro);
        janela.add(painelBotoes);
        
        janela.pack();
    }

/**Classe que cria a tela principal */
    private class TelaSistema{
        private JFrame janelaSistema;
        private JTextArea areaTexto;
        private List<String> publicacoes;
        private UserController controladorUser;
        private TimesController controladorTime;
        private JButton botaoCadastrarTime;
        private JButton botaoCadastrarUser;
        private JButton botaoBuscarTime;
        private JButton botaoBuscarUser;
        private JButton botaoExcluirTime;
        private JButton botaoExcluirUser;
        private JButton botaoWiki;
        private JButton botaoComentar;
        private JButton botaoDarNota;
        private JButton botaoGrafico;
        private JButton botaoImprimirUser;
        private JButton botaoImprimirTimes;
        private JButton botaoFiltragem;
        private JButton botaoLimpar;
        private JScrollPane tamJanela;

        private Wiki wiki;

        public TelaSistema(){
            publicacoes = new ArrayList<>();
            controladorUser = new UserController();
            controladorTime = new  TimesController();
            wiki = new Wiki();
            construirJanelaSistema();
            
        }
        /**Constroi a JFrama da telaPrincipal */
        private void construirJanelaSistema(){
            janelaSistema = new JFrame("Seja bem vindo a Sirios"); 
            janelaSistema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            criarComponentesTela();
            montarTelaSistema();
            
        }
        /**cria os componentes da tela */
        private void criarComponentesTela(){

            areaTexto = new JTextArea();
            areaTexto.setFont(new Font("SansSerif",Font.ITALIC,15));
            areaTexto.setEditable(false);
            //areaTexto.setPreferredSize(new Dimension(350, 350));
            botaoCadastrarTime = new JButton("Cadastrar Time");
            botaoCadastrarUser = new JButton("Cadastrar Usuario");
            tamJanela = new JScrollPane(areaTexto);
            botaoBuscarUser = new JButton("Buscar Usuario");
            botaoBuscarTime = new JButton("Buscar Time:");
            botaoExcluirTime = new JButton("Excluir um Time");
            botaoExcluirUser = new JButton("Excluir Usuario");
            botaoWiki = new JButton("Wikipedia");
            botaoDarNota = new JButton("Avaliar time");
            botaoComentar = new JButton("Comentar");
            botaoGrafico = new JButton("Grafico");
            botaoImprimirUser = new JButton("Imprimir Usuarios");
            botaoImprimirTimes = new JButton("Imprimir Times");
            botaoDarNota = new JButton("Avaliar Time");
            botaoFiltragem = new JButton("Filtrar");
            botaoLimpar = new JButton("Limpar");

            botaoBuscarTime.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    buscarTime();       
                }
            });

            botaoCadastrarUser.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    cadastrarUsuario();        
                }
            });
            botaoBuscarUser.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e){
                    buscarUser();
            }
            });

            botaoCadastrarTime.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e){
                    criarTime();    
                }
            });


            botaoExcluirTime.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e){
                    excluirTime();
                }
            });


            botaoExcluirUser.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e){
                    excluirUser();
                }
            });

            botaoWiki.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    buscarPaginaWiki();
                }
            });

            botaoComentar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    comentar();
                }
            });
            botaoGrafico.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    plotarGrafico();
                }
            });

            botaoDarNota.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    adicionarAvaliacao();
                }
            });

            botaoImprimirTimes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    imprimirTimes();
                }
            });

            botaoImprimirUser.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    imprimirUser();
                }
            });

            botaoFiltragem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    filtrarDados();
                }
            });

            botaoLimpar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    areaTexto.setText(" ");
                }
            });
        }
        /**Filtra os dados dos times */
        private void filtrarDados(){
            String[] opcoes = {"Ordenar por nome", "Ordenar por classificacao", "Ordenar sem classificacao"};
            String opcaoSelecionada = (String)JOptionPane.showInputDialog(null, "Selecione","Filtragem", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
            if (opcaoSelecionada != null) {
                if (opcaoSelecionada.equals("Ordenar por nome")) {
                    controladorTime.ordenarPorNome(controladorTime.getTimes());
                } else if (opcaoSelecionada.equals("Ordenar por classificacao")) {
                    controladorTime.ordenarPorClassificacao(controladorTime.getTimes());
                } else if (opcaoSelecionada.equals("Ordenar sem classificacao")) {
                    controladorTime.ordenarSemClassificacao();
                }
            }
        }
        /**Imprime a lista de usuarios */
        private void imprimirUser(){
            atualizar(controladorUser.descricaoUser());
        }
        /**imprime a lista de times */
        private void imprimirTimes(){
            atualizar(controladorTime.descricaoTime());
        }
        /**cadastra um novo usuario */
        private void cadastrarUsuario(){
            boolean conseguiu = false;
            do{
                try{
                    String nome = JOptionPane.showInputDialog(janelaSistema , "Digite seu Nome");
                    String username = JOptionPane.showInputDialog(janelaSistema , "Digite seu User Name");
                    
                    String Idade = JOptionPane.showInputDialog(janelaSistema , "Digite sua idade");
                    Integer idade = Integer.parseInt(Idade);
                    String dataNascimento = JOptionPane.showInputDialog(janelaSistema , "Digite sua data de nascimemto");;
                    String email = JOptionPane.showInputDialog(janelaSistema , "Digite seu email");;
                    String password = JOptionPane.showInputDialog(janelaSistema , "Digite sua senha");
                    String opcao = JOptionPane.showInputDialog(janelaSistema , "Qual tipo de usuario voce quer cadastrar?\n1- Usuario Comun\n2- Moderador\n3- Administrador");
                    Integer i  = Integer.parseInt(opcao);
                    conseguiu = true;
                    controladorUser.addUser(nome, username, idade, dataNascimento, email, password, TiposUser.peloID(i));
                    JOptionPane.showMessageDialog(janelaSistema ,"Operacao realizada com Sucesso");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(janelaSistema, "Tipo de dado incorreto tente um inteiro");
                    break;
                }
            }while(!conseguiu);

        }
        /**cria uma nova avaliacao */
        private void adicionarAvaliacao(){
            boolean conseguiu = false;

            do{
                try{
                    String nome = JOptionPane.showInputDialog(janelaSistema,"Digite o nome do time\n");
                    String Nota = JOptionPane.showInputDialog(janelaSistema,"Digite a nota do Time\n");
                    Integer nota = Integer.parseInt(Nota);
                    controladorTime.adicionarClassificacao(nome, nota);
                    JOptionPane.showMessageDialog(janelaSistema,"Avaliacao inserida\n");
                    conseguiu = true;
                }catch(Exception e){
                    JOptionPane.showMessageDialog(janelaSistema,"Nota invalida tente novamente");
                    break;
                }
            }while(!conseguiu);
        }
        /**exibe a tela principal */
        public void executarTela(){
            janelaSistema.setVisible(true);
        }
        /**cria um novo time 
         * @param nomeTime
         * @param anoFundacao
         * @param qtdTitulos
         * @param tecnico
        */
        private void criarTime(){
            boolean conseguiu = false;
            Integer op = 0;
            
            do{
                try{
                    String nomeTime = JOptionPane.showInputDialog(janelaSistema , "Digite o nome do Time");

                    String anoFundacao = JOptionPane.showInputDialog(janelaSistema, "Ano de Fundacao");
                    String titulos =  JOptionPane.showInputDialog(janelaSistema, "Digite a quantidade de titulos");
                    Integer qtdTitulos = Integer.parseInt(titulos);
            
                    String tecnico = JOptionPane.showInputDialog(janelaSistema, "Tecnico");

            
                    String opcao =  JOptionPane.showInputDialog(janelaSistema , "Digite 1 para selecao e 2 para clube");
                    op = Integer.parseInt(opcao);
                    
                
                    if(op == 1){
                        criarSelecao(nomeTime, anoFundacao, qtdTitulos , tecnico);
                    }
                    else if(op == 2){
                        criarClube(nomeTime, anoFundacao, qtdTitulos , tecnico);   
                    }else {
                        JOptionPane.showMessageDialog(janelaSistema , "Opcao invalida, tente novamente");
                    }
                    conseguiu = true;
                    
                }catch(Exception e){
                    JOptionPane.showMessageDialog(janelaSistema, "Tipo de dado incorreto, tente um inteiro");
                    break;
                }
            }while(!conseguiu);
            
        }
        /**cria um clube 
         * @param nomeTime
         * @param anoFundacao
         * @param qtdTitulos
         * @param tecnico
        */
        private void criarClube(String nomeTime, String anoFundacao , int qtdTitulos, String tecnico){
            String pais = JOptionPane.showInputDialog(janelaSistema , "Pais de Origem");

            String campeonato = JOptionPane.showInputDialog(janelaSistema, "Campeonato disputando no momento");
            
            controladorTime.addClube(nomeTime, anoFundacao, qtdTitulos, tecnico, pais, campeonato);
            JOptionPane.showMessageDialog(janelaSistema ,"Operacao realizada com Sucesso");
        }
        /**cria uma selecao 
         * @param nomeTime
         * @param anoFundacao
         * @param qtdTitulos
         * @param tecnico
        */
        private void criarSelecao(String nomeTime, String anoFundacao , int qtdTitulos, String tecnico){
            String continente = JOptionPane.showInputDialog(janelaSistema , "Continente");

            String tipoSexo = JOptionPane.showInputDialog(janelaSistema, "Sexo da Selecao");
            
            controladorTime.addSelecao(nomeTime, anoFundacao, qtdTitulos, tecnico, continente, tipoSexo);
            JOptionPane.showMessageDialog(janelaSistema ,"Operacao realizada com Sucesso");
        }

        /**busca um time pelo seu nome */
        private void buscarTime(){
            String nome = JOptionPane.showInputDialog(janelaSistema, "Digite o nome do time");

            JOptionPane.showMessageDialog(janelaSistema, controladorTime.getTime(nome));
        }
        /**exclui um time pelo seu nome */
        private void excluirTime(){
            String nome = JOptionPane.showInputDialog(janelaSistema, "Digite o nome do time");
            for(Time t : controladorTime.getTimes()) {
                if(t.getNome().equals(nome)) {
                    controladorTime.removeTime(nome);
                    JOptionPane.showMessageDialog(janelaSistema, "Time removido");
                }
            }
        }
        /**exclui um usuario pelo seu nome */
        private void excluirUser(){
            String nome = JOptionPane.showInputDialog(janelaSistema, "Digite o nome do usuario");
            for(User u : controladorUser.getUser()) {
                if(u.getNome().equals(nome)) {
                    controladorUser.removeUsuario(nome);
                    JOptionPane.showMessageDialog(janelaSistema, "Usuario removido");
                }
            }
        }
        /**faz uma pesquisa na Wikipedia */
        private void buscarPaginaWiki(){
            String texto = JOptionPane.showInputDialog(janelaSistema,"Digite o texto");
            String a = texto;
            PaginaWiki pagina = null;
            

            try{
                pagina = wiki.consultarPagina(a);
                areaTexto.setText(pagina.getResumo());
                pagina = wiki.consultarPagina(a);
                atualizar(pagina.getResumo());
                List<String> titulo = wiki.pesquisarTitulosDePaginas(a);


                for(String s: titulo){
                    pagina = wiki.consultarPagina(s);
                    atualizar(pagina.getResumo());
                }   

            }catch(Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
        /**atualiza a tela principal */
        private void atualizar(String texto){
            areaTexto.setText("");
            publicacoes.add(texto);

            for(String p: publicacoes){
                areaTexto.append(p);
            }
            publicacoes.remove(texto);
        }
        /**adiciona um novo comentario */
        private void comentar(){
            String time = JOptionPane.showInputDialog(janelaSistema, "Digite o nome do time");
            String auto = JOptionPane.showInputDialog(janelaSistema, "O seu Username");
            String data = JOptionPane.showInputDialog(janelaSistema, "Digite a data de Hoje");
            String texto = JOptionPane.showInputDialog(janelaSistema, "Digite seu comentario");
        
            for(Time t: controladorTime.getTimes()){
                if(t.getNome().equals(time)){
                    controladorTime.adicionarComentario(time, auto, texto, data);
                    JOptionPane.showMessageDialog(janelaSistema,"Comentario inserido\n");
                }
            }
        }
        /**plota o grafico na tela */
        private void plotarGrafico(){
            controladorUser.plotarGrafico();
        }
        /**busca o usuario pelo seu nome */
        private void buscarUser(){
            String nome = JOptionPane.showInputDialog(janelaSistema, "Digite o nome do Usuario");

            JOptionPane.showMessageDialog(janelaSistema, controladorUser.getUser(nome));
        }
        /**monta a janela principal */
        private void montarTelaSistema(){
            janelaSistema.setSize(500,600);
            janelaSistema.setLayout(new BorderLayout());

            JPanel painelSuperior = new JPanel();
            painelSuperior.setLayout(new FlowLayout());
            painelSuperior.add(botaoFiltragem);
            painelSuperior.add(botaoLimpar);
            janelaSistema.add(painelSuperior, BorderLayout.NORTH);

            JPanel painelCentral = new JPanel();
            painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));
            painelCentral.add(tamJanela);
            janelaSistema.add(painelCentral, BorderLayout.CENTER);

            JPanel painelEsq = new JPanel();
            painelEsq.setLayout(new BoxLayout(painelEsq, BoxLayout.Y_AXIS));
            painelEsq.add(botaoCadastrarTime);
            painelEsq.add(botaoExcluirTime);
            painelEsq.add(botaoBuscarTime);
            janelaSistema.add(painelEsq, BorderLayout.WEST);
            

            JPanel painelDir = new JPanel();
            painelDir.setLayout(new BoxLayout(painelDir, BoxLayout.Y_AXIS));
            painelDir.add(botaoCadastrarUser);
            painelDir.add(botaoBuscarUser);
            painelDir.add(botaoExcluirUser);
            painelDir.add(botaoComentar);
            painelDir.add(botaoDarNota);
            janelaSistema.add(painelDir, BorderLayout.EAST);

            JPanel painelBaixo = new JPanel();
            painelBaixo.setLayout(new FlowLayout());
            painelBaixo.add(botaoWiki);
            painelBaixo.add(botaoGrafico);
            painelBaixo.add(botaoImprimirTimes);
            painelBaixo.add(botaoImprimirUser);

            janelaSistema.add(painelBaixo, BorderLayout.SOUTH);
            
            janelaSistema.pack();

        }
    }

    /**tela que o usuario ira chamar para fazer um cadastro novo antes de entrar no sistema */
    private  class TelaCadastro{
        private JFrame janelaCadastro;
        private JTextField campoNome;
        private JTextField campouUserName;
        private JTextField campoIdade;
        private JTextField campoDataNascimento;
        private JTextArea campoEmail;
        private JTextArea campoSenha;
        private JButton botaoConfirmar;

        private TelaCadastro(){
            construirJanelaCadastro();
        }

        /**controi a tela de cadastro */
        private void construirJanelaCadastro(){
            janelaCadastro = new JFrame();
            janelaCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            criarComponentesTelaCadastro();
            montarJanelaCadastro();
        }
        /**exibe a tela de cadastro */
        private void executarTelaCadastro(){    
            janelaCadastro.setVisible(true);
        }
        /**cria os componentes da tela de cadastro */
        private void criarComponentesTelaCadastro(){
            campoNome = new JTextField();
            campouUserName = new JTextField();
            campoIdade = new JTextField();
            campoDataNascimento = new JTextField();
            campoEmail = new JTextArea();
            campoSenha = new JTextArea();

            botaoConfirmar = new JButton("Confirmar");
            botaoConfirmar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    cadastrarUsuarioTelaCadastro();
                    executar();
                    janelaCadastro.setVisible(false);
                }
            });

        }

        /**cadastra um novo usuario */
        private void cadastrarUsuarioTelaCadastro(){
            String nome = campoNome.getText();
            String username = campouUserName.getText();
            String dataNascimento = campoDataNascimento.getText();
            String email = campoEmail.getText();
            String password =campoSenha.getText();

            boolean conseguiu = false;
            

            do{
                try{
                    String Idade = campoIdade.getText();
                    Integer idade = Integer.parseInt(Idade);
                    String opcao = JOptionPane.showInputDialog(janelaCadastro , "Qual tipo de usuario voce quer cadastrar?\n1- Usuario Comun\n2- Moderador\n3- Administrador");
                    Integer i = Integer.parseInt(opcao);
                    controladorUser.addUser(nome, username, idade, dataNascimento, email, password, TiposUser.peloID(i));
                    JOptionPane.showMessageDialog(janelaCadastro ,"Operacao realizada com Sucesso");
                    conseguiu = true;
                
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Tipo de dado incorreto, tente um inteiro");
                    break;
                }
            }while(!conseguiu);
            
        }
        /**monta a janela de cadastro */
        private void montarJanelaCadastro(){
            janelaCadastro.setSize(500, 900);

            janelaCadastro.setLayout(new BorderLayout());

            
            JPanel painelCadastro = new JPanel();
            painelCadastro.setLayout(new BoxLayout(painelCadastro, BoxLayout.Y_AXIS));
            painelCadastro.add(new JLabel("Nome"));
            painelCadastro.add(campoNome);
            painelCadastro.add(new JLabel("User name"));
            painelCadastro.add(campouUserName);
            painelCadastro.add(new JLabel("Idade"));
            painelCadastro.add(campoIdade);
            painelCadastro.add(new JLabel("Data Nascimento"));
            painelCadastro.add(campoDataNascimento);
            painelCadastro.add(new JLabel("Email"));
            painelCadastro.add(campoEmail);
            painelCadastro.add(new JLabel("Senha"));
            painelCadastro.add(campoSenha);

            painelCadastro.add(botaoConfirmar);
            janelaCadastro.add(painelCadastro, BorderLayout.CENTER);
            janelaCadastro.pack();
        }
    }
}

