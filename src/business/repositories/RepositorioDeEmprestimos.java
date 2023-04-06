package business.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import business.entities.Emprestimo;
import business.entities.Usuario;
import business.enums.Status;

public class RepositorioDeEmprestimos implements IRepositories<Emprestimo> {
	
		private static RepositorioDeEmprestimos instance;
		
		private ArrayList<Emprestimo> emprestimos;
		private ArrayList<Emprestimo> emprestimosAtrasados;
		private ArrayList<Emprestimo> historicoDeEmprestimos;
		
		public static RepositorioDeEmprestimos getInstance() {
		      if (instance == null) {
		        instance = new RepositorioDeEmprestimos();
		      }
		      return instance;
		    }

	    public RepositorioDeEmprestimos() {
	        
	        this.emprestimos = new ArrayList<>();
	        this.historicoDeEmprestimos = new ArrayList<>();
	        this.emprestimosAtrasados = new ArrayList<>();
	    }	 
	    
	    //EMPRESTIMO//------------------------------------------------------------
	    
	    
	    public List<Emprestimo> read() {
	        return this.emprestimos;  
	    }
	    	    
	    public List<Emprestimo> lHEmprestimos() {
	        return this.historicoDeEmprestimos;
	    }
	    
	    public List<Emprestimo> eAtrasados() {	    	
	        return this.emprestimosAtrasados;
	    }
	    
	    
         public boolean create(Emprestimo emprestimos) {
    		
            boolean sucesso=this.emprestimos.add(emprestimos);
                            this.historicoDeEmprestimos.add(emprestimos);
            
            return sucesso;
        }
         
         
        public boolean devolverLivroR(Emprestimo obj) {
        	
        	 emprestimos.remove(obj);
        	 
         return true;
        }
        
         public Emprestimo buscarPorEmpretimo(String id) {
 	        for ( Emprestimo emp : emprestimos) {
 	            if (emp.getUsuarioQueRealizou().equals(id)||emp.getItemEmprestadoo().equals(id)||emp.getNumeroDeCadastro().equals(id)) {
 	                return emp;
 	            }
 	        }
 	       return null;
	    }
         
         public List<Emprestimo> buscarPorEmpretimoDoUsuario(String id) {
        	    List<Emprestimo> emprestimosDoUsuario = new ArrayList<>();
        	    for (Emprestimo emp : emprestimos) {
        	        if (emp.getUsuarioQueRealizou().equals(id) || emp.getItemEmprestadoo().equals(id) || emp.getNumeroDeCadastro().equals(id)) {
        	            emprestimosDoUsuario.add(emp);
        	        }
        	    }
        	    return emprestimosDoUsuario;
        	}
         
         public void removerEmpretimoAtrasado(Emprestimo obj) {
  	       	 
          emprestimosAtrasados.remove(obj);
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
        	        
        	        emprestimosAtrasados.add(entrega);
        	        
        	      if(dataDefinidaPraEntrega!=dataDefinidaPraEntrega.plusDays(15))
        	      {        	        	
        	    	Usuario bloquearUsuario = entrega.getUsuarioQueRealizou(); 
        	    	bloquearUsuario.setStatus(Status.BLOCKED);
        	      }
        	     }
        	    }
        	  }

			@Override
			public boolean update(Emprestimo obj) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Emprestimo buscarPorNomes(String titulo) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean removerPorNome(String titulo) {
				// TODO Auto-generated method stub
				return false;
			}
        	}

