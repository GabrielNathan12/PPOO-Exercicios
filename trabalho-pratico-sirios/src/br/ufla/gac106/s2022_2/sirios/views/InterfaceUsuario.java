package br.ufla.gac106.s2022_2.sirios.views;
import java.util.List;
import java.util.Scanner;
import br.ufla.gac106.s2022_2.sirios.controller.TimesController;
import br.ufla.gac106.s2022_2.sirios.controller.UserController;
import br.ufla.gac106.s2022_2.sirios.times.Time;
import br.ufla.gac106.s2022_2.sirios.userFactory.TiposUser;
import br.ufla.gac106.javaWikiAPI.PaginaWiki;
import br.ufla.gac106.javaWikiAPI.Wiki;

/**Classe que faz a interface com o usuario atravez do terminal */
public class InterfaceUsuario implements Executar{
    private Wiki wiki;
    private Scanner input;
    private UserController controladorUser;
    private TimesController controladorTime;
    
    public InterfaceUsuario() {
        input = new Scanner(System.in);
        controladorUser =  new UserController();
        controladorTime = new TimesController();
        wiki = new Wiki();
    }

    /**Usuario fazer o login no sistema*/
    private void logar() {
        String username = pedirString("Usuario");
        if(controladorUser.verificaUsername(username)) {
            String senha = pedirString("Senha");
            if(controladorUser.verificaSenha(senha, username)) {
                System.out.println("Login efetuado com sucesso!\n");
            } else {
                System.out.println("Usuario ou senha incorretos!! Tente novamente.\n");
                executar();
            }
        } else {
            System.out.println("Usuario invalido!");
            executar();
        }
    }
    
    /**Printa as opcoes do para o usuario fazer o login ou se cadastrar, depois se inicia o programa*/
    public void executar() {
        int opcao;

        System.out.println("-----------------------------------------------------");
        System.out.println("Seja bem vindo á Sirios: ");
        System.out.println("Por favor, entre ou cadastre-se em nosso programa:");
        System.out.println("1- Login");
        System.out.println("2- Realizar cadastro");
        System.out.println("3- Sair");
        System.out.println("-----------------------------------------------------");
        
        opcao = Integer.parseInt(input.nextLine());
        switch(opcao){
            case 1: 
                logar();
            break;
            case 2:
                cadastrarUsuario();
            break;
            case 3:
                System.out.print("Obrigado por usar nosso programa...");    
            break;
            default:
                System.out.println("Opcao invalida!!!");
                executar();
            break;

        }
        
        do {
            exibir();
            opcao = pedirInt("\nDigite uma opção: ");
            opcaoMenu(opcao);
        }while(opcao != 13);     
                   
    }

    /**Printa as opcoes disponiveis */
    public void exibir() {
        System.out.println("\n-----------------------------------------------------");
        System.out.println("ESCOLHA UMA OPCAO ABAIXO: ");
        System.out.println("1- Cadastrar um novo time");
        System.out.println("2- Cadastrar um novo usuario");
        System.out.println("3- Exibir detalhes de um time");
        System.out.println("4- Exibir detalhes de um usuario");
        System.out.println("5- Exibir todos os times cadastrados");
        System.out.println("6- Exibir todos os usuarios cadastrados");
        System.out.println("7- Excluir um time");
        System.out.println("8- Excluir um usuario");
        System.out.println("9- Pesquisar na Wiki");
        System.out.println("10- Adicionar um comentario a um Time");
        System.out.println("11- Adicionar uma avaliacao a um Time");
        System.out.println("12- Plotar Grafico");
        System.out.println("13- Sair..");
        System.out.println("-----------------------------------------------------");

    }

