package lecteur_package;


public abstract class AfficheFichier implements LecteurFichier  {
	Fichier file;
	
		AfficheFichier(Fichier fichier){
		this.file = fichier;
	}
	
	public Fichier setFile(String name, String path){
		this.file = new Fichier(name, path); 
		return this.file;
	}

	@Override
	public void Ouvrir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Lire() {
		// TODO Auto-generated method stub
		
	}
	
}
