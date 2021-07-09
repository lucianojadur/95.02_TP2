/*
 * Nota: La clase map ya está implementada con un Singleton para que no pueda
 * crearse más de una vez. 
 * Faltaría agregar las excepciones en caso de intentarlo ya que por defecto no
 * hace nada pero tampoco avisa.
 *
 */



import java.util.ArrayList;
import java.util.HashMap;

public class Map{

	public static Map map;
	private ArrayList<Country> countries;
	private HashMap<String, ArrayList<Country>> borderings;

	private Map(String path){
		ParserMap parsed = ParserMap.getParsedFile(path);
		countries = parsed.list();
		borderings = parsed.dict();
		int armiesAmount = 1;
	}

	public static Map create(String path){
		if (Map.map == null)
			map = new Map(path);
		return map;
	}

	//Given 2 Countries, returns true if b belongs to the list of a's bordering.
	public boolean areBordering(Country a, Country b){
		return borderings.get(a.getName()).contains(b);
	}

	//Returns a counrtry if its name matches the string given as parameter.
	public Country get(String name){
		for(Country c : countries)
			if (c.getName().equals(name))
				return c;
		return null;
	}


/*Métodos para pruebas a lo clásico (consola)*/	

	public void printBorderings(){
		for(String key : borderings.keySet()){                                                                                                           
 		//  for(ArrayList<Country> l : map.get(key))
 		System.out.print(key + ": ");   
 		for(Country c : borderings.get(key))
			System.out.print(c.getName() + " ");
 			System.out.println(" ");
		}
 	}

}
