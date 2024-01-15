import com.example.demo.model.cliente;
import com.example.demo.model.empresa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {

    private static List<cliente> clientes = new ArrayList<>();
    private static List<empresa> empresas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha a operação (1 - Cadastrar, 2 - Consultar):");
        int escolhaOperacao = scanner.nextInt();

        if (escolhaOperacao == 1) {
            cadastrarOperacao(scanner);
        } else if (escolhaOperacao == 2) {
            consultarOperacao(scanner);
        } else {
            System.out.println("Opção inválida");
        }
    }

    private static void cadastrarOperacao(Scanner scanner) {
        System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
        int escolhaTipo = scanner.nextInt();

        if (escolhaTipo == 1) {
            cadastrarCliente(scanner);
        } else if (escolhaTipo == 2) {
            cadastrarEmpresa(scanner);
        } else {
            System.out.println("Opção inválida");
        }
    }

    private static void consultarOperacao(Scanner scanner) {
        System.out.println("Escolha o tipo para consulta (1 - Pessoa Física, 2 - Pessoa Jurídica):");
        int escolhaTipo = scanner.nextInt();

        if (escolhaTipo == 1) {
            consultarCliente(scanner);
        } else if (escolhaTipo == 2) {
            consultarEmpresa(scanner);
        } else {
            System.out.println("Opção inválida");
        }
    }

    private static void cadastrarCliente(Scanner scanner) {
        cliente novoCliente = new cliente();

        System.out.println("Digite o CPF do cliente:");
        String cpf = scanner.next();

        if (validarCPF(cpf)) {
            novoCliente.setCPF(cpf);
            clientes.add(novoCliente);
            System.out.println("Cliente cadastrado com sucesso!");
        } else {
            System.out.println("CPF inválido. Cliente não cadastrado.");
        }
    }

    private static void cadastrarEmpresa(Scanner scanner) {
        empresa novaEmpresa = new empresa();

        System.out.println("Digite o CNPJ da empresa:");
        String cnpj = scanner.next();

        if (validarCNPJ(cnpj)) {
            novaEmpresa.setCNPJ(cnpj);
            empresas.add(novaEmpresa);
            System.out.println("Empresa cadastrada com sucesso!");
        } else {
            System.out.println("CNPJ inválido. Empresa não cadastrada.");
        }
    }

    private static void consultarCliente(Scanner scanner) {
        System.out.println("Digite o CPF do cliente para consulta:");
        String cpfConsulta = scanner.next();

        for (cliente c : clientes) {
            if (c.getCPF().equals(cpfConsulta)) {
                System.out.println("Cliente encontrado: CPF - " + c.getCPF());
                return;
            }
        }

        System.out.println("Cliente não encontrado.");
    }

    private static void consultarEmpresa(Scanner scanner) {
        System.out.println("Digite o CNPJ da empresa para consulta:");
        String cnpjConsulta = scanner.next();

        for (empresa e : empresas) {
            if (e.getCNPJ().equals(cnpjConsulta)) {
                System.out.println("Empresa encontrada: CNPJ - " + e.getCNPJ());
                return;
            }
        }

        System.out.println("Empresa não encontrada.");
    }

    private static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int resto = soma % 11;
        int digitoVerificador1 = (resto < 2) ? 0 : (11 - resto);

        if (Character.getNumericValue(cpf.charAt(9)) != digitoVerificador1) {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        resto = soma % 11;
        int digitoVerificador2 = (resto < 2) ? 0 : (11 - resto);

        return Character.getNumericValue(cpf.charAt(10)) == digitoVerificador2;
    }

    private static boolean validarCNPJ(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]", "");

        if (cnpj.length() != 14) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 12; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i)) * ((i % 8) + 2);
        }
        int resto = soma % 11;
        int digitoVerificador1 = (resto < 2) ? 0 : (11 - resto);

        if (Character.getNumericValue(cnpj.charAt(12)) != digitoVerificador1) {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 13; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i)) * ((i % 8) + 2);
        }
        resto = soma % 11;
        int digitoVerificador2 = (resto < 2) ? 0 : (11 - resto);

        return Character.getNumericValue(cnpj.charAt(13)) == digitoVerificador2;
    }
}
