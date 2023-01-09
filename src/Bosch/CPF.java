package Bosch;

import java.util.ArrayList;

public class CPF {
    ArrayList<Character> letraSeparada = new ArrayList<>();
    ArrayList<Integer> numeroSeparado = new ArrayList<>();
    ArrayList<Integer> numeroSeparadoCalculo = new ArrayList<>();

    void removeEspecial(String numero){
        for (int i = 0; i < numero.length(); i++) {
            letraSeparada.add(numero.charAt(i));
        }
        letraSeparada.removeIf(n -> (n == '.' || n == '-'));
        for (Character character : letraSeparada) {
            Integer convertido = Integer.parseInt(character.toString());
            numeroSeparado.add((convertido));

        }
    }

    void calculaDigito(){

        int multiplicador = 10;
        int somaDigito = 0;
        for (int i = 0; i < numeroSeparado.size(); i++) {
            numeroSeparadoCalculo.add((numeroSeparado.get(i)*multiplicador));
            multiplicador --;
            somaDigito += numeroSeparadoCalculo.get(i);
        }
        int digito = 11-(somaDigito%11);
        digito = (digito > 9) ? 0 : digito;
        numeroSeparado.add(digito);


        // calcula o segundo digito.
        multiplicador = 11;
        somaDigito = 0;
        numeroSeparadoCalculo.clear();
        for (int i = 0; i < numeroSeparado.size(); i++) {
            numeroSeparadoCalculo.add((numeroSeparado.get(i)*multiplicador));
            multiplicador --;
            somaDigito += numeroSeparadoCalculo.get(i);
        }
        digito = 11-(somaDigito%11);
        digito = (digito > 9) ? 0 : digito;
        numeroSeparado.add(digito);
        StringBuilder formatCpf = new StringBuilder();
        for (int i = 0; i < numeroSeparado.size(); i++) {
            if (formatCpf.length() == 0){
                formatCpf = new StringBuilder(numeroSeparado.get(i).toString());
                continue;
            }if (formatCpf.length() == 3 || formatCpf.length() == 7){
                formatCpf.append(".");
            }
            if(formatCpf.length() == 11){
                formatCpf.append("-");
            }
            formatCpf.append(numeroSeparado.get(i));


        }
        System.out.println(formatCpf);
    }
}

