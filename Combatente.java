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

    public double atacar()
    {
        double ataque = Dado.nivelAtaque();
        return ataque;
    }

    public void defesa(double poderAtaque)
    {
        //modificar depois
        nivelEnergia-=poderAtaque;

    }





}
