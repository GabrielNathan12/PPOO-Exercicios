[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=9521988&assignment_repo_type=AssignmentRepo)
# Exercício Zoológico

## Parte 1 - Herança

Nesta primeira parte vamos exercitar os **conceitos básicos de herança** e ver como eles nos ajudam a **evitar duplicação de código** nas classes que **formam** uma hierarquia de herança.

### Passo 1.1 - Modelar as classes

*Atenção:* Este passo não envolve implementação; deve ser respondido aqui no próprio arquivo README.

Suponha que queiramos criar um sistema para um Zoológico que precise tratar as seguintes espécies de animais: leão, gorila, ema e arara.

- Sabe-se que todos os animais têm as seguintes características: um nome, uma espécie, uma determinada quantidade de patas e um som característico (tecnicamente, sua onomatopeia, ex: se fosse um gato, seria “miau”, se fosse uma galinha: “cocorico”).
- Além disso, os animais que possuem pelo têm a informação da cor do seu pelo; já os animais que voam têm a informação se voam bem ou voam mal.

O sistema deve possuir:

- Métodos para consulta de cada atributo de todos os animais.
- Método que retorne uma string com a descrição resumida de um animal, conforme os exemplos abaixo: 
  - `Simba é um(a) leão`.
  - `Blue é um(a) arara`.
- Método que retorne uma string com a descrição completa de um animal, como a do exemplo abaixo: 
  - `Simba é um(a) leão que faz roarrr e tem pelo laranja`.
  - `Blue é um(a) arara que faz reco-reco e voa bem`.

Neste passo você deve apenas **modelar as classes necessárias** para representar todos os animais utilizando o conceito de herança:

- Ou seja, você **deverá definir** apenas os nomes: de cada classe, dos seus atributos e seus métodos.
- Para isso: **altere esse arquivo README** com a sua definição das classes (no trecho abaixo) e **faça um commit**.

Dicas:
- Avalie cuidadosamente os atributos a serem definidos, evitando replicação de código.
- Lembre-se que suas classes não devem permitir que um programador crie objetos de animais que não façam sentido.
  - Por exemplo: não faz sentido criar uma ema com três pernas, ou que faça "au au".
  - Portanto, avalie bem como os atributos devem ser inicializados (e quais classes precisam ser criadas).
- Uma classe que representa uma espécie de animal deve ter nome no singular, já que um objeto dessa classe representará um único animal.
  - Por exemplo, uma classe para representar um gorila deveria ser chamar `Gorila`, e não `Gorilas`.

> Escreva aqui sua resposta

> Classe Animal -  Atributos: nome , especie ,qtdPatas, som.
> Metodos: getNome,gePatas, getSom,getEspecie ,descricaoCurta , descricaoLonga.

> Classe Mamifero (herda de Animal)- Atributos: Atributos - corPelo. 
> Metodos: getCorPelo, descricaoLonga.

> Classe Ave (herda de Animal) - Atributos: informacaoesVoo.
> Metodos: getInformacao, descricaoLonga.  

> Classe Leao (herda de Mamifero) - Atributos:  <br>
> Metodos:

> Classe Gorila (herda de Mamifero) - Atributos:  <br>
> Metodos: 

> Classe Ema (herda de Ave) - Atributos:  <br>
> Metodos: 

> Classe Arara (herda de Ave) - Atributos:  <br>
> Metodos: 
> 

> Classe Zoologico -  Atributos um ArrayList de Leao, Gorila, Ema, Arara
> Metodos: addLeao, addGorila, addEma, addArara, descricaoCompleta, descricaoResumida, buscarLeao, buscaGorila, buscarEma, buscarArara. 
> Exemplo de formato:
> 
> Classe A (herda de B) - Atributos: atr1, atr2 e atr3 - Métodos: metodoA, metodoB e metodoC

### Passo 1.2 - Implementar a Hierarquia de Herança

*Dica: Antes de começar esse passo, valide a sua modelagem do passo anterior com o professor.
Isso poderá evitar retrabalho na implementação.*

