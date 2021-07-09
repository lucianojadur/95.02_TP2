import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;


public class ParserMap{
//Attributes
	private ArrayList<Country> listOfCountries;
	private HashMap<String, ArrayList<Country>> map;

//Metods	
	private ParserMap(){
		listOfCountries = new ArrayList<Country>();
		map = new HashMap<String, ArrayList<Country>>();
	}

	public static ParserMap getParsedFile(String path){
		ParserMap map = new ParserMap();
		map.getListAndMapFrom(path);
		return map;	
	}

  //getters
	public HashMap<String, ArrayList<Country>> dict(){
		return map;
	}

	public ArrayList<Country> list(){
		return listOfCountries;
	}

/*
 * Estos 2 métodos de acá abajo funcionan bien pero para correr todo desde una
 * instancia de Map (que es la idea, Parser no existe en el juego después de
 * finalizar el setup) directamente pasé el más importante para ahí.
 *
 * Igual los dejo por si quieren probar que la lista de países también se cree
 * correctamente.
 *
 *
	public void printList(){
		for (Country c : listOfCountries)
			System.out.print(c.getName() + " ");
		System.out.println(" ");
	}

	public void printMap(){
		for(String key : map.keySet()){
			System.out.print(key + ": "); 	
			for(Country c : map.get(key))
					System.out.print(c.getName() + " ");
			System.out.println(" ");
		}
	}
*
*/

	//Parser. While reading a csv file opened from <path>, creates and appends
	//to the list each new Country inside the file by comparing their names
	//(file vs list).
	//When it reaches the end of each line, adds a new key-value pair to the
	//dictionary (every value contains a list of references to Countries from
	//listOfCountries, so no one is created twice or more)
	private void getListAndMapFrom(String path){
		BufferedReader reader = null;
		String line = "";
		String delim = ",";

		try {
			reader = new BufferedReader(new FileReader(path));
			while ((line = reader.readLine()) != null) {
				String [] names = line.split(delim);
				String key = names[0];
				String[] borderingsNames = Arrays.copyOfRange(names, 1, names.length);
				
				this.getCountriesFrom(names);
				//
				//Creo la lista de limítrofes de turno
				ArrayList<Country> borderings = new ArrayList<Country>();
				for(String name : borderingsNames){
					//
					//Busco x nombre los países limítrofes de la linea en la lista (sí o sí
					//fueron creados y agregados anteriormente)
					borderings.add(getByName(name));
				}
				//
				//Agrego los strings como claves (no paises).
				map.putIfAbsent(key,borderings);
			}
		} catch (Exception e) {	
			System.out.println("Ocurrió un error al procesar el archivo: " + path);
			System.out.println("Error: " + e);
		}	
	}


	//Adds to listOfCountries each new Country whose name is in <names>
	//(an array of Strings)
	private void getCountriesFrom(String[] names){
		for(String name : names){
			if(!isInList(name)){
				Country c =  new Country(name);
				listOfCountries.add(c);
			}
		}
	}
	
	//Looks for and returns a Country in listOfCountries given its name as String.
	//If not found retruns null
	private Country getByName(String name){
		for (Country c : listOfCountries)
			if(c.getName().equals(name))
				return c;
		return null;
	}

	//Linear search of a Country given its name as a String.
	private boolean isInList(String name){
		for(Country c : listOfCountries)	
			if (c.getName().equals(name))
				return true;
		return false;
	}	

}