    /**Funcao que trata cada opcao que o usuario digitou 
     * @param opcao
    */
    private void opcaoMenu(int opcao) {
        switch (opcao){
            case 1: 
                cadastrarTime();
            break;
            case 2:
                cadastrarUsuario();
            break;
            case 3:
                buscarTime();
            break;
            case 4:
                buscarUsuario();
            break;
            case 5:
                exibirTimes();
            break;
            case 6:
                exibirUsuarios();
            break;
            case 7:
                excluirTime();
            break;
            case 8:
                excluirUsuario();
            break;
            case 9:
                buscarPaginaWiki();            
            break;
            case 10:
                comentar();
            break;
            case 11:
                adicionarAvaliacao();
            break;
            case 12:
                plotarUmGrafico();
            break;
            case 13:
                fecharWiki();
                System.out.print("Obrigado por usar nosso programa...");    
            break;
            default:
                System.out.println("Opcao invalida!!!");
            break;
        }

        if(opcao != 13) {
            System.out.println("Digite ENTER para continuar!");
            input.nextLine();
        }
    }

    private void adicionarAvaliacao(){
        String nomeTime = pedirString("Digite o nome do time e depois a avaliacao (0 a 10)");
        Integer nota = Integer.parseInt(input.nextLine());
        controladorTime.adicionarClassificacao(nomeTime, nota);
    }   

