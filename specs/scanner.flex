// ******************************************
// * scanner.flex
// * Asignatura: Procesadores de lenguajes 1
// * Autor: Ubikitina
// * Curso: 2021-2022
// ******************************************

package compiler.lexical;

import compiler.syntax.sym;
import compiler.lexical.Token;
import es.uned.lsi.compiler.lexical.ScannerIF;
import es.uned.lsi.compiler.lexical.LexicalError;
import es.uned.lsi.compiler.lexical.LexicalErrorManager;

// incluir aqui, si es necesario otras importaciones

%%
 
%public
%class Scanner
%char
%line
%column
%cup
%unicode


%implements ScannerIF
%scanerror LexicalError

// incluir aqui, si es necesario otras directivas
%state COMENTARIO
%state CADENA_SIN_COMILLAS

%{
  LexicalErrorManager lexicalErrorManager = new LexicalErrorManager ();
  private int commentCount = 0;
  private int stringCount = 0;
  
  Token createToken (int t) {
  	Token token = new Token(t);
  	token.setLine (yyline + 1);
  	token.setColumn (yycolumn + 1);
  	token.setLexema (yytext ());
  	return token;
  }
%}  

%eof{
	if(commentCount != 0){ 
		LexicalError error = new LexicalError ("Comentario mal balanceado o anidamiento incorrecto.");
        error.setLine (yyline + 1);
        error.setColumn (yycolumn + 1);
        error.setLexema (yytext ());
        lexicalErrorManager.lexicalError (error);
        System.exit(-1); //detenemos ejecución
	}
	
	if(stringCount != 0){ 
		LexicalError error = new LexicalError ("Apertura de cadena sin cierre.");
        error.setLine (yyline + 1);
        error.setColumn (yycolumn + 1);
        error.setLexema (yytext ());
        lexicalErrorManager.lexicalError (error);
        System.exit(-1); //detenemos ejecución
	}
%eof}
  
LETRA = [A-Za-z]
DIGITO=[0-9]
NUMERO = 0|[1-9]({DIGITO})*
NUMERO_ERRONEO = (-{NUMERO}) | (-?(0+{NUMERO}) | (-?{NUMERO}*\.{NUMERO}+))
VECTOR = \[NUMERO\]
IDENTIFICADOR = {LETRA}({LETRA}|{DIGITO})*
IDENTIFICADOR_ERRONEO = {NUMERO}({LETRA}|_)({LETRA}|_|{NUMERO})*
ESPACIO_BLANCO=[ \t\r\n\f]
CADENA = ({LETRA}|{ESPACIO_BLANCO}|{DIGITO})*
fin = "fin"{ESPACIO_BLANCO}


%%

