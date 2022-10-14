import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 5;
        List<Pessoa> listaPessoas = new ArrayList<>();
        Metodos metodos = new Metodos();
        System.out.printf("PROJETO CRUD PROGRAMA +PRATI\n");

        do {
            try {
                do {
                    metodos.menuInicial();
                    opcao = sc.nextInt();
                    sc.nextLine();
                    if (opcao > 4) {
                        System.out.println(
                                "Op��o inv�lida, por favor, digite um n�mero conforme as op��es informadas.\n");
                    }
                } while (opcao > 4);
            } catch (Exception e) {
                System.out.println("OP��O INV�LIDA!");
                sc.nextLine();
            }

            switch (opcao) {
                case 1: {
                    listaPessoas.add(metodos.criarPessoa());
                    break;
                }
                case 2: {
                    metodos.mostrarDados(listaPessoas);
                    break;
                }
                case 3: {
                    metodos.atualizarDados(listaPessoas);
                    break;
                }
                case 4: {
                    metodos.deletarPessoa(listaPessoas);
                    break;
                }
                case 0: {
                    System.out.println("Encerrando sistema!");
                    opcao = 0;
                }
            }
        } while (opcao != 0);
        sc.close();
    }
}
