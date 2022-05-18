# ONE SDK

Projeto arquitetural que contempla todas as implementações comuns e classes utilitárias que podem ser reaproveitadas entre todos os microsserviços.

# Estrutura do projeto arquitetural

O projeto segue o esquema de multi-módulos do maven. E está divido em 5 módulos:

- **common**
    - Responśavel implementar classes utilitárias que podem ser utilizadas em todos os módulos de um microsserviço, pois é agnóstica a frameworks e libs (com exceção do lombok).
- **database**
    - Responsável por prover estrutura inicial para implementação de banco de dados e auditoria nos microsserviços.
    - Deve ser utilizado somente na camada de adapters.
- **infrastructure**
    - Responsável por prover a infraestrutura de componentes para tratamento de erros, mapeamento de objetos, carregamento dos arquivos de mensagem (message.properties), tracking de logs e request etc.
    - Deve ser utilizado somente na camada de adapters.
```
📦oneos-sdk
 ┣ 📂common
 ┃ ┣ 📂src
 ┃ ┃ ┣ 📂main
 ┃ ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┃ ┗ 📂br
 ┃ ┃ ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂oneos
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂assertion
 Classe utilitária para realizar validações de expressões e lançar exceções do tipo BaseException
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Assert.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂response
 Interfaces de comunicação padronizadas para envelopar as respostas de sucesso do servidor
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ServerResponseDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ServerResponseListDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂error
 Interfaces de comunicação padronizadas para envelopar as respostas de error do servidor
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Error.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ErrorMessageDetail.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂exception
 Pacote para mapeamento das exceções que podem ser lançadas pelos microsserviços
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BaseException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BusinessException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DomainException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ForbiddenException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UnauthorizedException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂message
 Interfaces de comunicação padronizadas para formatar as mensagens de erro
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MessageSourceCustom.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MessageTemplate.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂util
 Pacote com classes utilitárias gerais
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DateUtil.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DocumentNumberUtil.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FormatterUtil.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JWTUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LiquibaseUtil.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MoneyUtil.java
 ┃ ┃ ┃ ┗ 📂resources
 ┃ ┃ ┗ 📂test
 ┃ ┃ ┃ ┗ 📂java
 ┃ ┗ 📜pom.xml
 ┣ 📂database
 ┃ ┣ 📂src
 ┃ ┃ ┣ 📂main
 ┃ ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┃ ┗ 📂br
 ┃ ┃ ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂oneos
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 Pacote com modelo de persistêncua customizável que representa a tabela de revisões
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜RevisionEntityCustom.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂listener
 Pacote com listerner customizável para setar os atributos definidos no modelo de persistência Revision Entity Custom
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜RevisionListenerCustom.java
 ┃ ┃ ┃ ┗ 📂resources
 ┃ ┃ ┃ ┃ ┗ 📂db
 ┃ ┃ ┃ ┃ ┃ ┗ 📂changelog
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂scripts
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂common
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜V001_create_auditing_log_tables.sql
 ┃ ┃ ┗ 📂test
 ┃ ┃ ┃ ┗ 📂java
 ┃ ┗ 📜pom.xml
 ┣ 📂infrastructure
 ┃ ┣ 📂src
 ┃ ┃ ┣ 📂main
 ┃ ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┃ ┗ 📂br
 ┃ ┃ ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂oneos
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂component
 Pacote que engloba componentes customizáveis em geral para facilitar o desenvolvimento
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MessageSourceReader.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂config
 Pacote que engloba a configuração de componentes comuns entre os microsserviços
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MessageSourceConfiguration.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ObjectMapperConfiguration.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂infrastructure
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂exception
 Pacote que engloba o tratamento de exceções de forma global
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜GlobalExceptionHandler.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂logging
 Pacote com a implementação responsável por fazer o tracking de logs a cada requisição recebida nos microsserviços (A Implementar)
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LoggingAspect.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂tracking
 Pacote com classes utilitárias para fazer o tracking das informações recebidas em cada requisição nos microsserviços (A Implementar)
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Tracker.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TrackerRequest.java
 ┃ ┃ ┃ ┗ 📂resources
 ┃ ┃ ┗ 📂test
 ┃ ┃ ┃ ┗ 📂java
 ┃ ┗ 📜pom.xml
 ┣ 📜.gitignore
 ┗ 📜pom.xml
 ```

## Stack do projeto arquitetural

Principais frameworks e libs que compõem o projeto arquitetural.

| Framework/dependência   | Descritivo                                             | Versão      |
|-------------------------|--------------------------------------------------------|-------------|
| Spring Boot             | Base da aplicação                                      | 2.6.7       |
| Spring Web, WebMVC      | Recursos básicos de integração  web                    | 5.3.19      |
| Spring Autoconfigure    | Configuração automática de apps Spring                 | 2.6.7       |
| Hibernate Validator     | Permite expressar e validar restrições de aplicativos  | 7.0.4.Final |
| Jackson Databind        | Parser entre arquivos JSON e Jackson                   | 2.13.2.2    |
| Spring Data Envers      | Auditoria de dados                                     | 2.6.4       |
| Java                    | Codificação base do app                                | 17          |
| Maven                   | Gerenciador de dependências                            | 3.8.1       |
| Lombok                  | Produtividade e redução de código                      | 1.18.24     |

| Versão | Descrição           | Solicitante                  | Data         |
|:-------|:--------------------|:-----------------------------|:-------------|
| 1.0.0  | Estrutura inicial   | Bruno Chiaroni               | 18/05/2022   |