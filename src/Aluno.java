
public class Aluno extends Pessoa{
	
	private double notaFinal;
	
	public Aluno(String nom, String tel, String dataNasc, double nota){
		super(nom, tel, dataNasc);
		notaFinal = nota;		
	}
	
	@Override
	public String toString() {
		if (dataAlteracaoCadastro == null) {
			return "Aluno [Nome=" + nome + ", Telefone=" + telefone + ", Data de nascimento=" + dataDeNascimento
					+ ", Data de cadastro=" + dataDeCadastro.format(dF) + ", Nota final do curso: " + notaFinal + "]";
		}else {
			return "Aluno [Nome=" + nome + ", Telefone=" + telefone + ", Data de nascimento=" + dataDeNascimento
					+ ", Data de cadastro=" + dataDeCadastro.format(dF) + ", Data de alteracao cadastro="
					+ dataAlteracaoCadastro.format(dF) + ", Nota final do curso: " + notaFinal + "]";
		}
	}	
}


