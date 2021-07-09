/*
 * Main de prueba para imprimir el diccionario con
 * las listas de países limítrofes de cada país
 *
 * Nota1: Map almacena tanto la lista de países como una tabla con los limítrofes de cada país
 * Nota2: las claves de la tabla son Strings y las listas contienen <Country>s
 *
 * Ver Map y ParserMap para detalles de implementación
 *
 */

public class main{

	public static void main(String[] argv){
		Map map = Map.create("./mapa.csv");
		map.printBorderings();
	}
}
