package business.service;

import business.entities.*;
import business.exceptions.ElementoJaExisteException;
import business.exceptions.ElementoNaoEncontradoException;

import java.time.LocalDate;
import java.util.List;

public class PessoaService {
	private UsuarioService uService = new UsuarioService();
	private static PessoaService instance;

	private PessoaService() {
	}

	public static PessoaService getInstance() {
		if (instance == null) {
			instance = new PessoaService();
		}

		return instance;
	}

	public boolean cadastrarUsuario(String nome, String cpf, LocalDate idade, String endereco, String login, String password, boolean isAdmin) throws ElementoJaExisteException {
		boolean sucesso = this.uService.adicionarUsuario(nome, cpf, idade, endereco, login, password, isAdmin);
		return sucesso;
	}

	public boolean bloquearUsuario(String Usuario) throws ElementoNaoEncontradoException {
		boolean sucesso = this.uService.bUsuario(Usuario);
		return sucesso;
	}

	public boolean liberarUsuario(String Usuario) throws ElementoNaoEncontradoException {
		boolean sucesso = this.uService.libUsuario(Usuario);
		return sucesso;
	}

	public boolean advertirUsuario(String Usuario) throws ElementoNaoEncontradoException {
		boolean sucesso = this.uService.advirUsuario(Usuario);
		return sucesso;
	}

	public boolean removerUsuario(String id) throws ElementoNaoEncontradoException {
		boolean sucesso = this.uService.rUsuario(id);
		return sucesso;
	}

	public List<Pessoa> listaDeUsuarios() {
		List<Pessoa> usuarios = this.uService.lUsuarios();
		return usuarios;
	}

	public boolean atualizarEmderecoDoUsuario(String id, String novoEmdereco) throws ElementoNaoEncontradoException {
		boolean sucesso = this.uService.atualizarUEmdereco(id, novoEmdereco);
		return sucesso;
	}

	public boolean atualizarLoginESenhaDoUsuario(String login, String password, String novoLogin, String novoPassword) throws ElementoNaoEncontradoException {
		boolean sucesso = this.uService.atualizarULoginESenha(login, password, novoLogin, novoPassword);
		return sucesso;
	}

	public boolean atualizarStatusAdiminUsuario(String cpf, boolean isAdmin) throws ElementoNaoEncontradoException {
		boolean sucesso = this.uService.atualizarUAdimin(cpf, isAdmin);
		return sucesso;
	}

	public boolean cadastrarAutor(String nome, LocalDate idade, String endereco, String pseudonimo, String nacionalidade) throws ElementoJaExisteException {
		boolean sucesso = this.uService.adicionarAutor(nome, idade, endereco, pseudonimo, nacionalidade);
		return sucesso;
	}

	public List<Autor> listaDeAutores() {
		List<Autor> autores = this.uService.listaAutores();
		return autores;
	}

	public List<ObraImpressa> buscarObraPorAutor(String obrasAutor) throws ElementoNaoEncontradoException {
		List<ObraImpressa> bOPA = this.uService.bObraPorAutor(obrasAutor);
		return bOPA;
	}

	public String emprestrarObra(String numeroDeCadastro, String itemEmprestado) throws ElementoNaoEncontradoException {
		String obra = this.uService.emprestarL(numeroDeCadastro, itemEmprestado);
		return obra;
	}

	public String devolverLivro(String Usuario, String Obra) throws ElementoNaoEncontradoException {
		String obra = this.uService.devolverL(Usuario, Obra);
		return obra;
	}

	public List<Emprestimo> listaDeEmprestimos() {
		List<Emprestimo> emprestimos = this.uService.lEmprestimos();
		return emprestimos;
	}

	public List<Emprestimo> historicoDeEmprestimos() {
		List<Emprestimo> emprestimos = this.uService.hEmprestimos();
		return emprestimos;
	}

	public List<Emprestimo> emprestimosAtrazados() {
		List<Emprestimo> emprestimos = this.uService.epAtrasados();
		return emprestimos;
	}

	public List<Emprestimo> buscarEmprestimosDoUsuario(String nomeOuNdc) throws ElementoNaoEncontradoException {
		List<Emprestimo> emprestimos = this.uService.empDoUsuario(nomeOuNdc);
		return emprestimos;
	}

	public void ativarContador() {
		this.uService.iniciarContador();
	}

	public Usuario loginDoUsuario(String login, String Senha) throws ElementoNaoEncontradoException {
		Usuario usuario = this.uService.loginUsuario(login, Senha);
		return usuario;
	}

	public UsuarioService getuService() {
		return this.uService;
	}
}

		