Neste passo você deve **implementar todas as classes** necessárias para representar os animais, e que você definiu no passo anterior.

Dicas:
- Não crie todas as classes de uma vez. Comece criando apenas o necessário para ter objetos de uma única espécie.
- Em seguida, na classe que tem o método `main`, crie um objeto daquela espécie e chame alguns métodos diretamente no código para testar sua implementação.
- Depois de validar e garantir que está tudo certo com a primeira classe, aí sim crie as classes para as demais espécies.

Não se esqueça de fazer um commit ao terminar esse passo.

### Passo 1.3 - Criar a classe Zoologico

**Crie uma classe chamada `Zoologico`** que gerencie os objetos de cada espécie. 

A classe deverá ter:

- Uma coleção (`ArrayList` ou `HashMap`) para cada espécie de animal.
   - Obs.: mesmo que já conheça polimorfismo, por objetivos didáticos, é importante que crie coleções separadas neste exercício.
- Métodos para adicionar cada espécie de animal.
  - Os métodos devem receber os dados necessários e dentro ddiferenteeles é que os objetos serão criados.

- Método que recebe o nome de um animal e retorna sua descrição completa.
- Método que lista a descrição resumida de todos os animais do zoológico.
- Método que lista a descrição completa de todos os animais do zoológico.

O código inicial de uma classe `InterfaceUsuario`, que implementa o menu de opções para o usuário do programa, já foi fornecido para você.
Você deverá **alterar a classe `InterfaceUsuario`** para que ela chame os métodos da sua classe `Zoológico` (e obtenha dados do usuário, quando necessário).diferente

Teste suas implementações!

Ao final, não se esqueça de fazer um commit e sincronizar suas alterações.

## Parte 2 - Diagrama de Classes UML

Vamos agora aprender a criar **diagramas de classes UML** para nossos projetos.

### Passo 2.1 - Diagrama de Classes Simplificado

Crie um diagrama de classes simplificado para o projeto do Zoológico:

- Neste tipo de diagrama, basta representar as classes (não é necessário representar atributos e nem métodos).

O diagrama criado deve ser exportado para um arquivo imagem do tipo `PNG` e colocado dentro de uma pasta `doc` criada dentro da pasta principal do projeto (obs.: não crie a pasta dentro de `src`).

### Passo 2.2 - Diagrama de Classes Completo

*Dica: valide com o professor o diagrama do passo anterior antes de fazer o diagrama completo*

Crie agora um diagrama de classe completo, incluindo os atributos e métodos de todas as classes.

- Obs.: exporte o diagrama para um arquito imagem do tipo `PNG` diferente do anterior (para que seu projeto tenha os dois diagramas dentro da pasta `doc`).

## Parte 3 - Polimorfismo

Nesta terceira parte vamos exercitar **os conceitos de polimorfismo** e perceber como eles nos ajudam a **evitar duplicação** de código nas classes que **utilizam** classes de uma hierarquia de herança.

### Passo 3.1 - Experimentando Polimorfismo 1

Vamos começar exercitando nosso entendimento sobre os conceitos de polimorfismo.
Para isso, crie uma classe chamada `Teste` com um método `main` e, dentro dele, faça o seguinte:

- Declare uma variável chamada `animal` do tipo `Animal` e atribua a ela um objeto da classe `Leao`.
- Chame o método `getNome` usando a variável `animal`.
- Agora, usando a mesma variável `animal`, atribua a ela um objeto da classe `Arara`.
- Chame o método `getNome` usando a variável criada.

Explique abaixo, da forma mais completa possível, como é possível que a mesma variável `animal` possa ser usada para chamar métodos de objetos de classes diferentes.

>  ... escreva aqui a sua resposta ...
> Isso é possível pelo fato de que a JVM primeiro busca pelo seu tipo dinamico da variavel e já na execução do programa ela vai usar seu tipo estático que nesse caso são seus subtipos por meio da hierarquia da herença e então podemos usar seus metodos normalmente.

Ao terminar, faça um commit com as alterações da classe `Teste` e as alterações neste arquivo README.

