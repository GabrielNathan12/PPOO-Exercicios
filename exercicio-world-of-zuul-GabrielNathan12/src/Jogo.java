/**
 * Essa é a classe principal da aplicacao "World of Zull".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.
 * 
 * Usuários podem caminhar em um cenário. E é tudo! Ele realmente precisa ser 
 * estendido para fazer algo interessante!
 * 
 * Para jogar esse jogo, crie uma instancia dessa classe e chame o método "jogar".
 * 
 * Essa classe principal cria e inicializa todas as outras: ela cria os ambientes, 
 * cria o analisador e começa o jogo. Ela também avalia e  executa os comandos que 
 * o analisador retorna.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido e adaptado por Julio César Alves)
 */

 //Julio ainda faltas os opcionais, vou ver se faco eles amanha a tarde, acho que nem vou mandar pro git vou deixar guardado no meu computador mesmo
public class Jogo {
    // analisador de comandos do jogo
    private Analisador analisador;
    // ambiente onde se encontra o jogador
    private Ambiente ambienteAtual;
    private Maculado jogador;
        
    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo()  {
        criarAmbientes();
        analisador = new Analisador();
        jogador = new Maculado("Gabriel");
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes() {
        Ambiente lingrave, caelid, platus, montanha, mansao, rio;
      
        // cria os ambientes
        lingrave = new Ambiente("em um espaço aberto,em Lingrave,a frente esta Platus Altos ");
        caelid = new Ambiente("em Caelid");
        platus = new Ambiente("em Platus Altos");
        montanha = new Ambiente("na Montanha dos Gigantes");
                                                                    //No jogo em si tem uma carta que voce pega nessa mansao, que sao umas missoes para voce completar
        mansao = new Ambiente("Mansao Vulcanica" , new Item("carta" , 0));
        rio = new Ambiente("Rio Siofra " , new Item("chave", 1));
        
        // inicializa as saidas dos ambientes
        lingrave.ajustarSaidas("norte",platus);
        lingrave.ajustarSaidas("leste",caelid);
        lingrave.ajustarSaidas("baixo",rio);

        rio.ajustarSaidas("cima", lingrave);

        caelid.ajustarSaidas("leste", lingrave);

        platus.ajustarSaidas("oeste",mansao);
        platus.ajustarSaidas("leste",montanha);
        platus.ajustarSaidas("sul",lingrave);

        montanha.ajustarSaidas("oeste",platus);

        mansao.ajustarSaidas("leste",platus);

        ambienteAtual = lingrave;  // o jogo comeca em frente à reitoria
    }

    /**
     *  Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar()  {
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nós repetidamente lemos comandos e 
        // os executamos até o jogo terminar.
                
        boolean terminado = false;
        while (! terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Até mais!");
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas() {
        System.out.println();
        System.out.println("Bem-vindo ao Elder Ring!");
        System.out.println("Elder Ring eh um novo jogo de aventura, incrivel.");
        System.out.println("Digite 'ajuda' se voce precisar de ajuda.");
        System.out.println();
        
        imprimirLocalizacaoAtual();
       
    }
    public void observar(Comando comando){
        imprimirLocalizacaoAtual();
        System.out.println(ambienteAtual.getDescricaoLonga());
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando)  {
        boolean querSair = false;

        if(comando.ehDesconhecido()) {
            System.out.println("Eu nao entendi o que voce disse...");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        }
        else if (palavraDeComando.equals("ir")) {
            irParaAmbiente(comando);
        }
        else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        }
        else if(palavraDeComando.equals("observar")){
            observar(comando);
        }
        else if(palavraDeComando.equals("pegar")){
            pegarItem(comando);
        }
        else if(palavraDeComando.equals("inventario")){
            exibirItens(comando);
        }

        return querSair;
    }

    public void exibirItens(Comando comando){
        System.out.println("Itens no seu inventario:" );
        System.out.println(jogador.listarItens());
    }

    public void pegarItem(Comando comando){
        if(!comando.temSegundaPalavra()) {            
            System.out.println("Pegar o que ?");
            return;
        }
        else {
            if(ambienteAtual.achouItem()){
                jogador.addItem(ambienteAtual.consultarItem());
                ambienteAtual.coletarItem();
                System.out.println("Item coletado");
            }
            else{
                System.out.println("Comando invalido");
            }
        }
    
    }
    /**
     * Exibe informações de ajuda.
     * Aqui nós imprimimos algo bobo e enigmático e a lista de  palavras de comando
     */
    private void imprimirAjuda()  {
        System.out.println("Voce esta perdido. Nao sabe qual caminho percorrer a partir daqui. Voce caminha");
        System.out.println("pelo Mapa de Elder Ring.");
        System.out.println();
        System.out.println("Suas palavras de comando sao:");
        System.out.println("  " + analisador.getComandos());
    }

    /** 
     * Tenta ir em uma direcao. Se existe uma saída para lá entra no novo ambiente, 
     * caso contrário imprime mensagem de erro.
     */
    private void irParaAmbiente(Comando comando)  {
        // se não há segunda palavra, não sabemos pra onde ir...
        if(!comando.temSegundaPalavra()) {            
            System.out.println("Ir pra onde?");
            return;
        }

        String direcao = comando.getSegundaPalavra();

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = null;

        proximoAmbiente = ambienteAtual.getAmbiente(direcao);

        if (proximoAmbiente == null) {
            System.out.println("Nao ha passagem!");
        }
        else {
            ambienteAtual = proximoAmbiente;
            imprimirLocalizacaoAtual();
            
        }
    }

    public void imprimirLocalizacaoAtual(){
        System.out.println("Voce esta " + ambienteAtual.getDescricao());
        System.out.print("Saidas: ");
        System.out.println(ambienteAtual.getSaidas());
        System.out.println();
    }
    /** 
     * "Sair" foi digitado. Verifica o resto do comando pra ver se nós queremos 
     * realmente sair do jogo.
     * @return true, se este comando sai do jogo, false, caso contrário.
     */
    private boolean sair(Comando comando)  {
        if(comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        }
        else {
            return true;  // sinaliza que nós realmente queremos sair
        }
    }
}
