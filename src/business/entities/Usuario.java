package business.entities;

import business.enums.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

    public class Usuario extends Pessoa {
    	
        private String login;
        private String password;
        private String numeroDeCadastro;
        private boolean isAdmin;
        private Status status;
        
        List<Emprestimo> emprestimo = new ArrayList<>();
        
        public Usuario() {}
        
     public Usuario(String nome, String cpf, LocalDate idade, String endereco, String login, String password,
                Status status, String numeroDeCadastro, Boolean isAdmin) {
    	 
     super(nome, cpf, idade, endereco);
     this.login = login;
     this.password = password;
     this.status = status;
     this.numeroDeCadastro = numeroDeCadastro;           
     this.isAdmin=isAdminn();
 }

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public String getNumeroDeCadastro() {
			return numeroDeCadastro;
		}

		public void setNumeroDeCadastro(String numeroDeCadastro) {
			this.numeroDeCadastro = numeroDeCadastro;
		}				

		public boolean isAdminn() {
			return isAdmin;
		}

		public List<Emprestimo> getEmprestimo() {
			return emprestimo;
		}

		public void setEmprestimo(Emprestimo emprestimo) {
			this.emprestimo.add(emprestimo);
		}

		public boolean isAdmin() {
			return isAdmin;
		}
         // ----------------
		public void setAdmin(boolean isAdmin) {
			this.isAdmin = isAdmin;
		}
		public boolean atualizar(Emprestimo obj) {
					  	 
			emprestimo.remove(obj);
			 
			 return  true;
		    }

		@Override
		public String toString() {
		    return "\n(Usuario)" + "\n\n"+
		    	   "-nome='" + getNome() + '\'' +"\n"+
		           "-login='" + login + '\'' +"\n"+
		           "-password='" + password + '\'' +"\n"+
		           "-numeroDeCadastro=" + numeroDeCadastro +"\n"+
		           "-isAdmin=" + isAdmin +"\n"+
		           "-status=" + status +"\n"+
		           "-cpf='" + getCpf() + '\'' +"\n"+
		           "-dataDeNascimento=" + getIdade() +"\n"+
		           "-endereco='" + getEndereco() + '\'' +"\n"+
		           "-Idade=" + calcularIdade() +" anos\n\n"+
		           "(Lista de emprestimos do usuario)" +"\n\n"+ getEmprestimo() +"\n";
		}
		
}
