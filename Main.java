import java.util.Scanner;

public class Main {
    public static void main (String[] argumentos){
        
        String[] Nomes = new String[5]; 

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um valor para o vetor");
        System.out.println("String informada: \n" + scanner.nextLine());

        Nomes[0] = "1";
        Nomes[1] = "2";
        Nomes[2] = "3";
        Nomes[3] = "4";
        Nomes[4] = "5";

        for (String nome : Nomes ){
            System.out.println("i" + nome);
        }

        System.out.println("Math: " + Math.pow(3, 4));
        
    }

}
