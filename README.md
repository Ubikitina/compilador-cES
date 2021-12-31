# Objetivo compilador-cES
Práctica de la asignatura Procesadores del Lenguaje I de la Universidad Nacional a Distancia (UNED). El objetivo de la práctica es realizar las fases de análisis léxico y sintáctico de un compilador del lenguaje cES, variación del conocido lenguaje C con la característica particular de que las palabras reservadas estarán en castellano.

# Tabla de Contenido
1. [Estructura del compilador y fases](#1)
    1. Analizador Léxico
    2. Analizador Sintáctico
2. Especificaciones Léxicas del Lenguaje cES
    1. Comentarios
    2. Constantes literales
    3. Identificadores
    4. Palabras reservadas
    5. Delimitadores
    6. Operadores
3. Bibliografía

<a name="1"/>

# Estructura del compilador y fases
Un compilador realiza dos principales procesos: análisis y síntesis.
- **Análisis o _front-end_ del compilador**: divide el programa fuente en componentes e impone una estructura gramatical sobre ellas. Después utiliza esta estructura para crear una representación intermedia del programa fuente. Dentro de la fase de análisis podemos encontrar los componentes de Analizador Léxico, Analizador Sintáctico y Analizador Semántico. Si la parte del análisis detecta que el programa fuente está mal formado en cuanto a la sintaxis, o que no tiene una semántica consistente, entonces debe proporcionar mensajes informativos para que el usuario pueda corregirlo.
- **Síntesis o _back-end_ del compilador**: construye el programa destino deseado a partir de la representación intermedia y de la información en la tabla de símbolos. Típicamente está compuesto por los componentes Generdor de código y Optimizador, entre otros.

<p align="center">
  <img width="488" height="888" src="https://github.com/Ubikitina/compilador-cES/blob/main/images/Fases%20de%20un%20compilador.png">
</p>

## Analizador Léxico
El analizador léxico lee una secuencia ordenada de TOKENS. Un TOKEN es una entidad léxica indivisible que tiene un sentido único dentro del lenguaje. En términos generales es posible distinguir diferentes tipos de TOKENS. Los operadores aritméticos, relacionales y lógicos, los delimitadores como los paréntesis o los corchetes, los identificadores utilizados para nombrar variables, constantes o nombres de procedimientos, o las palabras reservadas del lenguaje son algunos ejemplos significativos.

## Analizador Sintáctico o _parser_
El analizador sintáctico utiliza los tokens producidos por el analizador léxico para crear una representación intermedia en forma de árbol que describa la estructura gramatical del flujo de tokens. Una representación típica es el árbol sintáctico, en el cual cada nodo interior representa una operación y los hijos del nodo representan los argumentos de la operación.

# Especificaciones Léxicas del Lenguaje cES
## Comentarios
- Un comentario es una secuencia de caracteres que se encuentra encerrada entre los delimitadores de principio de comentario y final de comentario: “/*” y “*/”, respectivamente. 
- Todos los caracteres encerrados dentro de un comentario deben ser ignorados por el analizador léxico. En este sentido su procesamiento no debe generar TOKENS que se comuniquen a las fases posteriores del compilador. 
- El analizador léxico deberá gestionar apropiadamente el anidamiento de comentarios para garantizar que los delimitadores de principio y fin de comentario están adecuadamente balanceados.

## Constantes literales
- Se distinguen dos tipos de constantes literales: Enteros y Cadenas de caracteres.
- Enteros: representan valores enteros no negativos.
- Cadenas de caracteres:
  - secuencia ordenada de caracteres ASCII delimitadas por las comillas dobles. 
  - serán utilizadas únicamente para poder escribir mensajes de texto por pantalla mediante la instrucción escribe(). No crearemos variables de este tipo.
  - solo se permitirán letras, dígitos y espacios en blanco dentro de una cadena de caracteres.

## Identificadores
- Secuencia ordenada de letras y dígitos que comienzan obligatoriamente por una letra.
- Nombran las entidades del programa tales como las variables o las funciones definidas por el programador.
- Son sensibles a las mayúsculas (_case sensitive_).
- La longitud no está restringida.

## Palabras reservadas
- Son entidades del lenguaje que, a nivel léxico, tienen un significado especial de manera que no pueden ser utilizadas para nombrar otras entidades como variables, constantes, funciones o procedimientos.
- Listado de palabras a utilizar:
  - `caso` Usado en sentencias “alternativas” para delimitar una o varias sentencias.
  - `constante` Define una constante simbólica numérica.
  - `corte` Usado en sentencias “alternativas”. Delimita un caso.
  - `entero` Tipo entero.
  - `escribe` Muestra por pantalla un texto.
  - `escribeEnt` Muestra por pantalla un entero.
  - `alternativas` Cabecera de una sentencia condicional “alternativas”.
  - `mientras` Cabecera de una sentencia de flujo “mientras”.
  - `pordefecto` Caso por defecto en una sentencia “alternativas”.
  - `principal` Nombre de la función principal.
  - `devuelve` Instrucción de retorno en funciones.
  - `si` Cabecera de una sentencia condicional “si”.
  - `sino` Parte optativa de una sentencia condicional “si”.
  - `tipo` Marca la declaración de un tipo.
  - `vacio` Tipo vacio.

## Delimitadores
- `"` Delimitador de constante literal de cadena.
- `( )` Delimitadores de expresiones y de parámetros.
- `[ ]` Delimitador de rango en una declaración de un vector.
- `,` Delimitador en listas de identificadores.
- `;` Delimitador en secuencias de sentencias.
- `:` Delimitador en una sentencia “alternativas”.

## Operadores
- Operadores aritméticos
  - `+` suma
  - `*` producto
- Operadores relacionales
  - `<` menor
  - `==` igual
- Operadores lógicos
  - `&&` conjunción lógica
  - `!` negación lógica
- Operadores especiales
  - `++` autoincremento
- Operadores de asignación
  - `=` asignación
  - `+=` asignación con suma
- Operadores de acceso
  - `[ ]` acceso a elemento de vector

# Especificaciones Sintácticas del Lenguaje cES
## Estructura de un programa y ámbitos de visibilidad
- Un programa en cES es un fichero de código fuente con extensión ‘.ces’ que comienza por una sección opcional donde se declara el conjunto de constantes simbólicas necesarias, seguido de secciones para la declaración de variables y tipos globales y la declaración de funciones no anidadas entre las que se encuentra la función principal.
- Pueden existir varias secciones de declaración global de variables y tipos alternadas entre las declaraciones de funciones. Es decir, las variables y tipos globales se pueden declarar en cualquier parte fuera del código de las funciones.
- Las constantes simbólicas sólo pueden ser definidas al inicio del programa.

## Declaraciones de constantes SIMBÓLICAS
- Constituyen una representación nombrada de datos constantes cuyo valor va a permanecer inalterado a lo largo de la ejecución del programa.
- En cES todas las constantes simbólicas son de tipo entero.
- Sintaxis: `#constante nombre valor;`
  - `nombre` es el nombre simbólico que recibe la constante definida dentro del programa
  - `valor` es un valor constante de tipo entero (número)

## Declaración de tipos

### Tipos primitivos: Tipo entero
- El tipo entero se representa con la palabra reservada entero.
- La aplicación de este tipo aparece en contextos:
  - Declaración de variables
  - Declaración de parámetros de funciones
  - Tipos de retorno de las funciones
  - Declaración de tipos compuestos

Ejemplos de la sintáxis:

`entero a;`
`entero sumar (entero x, entero y) { ...`
`tipo entero vector[10];`

### Tipos primitivos: Tipo vacio
- El tipo vacio se representa con la palabra reservada vacio.
- La aplicación de este tipo solo se realiza en el contexto donde una función se comporte como un procedimiento (esto es, como un bloque de código cuya invocación no produce ningún valor de retorno al programa llamante).

Ejemplos de la sintáxis:
`vacio main () { ... }` `vacio escribeEntero (entero x) { ... }`

### Tipos compuestos: Tipo vector
- Son tipos definidos por el programador y establecidos como un tipo más del lenguaje.
- El tipo creado recibe nombre (identificador) que sirve para referenciarlo posteriormente.
- Siempre hay que crear el tipo estructurado (con nombre) antes de ser utilizado.
- En cES sólo pueden declararse vectores de una dimensión y cuyo tipo base sea un entero.

Ejemplo de la sintaxis para la creación del tipo:
`tipo entero nombre[tam];`, donde:
- `nombre` es el identificador
- `tam` es una constante literal numérica o simbólica que indica el número de elementos que contiene el vector.

## Declaración de variables
Se utiliza la siguiente sintaxis:
`nombre-tipo var1 [ = val1], var2 [ = val2], ...;`
Donde:
- `nombre-tipo` es el nombre primitivo del lenguaje o definido por el usuario.
- `var1, var2,...` son identificadores para las variables creadas.
- `val1, val2,...` son valores opcionales asignados.

## Declaración de bloques
- Son una secuencia ordenada de instrucciones encapsuladas dentro de los delimitadores { y }.
- La estructura sintáctica de los bloques es anidante.
- Comienzan por una sección opcional de declaración de tipos, seguidas de una sección opcional de declaración de variables y continuan por una secuencia ordenada de sentencias que a su vez pueden contener a otros bloques.

## Declaración de funciones
- Bloque encapsulado bajo un nombre.

Ejemplo de la sintaxis:
```
tipo-retorno nombre (tipo1 param1, tipo2 param2,...){
    /* declaración de tipos y variables locales */
    /* sentencias */
    devuelve expresión;
}
```

# Código implementado en Flex y Cup


# Bibliografía
Aho, A., Lam, M., Sethi, R., & Ullman, J. (2008). Compiladores (2nd ed.). Pearson Educación.
