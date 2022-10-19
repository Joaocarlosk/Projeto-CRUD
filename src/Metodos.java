import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Metodos {
    Scanner sc = new Scanner(System.in);

    public void menuInicial() {
        System.out.print("\nDIGITE A OPÇÃO DESEJADA:\n");
        System.out.println("1- Criar pessoa ou aluno");
        System.out.println("2- Mostrar dados de todas pessoas e alunos criadas");
        System.out.println("3- Atualizar dados de uma pessoa ou aluno");
        System.out.println("4- Deletar uma pessoa ou aluno");
        System.out.println("0- Encerrar programa");
    }

    public Pessoa criarPessoa() {
        boolean opcaoNota = true;
        int opcao;
        System.out.printf("Informe os dados para cadastrar uma nova pessoa ou aluno:\n");
        System.out.print("Nome: ");
        String nom = sc.nextLine();
        System.out.print("Telefone: ");
        String tel = sc.nextLine();
        System.out.print("Data de nascimento: ");
        String dataNasc = sc.nextLine();
        do {
            try {
                System.out.printf("Deseja informar a nota final do curso?\n1-Sim\n2-Não");
                opcao = sc.nextInt();
                sc.nextLine();
                if (opcao == 1) {
                    opcaoNota = false;
                    System.out.print("Nota final do curso: ");
                    double nota = Double.parseDouble(sc.nextLine().replace(',', '.'));
                    Pessoa p = new Aluno(nom, tel, dataNasc, nota);
                    return p;
                } else if (opcao == 2) {
                    opcaoNota = false;
                    Pessoa p = new Pessoa(nom, tel, dataNasc);
                    return p;
                } else {
                    System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida!");
                sc.nextLine();
            }
        } while (opcaoNota);
        return new Pessoa();
    }

    public void mostrarDados(List<Pessoa> lista) {
        if (lista.size() == 0) {
            System.out.println("Não há usuários cadastrados!");
        } else {
            for (Pessoa pessoa : lista)
                System.out.println(pessoa.toString());
        }
    }

    public void atualizarDados(List<Pessoa> lista) {
        int opcao = 0;
        int flag = 0;
        System.out.println("Digite o nome da pessoa ou aluno: ");
        String nome = sc.nextLine();
        System.out.println("Digite a data de nascimento da pessoa ou aluno: ");
        String dataNasc = sc.nextLine();
        for (Pessoa p : lista) {
            if (nome.equalsIgnoreCase(p.getNome()) && dataNasc.equalsIgnoreCase(p.getDataDeNascimento())) {
                flag++;
                try {
                    do {
                        System.out.print("\nDIGITE A OPÇÃOO DESEJADA:\n");
                        System.out.println("1- Alterar Nome");
                        System.out.println("2- Alterar telefone");
                        System.out.println("3- Alterar data de nascimento");
                        opcao = sc.nextInt();
                        sc.nextLine();
                        if (opcao > 3 || opcao == 0) {
                            System.out.println(
                                    "Opção inválida, por favor, digite um número conforme as opções informadas.\n");
                        }
                    } while (opcao > 3 || opcao == 0);

                } catch (Exception e) {
                    System.out.println("OPÇÃOO INVÁLIDA!");
                    sc.nextLine();
                }

                switch (opcao) {
                    case 1: {
                        System.out.println("Digite o novo nome:");
                        String novoNovoNome = sc.nextLine();
                        p.setNome(novoNovoNome);
                        System.out.println("Nome atualizado com sucesso!");
                        p.setDataAlteracaoCadastro(LocalDate.now());
                        break;
                    }
                    case 2: {
                        System.out.println("Digite o novo telefone:");
                        String novoTelefone = sc.nextLine();
                        p.setTelefone(novoTelefone);
                        System.out.println("Telefone atualizado com sucesso!");
                        p.setDataAlteracaoCadastro(LocalDate.now());
                        break;
                    }
                    case 3: {
                        System.out.println("Digite a nova data de nascimento:");
                        String novaData = sc.nextLine();
                        p.setDataDeNascimento(novaData);
                        System.out.println("Data de nascimento atualizado com sucesso!");
                        p.setDataAlteracaoCadastro(LocalDate.now());
                        break;
                    }
                }
            }
        }
        if (flag == 0) {
            System.out.println("Pessoa ou aluno não cadastrado!");
        }
    }

    public void deletarPessoa(List<Pessoa> lista) {
        int flag = 0;
        System.out.println("Digite o nome da pessoa ou aluno que você quer deletar: ");
        String nome = sc.nextLine();
        System.out.println("Digite a data de nascimento da pessoa ou aluno que você quer deletar: ");
        String dataNasc = sc.nextLine();
        for (Pessoa p : lista) {
            if (nome.equalsIgnoreCase(p.getNome()) && dataNasc.equalsIgnoreCase(p.getDataDeNascimento())) {
                flag++;
                lista.remove(p);
                System.out.println("Cadastro removido com sucesso!");
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Pessoa ou aluno não cadastrado!");
        }
    }

}
