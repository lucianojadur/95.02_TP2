# 95.02_TP2
Trabajo Práctico 2  de Algoritmos y Programación III - FIUBA

Nota: x ahora sólo copié tal cual está en el original la clase Country para chequear que el parseo y la creación del mapa sea correcta. 
No lo modifiqué, por lo que tanto el mapa como el parser deberían ser compatibles con lo que hay escrito hasta ahora.

Nota2: seguramente el parser se pueda mejorar. Lo hice así a lo bruto y, si bien hace lo único que tiene que hacer (obtener y almacenar de forma "correcta" los datos del mapa escpecificados en un archivo), dentro de la función que parsea todo hace 2 cosas a la vez: 
    1. crea una lista con referencias a todos los países
    2. crea el diccionario con todos los <name>s de los países como claves y sus correspondientes listas de PAÍSES (no strings) limítrofes.

  EL motivo de que el punto 2 sea así se debe a que si tomamos a las claves como objetos de tipo Country vamos a tener que sobrecargar sí o sí el método hashCode()
  para evitar que haya conflictos a la hora de buscar y matchear dicha clave en la tabla (no recuerdo si explicaron eso, sé que el equals sí lo vimos pero este no sé).
  Al tomar las claves como strings no habría conflicto ya que el lenguaje tiene incorporado "de fábrica" ese método de forma eficaz para cadenas, así que por más
  que haya 20000 strings "Argentina" dando vueltas por ahí, el diccionario siempre va a devolver la misma lista para cualquiera de esos strings.
  
Nota3: ya están los 50 países con sus correspondientes limítrofes; lo que no chequée es de qué versión del teg es. 
