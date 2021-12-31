# Objetivo compilador-cES
Práctica de la asignatura Procesadores del Lenguaje I de la Universidad Nacional a Distancia (UNED). El objetivo de la práctica es realizar las fases de análisis léxico y sintáctico de un compilador del lenguaje cES, variación del conocido lenguaje C con la característica particular de que las palabras reservadas estarán en castellano.

# Tabla de Contenido
TBD

# Estructura del compilador y fases
Un compilador realiza dos principales procesos: análisis y síntesis.
- **Análisis o _front-end_ del compilador**: divide el programa fuente en componentes e impone una estructura gramatical sobre ellas. Después utiliza esta estructura para crear una representación intermedia del programa fuente. Dentro de la fase de análisis podemos encontrar los componentes de Analizador Léxico, Analizador Sintáctico y Analizador Semántico. Si la parte del análisis detecta que el programa fuente está mal formado en cuanto a la sintaxis, o que no tiene una semántica consistente, entonces debe proporcionar mensajes informativos para que el usuario pueda corregirlo.
- **Síntesis o _back-end_ del compilador**: construye el programa destino deseado a partir de la representación intermedia y de la información en la tabla de símbolos. Típicamente está compuesto por los componentes Generdor de código y Optimizador, entre otros.

<p align="center">
  <img width="488" height="888" src="https://github.com/Ubikitina/compilador-cES/blob/main/images/Fases%20de%20un%20compilador.png">
</p>


# Aspectos Léxicos del Lenguaje cES
El lenguaje cES es una versión del lenguaje C con la característica particular de que las palabras reservadas estarán en castellano.

# Bibliografía
Aho, A., Lam, M., Sethi, R., & Ullman, J. (2008). Compiladores (2nd ed.). Pearson Educación.
