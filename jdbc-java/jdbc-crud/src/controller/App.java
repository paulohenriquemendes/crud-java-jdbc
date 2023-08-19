package controller;

import java.util.List;
import java.util.Scanner;

import model.Funcionario;
import service.FuncionarioDao;

public class App {
    public static void main(String[] args) throws Exception {
        
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.create();  

        Scanner scanner = new Scanner(System.in);

        System.out.println("SISTEMA DE GERENCIAMENTO DE FUNCIONÁRIO");

        System.out.println("1 - CADASTRO \n2 - EDIÇÃO \n3 - DELETAR \n4 - LISTAR");
        int opcao = scanner.nextInt();

        switch(opcao){
            
            case 1:
                Funcionario funcionario = new Funcionario();
                System.out.println("Informe o nome do funcionário");
                funcionario.setNome(scanner.next());
                System.out.println("Informe a quantidade de horas trabalhadas pelo funcionário");
                funcionario.setHorasTrabalhadas(scanner.nextDouble());
                System.out.println("Informe o valor da hora do funcionário");
                funcionario.setHorasValor(scanner.nextDouble());
                funcionarioDao.insert(funcionario);
                break;
            case 2:
                Funcionario funcionarioEdit = new Funcionario();
                System.out.println("Qual funcionário deseja editar? Informe o id:");
                funcionarioEdit.setId(scanner.nextInt());
                System.out.println("Informe o nome do funcionário");
                funcionarioEdit.setNome(scanner.next());
                System.out.println("Informe a quantidade de horas trabalhadas pelo funcionário");
                funcionarioEdit.setHorasTrabalhadas(scanner.nextDouble());
                System.out.println("Informe o valor da hora do funcionário");
                funcionarioEdit.setHorasValor(scanner.nextDouble());
                funcionarioDao.update(funcionarioEdit);
                break;
            case 3:
                Funcionario funcionarioDelete = new Funcionario();
                System.out.println("Qual funcionário deseja excluir? Informe o id:");
                funcionarioDelete.setId(scanner.nextInt());
                funcionarioDao.delete(funcionarioDelete);
                break;
            case 4:
                List<Funcionario> funcionarios = funcionarioDao.getAll();
                for(Funcionario f: funcionarios){
                    System.out.println("ID:" + f.getId() + ": " + "NOME: " + f.getNome());
                }
                break;
            default:
                System.out.println("Opção Inválida");
              
        }       
    }
}
