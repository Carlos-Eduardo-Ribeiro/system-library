package business.entities;
import java.time.LocalDate;
public class Pessoa {
	
        private String nome;
        private String cpf;
        private LocalDate idade;
        private String endereco;

        public Pessoa() {}
        
        public Pessoa(String nome, String cpf, LocalDate idade, String endereco) {
            this.nome = nome;
            this.cpf = cpf;
            this.idade = idade;
            this.endereco = endereco;
        }

        public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public LocalDate getIdade() {
			return idade;
		}

		public void setIdade(LocalDate idade) {
			this.idade = idade;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		public int calcularIdade() {
            LocalDate dataAtual = LocalDate.now();
            return dataAtual.getYear() - idade.getYear();
        }

        public String toString() {
            return  ", Nome: " + nome + "\n" +
                    ", CPF: " + cpf + "\n" +
                    ", Idade: " + idade.toString() + "\n" +
                    ", Endereço: " + endereco;
        }
    }