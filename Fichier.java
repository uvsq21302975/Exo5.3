
public class Fichier extends Composant
{
   
    private int taille_fichier;

    public Fichier(String nom,int taille)
    {
        this.nom = nom;
        this.taille_fichier = taille;
    }

    public int Fichier_size()
    {
        return taille_fichier;
    }
}