    private void plotarUmGrafico(){
        controladorUser.plotarGrafico();
    }
    /**Realiza uma pesquisa na Wiki e retorna a pagina da wikipedia */
    private void buscarPaginaWiki(){
        
        String texto ;
        texto = pedirString("Digite o titulo que deseja buscar");

        PaginaWiki pagina = null;
        
       try {
           pagina = wiki.consultarPagina(texto);
           
       }
       catch (Exception e) {
           e.printStackTrace();
           e.getCause();
       }
        System.out.println(pagina.getResumo());

        try {
            pagina = wiki.consultarPagina(texto);
            List<String> titulo = wiki.pesquisarTitulosDePaginas(texto);
            System.out.print("\nPaginas relacionadas\n");

            for (String s : titulo) {
                pagina = wiki.consultarPagina(s);
                System.out.print(s + "\n" + pagina.getResumo() + "\n");
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }
    /**Faz um novo comentario */
    public void comentar(){
        
        String time = pedirString("Informe o Time que deseja comentar");
        String autor = pedirString("Informe seu username");
        String data = pedirString("Informe a data de hoje");
        String texto = pedirString("Informe seu comentario");
        
        for(Time t : controladorTime.getTimes()) {
            if(t.getNome().equals(time)) {
                controladorTime.adicionarComentario(time, autor, texto, data);
                System.out.println("Comentario inserido\n");
                System.out.println(t.getComentarios());
            }
        }
    }
    /**Retorna uma String para a leitura de uma*/
    private String pedirString(String instrucao) {
        System.out.print(instrucao + ": ");
        String informacao = input.nextLine();
        return informacao;
    }
    /**fecha a wiki */
    private void fecharWiki(){
        try{
            wiki.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**Retorna um inteiro para a leitura de um
     * @param instrucao
     * @return informacao
    */
    private int pedirInt(String instrucao) {
        System.out.print(instrucao + ": ");
        Integer informacao = Integer.parseInt(input.nextLine());
        return informacao;
    }
    /***cria um novo time 
     * @param opcao
    */
    private void criarTime(int opcao){

        boolean conseguiu = false;

        do {
            try{
                String nomeTime;
                String anoFundacao;
                Integer qtdTitulos = 0;
                String tecnico;
                nomeTime = pedirString("O nome da seleção");
                anoFundacao = pedirString("O ano de fundação");
                qtdTitulos = pedirInt("Digite a quantidade de titulos");
                tecnico = pedirString("Digite o nome do Tecnico");

                switch (opcao){
                    case 1:
                        criarSelecao(nomeTime, anoFundacao, qtdTitulos, tecnico);
                    break;
                    
                    case 2:
                        criarClube(nomeTime, anoFundacao, qtdTitulos, tecnico);
                    break;
                    default:
                        System.out.println("Opcao invalida");
                    break;
                }
                conseguiu = true;
            }catch(Exception e){
                System.out.println("Tipo de entrada invalida");
            }
        }while(!conseguiu);

        
        
    }
    /**Cria uma Selecao no banco de dados
     * @param nomeTime
     * @param anoFundacao
     * @param qtdTitulos
     * @param tecnico
    */
    private void criarSelecao(String nomeTime, String anoFundacao, int qtdTitulos, String tecnico) {

        String continente;
        String tipoSexo;

        
        continente = pedirString("Digite o continente que ele pertence");
        tipoSexo = pedirString("Digite a categoria da Seleção (Masculino/Feminino)");
        
        controladorTime.addSelecao(nomeTime, anoFundacao, qtdTitulos, tecnico, continente, tipoSexo);
    }

    /**Cria um Clube no banco de dados
     * @param nomeTime
     * @param anoFundacao
     * @param qtdTitulos
     * @param tecnico
    */
    private void criarClube(String nomeTime, String anoFundacao, int qtdTitulos, String tecnico) {

        String pais;
        String campeonato;

        
        pais = pedirString("Digite o pais que ele pertence: ");
        campeonato = pedirString("Digite o campeonato que ele participa: ");
      
        controladorTime.addClube(nomeTime, anoFundacao, qtdTitulos,tecnico, pais , campeonato);
    }

    /**Menu que o usuario ira descidir qual time ele quer cadastrar*/
    private void cadastrarTime() {
        System.out.println("Digite se é uma seleção ou um clube");
        System.out.println("1- Para seleção");
        System.out.println("2- Para clube");
        Integer opcao = Integer.parseInt(input.nextLine());
        criarTime(opcao);
    }

    /**Retorna um time buscado pelo seu nome*/
    private void buscarTime() {
        String nome;
        nome = pedirString("Digite o nome time");
        System.out.println(controladorTime.buscarTime(nome));
    }

    private void buscarUsuario() {
        String nome;
        nome = pedirString("Digite o nome do usuario");
        System.out.println(controladorUser.getUser(nome));
    }


    /**Exibe tudo que esta nos arquivos*/
    private void exibirTimes() {
        System.out.println("\nTimes cadastrados\n" + controladorTime.descricaoTime());
    }

    /**Exibe tudo que esta nos arquivos*/
    private void exibirUsuarios() {
        System.out.println("\nUsuarios cadastrados\n" + controladorUser.descricaoUser());
    }

    /**Exclui um time do arquivo pelo seu nome*/
    private void excluirTime() {
        //if(controlador.verificaTipoUsuarioLogado() == 1) {
            String name = pedirString("Digite o nome do Time a ser removido");
            controladorTime.removeTime(name);
            System.out.println("Time removido");
        //} else {
            System.out.println("ERRO: Somente Administradores podem remover times!");
        //}
    }

    /**Exclui um time do arquivo pelo seu nome*/
    private void excluirUsuario() {
        String name = pedirString("Digite o nome do Usuario a ser removido");
        controladorUser.removeUsuario(name);
        System.out.println("Usuario removido");
    }

    /**Menu que o usuario ira discidir qual tipo de usuario ele ira criar */
    private void cadastrarUsuario() {
        //String usernameUser;
        
        
        boolean conseguiu = false;
        do{
            try{
                String nome;
                String username;
                int idade = 0;
                String dataNascimento;
                String email;
                String password;

                nome = pedirString("Digite o nome do usuario");
                username = pedirString("Digite o username do usuario");
                idade = pedirInt("Digite a idade do usuario");
                dataNascimento = pedirString("Digite a data de nascimento do usuario");
                email = pedirString("Digite o email do usuario");
                password = pedirString("Digite a senha");

                System.out.println("Qual tipo de usuario voce quer cadastrar?");
                System.out.println("1- Usuario Comun");
                System.out.println("2- Moderador");
                System.out.println("3- Administrador");
                System.out.println("4- Voltar");


                System.out.println("ATENCAO - Somente Administradores podem cadastrar usuarios Administradores!");
                
                int opcao = pedirInt("Digite uma opcao");
                controladorUser.addUser(nome, username, idade, dataNascimento, email, password, TiposUser.peloID(opcao));
                executar();
                System.out.println("Operacao realizada com sucesso!");

                
                conseguiu = true;
            }catch(Exception e){
                System.out.println("Tipo de dado nao esperado, dado correto e um inteiro\n");
            }
        }while(!conseguiu);
        
             
    }
}
