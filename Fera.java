import java.util.Random;

public class Fera extends Combatente
{
    static Random random = new Random();
    float sangramento = 0;
    public Fera(String nome , double nivelEnergia)
    {
        super(nome,nivelEnergia);
    }

    public double escolherAtaque(Combatente adversario)
    {
        int acao = random.nextInt(2)+1;

        switch(acao)
        {
            case(1)->{
                return morde(adversario);
            }
            case(2)->{
                return usarGarra(adversario);
            }
            default -> {
                return 0.0;
            }
        }
    }

    
    public double morde(Combatente adversario)
    {
        double ataque = (Dado.nivelAtaque()/100) * adversario.nivelEnergia;
        if(adversario.nivelEnergia<20 && random.nextDouble(4)>3.5)
        {
            adversario.nivelEnergia = 0.0;
            return 9999;
        }
        else
        {
            return ataque;
        }
    }

    public double usarGarra(Combatente adversario)
    {
        double ataque = Dado.nivelAtaque();

        if(adversario.nivelEnergia>=100)
        {
            sangramento=0;
        }

        ataque = ataque * sangramento + ataque;

        ++sangramento;

        return ataque;

    }
}