//Aqui comienza el estado YYINITIAL
<YYINITIAL> 
{

	"("                { return createToken (sym.PARENTESISIZQ); }	
	")"                { return createToken (sym.PARENTESISDCH); }	
	"{"                { return createToken (sym.LLAVEIZQ); }
	"}"                { return createToken (sym.LLAVEDCH); }
	"["                { return createToken (sym.CORCHETEIZQ); }
	"]"                { return createToken (sym.CORCHETEDCH); }
	"/*"               { commentCount = commentCount+1; yybegin(COMENTARIO); }
	"*/"               { 
	                       LexicalError error = new LexicalError ("Cierre de comentario antes de apertura.");
                           error.setLine (yyline + 1);
                           error.setColumn (yycolumn + 1);
                           error.setLexema (yytext ());
                           lexicalErrorManager.lexicalError (error);
                           System.exit(-1); //detenemos ejecución
	                   }
	":"                { return createToken (sym.DOSPUNTOS); }
	","                { return createToken (sym.COMA); }
	";"                { return createToken (sym.PUNTOCOMA); }
    "*"                { return createToken (sym.PRODUCT); }
    "<"                { return createToken (sym.MINOR); }
    "=="               { return createToken (sym.EQUAL); }
    "&&"               { return createToken (sym.AND); }
    "!"                { return createToken (sym.NOT); }
    "++"               { return createToken (sym.AUTOINCREMENT); }
    "="                { return createToken (sym.ASSIGN); }
    "+="               { return createToken (sym.ASSIGNWITHSUM); }
    "+"                { return createToken (sym.PLUS); }
    "caso"             { return createToken (sym.CASE); }    
    "constante"        { return createToken (sym.CONSTANT); }    
    "corte"            { return createToken (sym.BREAK); }    
    "entero"           { return createToken (sym.INT); }    
    "escribe"          { return createToken (sym.WRITE); }    
    "escribeEnt"       { return createToken (sym.WRITEINT); }    
    "alternativas"     { return createToken (sym.ALTERNATIVE); }    
    "mientras"         { return createToken (sym.WHILE); }    
    "pordefecto"       { return createToken (sym.DEFAULT); }    
    "principal"        { return createToken (sym.MAIN); }    
    "devuelve"         { return createToken (sym.RETURN); }    
    "si"               { return createToken (sym.IF); }    
    "sino"             { return createToken (sym.ELSE); }    
    "tipo"             { return createToken (sym.TYPE); }    
    "vacio"            { return createToken (sym.VOID); } 
    "#constante"	   { return createToken (sym.CTE); }
    "\""               { stringCount = stringCount+1; yybegin(CADENA_SIN_COMILLAS); }
    {IDENTIFICADOR}    { return createToken (sym.ID); }
    {IDENTIFICADOR_ERRONEO} { 
	                       LexicalError error = new LexicalError ("Identificador incorrecto.");
                           error.setLine (yyline + 1);
                           error.setColumn (yycolumn + 1);
                           error.setLexema (yytext ());
                           lexicalErrorManager.lexicalError (error);
                           System.exit(-1); //detenemos ejecución
	                   }
    {VECTOR}           { return createToken (sym.VECT); }
    {NUMERO_ERRONEO}   { 
	                       LexicalError error = new LexicalError ("Número incorrecto.");
                           error.setLine (yyline + 1);
                           error.setColumn (yycolumn + 1);
                           error.setLexema (yytext ());
                           lexicalErrorManager.lexicalError (error);
                           System.exit(-1); //detenemos ejecución
	                   }
    {NUMERO}           { return createToken (sym.NUM); }                

    
           
           

    {ESPACIO_BLANCO}   {} //Se ignoran los espacios en blanco.
    {fin}              {} //Se ignora el fin.
    
    // error en caso de coincidir con ningún patrón
	[^]     
                        {                                               
                           LexicalError error = new LexicalError ("No coincide con ningún patrón");
                           error.setLine (yyline + 1);
                           error.setColumn (yycolumn + 1);
                           error.setLexema (yytext ());
                           lexicalErrorManager.lexicalError (error);
                           System.exit(-1); //detenemos ejecución
                        }
    
} //Aqui termina el estado YYINITIAL

//Aqui comienza el estado COMENTARIO
<COMENTARIO> 
{    
    "/*"               { commentCount = commentCount+1; }
    "*/"               { commentCount = commentCount-1;
    					 if (commentCount==0) { yybegin(YYINITIAL); }
     				   }
    [^]                {} //Ignoramos en caso de no coincidir con ningún patrón anteriormente listado, es decir, ignoramos todo el contenido del comentario.
                         
} //Aqui termina el estado COMENTARIO

//Aqui comienza el estado CADENA_SIN_COMILLAS
<CADENA_SIN_COMILLAS> 
{ 
    //Lanzamos error si se trata de cadenas con otros caracteres diferentes a letras, dígitos y espacios en blanco.
    {CADENA}*([^A-Za-z0-9 \t\f\"])+([^A-Za-z0-9 \t\f\"]|{CADENA})* { 
                           LexicalError error = new LexicalError ("Carácter(es) no permitido(s) en la cadena.");
                           error.setLine (yyline + 1);
                           error.setColumn (yycolumn + 1);
                           error.setLexema (yytext ());
                           lexicalErrorManager.lexicalError (error);
                           System.exit(-1); //detenemos ejecución
                       }
    {CADENA}           { return createToken (sym.STRING); }
    "\""               { stringCount = stringCount-1; 
                         if (stringCount==0) { yybegin(YYINITIAL); }
                       }
    [^]                {} //Ignoramos en caso de no coincidir con ningún patrón anteriormente listado.
} //Aqui termina el estado CADENA_SIN_COMILLAS