### Passo 3.2 - Experimentando Polimorfismo 2

Agora, altere o método `main` da classe `Teste` e faça o seguinte:
- Crie um método chamado `exibirDescricaoCompleta` que recebe uma variável do tipo `Animal`.
  - Dentro dele, chame o método de descrição completa usando o parâmetro `animal`.
  - E exiba o resultado na tela.
- No método `main`, chame o método `exibirDescricaoCompleta` passando um objeto da classe `Tigre`.

O que é exibido?

>  ... escreva aqui a sua resposta ...
>  É exibido a descrição completa do Leão passado como parametro

O método de descrição completa chamado inicialmente pertence a qual classe?

>  ... escreva aqui a sua resposta ...
> Esse método pertence inicialmente a classe Mamifero. 

Agora chame o método `exibirDescricaoCompleta` passando um objeto da classe `Ema`.

O que é exibido?

>  ... escreva aqui a sua resposta ...
> É exibido a descrição completa da Ema passado como parametro

O método de descrição completa chamado inicialmente pertence a qual classe?

>  ... escreva aqui a sua resposta ...
> Esse método pertence inicialmente a classe Ave

Explique, da forma mais completa possível, como o mesmo trecho de código (método `exibirDescricaoCompleta`) pode ser usado para chamar métodos de classes diferentes.

>  ... escreva aqui a sua resposta ...
> Por que ambas as classes passadas como parametros são subitipos da classe animal, e isso ocorre pelo fato de que a JVM primeiro começa buscando pelo seu tipo dinâmico do objeto e caso não for encontrado ele sube na hierarquia de herença até encontralo ou dar erro de compilação.
Ao terminar, faça um novo commit com as alterações (na classe Teste e neste arquivo README).

### Passo 3.3 - Usando Polimorfismo no Projeto Zoologico

Vamos agora perceber como o polimorfismo ajuda a reduzir a replicação de código. 

Para isso, você deve alterar a classe `Zoologico`:

- Substitua as coleções de animais de cada espécie por uma única coleção (`ArrayList` ou `HashMap`) com todos os animais.
- E, devido a essa modificação, implemente as alterações necessárias nos métodos da classe.

Do ponto de vista do usuário, seu programa deverá continuar funcionando da mesma forma que você havia feito no exercício da aula anterior.
Mas repare que agora seu projeto terá um *Design* de classes melhor.

Teste suas alterações!

Ao final, faça um novo commit no seu repositório.

### Passo 3.4 - Identificando o uso de Polimorfismo

Para todas as perguntas abaixo, você deve indicar exatamente a classe e o número da linha de código onde cada situação acontece.

1. Indique pelo menos uma **variável polimórfica** utilizada no seu código e explique porque ela é uma variável polimórfica.

> Nome da classe: 
> Zoologico 
> Número da linha:
> 4
> Nome da variável:
> animais
> Explicação:Por que ela e do tipo da superclasse e guarda varius tipos de objetos de suas subclasses.


2. Identifique algum ponto no código onde está sendo usado o **princípio da substituição** e explique o que é este princípio.

> Nome da classe:
> Zoologico 
> Número da linha:
> 50
> Explicação: Por que o metodo buscar, ele vai buscar um animal pelo seu nome e vai retornar o animal indepedente de qual for suas subclasses se ele exitir dentro do ArrayList


3. Identifique algum ponto no código onde uma variável tem **tipo estático diferente de seu tipo dinâmico** (indique quais são os tipos estático e dinâmico da variável neste ponto).

> Nome da classe:
> Zoologico 
> Número da linha:
> 10 a 28
> Nome da variável:
> animais 
> Tipo estático:
> Animais 
> Tipo dinâmico: Leao, Gorila, Ema e Arara


4. Identifique onde ocorre uma chamada de método na qual seja utilizado o conceito de **polimorfismo de método**.

> Nome da classe:
> Zoologico
> Número da linha: 30 a 49

### Passo 3.5 - Atualização do Diagrama de Classes

Faça as alterações necessárias nos diagramas de classes para que eles representem o seu código alterado após o passo 2.3.


