package Bosch;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String CPF;
        Scanner s = new Scanner(System.in);
        CPF c = new CPF();
        System.out.print("Digite os 9 primeiro numeros do CPF: ");
        String cpf = s.nextLine();
        c.removeEspecial(cpf);
        c.calculaDigito();
    }
}
