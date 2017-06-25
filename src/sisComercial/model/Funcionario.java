package sisComercial.model;

import java.util.Calendar;
import java.util.UUID;

public class Funcionario {
	private String id;
	private String nomeFuncionario;
	private double salarioBase;
	private double complementoSalarial;
	private double porcentagenAdiantamento;
	private double salarioCarteira;
	private double salarioLiquido;
	private double vlAdiantamento;
	private double vlsaldoSalario;
	private Usuario usuario;
	private Cpf cpf;
	private Rg rg;
	private CarteiraTrabalho carteiraTrabalho;
	private Endereco endereco;
	private Calendar dataDeNascimento;
	
	public Funcionario() {
		this.id = UUID.randomUUID().toString();
	}

	public Funcionario(String nomeFuncionario, double salarioBase, double complementoSalarial,
			double porcentagenAdiantamento, double salarioCarteira, double salarioLiquido, double vlAdiantamento,
			double vlsaldoSalario, Usuario usuario, Cpf cpf, Rg rg, CarteiraTrabalho carteiraTrabalho,
			Endereco endereco, Calendar dataDeNascimento) {
		this();
		this.nomeFuncionario = nomeFuncionario;
		this.salarioBase = salarioBase;
		this.complementoSalarial = complementoSalarial;
		this.porcentagenAdiantamento = porcentagenAdiantamento;
		this.salarioCarteira = salarioCarteira;
		this.salarioLiquido = salarioLiquido;
		this.vlAdiantamento = vlAdiantamento;
		this.vlsaldoSalario = vlsaldoSalario;
		this.usuario = usuario;
		this.cpf = cpf;
		this.rg = rg;
		this.carteiraTrabalho = carteiraTrabalho;
		this.endereco = endereco;
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getComplementoSalarial() {
		return complementoSalarial;
	}

	public void setComplementoSalarial(double complementoSalarial) {
		this.complementoSalarial = complementoSalarial;
	}

	public double getPorcentagenAdiantamento() {
		return porcentagenAdiantamento;
	}

	public void setPorcentagenAdiantamento(double porcentagenAdiantamento) {
		this.porcentagenAdiantamento = porcentagenAdiantamento;
	}

	public double getSalarioCarteira() {
		return salarioCarteira;
	}

	public void setSalarioCarteira(double salarioCarteira) {
		this.salarioCarteira = salarioCarteira;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public double getVlAdiantamento() {
		return vlAdiantamento;
	}

	public void setVlAdiantamento(double vlAdiantamento) {
		this.vlAdiantamento = vlAdiantamento;
	}

	public double getVlsaldoSalario() {
		return vlsaldoSalario;
	}

	public void setVlsaldoSalario(double vlsaldoSalario) {
		this.vlsaldoSalario = vlsaldoSalario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cpf getCpf() {
		return cpf;
	}

	public void setCpf(Cpf cpf) {
		this.cpf = cpf;
	}

	public Rg getRg() {
		return rg;
	}

	public void setRg(Rg rg) {
		this.rg = rg;
	}

	public CarteiraTrabalho getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(CarteiraTrabalho carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Calendar getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Calendar dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	
	

}
