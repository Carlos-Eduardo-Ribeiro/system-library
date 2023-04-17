package business.repositories;

import business.entities.ObraImpressa;

import java.util.ArrayList;
import java.util.List;


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
    
    //Methods//-------------------------------------------------

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

    public List<ObraImpressa> read() {
        return this.obras;
    }

    public ObraImpressa buscarPorNomes(String titulo) {
        for (ObraImpressa obra : obras) {
            if (obra.getTitulo().equals(titulo)||obra.getAutor().equals(titulo)) {
                return obra;
            }
        }
        return null;
    }
    //obras do autor
    public List<ObraImpressa> buscarObrasDoAutor(String id) {
	    List<ObraImpressa> obrasDoAutor = new ArrayList<>();
	    for (ObraImpressa obra : obras) {
	        if (obra.getAutor().equals(id)) {
	        	obrasDoAutor.add(obra);
	        }
	    }
	    return obrasDoAutor;
	}

    public ObraImpressa buscObraPorAutor(String obrasAutor) {
        for (ObraImpressa obra : obras) {
            if (obra.getAutor().equals(obrasAutor)||obra.getTitulo().equals(obrasAutor)) {
                return obra;
            }
        }
        return null;
    }
}

