import java.util.Scanner;
import java.util.Random;
public class Tabuada {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Random ran = new Random();


        int userResult = 1;
        int hits = 0;
        int totalQuestions = 0;

        System.out.println("Jogo da multiplicação, para encerrar o jogo digite o número '0'");

        while (userResult != 0) {

            int range = 10 - 1 + 1;
            int random1 = ran.nextInt(range) + 1; //números aleatórios de 0-10
            int random2 = ran.nextInt(range) + 1;
            int result = random1 * random2;

            System.out.println("Qual é o valor da multiplicação de " + random1 + " x " + random2 + " ?");

            if (input.hasNext()) {
                String inputStr = input.nextLine().trim();//trim para tratar no try-catch
                if (inputStr.equals("0")) {
                    System.out.println("Você digitou o número '0', e o programa foi encerrado.");
                    break;
                }
                // -------------------------------------------------------------------------
                try {
                    float inputFloat = Float.parseFloat(inputStr);
                    int inputInt = (int) inputFloat;
                    if (inputFloat == inputInt) {
                        userResult = inputInt;
                    } else {
                        System.out.println("Entrada inválida, digite um número inteiro.");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida, digite um número inteiro.");
                    continue;
                }
                // --------------------------------------------------------------------------
                if (result == userResult) {
                    System.out.println("Parabéns! Você acertou, o valor é: " + result);
                    hits++;
                } else {
                    System.out.println("Resposta errada, você digitou: " + userResult + ", e a resposta certa é: " + result + ". Não desista, tente novamente!");
                }
                totalQuestions++;
            }

        }
        float hitsPercentage = (float) hits / totalQuestions * 100;
        System.out.println("Você acertou " + hits + " de " + totalQuestions + " perguntas. Seu percentual de acertos é: " + hitsPercentage + "%");
    }
}