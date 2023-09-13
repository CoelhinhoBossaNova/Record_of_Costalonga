public class Combatente
{
    protected String nome;
    protected double nivelEnergia;

    public Combatente(String nome , double nivelEnergia)
    {
        this.nome = nome;
        this.nivelEnergia = nivelEnergia;
    }

    public String getNome()
    {
        return this.nome;
    }

    public double getNivelEnergia()
    {
        return this.nivelEnergia;
    }


    public boolean estarVivo()
    {
        if(nivelEnergia>0)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }

    public double atacar(Combatente atacante , Combatente defensor)
    {
        if(atacante instanceof Lutador)
        {
            Lutador boxeador = (Lutador) atacante;

            if(boxeador instanceof  Gladiador)
            {
                 Gladiador espartano = (Gladiador) boxeador;
                 return espartano.apagarDepois();
            }
            else
            {
                return boxeador.escolherAtaque();
            }
        }
        else if(atacante instanceof Fera)
        {
            Fera besta = (Fera) atacante;
            return besta.escolherAtaque(defensor);
        }
        else
        {
            return Dado.nivelAtaque();
        }

    }

    public void defesa(double poderAtaque , Combatente defensor)
    {
        //modificar depois
        if(defensor instanceof Lutador)
        {
            Lutador boxeador = (Lutador) defensor;

            if(boxeador instanceof  Gladiador)
            {
                //Terminar
                nivelEnergia-=poderAtaque;
            }
            else
            {
                boxeador.escolherDefesa(poderAtaque);
            }
        }
        else if(defensor instanceof Fera)
        {
            nivelEnergia-=poderAtaque;
        }
        else
        {
            nivelEnergia-=(poderAtaque) * (Dado.nivelAtaque()/2);
        }

    }
}
