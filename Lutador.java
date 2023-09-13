import java.util.Random;

public class Lutador extends Combatente
{
    static Random random = new Random();
    private String nomeGolpe;
    private String nomeDefesa;

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

                setNomeAtaque("Chutar");
                return socar();
            }
            case(2)->{
                setNomeAtaque("Chutar");
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
                setNomeDefesa("Bloqueio");
                guarda(poderAtaque);
            }
            case(2)->{
                setNomeDefesa("Esquiva");
                esquivar(poderAtaque);
            }

        }

    }

    public String getNomeAtaque()
    {
        return nomeGolpe;
    }

    public void setNomeAtaque(String nomeGolpe)
    {
        this.nomeGolpe = nomeGolpe;
    }

    public String getNomeDefesa()
    {
        return nomeDefesa;
    }

    public void setNomeDefesa(String nomeDefesa)
    {
        this.nomeDefesa = nomeDefesa;
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
