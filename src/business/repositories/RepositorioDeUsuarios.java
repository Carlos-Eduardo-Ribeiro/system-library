package business.repositories;

import business.entities.Autor;
import business.entities.Pessoa;
import business.entities.Usuario;
import business.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeUsuarios implements IRepositories<Pessoa> {
		
		private static RepositorioDeUsuarios instance;
		
		private ArrayList<Pessoa> usuarios;
		private ArrayList<Autor> autores;
		
		public static RepositorioDeUsuarios getInstance() {
		      if (instance == null) {
		        instance = new RepositorioDeUsuarios();
		      }
		      return instance;
		    }

	    public RepositorioDeUsuarios() {
	        this.usuarios = new ArrayList<>();
	        this.autores = new ArrayList<>();
	    }	    

	    public boolean create (Pessoa usuario) {
	    	
	    	if(usuario instanceof Usuario)
	    	{
	        boolean sucesso =this.usuarios.add(usuario);
	        return sucesso;
	    	}
	    	if(usuario instanceof Autor)
	    	{
	        boolean sucesso =this.autores.add( (Autor) usuario);
	        return sucesso;
	    	}
	    	return false;
	    }
	    
	    public boolean removerPorNome(String nome) {
	    	
	    
	    for (Pessoa pessoa : usuarios) {
            if (pessoa instanceof Usuario) {
                Usuario usuario = (Usuario) pessoa;
                if (usuario.getNumeroDeCadastro().equals(nome) || usuario.getLogin().equals(nome)||usuario.getNome().equals(nome)||usuario.getCpf().equals(nome)) {
                	this.usuarios.remove(usuario);
                	return true;
                }
            }
	    }
            for (Pessoa pessoa2 : autores) {
                if (pessoa2 instanceof Autor) {
            	    Autor autor = (Autor) pessoa2;
                    if(autor.getNome().equals(nome) || autor.getCpf().equals(nome)) {
                       this.autores.remove(autor);
                        return true ;	             
            }
          }
        }
         return false;  
	   }    
	    
	    public List<Pessoa> read() {
	        return this.usuarios;  
	        }
	    
	    public  List<Autor> listaA() {
                    
              return this.autores;
           }
    
	    public boolean updateStatus(String usuario, Status newStatus){
	    
	    Usuario user = (Usuario) buscarPorNomes(usuario);
	    Usuario alterarStatus = (Usuario) buscarPorNomes(usuario);
	    
	    if (user!= null) {
	    	
	    if(newStatus==Status.BLOCKED) 
	     {
	       alterarStatus.setStatus(Status.BLOCKED);
	       return true;
	     }	   
	    else if(newStatus==Status.RELEASED) 
	     {
	       alterarStatus.setStatus(Status.RELEASED);
	       return true;
	     }
	        	
	     else if(newStatus==Status.WARNED) 
         {
           alterarStatus.setStatus(Status.WARNED);
           return true;
         }
	    }
	    return false;
	    }
	    
	    public Pessoa buscarPorNomes(String nome) {
	    	
	        for (Pessoa pessoa : usuarios) {
	            if (pessoa instanceof Usuario) {
	                Usuario usuario = (Usuario) pessoa;
	                if (usuario.getNumeroDeCadastro().equals(nome) || usuario.getLogin().equals(nome)||usuario.getNome().equals(nome)||usuario.getCpf().equals(nome)) {
	                    return usuario;
	                }
	            }
	        }
	            for (Pessoa pessoa2 : autores) {
	                if (pessoa2 instanceof Autor) {
	            	    Autor autor = (Autor) pessoa2;
	                    if(autor.getNome().equals(nome) || autor.getCpf().equals(nome)) {
	                       return autor ;	             
	            }
	          }
	        }
	        return null;
	    }
	    
	    public boolean update(Pessoa obj) {
	   		
	    	Pessoa paraRemover= buscarPorNomes(obj.getCpf());
	    	removerPorNome(paraRemover.getCpf());
	    	create(obj);
	    	
	    	return true;
	    	
	    }                        

	}