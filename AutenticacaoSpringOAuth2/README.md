# Autenticação com Spring e OAuth2
Este projeto foi desenvolvido durante o **ACELERA DEV - JAVA** promovido pela **[CODENATION*](https://www.codenation.dev/)*, integrando uma das disciplinas do **sétimo módulo** do curso. Como fonte de estudo adotou-se também o material fornecido pelo [AcademiaDev](https://academiadev.gitbook.io/joinville/seguranca/oauth2).

## Criação do projeto
Foi utilizado o [Spring Initializr](https://start.spring.io/) para a criação do projeto inicial com as seguintes configurações:
![enter image description here](https://github.com/thiagohrcosta/Codenation-Java/blob/master/AutenticacaoSpringOAuth2/img/img01.png?raw=true)

## Criando a entidade de usuário
Como estrutura base no desenvolvimento deste projeto, adotou-se três pacotes `model`, `repository` e `controller`, da seguinte forma:

 - O pacote `model` seria responsável por armazenar a classe `Usuario.java`, servindo conforme instruções do projeto para representar a entidade Usuario no banco de dados;
 ![enter image description here](https://github.com/thiagohrcosta/Codenation-Java/blob/master/AutenticacaoSpringOAuth2/img/img02.png?raw=true)

Na criação do `Usuario.java` utilizou-se algumas *annotations* tais como @Id e @eneratedValue no atributo Id, ficando:

>@Id
>@GeneratedValue
>private Long Id;
>
> private String login;
> private String senha

No momento não utilizou-se o **Lombok** que será posteriormente adotado para aprimorar o presente trabalho, o que exige a criação do *construtor* e dos *getters* e *setters*.

 - Já o pacote `repository` armazenaria a classe denominada `UsuarioRepository.java`, a qual será responsável pela integração da aplicação com a tabela de Usuários no banco de dados. 
![enter image description here](https://github.com/thiagohrcosta/Codenation-Java/blob/master/AutenticacaoSpringOAuth2/img/img03.png?raw=true)

 - Por fim, o pacote `controller` seria responsável por armazenar a classe `UsuarioController.java`, sendo aqui determinada a interface de comunicação externa. 
 ![enter image description here](https://github.com/thiagohrcosta/Codenation-Java/blob/master/AutenticacaoSpringOAuth2/img/img04.png?raw=true)

## Spring Secutiry
Foi adicionado ao `build.gradle` a seguinte linha de comando: 

>compile('org.springframework.boot:spring-boot-starter-security')

Trata-se de uma ferramenta de segurança que já integra do Spring e uma vez adicionada, acarretará o seguinte resultado diante de uma requisição **GET** (utilizou-se o *Insomnia* para a requisição):
![enter image description here](https://github.com/thiagohrcosta/Codenation-Java/blob/master/AutenticacaoSpringOAuth2/img/img05.png?raw=true)

O retorno como *Status: 401* significa dizer que a tentativa de requisição não obteve sucesso diante da falta de autorização, vejamos:

>"*O código de resposta de status de erro do cliente HTTP **`401 Unauthorized`** indica que a solicitação não foi aplicada porque não possui credenciais de autenticação válidas para o recurso de destino*". 
Fonte: [MDN Web Docs](https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Status/401#:~:text=O%20c%C3%B3digo%20de%20resposta%20de,para%20o%20recurso%20de%20destino.)
