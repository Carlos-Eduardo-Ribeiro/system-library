package business.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import business.entities.Pessoa;
import business.entities.Usuario;
import business.enums.Status;
import business.entities.Autor;
import business.entities.Emprestimo;
import business.entities.ObraImpressa;

	public class RepositorioDeUsuarios implements IRepositories<Pessoa> {
		
		private static RepositorioDeUsuarios instance;
		
		private ArrayList<Pessoa> usuarios;
		private ArrayList<Emprestimo> emprestimos;
		private ArrayList<Emprestimo> historicoDeEmprestimos;
		private ArrayList<Autor> autores;
		
		public static RepositorioDeUsuarios getInstance() {
		      if (instance == null) {
		        instance = new RepositorioDeUsuarios();
		      }
		      return instance;
		    }

	    public RepositorioDeUsuarios() {
	        this.usuarios = new ArrayList<>();
	        this.emprestimos = new ArrayList<>();
	        this.autores = new ArrayList<>();
	        this.historicoDeEmprestimos= new ArrayList<>();
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
	        for (Pessoa user : usuarios) {
	            if (user.getNome().equals(nome)) {
	            	this.usuarios.remove(user);
	                return true;
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
	    

	    public List<Emprestimo> listaEmprestimos() {
	        return this.emprestimos;
	    }
	    public List<Emprestimo> lHEmprestimos() {
	        return this.historicoDeEmprestimos;
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
	        for (Pessoa us : usuarios) {
	            if (us.getNome().equals(nome)||us.getCpf().equals(nome)||us.getNome().equals(nome)) {
	                return us;
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
	    //EMPRESTIMO//
	    
         public boolean createEmpretimo(Emprestimo emprestimos) {
    		
            boolean sucesso=this.emprestimos.add(emprestimos);
                            this.historicoDeEmprestimos.add(emprestimos);
            
            return sucesso;
        }
         //-----------------------------------------------------
        public boolean devolverLivroR(Emprestimo obj) {
        	
        	 emprestimos.remove(obj);
        	 
         return true;
        }
        //-------------------------------------------------------------
        
         public Emprestimo buscarPorEmpretimo(String nome) {
 	        for ( Emprestimo emp : emprestimos) {
 	            if (emp.getUsuarioQueRealizou().equals(nome)||emp.getItemEmprestadoo().equals(nome)) {
 	                return emp;
 	            }
 	        }
 	       return null;
	}
                          

         public void iniciarVerificacaoEntregasAtrasadas(){
             ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
             executorService.scheduleAtFixedRate(() -> verificarEntregasAtrasadas(), 0, 24, TimeUnit.HOURS);
         }       
        
        	  public void verificarEntregasAtrasadas() {
        	    LocalDate dataAtual = LocalDate.now();
        	    for (Emprestimo entrega : emprestimos) {
        	      if (entrega.getDataDeEntrega().isBefore(dataAtual));// && entrega.getStatusEntrega() != StatusEntrega.ATRASADA 
        	      {
        	    	LocalDate dataDefinidaPraEntrega = entrega.getDataDeEntrega();
        	    	
        	        Usuario adivertirUsuario=entrega.getUsuarioQueRealizou(); 
        	        adivertirUsuario.setStatus(Status.WARNED);
        	        
        	      if(dataDefinidaPraEntrega!=dataDefinidaPraEntrega.plusDays(15))
        	      {        	        	
        	    	Usuario bloquearUsuario = entrega.getUsuarioQueRealizou(); 
        	    	bloquearUsuario.setStatus(Status.BLOCKED);
        	      }
        	     }
        	    }
        	  }
        	}