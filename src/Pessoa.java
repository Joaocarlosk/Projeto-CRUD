import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Pessoa {
	Scanner sc = new Scanner(System.in);
	DateTimeFormatter dF = DateTimeFormatter.ofPattern("dd/MM/yyy");
	protected String nome;
	protected String telefone;
	protected String dataDeNascimento;
	protected LocalDate dataDeCadastro = LocalDate.now();
	protected LocalDate dataAlteracaoCadastro;

	public Pessoa(String nom, String tel, String dataNasc) {
		nome = nom;
		telefone = tel;
		dataDeNascimento = dataNasc;
	}

	public Pessoa() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public LocalDate getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(LocalDate dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public LocalDate getDataAlteracaoCadastro() {
		return dataAlteracaoCadastro;
	}

	public void setDataAlteracaoCadastro(LocalDate dataAlteracaoCadastro) {
		this.dataAlteracaoCadastro = dataAlteracaoCadastro;
	}

	@Override
	public String toString() {
		if (dataAlteracaoCadastro == null) {
			return "Pessoa [Nome=" + nome + ", Telefone=" + telefone + ", Data de nascimento=" + dataDeNascimento
					+ ", Data de cadastro=" + dataDeCadastro.format(dF) + "]";
		} else {
			return "Pessoa [Nome=" + nome + ", Telefone=" + telefone + ", Data de nascimento=" + dataDeNascimento
					+ ", Data de cadastro=" + dataDeCadastro.format(dF) + ", Data de alteracao cadastro="
					+ dataAlteracaoCadastro.format(dF) + "]";
		}
	}

}
