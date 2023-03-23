package view;

import java.time.LocalDate;
import java.util.Scanner;

import business.entities.Usuario;
import business.repositories.RepositorioDeObras;
import business.repositories.RepositorioDeUsuarios;
import business.service.ControladorObra;
import business.service.ControladorUsuario;

public class TesteMain {


    public static void main(String[] args) {


        ControladorObra obra = ControladorObra.getInstance();
        ControladorUsuario usuario = ControladorUsuario.getInstance();
        usuario.ativarContador();
        Scanner sc = new Scanner(System.in);


        do {
            try {

                System.out.printf("\nDigite o comando:\n\n1.CADASTRAR\n2.EXECLUIR\n3.PROCURAR\n4.UPDATE\n");
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

                                System.out.println(obra.cadastrarLivro(valor111, valor112, valor113, valor114, valor115, data, valor116,valor117));

                                break;

                            case 2:
                                System.out.println("(Castrar Atigo Ciêntifico)\n");
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

                                System.out.println(obra.cadastrarArtigoCientifico(valor126, valor121, valor122, valor123, valor124, data2, valor125,valor127,valor128));
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
                                System.out.println(usuario.cadastrarUsuario(valor131, valor132, data3, valor133, valor134, valor135, resultado));

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

                                System.out.printf("Digite o cpf:");
                                String valor144=sc.nextLine();

                                System.out.printf("Digite sua data de nascimento (YYYY-MM-DD): ");
                                LocalDate data4 = LocalDate.parse(sc.nextLine());

                                System.out.printf("Digite o enderço:");
                                String valor145=sc.nextLine();

                                System.out.println(usuario.cadastrarAutor(valor141, valor142, valor143,valor144,data4,valor145));

                                break;

                            case 5:
                                System.out.println("(Realizar emprestimo)\n");
                                sc.nextLine();

                                System.out.printf("Digite o número de cadastro:");
                                String valor151=sc.nextLine();

                                System.out.printf("Digite o nome do itemEmprestado:");
                                String valor152=sc.nextLine();

                                System.out.printf("Digite o nome do usuario Que Realizou:");
                                String valor153=sc.nextLine();

                                System.out.println(usuario.emprestrarObra(valor151, valor152, valor153));

                                break;

                            case 6:
                                System.out.println("(Devolver Obra)\n");
                                sc.nextLine();

                                System.out.printf("Digite o nome usuário:");
                                String valor161=sc.next();

                                System.out.printf("Digite o nome da obra:");
                                String valor162=sc.next();

                                System.out.println(usuario.devolverLivro(valor161,valor162));

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
                                System.out.println(obra.excluirObra(valor211));

                                break;

                            case 2:
                                System.out.println("(Excluir Usuário)\n");
                                sc.nextLine();

                                System.out.printf("Digite o nome do usuario:");
                                String valor222 = sc.nextLine();
                                System.out.println(usuario.removerUsuario(valor222));

                                break;
                        }
                        break;

                    //-------------------------------------------------------------------------------------------//
                    case 3:
                        System.out.println("Digite o comando:\n\n1.Buscar obra por nome\n2.Lista de obras\n3.Lista de usuarios\n4.Lista de emprestimos\n5.Lista de autores\n6.buscar obra por autor\n7.hitórico de emprestimos\n8.voltar");
                        int a3= sc.nextInt();
                        switch (a3)
                        {
                            case 1:
                                System.out.println("(Buscar Obra Por Nome)\n");
                                sc.nextLine();

                                System.out.printf("Digite o nome da obra:");
                                String valor311 = sc.nextLine();

                                System.out.println(obra.buscarObra(valor311));

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

                                System.out.println(usuario.buscarObraPorAutor(valor361));

                                break;

                            case 7:
                                System.out.println("(Hitórico de emprestimos)\n");
                                sc.nextLine();

                                System.out.println(usuario.historicoDeEmprestimos());

                                break;
                        }
                        break;

                    //-------------------------------------------------------------------------------------------//
                    case 4:
                        System.out.println("Digite o comando:\n\n1.Atualizar Obra\n2.Atualizar status do usuário\n3.Utualizar usuário\n4.voltar\n");
                        int a4= sc.nextInt();
                        switch (a4)
                        {
                            case 1:
                                System.out.println("(Atualizar Obra)\n");
                                sc.nextLine();

                                System.out.printf("Digite o nome da obra:");
                                String valor411=sc.nextLine();

                                System.out.printf("Digite o novo nome da obra:");
                                String valor412=sc.nextLine();

                                System.out.printf("Digite a nova editora:");
                                String valor413=sc.nextLine();

                                System.out.printf("Digite a nova quantidade total:");
                                int valor414=sc.nextInt();

                                System.out.printf("Digite o novo número de páginas:");
                                int valor415=sc.nextInt();
                                sc.nextLine();

                                System.out.printf("Digite o novo idioma:");
                                String valor416=sc.nextLine();

                                System.out.println(obra.atualizarObra(valor411, valor412, valor413, valor414,valor415, valor416));

                                break;

                            case 2:
                                System.out.println("(Atualizar Status Do Usuário)\n");
                                sc.nextLine();

                                System.out.printf("Digite o nome do usuário:");
                                String valor421=sc.nextLine();

                                System.out.printf("Digite o comando:\n1.Bloquear\n2.Adivertir\n3.Liberar\n");
                                int valor422=sc.nextInt();

                                if(valor422==1)
                                {
                                    System.out.println(usuario.bloquearUsuario(valor421));
                                }
                                else if(valor422==2)
                                {
                                    System.out.println(usuario.advertirUsuario(valor421));
                                }
                                else if(valor422==3)
                                {
                                    System.out.println(usuario.liberarUsuario(valor421));
                                }
                                break;

                            case 3:
                                System.out.println("(Atualizar Usuário)\n");
                                sc.nextLine();

                                System.out.printf("Digite seu cpf:");
                                String valor431=sc.nextLine();

                                System.out.printf("Digite seu novo endereço:");
                                String valor432=sc.nextLine();

                                System.out.printf("Digite seu novo login:");
                                String valor433=sc.nextLine();

                                System.out.printf("Digite seu novo senha:");
                                String valor434=sc.nextLine();

                                System.out.printf("Digite seu numeroDeCadastro:");
                                String valor435=sc.nextLine();

                                System.out.printf("\nÉ um adiministrador:\n1.sim\n2.não\n");
                                int valor436=sc.nextInt();

                                boolean resultado= false;
                                if(valor436==1)
                                {
                                    resultado= true;
                                }
                                else if(valor436==2)
                                {
                                    resultado= false;
                                }
                                System.out.println(usuario.atualizarUsuario(valor431, valor432, valor433, valor434, valor435, resultado));

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