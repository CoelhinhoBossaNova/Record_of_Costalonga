import java.util.Scanner;
import java.util.ArrayList;

/*
Trabalho inacabado (não foi feito Gladiador)
*/

public class AppArena
{
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Combatente> listaPersonagens = new ArrayList<>();
    static int qtPersonagens;
    static int rodada = 1;

    public static void main(String[] args)
    {

        System.out.println("Bem Vindo ao 'Record of Costalonga' \n");

        System.out.print("Quantos personagens deseja selecionar na arena: ");
        qtPersonagens = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < qtPersonagens; i++)
        {
            System.out.printf("Ficha %d",i+1);
            criaPersonagem(i + 1);
        }

        System.out.print("Pressione 'Enter' para ver o combate: ");
        scanner.nextLine();
        campeonato();
        scanner.close();
    }

    public static void criaPersonagem(int index)
    {
        String nickname;
        int classe;

        System.out.printf("\nDigite o nome do personagem %d: ", index);
        nickname = scanner.nextLine();

        System.out.print("\nClasses disponíveis\n");
        System.out.println("1 - Combatente");
        System.out.println("2 - Lutador");
        System.out.println("3 - Gladiador");
        System.out.println("4 - Fera");

        System.out.printf("\nDigite a classe do %s: ", nickname);
        classe = scanner.nextInt();
        scanner.nextLine();

        switch (classe) {
            case (1) -> {
                Combatente sanguinario = new Combatente(nickname, 140.0);
                listaPersonagens.add(sanguinario);
            }
            case (2) -> {
                Lutador boxeador = new Lutador(nickname, 90.0);
                listaPersonagens.add(boxeador);
            }
            case (3) -> {
                Gladiador barbaro = new Gladiador(nickname, 100.0);
                listaPersonagens.add(barbaro);
            }
            case (4) -> {
                Fera besta = new Fera(nickname, 50.0);
                listaPersonagens.add(besta);
            }
            default -> {
                System.out.println("Opção invalida, tente novamente");
                System.exit(1);
            }
        }
    }

    public static void campeonato()
    {
        Combatente personagem1 = null;
        Combatente personagem2 = null;

        while (listaPersonagens.size() > 1)
        {
            personagem1 = listaPersonagens.get(0);
            personagem2 = listaPersonagens.get(1);

            Combatente vencedor = luta(personagem1,personagem2);

            assert vencedor != null;

            System.out.print("Pressione 'Enter' para saber quem ganhou: ");
            scanner.nextLine();

            System.out.printf("%s vs %s quem ganhou foi : %s com %.2f de vida\n",personagem1.getNome(),personagem2.getNome(),vencedor.getNome(),vencedor.nivelEnergia);

        }
        System.out.printf("\nO ultimo a ficar de pé foi %s da classe %s com %.2f de vida \n",listaPersonagens.get(0).nome,listaPersonagens.get(0).getClass().getName(),listaPersonagens.get(0).nivelEnergia);
    }


    public static Combatente luta(Combatente personagem1, Combatente personagem2)
    {

        //Concertar prints depois

        Combatente primeiroAtacante = (Math.random() >= 0.5) ? personagem1 : personagem2;
        double ataque = 0.0;

        System.out.printf("\nRodada %d\n",rodada);
        System.out.printf("%s vs %s\n\n",personagem1.getNome(),personagem2.getNome());

        while (personagem1.estarVivo() && personagem2.estarVivo())
        {
            Combatente atacante = primeiroAtacante;
            Combatente defensor = (atacante == personagem1) ? personagem2 : personagem1;

            ataque = atacante.atacar(atacante , defensor);
            defensor.defesa(ataque,defensor);

            if (!defensor.estarVivo())
            {
                System.out.printf("%s morreu e esta fora de combate \n",defensor.getNome());

                listaPersonagens.remove(defensor);
                ++rodada;
                return atacante;
            }

            primeiroAtacante = defensor;
        }
        return null;
    }
}
