package business.repositories;

import java.util.ArrayList;
import java.util.List;
import business.entities.ObraImpressa;


public class RepositorioDeObras implements IRepositories<ObraImpressa> {
	
	private static RepositorioDeObras instance;
	
	private ArrayList<ObraImpressa> obras;
	
	public static RepositorioDeObras getInstance() {
	      if (instance == null) {
	        instance = new RepositorioDeObras();
	      }
	      return instance;
	    }

    public RepositorioDeObras() {
        this.obras = new ArrayList<>();
    }

    public boolean create(ObraImpressa obra) {
        boolean a =this.obras.add(obra);
        return a;
    }
    
    public boolean removerPorNome(String titulo) {
        for (ObraImpressa obra : obras) {
            if (obra.getTitulo().equals(titulo)) {
            	this.obras.remove(obra);
                return true;
            }
        }
        return false;
    }

    public boolean update(ObraImpressa obj) {
    	   		
    	ObraImpressa paraRemover= buscarPorNomes(obj.getTitulo());
    	removerPorNome(paraRemover.getTitulo());
    	create(obj); 
    	return true;
    	
    }

    public ObraImpressa buscarPorNomes(String titulo) {
        for (ObraImpressa obra : obras) {
            if (obra.getTitulo().equals(titulo)) {
                return obra;
            }
        }
        return null;
    }


    public List<ObraImpressa> read() {
        return this.obras;
    }
    
    public ObraImpressa buscObraPorAutor(String obrasAutor) {
        for (ObraImpressa obra : obras) {
            if (obra.getAutor().equals(obrasAutor)) {
                return obra;
            }
        }
        return null;
    }
 
}

