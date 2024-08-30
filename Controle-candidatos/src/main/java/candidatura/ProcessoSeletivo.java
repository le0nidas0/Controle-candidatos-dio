package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {

        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paula", "Augusto", "Monica", "Fabricio", "Mirela", "daniela", "Jorge"};

        for (String candidato: candidatos) {
            entrandoEmContato(candidato);

        }
    }

    public static void entrandoEmContato(String candidato) {

        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;

            if(continuarTentando){
                tentativasRealizadas++;

            }
            else
                System.out.println("Contato realizado com sucesso ");

        }while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " na " +tentativasRealizadas +" tentativa ");
        }
        else
            System.out.println("Nao conseguimos contato com " +candidato +candidato +" Numemero maximo de tentativas " +tentativasRealizadas);
    }

    public static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    public static void imprimirSelecionados() {
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paula", "Augusto", "Monica", "Fabricio", "Mirela", "daniela", "Jorge"};
        System.out.println("imprimindo a lista de candidatos informando o indice do elemento");

        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("O candidato de numero " +(i+1) +" e " +candidatos[i]);
        }
        System.out.println("abreviacao");

        for (String candidato: candidatos){
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }


    public static void selecaoCandidatos(){
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paula", "Augusto", "Monica", "Fabricio", "Mirela", "daniela", "Jorge"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPrentendido();

            System.out.println("O candidato " +candidato + " solicitou esse valor de salario " +salarioPretendido);

            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " +candidato +" foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    public static double valorPrentendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    public static void analisarCandidato(double salarioPretendido){

        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido ){
            System.out.println("Ligar para o candidato.");
        } else if (salarioBase==salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta");
        }
        else{
            System.out.println("Aguardando o resultado dos demais candidatos");
        }

    }
}
