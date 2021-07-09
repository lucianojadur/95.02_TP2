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
	private int armiesAmount;

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
