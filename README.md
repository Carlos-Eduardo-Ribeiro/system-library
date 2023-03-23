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
 2. O sistema permitirá a sua manutenção a partir de uma conta de administrador(o funcionário). Que deverá ter uma conta(login e senha), mas só consiguirá fazer essa conta se, e somente se, possuir um número de cadastro na empresa(que verifica se ele realmente é um funcionário).
 3. O sistema permitirá a visualização de todos os livros da biblioteca.
 4. O sistema só permitirá o empréstimo de um livro se o usuário(leitor) estiver com o status no modo ativo.
 5. Um administrador poderá bloquear qualquer usuário que esteja pendente com sua devolução de livros. Para isso ele primeiro irá advertir o usuário. Dando um número de dias a mais para o mesmo conseguir devolver o livro. Se devolver a tempo ele volta para o status ativo. Caso contrário passará a ser bloqueado por um tempo.
 6. O administrador poderá banir um usuário caso ultrapasse um número determinado de bloqueamentos. Mandando o seu cpf para uma base de dados, para que não consiga fazer mais uma conta.
 7. Sempre que um usuário for fazer uma conta, seu cpf será, primeiramente, verificado na base de dados.
 8. Será o administrador que irá adicionar, excluir ou atualizar um livro no sistema.
 9. O sistema irá mostrar ao usuário quando ele estiver advertido e bloqueado.

### Diagrama UML:
<p align="left"> 
 <img width="950" src="https://user-images.githubusercontent.com/118121309/227179622-defe51ad-d526-461e-b929-9df2e567fe52.png"
</p>
 
### Diagrama Navegacional:
<p align="left"> 
 <img width="950" src="https://user-images.githubusercontent.com/118121309/227180702-8a010ea5-4f3c-498a-a6d1-d886e8b2679f.png"
</p>


