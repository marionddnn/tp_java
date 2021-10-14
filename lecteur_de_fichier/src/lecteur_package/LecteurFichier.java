package lecteur_package;

public interface LecteurFichier {
	Fichier setFile(String name, String path);
	void Ouvrir();
	void Lire();
	void Afficher(fenetre fenetre);
	
}
