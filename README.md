# Objetivo compilador-cES
Práctica de la asignatura Procesadores del Lenguaje I de la Universidad Nacional a Distancia (UNED). El objetivo de la práctica es realizar las fases de análisis léxico y sintáctico de un compilador del lenguaje cES, variación del conocido lenguaje C con la característica particular de que las palabras reservadas estarán en castellano.

# Tabla de Contenido
1. [Estructura del compilador y fases](#1)
    1. [Analizador Léxico](#2)
    2. [Analizador Sintáctico](#3)
2. [Especificaciones Léxicas del Lenguaje cES](#4)
    1. [Comentarios](#5)
    2. [Constantes literales](#6)
    3. [Identificadores](#7)
    4. [Palabras reservadas](#8)
    5. [Delimitadores](#9)
    6. [Operadores](#10)
3. [Especificaciones Sintácticas del Lenguaje cES](#11)
    1. [Estructura de un programa y ámbitos de visibilidad](#12)
    2. [Declaraciones de constantes SIMBÓLICAS](#13)
    3. [Declaración de tipos](#14)
    4. [Declaración de variables](#18)
    5. [Declaración de bloques](#19)
    6. [Declaración de funciones](#20)
    7. [Llamada a funciones](#21)
    8. [Expresiones](#22)
    9. [Sentencias](#23)
    10. [Asignaciones](#24)
    11. [Asignación con suma](#25)
    12. [Sentencia de control de flujo condicional SI – SINO](#26)
    13. [Sentencia de control de flujo condicional ALTERNATIVAS](#27)
    14. [Sentencia de control de flujo iterativo MIENTRAS](#28)
    15. [Sentencias de salida](#29)
4. [Código implementado en Flex y Cup](#30)
5. [Herramientas utilizadas](#31)
    1. [JFlex](#32)
    2. [Cup](#33)
6. [Bibliografía](#34)

<a name="1"/>

# Estructura del compilador y fases
Un compilador realiza dos principales procesos: análisis y síntesis.
- **Análisis o _front-end_ del compilador**: divide el programa fuente en componentes e impone una estructura gramatical sobre ellas. Después utiliza esta estructura para crear una representación intermedia del programa fuente. Dentro de la fase de análisis podemos encontrar los componentes de Analizador Léxico, Analizador Sintáctico y Analizador Semántico. Si la parte del análisis detecta que el programa fuente está mal formado en cuanto a la sintaxis, o que no tiene una semántica consistente, entonces debe proporcionar mensajes informativos para que el usuario pueda corregirlo.
- **Síntesis o _back-end_ del compilador**: construye el programa destino deseado a partir de la representación intermedia y de la información en la tabla de símbolos. Típicamente está compuesto por los componentes Generdor de código y Optimizador, entre otros.

<p align="center">
  <img width="488" height="888" src="https://github.com/Ubikitina/compilador-cES/blob/main/images/Fases%20de%20un%20compilador.png">
</p>

<a name="2"/>

## Analizador Léxico
El analizador léxico lee una secuencia ordenada de TOKENS. Un TOKEN es una entidad léxica indivisible que tiene un sentido único dentro del lenguaje. En términos generales es posible distinguir diferentes tipos de TOKENS. Los operadores aritméticos, relacionales y lógicos, los delimitadores como los paréntesis o los corchetes, los identificadores utilizados para nombrar variables, constantes o nombres de procedimientos, o las palabras reservadas del lenguaje son algunos ejemplos significativos.

<a name="3"/>

## Analizador Sintáctico o _parser_
El analizador sintáctico utiliza los tokens producidos por el analizador léxico para crear una representación intermedia en forma de árbol que describa la estructura gramatical del flujo de tokens. Una representación típica es el árbol sintáctico, en el cual cada nodo interior representa una operación y los hijos del nodo representan los argumentos de la operación.

<a name="4"/>

# Especificaciones Léxicas del Lenguaje cES

<a name="5"/>

## Comentarios
- Un comentario es una secuencia de caracteres que se encuentra encerrada entre los delimitadores de principio de comentario y final de comentario: “/*” y “*/”, respectivamente. 
- Todos los caracteres encerrados dentro de un comentario deben ser ignorados por el analizador léxico. En este sentido su procesamiento no debe generar TOKENS que se comuniquen a las fases posteriores del compilador. 
- El analizador léxico deberá gestionar apropiadamente el anidamiento de comentarios para garantizar que los delimitadores de principio y fin de comentario están adecuadamente balanceados.

<a name="6"/>

## Constantes literales
- Se distinguen dos tipos de constantes literales: Enteros y Cadenas de caracteres.
- Enteros: representan valores enteros no negativos.
- Cadenas de caracteres:
  - secuencia ordenada de caracteres ASCII delimitadas por las comillas dobles. 
  - serán utilizadas únicamente para poder escribir mensajes de texto por pantalla mediante la instrucción escribe(). No crearemos variables de este tipo.
  - solo se permitirán letras, dígitos y espacios en blanco dentro de una cadena de caracteres.

<a name="7"/>

## Identificadores
- Secuencia ordenada de letras y dígitos que comienzan obligatoriamente por una letra.
- Nombran las entidades del programa tales como las variables o las funciones definidas por el programador.
- Son sensibles a las mayúsculas (_case sensitive_).
- La longitud no está restringida.

<a name="8"/>

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

<a name="9"/>

## Delimitadores
- `"` Delimitador de constante literal de cadena.
- `( )` Delimitadores de expresiones y de parámetros.
- `[ ]` Delimitador de rango en una declaración de un vector.
- `,` Delimitador en listas de identificadores.
- `;` Delimitador en secuencias de sentencias.
- `:` Delimitador en una sentencia “alternativas”.

<a name="10"/>

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

<a name="11"/>

# Especificaciones Sintácticas del Lenguaje cES

<a name="12"/>

## Estructura de un programa y ámbitos de visibilidad
- Un programa en cES es un fichero de código fuente con extensión ‘.ces’ que comienza por una sección opcional donde se declara el conjunto de constantes simbólicas necesarias, seguido de secciones para la declaración de variables y tipos globales y la declaración de funciones no anidadas entre las que se encuentra la función principal.
- Pueden existir varias secciones de declaración global de variables y tipos alternadas entre las declaraciones de funciones. Es decir, las variables y tipos globales se pueden declarar en cualquier parte fuera del código de las funciones.
- Las constantes simbólicas sólo pueden ser definidas al inicio del programa.

<a name="13"/>

## Declaraciones de constantes SIMBÓLICAS
- Constituyen una representación nombrada de datos constantes cuyo valor va a permanecer inalterado a lo largo de la ejecución del programa.
- En cES todas las constantes simbólicas son de tipo entero.
- Sintaxis: `#constante nombre valor;`
  - `nombre` es el nombre simbólico que recibe la constante definida dentro del programa
  - `valor` es un valor constante de tipo entero (número)

<a name="14"/>

## Declaración de tipos

<a name="15"/>

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

<a name="16"/>

### Tipos primitivos: Tipo vacio
- El tipo vacio se representa con la palabra reservada vacio.
- La aplicación de este tipo solo se realiza en el contexto donde una función se comporte como un procedimiento (esto es, como un bloque de código cuya invocación no produce ningún valor de retorno al programa llamante).

Ejemplos de la sintáxis:
`vacio main () { ... }` `vacio escribeEntero (entero x) { ... }`

<a name="17"/>

### Tipos compuestos: Tipo vector
- Son tipos definidos por el programador y establecidos como un tipo más del lenguaje.
- El tipo creado recibe nombre (identificador) que sirve para referenciarlo posteriormente.
- Siempre hay que crear el tipo estructurado (con nombre) antes de ser utilizado.
- En cES sólo pueden declararse vectores de una dimensión y cuyo tipo base sea un entero.

Ejemplo de la sintaxis para la creación del tipo:
`tipo entero nombre[tam];`, donde:
- `nombre` es el identificador
- `tam` es una constante literal numérica o simbólica que indica el número de elementos que contiene el vector.

<a name="18"/>

## Declaración de variables
Se utiliza la siguiente sintaxis:
`nombre-tipo var1 [ = val1], var2 [ = val2], ...;`
Donde:
- `nombre-tipo` es el nombre primitivo del lenguaje o definido por el usuario.
- `var1, var2,...` son identificadores para las variables creadas.
- `val1, val2,...` son valores opcionales asignados.

<a name="19"/>

## Declaración de bloques
- Son una secuencia ordenada de instrucciones encapsuladas dentro de los delimitadores { y }.
- La estructura sintáctica de los bloques es anidante.
- Comienzan por una sección opcional de declaración de tipos, seguidas de una sección opcional de declaración de variables y continuan por una secuencia ordenada de sentencias que a su vez pueden contener a otros bloques.

<a name="20"/>

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

<a name="21"/>

## Llamada a funciones
- Los parámetros que se pueden pasar como parámetro son: expresiones, variables, constantes simbólicas y elementos de vectores.
- La estructura de la declaración de funciones es plana. Es decir, en cES no es posible definir funciones dentro de otras funciones.

Ejemplo de la sintaxis:
`escribeEnt (a); /* Escribe 1 */` `incrementa (a);`

<a name="22"/>

## Expresiones
- Construcción del lenguaje que devuelve un valor de retorno al contexto del programa donde aparece la expresión.
- Existen varios tipos, presentados a continuación.


**Expresiones aritméticas**: 
- Devuelven un valor de tipo entero al programa. Incluyen:
    - constantes literales de tipo entero
    - constantes simbólicas de tipo entero
    - los identificadores (variables o parámetros) de tipo entero
    - las funciones que devuelven un valor de tipo entero.
    - suma y producto de dos de las anteriores (dos expresiones aritméticas)
    - autoincremento de una expresión aritmética

**Expresiones lógicas**: 
- Expresión aritmética evaluada en un contexto lógico que devuelven un valor de verdad (cierto o falso). 
- Debido a que en cES no existe un tipo primitivo para tipificar expresiones lógicas, se implementan de la siguiente forma: 
    - Si la expresión devuelve un valor igual a 0 este resultado se interpreta con el significado de falso. 
    - Si la expresión devuelve un valor distinto de 0 se interpreta con el significado de verdadero.

**Expresiones de acceso a vectores**:
- Se realiza de forma indexada, con operadores de acceso a vector [ ].
- Dentro de los delimitadores se ubica una expresión aritmética.

Ejemplos:
```
v [0] = 1; v [1] = 2; v[2] = 3;
escribeEnt (v[0]); /* Escribe 1 */
escribeEnt (v[1+1]); /* Escribe 3 */
escribeEnt (v[v[1]]); /* Escribe 3 */
```

**Autoincrementos**:
- Utiliza el operador ++ después de la referencia a una variable o elemento de un vector.
- Sintaxis: `ref++`

**Precedencia y asociatividad de operadores**:
A continuación se muestra la precedencia y asociatividad. La prioridad decrece según se avanza en la tabla y los operadores en la misma fila tienen igual precedencia.
| Precedencia  | Asociatividad |
| ------------- | ------------- |
| ( )  | Izquierdas  |
| [ ]  | Izquierdas  |
| ++, ! | Izquierdas  |
| * | Izquierdas  |
| + | Izquierdas  |
| < | Izquierdas  |
| == | Izquierdas  |
| && | Izquierdas  |

<a name="23"/>

## Sentencias
- Permiten realizar determinadas operaciones dentro del flujo de ejecución de un programa.
- Las expresiones pueden ser utilizadas como sentencias. Pueden aparecer de forma individual en el código sin generar error (p.ej. `a+b;`).
- Son sentencias también las demás unidades de código, como por ejemplo, las sentencias de asignación, las sentencias de control de flujo condicional e iterativo, y las sentencias de salida. Ejemplos concretos: bloques si-sino, mientaras, alternativa-caso, etc.

<a name="24"/>

## Asignaciones
- Se escribe primero una referencia a alguno de estos elementos seguido del operador de asignación (=) y a su derecha una expresión.
- Ejemplo: `ref = expresion;`, donde
    - `ref` es una referencia a una variable o elemento de un vector.
    - `expresión` es una expresión del mismo tipo que la referencia.

<a name="25"/>

## Asignación con suma
- Ejemplo: `ref += expresion`, donde
    - `ref` es una referencia a una variable o elemento de un vector.
    - `expresión` es una expresión del mismo tipo que la referencia.

<a name="26"/>

## Sentencia de control de flujo condicional SI – SINO
- Tiene dos formas sintácticas:
```
si (expresionLogica)
/* sentencias */

si (expresionLogica)
/* sentencias1 */
sino
/* sentencias2 */
```
- Puede contener llaves { } o no.
- Puede anidarse con otras construcciones de tipo si o con otros tipos de sentencias de control de flujo.

<a name="27"/>

## Sentencia de control de flujo condicional ALTERNATIVAS
- Forma sintáctica:
```
alternativas (expresion) {
caso constante1: /* sentencias 1*/ corte;
caso constante2: /* sentencias 2*/ corte;
pordefecto: /* sentencias*/ corte;
}
```
- `expresion` corresponde con una expresión aritmética.
- `constante` corresponden a las constantes numéricas.

<a name="28"/>

## Sentencia de control de flujo iterativo MIENTRAS
- Forma sintáctica:
```
mientras (expresionLogica)
    /* sentencias */
```
- Puede contener llaves { } o no.

<a name="29"/>

## Sentencias de salida
- Emiten una salida pestándar (pantalla).
- Dos tipos:
    -  `escribe(“Hola mundo”);` toma una constante literal de tipo cadena de texto y la muestra por la salida estándar.
    -  `escribeEnt(12);` o `escribeEnt(a);` recibe una expresión de tipo entero y muestra su resultado por la salida estándar.
-  Ambos pueden no recibir parámetros, en ese caso no mostrarían nada (realizan un salto de línea).

<a name="30"/>

# Código implementado en Flex y Cup
El código desarrollado es el siguiente:
- [specs/scanner.flex](specs/scanner.flex): corresponde al analizador léxico implementado en Flex.
- [specs/parser.cup](specs/parser.cup): corresponde al analizador sintáctico implementado en Cup.

Además, el repositorio incluye juegos de prueba en el directorio [test/](test/).

<a name="31"/>

# Herramientas utilizadas

<a name="32"/>

## JFlex
Utilizado para especificar analizadores léxicos. Utiliza reglas que definen expresiones regulares como patrones en que encajar los caracteres que se van leyendo del archivo fuente, obteniendo tokens.
Web: http://jflex.de/

<a name="33"/>

## Cup
Herramienta que permite especificar gramáticas formales facilitando el análisis sintáctico para obtener un analizador ascendente de tipo LALR. 
Web: http://www2.cs.tum.edu/projects/cup/

<a name="34"/>

# Bibliografía
Aho, A., Lam, M., Sethi, R., & Ullman, J. (2008). Compiladores (2nd ed.). Pearson Educación.

JFlex: http://jflex.de/

Cup: http://www2.cs.tum.edu/projects/cup/
