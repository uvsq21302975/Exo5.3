import java.util.ArrayList;
import java.util.Iterator;


public class Repertoire extends Composant
{
    private ArrayList<Composant> liste_composants;

   
    public Repertoire(String nom)
    {
        this.nom = nom;
        this.liste_composants = new ArrayList<Composant>(); //liste des composants
    }
    
    public boolean contient(Composant c) {
        Iterator<Composant> liste_composant = liste_composants.iterator(); // parcours de la liste avec un iterateur
        Composant tmp;
        
        while(liste_composant.hasNext()) 
        {
            tmp = liste_composant.next();
            if(tmp.equals(c))
            {
                return true;
            }
            else if(tmp instanceof Repertoire) 
            {
                 if(((Repertoire)tmp).contient(c)) 
                 { //On teste a la suite si le composant est dans le sous-repertoire
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean ajouter(Composant comp)
    {
        if(this.contient(comp)) 
        {
            return false;
        }
        else if((comp instanceof Repertoire) && (((Repertoire) comp).contient(this))) 
        {
            return false;
        }
        else 
        {
            return liste_composants.add(comp);
        }
    }
    
    public boolean retirer(Composant comp)
    {
        return liste_composants.remove(comp);
    }
    
    public int Fichier_size()
    {
        Iterator<Composant> liste_composant = liste_composants.iterator();
        int somme = 0;
        
        while(liste_composant.hasNext()) 
        {
            somme = somme + liste_composant.next().Fichier_size(); 
        }
        return somme;
    }
}