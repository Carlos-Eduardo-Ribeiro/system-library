package business.service;

import business.entities.*;
import business.enums.Status;
import business.exceptions.ElementoJaExisteException;
import business.exceptions.ElementoNaoEncontradoException;
import business.repositories.RepositorioDeEmprestimos;
import business.repositories.RepositorioDeObras;
import business.repositories.RepositorioDeUsuarios;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class UsuarioService {
	private RepositorioDeUsuarios repositorio = RepositorioDeUsuarios.getInstance();
	private RepositorioDeObras obrasUser = RepositorioDeObras.getInstance();
	private RepositorioDeEmprestimos empDeUsuarios = RepositorioDeEmprestimos.getInstance();
	private Usuario usuarioAtivo;
	private Status status;

	public boolean adicionarUsuario(String nome, String cpf, LocalDate idade, String endereco, String login, String password, boolean isAdmin) throws ElementoJaExisteException {
		if (this.repositorio.buscarPorNomes(cpf) != null) {
			throw new ElementoJaExisteException(nome);
		} else {
			Status var10000 = this.status;
			Status atribuirStatusDeCadastro = Status.RELEASED;

			Usuario aqui;
			String numeroDeCadastro;
			do {
				Random gerador = new Random();
				long valor = (long) (gerador.nextInt(10001) + 10000);
				numeroDeCadastro = String.valueOf(valor);
				aqui = (Usuario) this.repositorio.buscarPorNomes(numeroDeCadastro);
			} while (aqui != null && numeroDeCadastro.equals(aqui.getNumeroDeCadastro()));

			Usuario usuario = new Usuario(nome, cpf, idade, endereco, login, password, atribuirStatusDeCadastro, numeroDeCadastro, isAdmin);
			usuario.setNome(nome);
			usuario.setCpf(cpf);
			usuario.setEndereco(endereco);
			usuario.setLogin(login);
			usuario.setPassword(password);
			usuario.setStatus(atribuirStatusDeCadastro);
			usuario.setNumeroDeCadastro(numeroDeCadastro);
			usuario.setAdmin(isAdmin);
			boolean sucesso = this.repositorio.create(usuario);
			return sucesso;
		}
	}

	public boolean bUsuario(String idUsuario) throws ElementoNaoEncontradoException {
		Usuario user = (Usuario) this.repositorio.buscarPorNomes(idUsuario);
		if (user != null) {
			Status var10002 = this.status;
			boolean sucesso = this.repositorio.updateStatus(idUsuario, Status.BLOCKED);
			return sucesso;
		} else {
			throw new ElementoNaoEncontradoException(idUsuario);
		}
	}

	public boolean libUsuario(String idUsuario) throws ElementoNaoEncontradoException {
		Usuario user = (Usuario) this.repositorio.buscarPorNomes(idUsuario);
		if (user != null) {
			Status var10002 = this.status;
			boolean sucesso = this.repositorio.updateStatus(idUsuario, Status.RELEASED);
			return sucesso;
		} else {
			throw new ElementoNaoEncontradoException(idUsuario);
		}
	}

	public boolean advirUsuario(String idUsuario) throws ElementoNaoEncontradoException {
		Usuario user = (Usuario) this.repositorio.buscarPorNomes(idUsuario);
		if (user != null) {
			Status var10002 = this.status;
			boolean sucesso = this.repositorio.updateStatus(idUsuario, Status.WARNED);
			return sucesso;
		} else {
			throw new ElementoNaoEncontradoException(idUsuario);
		}
	}

	public boolean rUsuario(String idUsuario) throws ElementoNaoEncontradoException {
		Pessoa pessoa = this.repositorio.buscarPorNomes(idUsuario);
		if (pessoa != null) {
			boolean sucesso = this.repositorio.removerPorNome(idUsuario);
			return sucesso;
		} else {
			throw new ElementoNaoEncontradoException(idUsuario);
		}
	}

	public List<Pessoa> lUsuarios() {
		List<Pessoa> todasosUsuarios = this.repositorio.read();
		return todasosUsuarios;
	}

	public boolean atualizarUEmdereco(String id, String novoEmdereco) throws ElementoNaoEncontradoException {
		if (this.repositorio.buscarPorNomes(id) == null) {
			throw new ElementoNaoEncontradoException(id);
		} else {
			Usuario usuario = (Usuario) this.repositorio.buscarPorNomes(id);
			usuario.setEndereco(novoEmdereco);
			this.repositorio.update(usuario);
			return true;
		}
	}

	public boolean atualizarUSenha(String login, String password, String novoPassword) throws ElementoNaoEncontradoException {
		Pessoa pessoa = this.repositorio.buscarPorNomes(login);
		if (pessoa instanceof Usuario usuario) {
			if (usuario.getPassword().equals(password)) {
				usuario.setPassword(novoPassword);
				this.repositorio.update(usuario);
				return true;
			}
		}
		throw new ElementoNaoEncontradoException(login);
	}

	public boolean atualizarUAdimin(String id, boolean isAdmin) throws ElementoNaoEncontradoException {
		if (this.repositorio.buscarPorNomes(id) == null) {
			throw new ElementoNaoEncontradoException(id);
		} else {
			Usuario usuario = (Usuario) this.repositorio.buscarPorNomes(id);
			usuario.setAdmin(isAdmin);
			this.repositorio.update(usuario);
			return true;
		}
	}

	public boolean adicionarAutor(String nome, LocalDate idade, String endereco, String pseudonimo, String nacionalidade) throws ElementoJaExisteException {
		if (this.repositorio.buscarPorNomes(nome) != null&&this.repositorio.buscarPorNomes(pseudonimo)!=null) {
			throw new ElementoJaExisteException(nome);
		} else {
			Autor autor = new Autor(nome, idade, endereco, pseudonimo, nacionalidade);
			autor.setNome(nome);
			autor.setPseudonimo(pseudonimo);
			autor.setNacionalidade(nacionalidade);
			autor.setIdade(idade);
			autor.setEndereco(endereco);
			boolean sucesso = this.repositorio.create(autor);
			return sucesso;
		}
	}

	public List<Autor> listaAutores() {
		List<Autor> autores = this.repositorio.listaA();
		return autores;
	}

	public List<ObraImpressa> bObraPorAutor(String obrasAutor) throws ElementoNaoEncontradoException {
		if (this.obrasUser.buscObraPorAutor(obrasAutor) == null) {
			throw new ElementoNaoEncontradoException(obrasAutor);
		} else {
			List<ObraImpressa> bOPA = this.obrasUser.buscarObrasDoAutor(obrasAutor);
			return bOPA;
		}
	}

	public String emprestarL(String numeroDeCadastro, String itemEmprestado) throws ElementoNaoEncontradoException {
		Usuario checarU = (Usuario) this.repositorio.buscarPorNomes(numeroDeCadastro);
		ObraImpressa checarO = this.obrasUser.buscarPorNomes(itemEmprestado);
		if (checarU != null && checarO != null) {
			label16:
			{
				Status var10000;
				Status var10001;
				if (checarO.getQuantidade() >= 1) {
					var10000 = checarU.getStatus();
					var10001 = this.status;
					if (var10000 == Status.RELEASED) {
						break label16;
					}
				}

				var10000 = checarU.getStatus();
				var10001 = this.status;
				if (var10000 != Status.WARNED) {
					return "\n(O usuario não pode executar emprestimos)\nUsuário Status :" + String.valueOf(checarU.getStatus());
				}
			}

			checarO.setdebiatarObra();
			LocalDate agora = LocalDate.now();
			LocalDate dataFinalParaDevoçao = agora.plusDays(15L);
			Emprestimo emprestimo = new Emprestimo(numeroDeCadastro, agora, itemEmprestado);
			emprestimo.setDataDeEntrega(dataFinalParaDevoçao);
			emprestimo.setItemEmprestado(checarO);
			emprestimo.setUsuarioQueRealizou(checarU);
			emprestimo.setItemEmprestadoo(itemEmprestado);
			this.empDeUsuarios.create(emprestimo);
			checarU.setEmprestimo(emprestimo);
			return "\nEmprestimo cadastrado";
		} else {
			throw new ElementoNaoEncontradoException(numeroDeCadastro);
		}
	}

	public String devolverL(String id, String Obra) throws ElementoNaoEncontradoException {
		Usuario checarU = (Usuario) this.repositorio.buscarPorNomes(id);
		ObraImpressa checarO = this.obrasUser.buscarPorNomes(Obra);
		if (checarU != null && checarO != null) {
			LocalDate agora = LocalDate.now();
			String a = checarO.getTitulo();
			Emprestimo atualizar = this.empDeUsuarios.buscarPorEmpretimo(a);
			if (atualizar.getItemEmprestado() == checarO) {
				atualizar.setDataDeDevolucaoEfetiva(agora);
				checarO.setCreditarObra();
				checarU.atualizar(atualizar);
				this.empDeUsuarios.devolverLivroR(atualizar);
				this.empDeUsuarios.removerEmpretimoAtrasado(atualizar);
				Status var10000 = checarU.getStatus();
				Status var10001 = this.status;
				if (var10000 == Status.WARNED) {
					var10001 = this.status;
					checarU.setStatus(Status.RELEASED);
				}

				return "\nObra devolvida com sucesso";
			} else {
				return "";
			}
		} else {
			throw new ElementoNaoEncontradoException(id);
		}
	}

	public List<Emprestimo> lEmprestimos() {
		List<Emprestimo> emprestimos = this.empDeUsuarios.read();
		return emprestimos;
	}

	public List<Emprestimo> hEmprestimos() {
		List<Emprestimo> emprestimos = this.empDeUsuarios.lHEmprestimos();
		return emprestimos;
	}

	public List<Emprestimo> epAtrasados() {
		List<Emprestimo> emprestimos = this.empDeUsuarios.eAtrasados();
		return emprestimos;
	}

	public List<Emprestimo> empDoUsuario(String nomeOuNdc) throws ElementoNaoEncontradoException {
		if (this.empDeUsuarios.buscarPorEmpretimoDoUsuario(nomeOuNdc) == null) {
			throw new ElementoNaoEncontradoException(nomeOuNdc);
		} else {
			List<Emprestimo> emprestimos = this.empDeUsuarios.buscarPorEmpretimoDoUsuario(nomeOuNdc);
			return emprestimos;
		}
	}

	public void iniciarContador() {
		this.empDeUsuarios.iniciarVerificacaoEntregasAtrasadas();
	}

	public Usuario loginUsuario(String login, String Senha) throws ElementoNaoEncontradoException {
		Pessoa pessoa = this.repositorio.buscarPorNomes(login);
		if (pessoa instanceof Usuario usuario) {
			System.out.println(usuario.getNumeroDeCadastro());
			if (usuario.getPassword().equals(Senha)) {
				this.usuarioAtivo = usuario;
				return usuario;
			}
		}
		throw new ElementoNaoEncontradoException(login);
	}

	public Usuario getUsuarioAtivo() {
		return usuarioAtivo;
	}

	public void setUsuarioAtivo(Usuario usuarioAtivo) {
		this.usuarioAtivo = usuarioAtivo;
	}

	public Usuario buscarU(String usuario) throws ElementoNaoEncontradoException {
		if (repositorio.buscarPorNomes(usuario) == null) {
			throw new ElementoNaoEncontradoException(usuario);
		} else {
			Usuario sucesso = (Usuario) repositorio.buscarPorNomes(usuario);
			return sucesso;
		}
	}
}
