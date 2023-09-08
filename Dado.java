import java.util.Random;

public class Dado 
{
    private static final Random random = new Random();
    public static double nivelAtaque()
    {

        double resultado; 
        int D20 = random.nextInt(21);
        double sorte = random.nextDouble(5);

        sorte = sorte==0? 1 : sorte;

        int totalCritico = critico(D20 , sorte);

        resultado = D20 * totalCritico;

        return resultado;
    }

    public static int nivelDefesa ()
    {
        int D20 = random.nextInt(21);
        double sorte = random.nextDouble(5);

        while(D20<=10 && sorte>=3.5)
        {
            D20 = random.nextInt(21);
        }

        if(D20>=18) return 100;
        else if(D20>=14) return 75;
        else if(D20>=10) return 50;
        else if(D20>=3) return 15;
        else return 0;
    }

    public static int critico(int D20 , double sorte)
    {
        if(D20>=15 && sorte>3) return 100;
        else return 1;

    }
}
