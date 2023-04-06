package business.service;

import java.time.LocalDate;

import java.util.List;
import java.util.Random;
import business.enums.Status;
import business.entities.Autor;
import business.entities.Pessoa;
import business.entities.Usuario;
import business.entities.Emprestimo;
import business.entities.ObraImpressa;
import business.repositories.RepositorioDeObras;
import business.repositories.RepositorioDeUsuarios;
import business.repositories.RepositorioDeEmprestimos;

	public class UsuarioService {

	private RepositorioDeUsuarios repositorio;
	private RepositorioDeObras obrasUser;
	private RepositorioDeEmprestimos empDeUsuarios;
	

	public UsuarioService() {
		
	    this.repositorio = RepositorioDeUsuarios.getInstance(); 
	    this.obrasUser = RepositorioDeObras.getInstance();
	    this.empDeUsuarios = RepositorioDeEmprestimos.getInstance();
	}
	
	private Status status;
	
		
	//Usuário//-----------------------------------------------------------
	
	 public boolean adicionarUsuario(String nome, String cpf, LocalDate idade, String endereco, String login, String password, boolean isAdmin) {
	    
		if(repositorio.buscarPorNomes(cpf)!=null||repositorio.buscarPorNomes(nome)!=null)
		{
		 return false;
		}
        Status atribuirStatusDeCadastro= status.RELEASED;        
        Usuario aqui;
        String numeroDeCadastro;
        
        do {
        	        
        Random gerador = new Random();
        long valor = gerador.nextInt(10001) + 10000;
        numeroDeCadastro = String.valueOf(valor);
        aqui = (Usuario) repositorio.buscarPorNomes(numeroDeCadastro);
       
        }
        while(aqui != null && numeroDeCadastro.equals(aqui.getNumeroDeCadastro()));
                      
	    Usuario usuario= new Usuario(nome,cpf,idade,endereco,login,password,atribuirStatusDeCadastro,numeroDeCadastro,isAdmin);
	   
	    usuario.setNome(nome);
	    usuario.setCpf(cpf);
	    usuario.setEndereco(endereco);
	    usuario.setLogin(login);
	    usuario.setPassword(password);
	    usuario.setStatus(atribuirStatusDeCadastro);
	    usuario.setNumeroDeCadastro(numeroDeCadastro);
	    usuario.setAdmin(isAdmin);
	    
	    boolean sucesso = repositorio.create(usuario);
	    
	    return sucesso;
	    }
	 
		public boolean bUsuario(String idUsuario) {
			
			Usuario user = (business.entities.Usuario) repositorio.buscarPorNomes(idUsuario);
    	    
			if(user!=null) {
				
	        boolean sucesso = ((RepositorioDeUsuarios) repositorio).updateStatus(idUsuario,status.BLOCKED);

	        return sucesso;
			}
			return false;
	    }
		
		 public boolean libUsuario(String idUsuario) {
	    	    
			   Usuario user = (business.entities.Usuario) repositorio.buscarPorNomes(idUsuario);
			    
			    if(user!=null) {
			    	
		        boolean sucesso = ((RepositorioDeUsuarios) repositorio).updateStatus(idUsuario,status.RELEASED);

		        return sucesso;
		        
			    }
			    return false;
		    }
        
        
         public boolean advirUsuario(String idUsuario) {
  	       
            Usuario user = (business.entities.Usuario) repositorio.buscarPorNomes(idUsuario);
    	    
			if(user!=null) {
	        boolean sucesso = ((RepositorioDeUsuarios) repositorio).updateStatus(idUsuario,status.WARNED);

	        return sucesso;
			}
			return false;
	     }
        
        public boolean rUsuario(String id) {
            
 	       boolean sucesso = repositorio.removerPorNome(id);
 	        
 	        return sucesso;
 	    }
        public List<Pessoa> lUsuarios()
		{
			 
	     List<Pessoa> todasosUsuarios = repositorio.read();
	     
	     return todasosUsuarios;
		}   
        
        
           public boolean atualizarUEmdereco (String id,String novoEmdereco) {
            
         	if(repositorio.buscarPorNomes(id)==null) 
         	{
         	 return false;
         	}
         	else{
         		
            Usuario usuario=(Usuario) repositorio.buscarPorNomes(id);
         	 
         	usuario.setEndereco(novoEmdereco);
        
            repositorio.update(usuario);
            
            return true;
         	}           
         	}
           
           public boolean atualizarULoginESenha(String login, String password, String novoLogin, String novoPassword) {
        	   
        	   Pessoa pessoa = repositorio.buscarPorNomes(login);
        	    
        	    if (pessoa instanceof Usuario) {
        	    	
        	        Usuario usuario = (Usuario) pessoa;
        	        
        	        if (usuario.getPassword().equals(password)) {
        	        	
        	            usuario.setLogin(novoLogin);
        	            usuario.setPassword(novoPassword);
        	            repositorio.update(usuario);
        	            
        	            return true;
        	        }
        	    }
        	    return false;
        	}

           
           public boolean atualizarUAdimin (String id, boolean isAdmin) {
               
             if(repositorio.buscarPorNomes(id)==null) 
           	{
           	 return false;
           	}
             else {	
            	 
             Usuario usuario= (Usuario) repositorio.buscarPorNomes(id);
               	               		                        	 
             usuario.setAdmin(isAdmin);
                           
             repositorio.update(usuario);
                  
             return true;
             }
                  
           }
                  
        
      //Autor//---------------------------------------
   	 
   	 public boolean adicionarAutor(String nome,String pseudonimo,String nacionalidade,String cpf, LocalDate idade, String endereco) {
   	    

   	    Autor autor= new Autor(nome,pseudonimo,nacionalidade,cpf,idade,endereco);
   	    
   	    autor.setNome(nome);
   	    autor.setPseudonimo(pseudonimo);
   	    autor.setNacionalidade(nacionalidade);
   	    autor.setCpf(cpf);
   	    autor.setIdade(idade);
   	    autor.setEndereco(endereco);
   	    
   	    boolean sucesso = repositorio.create(autor);
   	    
   	    return sucesso;
   	    }
   	 
   	  public  List<Autor> listaAutores() {
          	
          	 List<Autor> autores = ((RepositorioDeUsuarios) repositorio).listaA();
               
               return autores;
           }
   	  public  List<ObraImpressa> bObraPorAutor (String obrasAutor) {
          	
           	 List<ObraImpressa> bOPA = ((RepositorioDeObras)obrasUser).buscarObrasDoAutor(obrasAutor);
              
                return bOPA;
            }
        
        //EMPRESTIMO//-------------------------------------------
        
         public String emprestarL(String numeroDeCadastro, String itemEmprestado, String usuarioQueRealizou) {
	    	             	
        	 
        	 Usuario checarU= (Usuario) repositorio.buscarPorNomes(usuarioQueRealizou);
        	 ObraImpressa checarO = obrasUser.buscarPorNomes(itemEmprestado);            
             
        	 if(checarU==null||checarO==null)
             {
              return "\nObra ou Usuario não emcontrado";
             }
             
             else if(checarO.getQuantidade()>=1&&checarU.getStatus()==status.RELEASED||checarU.getStatus()==status.WARNED)
             {
            checarO.setdebiatarObra();        	        	        	
        	LocalDate agora = LocalDate.now();
        	LocalDate dataFinalParaDevoçao = agora.plusDays(15);
        	
	        Emprestimo emprestimo= new Emprestimo(numeroDeCadastro,agora,itemEmprestado);	                  
	        emprestimo.setDataDeEntrega(dataFinalParaDevoçao);       
	        emprestimo.setItemEmprestado(checarO);
	        emprestimo.setUsuarioQueRealizou(checarU);
	        emprestimo.setItemEmprestadoo(itemEmprestado);
	        	        	                    	        	     	        
	        empDeUsuarios.create(emprestimo);  
	        
	        checarU.setEmprestimo(emprestimo);
	        
	        return "\nEmprestimo cadastrado";
        	} 
             else
             {
              return "\n(O usuario não pode executar emprestimos)\nUsuário Status :"+checarU.getStatus();
             }
            }
         
         public String devolverL(String id,String Obra) {
 	    	
         Usuario checarU= (Usuario) repositorio.buscarPorNomes(id);         
         ObraImpressa checarO =obrasUser.buscarPorNomes(Obra); 
         
         if(checarU==null||checarO==null)
         {
          return "\nObra ou Usuario não emcontrado";
         }
                           
         LocalDate agora = LocalDate.now();
         String a = checarO.getTitulo();
         Emprestimo atualizar = ((RepositorioDeEmprestimos) empDeUsuarios).buscarPorEmpretimo(a);        
         
         if(atualizar.getItemEmprestado()==checarO) {
        	 
         atualizar.setDataDeDevolucaoEfetiva(agora);
          
       	 checarO.setCreditarObra();         
       	 
       	 checarU.atualizar(atualizar);
       	
       	 ((RepositorioDeEmprestimos) empDeUsuarios).devolverLivroR(atualizar);
       	 
       	 ((RepositorioDeEmprestimos) empDeUsuarios).removerEmpretimoAtrasado(atualizar);
                 
         if(checarU.getStatus()==status.WARNED)
         {
        	checarU.setStatus(status.RELEASED);
         }
         return "\nObra devolvida com sucesso";
         
       	 }          
         return "";        
         }         
         
         public  List<Emprestimo> lEmprestimos() {
         	
           	 List<Emprestimo> emprestimos = empDeUsuarios.read();
                
                return emprestimos;
            }
         
         public  List<Emprestimo> hEmprestimos() {
         	
          	 List<Emprestimo> emprestimos = ((RepositorioDeEmprestimos) empDeUsuarios).lHEmprestimos();
               
               return emprestimos;
           }
         
         public List<Emprestimo> epAtrasados() {	 
        	 
        	 List<Emprestimo> emprestimos =  ((RepositorioDeEmprestimos) empDeUsuarios).eAtrasados();
 	        
        	 return emprestimos;
 	      }
         
         public List<Emprestimo> empDoUsuario(String nomeOuNdc) {
         	
        	 List<Emprestimo> emprestimos = empDeUsuarios.buscarPorEmpretimoDoUsuario(nomeOuNdc);
             
             return emprestimos;
         }
         
         //Contador//----------------------------------------------------
         
         public void iniciarContador()
         {
         ((RepositorioDeEmprestimos) empDeUsuarios).iniciarVerificacaoEntregasAtrasadas();
       
         }
          
}