package business.entities;
import java.time.LocalDate;
import business.enums.Status;

	public class Emprestimo {
		
	    private LocalDate dataDeEmprestimo;
	    private LocalDate dataDeEntrega;
	    private LocalDate dataDeDevolucaoEfetiva;
	    private ObraImpressa itemEmprestado;
	    private Usuario usuarioQueRealizou;
	    private String numeroDeCadastro;
	    private String itemEmprestadoo;

	    public Emprestimo(String numeroDeCadastro,LocalDate dataDeEmprestimo, String itemEmprestadoo) {
	        this.dataDeEmprestimo = dataDeEmprestimo;
	        this.itemEmprestadoo = itemEmprestadoo;
	        this.numeroDeCadastro=numeroDeCadastro;
	       
	    }

	    public LocalDate getDataDeEmprestimo() {
	        return dataDeEmprestimo;
	    }

	    public void setDataDeEmprestimo(LocalDate dataDeEmprestimo) {
	        this.dataDeEmprestimo = dataDeEmprestimo;
	    }

	    public LocalDate getDataDeEntrega() {
	        return dataDeEntrega;
	    }

	    public void setDataDeEntrega(LocalDate dataDeEntrega) {
	        this.dataDeEntrega = dataDeEntrega;
	    }

	    public LocalDate getDataDeDevolucaoEfetiva() {
	        return dataDeDevolucaoEfetiva;
	    }

	    public void setDataDeDevolucaoEfetiva(LocalDate dataDeDevolucaoEfetiva) {
	        this.dataDeDevolucaoEfetiva = dataDeDevolucaoEfetiva;
	    }

	    public ObraImpressa getItemEmprestado() {
	        return itemEmprestado;
	    }

	    public void setItemEmprestado(ObraImpressa itemEmprestado) {
	        this.itemEmprestado = itemEmprestado;
	    }

	    public Usuario getUsuarioQueRealizou() {
	        return usuarioQueRealizou;
	    }

	    public void setUsuarioQueRealizou(Usuario usuarioQueRealizou) {
	        this.usuarioQueRealizou = usuarioQueRealizou;
	    }		
		
		public String getNumeroDeCadastro() {
			return numeroDeCadastro;
		}

		public void setNumeroDeCadastro(String numeroDeCadastro) {
			this.numeroDeCadastro = numeroDeCadastro;
		}
		

		public String getItemEmprestadoo() {
			return itemEmprestadoo;
		}

		public void setItemEmprestadoo(String itemEmprestadoo) {
			this.itemEmprestadoo = itemEmprestadoo;
		}

		@Override
		public String toString() {
		    return "(Emprestimo)\n\n" + 
		           "-dataDeEmprestimo=" + dataDeEmprestimo +"\n"+
		           "-dataDeEntrega=" + dataDeEntrega +"\n"+
		           "-dataDeDevolucaoEfetiva=" + dataDeDevolucaoEfetiva +"\n\n"+
		           "(caracteristicas do item)"+"\n\n"+
		           "-titulo da obra: "+itemEmprestado.getTitulo() +"\n"+
		           "-autor: "+itemEmprestado.getAutor() +"\n"+
		           "-quntidade disponivel: "+itemEmprestado.getQuantidade() +"\n\n"+
		           "(usuarioQueRealizou)\n\n"+
		           "-nome do usuario: "+usuarioQueRealizou.getNome() +"\n"+
		           "-número de cadastro: "+usuarioQueRealizou.getNumeroDeCadastro()+"\n";
		           		      
		}    
	}