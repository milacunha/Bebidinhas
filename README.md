# 🍹 Bebidinhas (Consulta de Bebidas)

Esse projeto tem como objetivo demostrar o uso de alguns padrões e arquiteturas para o desenvolvimento Android, tais como MVI, Ktor, Koin e Jetpack Compose. 

Como resultado, o aplicativo consulta uma API com uma base de dados sobre bebidas e as mostra na tela. No aplicativo, é possível fazer consultas de bebidas pela inicial das mesmas, seja por letra ou número. Também é realizado tratativas de erro e carregamento.

## 🌱 Começando

Para testar o aplicativo, é necessário clonar o projeto e rodar no dispositivo Android que desejar.

## 🚧 Implementação

Como mencionado, esse aplicativo visa o estudo de novos padrões, arquiteturas e ferramentas com foco em desenvolvimento Android.

### Arquitetura MVI

A principal ideia do MVI é a **abordagem reativa e funcional** para construir interfaces para o usuário. Por ser **unidirecional**, só existe uma forma dos dados na tela serem atualizados e isso faz com que aplicativos robustos e com fluxos complexos sejam **estruturados de maneira previsível e com redução de código**. O MVI resolve muito bem **problemas com estados da tela**.

### Comunicação da API com Ktor

O Ktor é uma **biblioteca open source** para autenticar e interagir com APIs e enviar informações usando internet. Pode ser utilizado para **criar tanto client quanto o server** de uma aplicação e tem-se o **fluxo assíncrono** com o uso de coroutines. Utiliza-se os **plugins específicos** para cada feature que precisar, fazendo com que seja **modularizado**, tendo apenas o que precisa para o projeto. **Suporta multiplataforma**, viabilizando a criação de microsserviços e aplicações web, bem como o Kotlin Multiplataform.

### Injeção de Dependência com Koin

A injeção de dependência é uma **boa prática técnica**, indica que as instâncias fiquem de forma centralizada, dessa forma, conseguem ser **inicializadas em um único lugar**. Além disso, as instâncias são **criadas quando necessário**, de acordo com o escopo e do tipo que for preciso. **Suporta multiplataforma**, com aplicativos nativos e web, e também é possível **compartilhar código entre Android e iOS**. **Funciona em tempo de execução** e com **módulos** que especificam como criar as instâncias.

### Elaboração das telas com Jetpack Compose

O Jetpack Compose é o kit de ferramentas recomendado pelo Android para **desenvolvimento de telas**. A ideia é criar telas e componentes **de forma mais rápida e com menos código** do que com os XMLs. Funciona de forma **hierárquica na construção** dos componentes da tela e **guiado a estados**, fazendo com que a cada elemento modificado a UI seja automaticamente atualizada. 

## 🛠️ Construção

A construção do aplicativo foi possível com as seguintes ferramentas

- API utilizada com a base de dados das bebidas foi a The CocktailDB, sendo aplicada a versão gratuita.
    - [The CocktailDB link](https://www.thecocktaildb.com/api.php)
- Todos os ícones utilizados no aplicativo foram do site FlatIcon, todos baixados na versão gratuita.
    - [FlatIcon link](https://www.flaticon.com/br/)

### Fluxos de Tela

Os fluxos de tela foram desenhados no Figma e replicados no aplicativo com Jetpack Compose.

![ui-flow-bebidinhas](https://github.com/user-attachments/assets/79003883-ef2b-43d4-9e93-a2b2ba9b35ca)

### Diagrama

O diagrama de requisitos demonstra o fluxo estrutural do aplicativo.

![diagram-bebidinhas](https://github.com/user-attachments/assets/0d0a21de-9c08-4246-aa44-fe37592efca5)

## 📝 Autores

Projeto desenhado, desenvolvido e documentado por **Camila Cunha**

- [Github](https://github.com/milacunha)
- [LinkedIn](https://www.linkedin.com/in/camila-s-e-cunha/)

Agradecimento a **Laís Jesus** pelo apoio no estudo

- [Github](https://github.com/laissdj49)
- [LinkedIn](https://www.linkedin.com/in/laissdj49/)
