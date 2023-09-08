import java.util.Random;

public class Lutador extends Combatente
{
    static Random random = new Random();

    public Lutador(String nome , double nivelEnergia)
    {
        super(nome,nivelEnergia);
    }


    public double escolherAtaque()
    {
        int Ataque = random.nextInt(2)+1;

        switch(Ataque)
        {   
            case(1)->{

                return socar();
            }
            case(2)->{
               return chutar();
            }
            default -> {
                return 0;
            }
        }
    } 
        
    public void escolherDefesa(double poderAtaque)
    {
        int defesa = random.nextInt(2)+1;

        switch(defesa)
        {   
            case(1)->{

                guarda(poderAtaque);
            }
            case(2)->{
                esquivar(poderAtaque);
            }

        }

    }
    public double socar()
    {
        double poderAtaque = Dado.nivelAtaque() + 15;

        if((nivelEnergia-(poderAtaque * 0.15f))>15)
        {
            nivelEnergia-= poderAtaque * 0.15f;
        }

        return poderAtaque;

    }

    public double chutar()
    {
        double poderAtaque = Dado.nivelAtaque() + 20;

        if((nivelEnergia-(poderAtaque * 0.30f))>15)
        {
            nivelEnergia-= poderAtaque * 0.30f;
        }

        return poderAtaque;
    }

    public void esquivar(double poderAtaque)
    {
        if(Dado.nivelDefesa()==100)
        {
            nivelEnergia -=0;
        }
        else
        {
            nivelEnergia-=poderAtaque;
        }
    }

    public void guarda(double poderAtaque)
    {
        int bloqueia = Dado.nivelDefesa();

        if(bloqueia==100)
        {
            nivelEnergia-=poderAtaque*0.90f;
        }
        else
        {
            nivelEnergia -=poderAtaque*(bloqueia/100.0);
        }
    }

}
