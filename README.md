# Projeto system-library

### Integrantes do grupo:

* Gabriel Ramos de Souza - Gabriel_ramos-souza@hotmail.com
* Daniel Feitosa Botelho de Andrade - danielfbdeandrade2@gmail.com
* Carlos Eduardo Ribeiro - carlos.eduardo.rb18@gmail.com

### Descrição geral do projeto:
A principal funcionalidade do sistema é atribuir um livro a um estudante, e um estudante a vários livros. De maneira mais informal um estudante irá poder pegar emprestado vaários livros, com tempo determinado. E o livro pegado emprestado pelo estudante será será "marcado" como emprestado, não podendo ser emprestado a mais ninguém.
 
 Quem poderá usar o programa serão leitores, onde irão procurar(em uma base de dados) os livros disponíveis na biblioteca, poder pegar livros emprestados e devolve-los. O outro usuário do sistema será um funcionário da biblioteca, que poderá adicionar livros à biblioteca, excluir livros, e bloquear usuários caso passem do prazo de entrega. Deixando, assim, o usuário incapacitado de obter novos livros.
 
 ### Requisitos do Projeto:

 1. O sistema permitirá aos leitores o empréstimo de livros. O leitor(usuário) obterá os livros por meio de uma conta no sistema(login e senha).
 2. O sistema permitirá a sua manutenção a partir de uma conta de administrador(o funcionário). Que deverá ter uma conta(login e senha).
 3. O sistema permitirá a visualização de todos as obras da biblioteca.
 4. O sistema só permitirá o empréstimo de um livro se o usuário(leitor) estiver com o status no modo ativo.
 5. Um administrador poderá bloquear qualquer usuário que esteja pendente com sua devolução de livros. 
 6. Será o administrador que irá adicionar, excluir ou atualizar um livro no sistema.
 7. O sistema irá mostrar ao usuário quando ele estiver liberado, advertido e bloqueado.
 8. O usuário pode consultar sua lista de empréstimos ativos e a lista de todos os livros da biblioteca, além de poder procurar livros por autores ou por nomes. 
 9. O administrador poderá ver a lista de usuários como seus atributos.
10. O administrador poderá transformar um usuário em Administrador adquirindo todas as funções.
11. O administrador poderá adicionar e excluir autores.
12. O administrador poderá adicionar e excluir artigo científico.
13. O usuário poderá atualizar seu próprio endereço e senha.
### Diagrama UML:
<p align="left"> 
 <img width="950" src="https://user-images.githubusercontent.com/118121309/227179622-defe51ad-d526-461e-b929-9df2e567fe52.png"
</p>
 
### Diagrama Navegacional:
<p align="left"> 
 <img width="950" src="https://user-images.githubusercontent.com/118121309/227180702-8a010ea5-4f3c-498a-a6d1-d886e8b2679f.png"
</p>


