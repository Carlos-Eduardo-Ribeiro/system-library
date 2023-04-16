package view;

import java.time.LocalDate;
import java.util.Scanner;

import business.exceptions.ElementoJaExisteException;
import business.exceptions.ElementoNaoEncontradoException;
import business.service.ObraService;
import business.service.PessoaService;

public class TesteMain {


    public static void main(String[] args) {


        ObraService obra = ObraService.getInstance();
        PessoaService usuario = PessoaService.getInstance();
        usuario.ativarContador();
        Scanner sc = new Scanner(System.in);


        do {
            try {

                System.out.printf("\nDigite o comando:\n\n1.CADASTRAR\n2.EXCLUIR\n3.PROCURAR\n4.UPDATE\n");
                int v = sc.nextInt();
                sc.nextLine();
                switch (v) {

                    case 1:
                        System.out.println("Digite o comando:\n\n1.Cadastrar Livro\n2.Cadastrar Artigo Cientifico\n3.Cadastrar Usuário\n4.Cadastrar Autor\n5.Realizar Emprestimo\n6.Devolver Obra\n7.voltar");
                        int a1= sc.nextInt();
                        switch (a1)
                        {

                            case 1:

                                System.out.println("(Castrar Livro)\n");
                                sc.nextLine();

                                System.out.printf("Digite o titulo:");
                                String valor111=sc.nextLine();

                                System.out.printf("Digite o nome do autor:");
                                String valor112=sc.nextLine();

                                System.out.printf("Digite a quantidade:");
                                int valor113=sc.nextInt();

                                System.out.printf("Digite o número de paginas:");
                                int valor114=sc.nextInt();
                                sc.nextLine();
                                System.out.printf("Digite o idioma:");
                                String valor115=sc.nextLine();

                                System.out.printf("Digite o ano de publicação no formato (YYYY-MM-DD):");
                                LocalDate data = LocalDate.parse(sc.nextLine());

                                System.out.printf("Digite o nome da editora:");
                                String valor116=sc.nextLine();

                                System.out.printf("Digite o genero literario:");
                                String valor117=sc.nextLine();

                                try {

                                    System.out.println(obra.cadastrarLivro(valor111, valor112, valor113, valor114, valor115, data, valor116,valor117));

                                }catch (ElementoJaExisteException e) {

                                    System.out.println(e.getMessage());

                                }
                                break;

                            case 2:

                                System.out.println("(Cadastrar Atigo Ciêntifico)\n");
                                sc.nextLine();

                                System.out.printf("Digite o nome do autor:");
                                String valor126=sc.next();

                                System.out.printf("Digite o titulo:");
                                String valor121=sc.next();
                                sc.nextLine();
                                System.out.printf("Digite a quantidade:");
                                int valor122=sc.nextInt();

                                System.out.printf("Digite o número de paginas:");
                                int valor123=sc.nextInt();
                                sc.nextLine();
                                System.out.printf("Digite o idioma:");
                                String valor124=sc.nextLine();

                                System.out.printf("Digite o ano de publicação no formato (YYYY-MM-DD): ");
                                LocalDate data2 = LocalDate.parse(sc.nextLine());

                                System.out.printf("Digite o nome da editora:");
                                String valor125=sc.nextLine();

                                System.out.printf("Digite a referenciaBibliografica:");
                                String valor127=sc.nextLine();

                                System.out.printf("Resuma o atigo em algumas palavras:");
                                String valor128=sc.nextLine();

                                try {

                                    System.out.println(obra.cadastrarArtigoCientifico(valor126, valor121, valor122, valor123, valor124, data2, valor125,valor127,valor128));

                                }catch (ElementoJaExisteException e) {

                                    System.out.println(e.getMessage());
                                }
                                break;

                            case 3:

                                System.out.println("(Cadastrar usuário)\n");
                                sc.nextLine();

                                System.out.printf("Digite seu nome:");
                                String valor131=sc.nextLine();

                                System.out.printf("Digite o cpf:");
                                String valor132=sc.nextLine();

                                System.out.printf("Digite sua data de nascimento no (YYYY-MM-DD): ");
                                LocalDate data3 = LocalDate.parse(sc.nextLine());

                                System.out.printf("Digite seu endereço:");
                                String valor133=sc.nextLine();

                                System.out.printf("Digite seu login:");
                                String valor134=sc.nextLine();

                                System.out.printf("Crie sua senha:");
                                String valor135=sc.nextLine();

                                System.out.printf("É um adiministrador ?\n1.sim\n2.não\nescolha:");
                                int valor136=sc.nextInt();

                                boolean resultado= false;
                                if(valor136==1)
                                {
                                    resultado= true;
                                }
                                else if(valor136==2)
                                {
                                    resultado= false;
                                }

                                try {

                                    System.out.println(usuario.cadastrarUsuario(valor131, valor132, data3, valor133, valor134, valor135, resultado));

                                }catch (ElementoJaExisteException e) {

                                    System.out.println(e.getMessage());

                                }

                                break;

                            case 4:

                                System.out.println("(Cadastrar autor)\n");
                                sc.nextLine();

                                System.out.printf("Digite o nome do autor:");
                                String valor141=sc.nextLine();

                                System.out.printf("Digite o pseudonimo do autor:");
                                String valor142=sc.nextLine();

                                System.out.printf("Digite a nacionalidade do autor:");
                                String valor143=sc.nextLine();

                                System.out.printf("Digite sua data de nascimento (YYYY-MM-DD): ");
                                LocalDate data4 = LocalDate.parse(sc.nextLine());

                                System.out.printf("Digite o enderço:");
                                String valor145=sc.nextLine();

                                try {

                                    System.out.println(usuario.cadastrarAutor(valor141, data4, valor145, valor142, valor143));

                                }catch (ElementoJaExisteException e) {

                                    System.out.println(e.getMessage());

                                }

                                break;

                            case 5:

                                System.out.println("(Realizar empréstimo)\n");
                                sc.nextLine();

                                System.out.printf("Digite o número de cadastro:");
                                String valor151=sc.nextLine();

                                System.out.printf("Digite o nome do itemEmprestado:");
                                String valor152=sc.nextLine();

                                try {

                                    System.out.println(usuario.emprestrarObra(valor151, valor152));

                                }catch (ElementoNaoEncontradoException e) {

                                    System.out.println(e.getMessage());
                                }

                                break;

                            case 6:
                                System.out.println("(Devolver Obra)\n");
                                sc.nextLine();

                                System.out.printf("Digite o id do usuário:");
                                String valor161=sc.next();

                                System.out.printf("Digite o nome da obra:");
                                String valor162=sc.next();

                                try {

                                    System.out.println(usuario.devolverLivro(valor161,valor162));

                                }catch (ElementoNaoEncontradoException e) {

                                    System.out.println(e.getMessage());

                                }

                                break;
                        }
                        break;

                    //-------------------------------------------------------------------------------------------//
                    case 2:

                        System.out.println("Digite o comando:\n\n1.Excluir Obra\n2.Execluir usuário\n3.voltar\n");
                        int a2= sc.nextInt();

                        switch (a2) {
                            case 1:
                                System.out.println("(Excluir Obra)\n");
                                sc.nextLine();

                                System.out.printf("Digite o nome da Obra:");
                                String valor211 = sc.nextLine();

                                try {

                                    System.out.println(obra.excluirObra(valor211));

                                }catch (ElementoNaoEncontradoException e) {

                                    System.out.println(e.getMessage());

                                }

                                break;

                            case 2:
                                System.out.println("(Excluir Usuário)\n");
                                sc.nextLine();

                                System.out.printf("Digite o id do usuario:");
                                String valor222 = sc.nextLine();

                                try {

                                    System.out.println(usuario.removerUsuario(valor222));

                                }catch (ElementoNaoEncontradoException e) {

                                    System.out.println(e.getMessage());

                                }
                                break;
                        }
                        break;

                    //-------------------------------------------------------------------------------------------//
                    case 3:
                        System.out.println("Digite o comando:\n\n1.Buscar obra por nome\n2.Lista de obras\n3.Lista de usuarios\n4.Lista de emprestimos\n5.Lista de autores\n6.buscar obra por autor\n7.hitórico de emprestimos\n8.emprestimos atrasados\n9.Buscar emprestimos do usuario\n10.voltar");
                        int a3= sc.nextInt();
                        switch (a3)
                        {
                            case 1:
                                System.out.println("(Buscar Obra Por Nome)\n");
                                sc.nextLine();

                                System.out.printf("Digite o nome da obra:");
                                String valor311 = sc.nextLine();

                                try {

                                    System.out.println(obra.buscarObra(valor311));

                                }catch (ElementoNaoEncontradoException e) {

                                    System.out.println(e.getMessage());

                                }

                                break;

                            case 2:
                                System.out.println("(Lista De Obras)\n");
                                sc.nextLine();

                                System.out.println(obra.pesquisarObras());

                                break;

                            case 3:
                                System.out.println("(Lista Usuários)\n");
                                sc.nextLine();

                                System.out.println(usuario.listaDeUsuarios());

                                break;

                            case 4:
                                System.out.println("(Lista Emprestimos)\n");
                                sc.nextLine();

                                System.out.println(usuario.listaDeEmprestimos());

                                break;

                            case 5:
                                System.out.println("(Lista De Autores)\n");
                                sc.nextLine();

                                System.out.println(usuario.listaDeAutores());

                                break;

                            case 6:
                                System.out.println("(Buscar obras por autor)\n");
                                sc.nextLine();

                                System.out.printf("Digite o nome do autor:");
                                String valor361 = sc.nextLine();

                                System.out.println("Obras do autor: "+valor361+"\n");

                                try {

                                    System.out.println(usuario.buscarObraPorAutor(valor361));

                                }catch (ElementoNaoEncontradoException e) {

                                    System.out.println(e.getMessage());

                                }

                                break;

                            case 7:
                                System.out.println("(Hitórico de emprestimos)\n");
                                sc.nextLine();

                                System.out.println(usuario.historicoDeEmprestimos());

                                break;

                            case 8:
                                System.out.println("(Emprestimos atrasados)\n");
                                sc.nextLine();

                                System.out.println(usuario.emprestimosAtrazados());

                                break;

                            case 9:
                                System.out.println("(Buscar Emprestimos Usuario)\n");
                                sc.nextLine();

                                System.out.printf("Digite o id do usuário:");
                                String valor391=sc.nextLine();

                                try {

                                    System.out.println(usuario.buscarEmprestimosDoUsuario(valor391));

                                }catch (ElementoNaoEncontradoException e) {

                                    System.out.println(e.getMessage());

                                }

                                break;
                        }
                        break;

                    //-------------------------------------------------------------------------------------------//
                    case 4:
                        System.out.println("Digite o comando:\n\n1.Atualizar status do usuário\n2.Atualizar endereço do usuário\n3.Atualizar login e senha do usuário\n4.Atualizar status de admin do usuário\n5.Atualizar titulo da obra\n6.Atualizar editora da obra\n7.Atualizar número de paginas da obra\n8.Atualizar quantidade disponível da obra\n9.Atualizar idioma da obra\n10.voltar");
                        int a4= sc.nextInt();
                        switch (a4)
                        {

                            case 1:
                                System.out.println("(Atualizar Status Do Usuário)\n");
                                sc.nextLine();

                                System.out.printf("Digite o id do usuário:");
                                String valor411=sc.nextLine();

                                System.out.printf("Digite o comando:\n1.Bloquear\n2.Adivertir\n3.Liberar\n");
                                int valor412=sc.nextInt();

                                if(valor412==1)
                                {
                                    try {

                                        System.out.println(usuario.bloquearUsuario(valor411));

                                    }catch (ElementoNaoEncontradoException e) {

                                        System.out.println(e.getMessage());

                                    }
                                }
                                else if(valor412==2)
                                {
                                    try {

                                        System.out.println(usuario.advertirUsuario(valor411));

                                    }catch (ElementoNaoEncontradoException e) {

                                        System.out.println(e.getMessage());

                                    }
                                }
                                else if(valor412==3)
                                {
                                    try {

                                        System.out.println(usuario.liberarUsuario(valor411));

                                    }catch (ElementoNaoEncontradoException e) {

                                        System.out.println(e.getMessage());

                                    }
                                }

                                break;

                            case 2:

                                System.out.println("(Atualizar Endereço Do Usuário)\n");
                                sc.nextLine();

                                System.out.printf("Digite seu id:");
                                String valor421=sc.nextLine();

                                System.out.printf("Digite seu novo endereço:");
                                String valor422=sc.nextLine();

                                try {

                                    System.out.println(usuario.atualizarEmderecoDoUsuario(valor421, valor422));

                                }catch (ElementoNaoEncontradoException e) {

                                    System.out.println(e.getMessage());

                                }

                                break;

                            case 3:

                                System.out.println("(Atualizar Login e Senha )\n");
                                sc.nextLine();

                                System.out.printf("Digite seu atual login:");
                                String valor431=sc.nextLine();

                                System.out.printf("Digite sua atual senha:");
                                String valor432=sc.nextLine();

                                System.out.printf("Digite sua nova senha:");
                                String valor434=sc.nextLine();

                                try {

                                    System.out.println(usuario.atualizarSenhaDoUsuario(valor431, valor432, valor434));

                                }catch (ElementoNaoEncontradoException e) {

                                    System.out.println(e.getMessage());

                                }

                                break;

                            case 4:

                                System.out.println("(Atualizar Status de Admin)\n");
                                sc.nextLine();

                                System.out.printf("Digite seu id:");
                                String valor441=sc.nextLine();

                                System.out.printf("É um adiministrador:\n1.sim\n2.não\n");
                                int valor442=sc.nextInt();

                                boolean resultado= false;

                                if(valor442==1)
                                {
                                    resultado= true;
                                }
                                else if(valor442==2)
                                {
                                    resultado= false;
                                }

                                try {

                                    System.out.println(usuario.atualizarStatusAdiminUsuario(valor441, resultado));

                                }catch (ElementoNaoEncontradoException e) {

                                    System.out.println(e.getMessage());

                                }

                                break;

                            case 5:

                                System.out.println("(Atualizar Titulo Da Obra )\n");
                                sc.nextLine();

                                System.out.printf("Digite o titulo atual atual:");
                                String valor451=sc.nextLine();

                                System.out.printf("Digite o novo titulo:");
                                String valor452=sc.nextLine();

                                try {

                                    System.out.println(obra.atualizarTituloDaObra(valor451, valor452));

                                }catch (ElementoNaoEncontradoException e) {

                                    System.out.println(e.getMessage());

                                }

                                break;

                            case 6:

                                System.out.println("(Atualizar Editora Da Obra)\n");
                                sc.nextLine();

                                System.out.printf("Digite o titulo da obra:");
                                String valor461=sc.nextLine();

                                System.out.printf("Digite a nova editora:");
                                String valor462=sc.nextLine();

                                try {

                                    System.out.println(obra.atualizarEditoraDaObra(valor461, valor462));

                                }catch (ElementoNaoEncontradoException e) {

                                    System.out.println(e.getMessage());

                                }

                                break;

                            case 7:

                                System.out.println("(Atualizar Número De Paginas Da Obra)\n");
                                sc.nextLine();

                                System.out.printf("Digite o titulo da obra:");
                                String valor471=sc.nextLine();

                                System.out.printf("Digite o nova número total de paginas:");
                                int valor472=sc.nextInt();

                                try {

                                    System.out.println(obra.atualizarNumeroDePaginasDaObra(valor471, valor472));

                                }catch (ElementoNaoEncontradoException e) {

                                    System.out.println(e.getMessage());

                                }

                                break;

                            case 8:

                                System.out.println("(Atualizar Quantidade Disponível Da Obra)\n");
                                sc.nextLine();

                                System.out.printf("Digite o titulo da obra:");
                                String valor481=sc.nextLine();

                                System.out.printf("Digite a nova quantidade total disponível:");
                                int valor482=sc.nextInt();

                                try {

                                    System.out.println(obra.atualizarQuantidadeDisponivelDaObra(valor481, valor482));

                                }catch (ElementoNaoEncontradoException e) {

                                    System.out.println(e.getMessage());

                                }

                                break;

                            case 9:

                                System.out.println("(Atualizar Idioma Da Obra)\n");
                                sc.nextLine();

                                System.out.printf("Digite o titulo da obra:");
                                String valor491=sc.nextLine();

                                System.out.printf("Digite o nova idioma da obra:");
                                String valor492=sc.nextLine();

                                try {

                                    System.out.println(obra.atualizarIdiomaDaObra(valor491, valor492));

                                }catch (ElementoNaoEncontradoException e) {

                                    System.out.println(e.getMessage());

                                }

                                break;
                        }
                        break;
                }


            }catch (Exception e) {

                System.out.println("\n((Usuário digitou errado. Digite novamente da maneira pedida.))");
                sc.nextLine();
            }
        }while(true);
    }
}