/* The following code was generated by JFlex 1.4.1 on 1/1/22 21:03 */

// ******************************************
// * scanner.flex
// * Asignatura: Procesadores de lenguajes 1
// * Autor: ubikitina
// * Curso: 2021-2022
// ******************************************

package compiler.lexical;

import compiler.syntax.sym;
import compiler.lexical.Token;
import es.uned.lsi.compiler.lexical.ScannerIF;
import es.uned.lsi.compiler.lexical.LexicalError;
import es.uned.lsi.compiler.lexical.LexicalErrorManager;




/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 1/1/22 21:03 from the specification file
 * <tt>C:/Users/desktop/MyCodes2/ArquitecturaPLI-2021-2022/doc/specs/scanner.flex</tt>
 */
public class Scanner implements java_cup.runtime.Scanner, ScannerIF {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int CADENA_SIN_COMILLAS = 2;
  public static final int YYINITIAL = 0;
  public static final int COMENTARIO = 1;

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\55\1\7\1\0\1\55\1\7\22\0\1\53\1\31\1\54"+
    "\1\52\2\0\1\30\1\0\1\13\1\14\1\22\1\32\1\24\1\4"+
    "\1\5\1\21\1\3\11\2\1\23\1\25\1\26\1\27\3\0\4\1"+
    "\1\43\25\1\1\17\1\0\1\20\1\0\1\6\1\0\1\34\1\42"+
    "\1\33\1\50\1\41\1\10\2\1\1\11\2\1\1\44\1\46\1\12"+
    "\1\36\1\47\1\1\1\37\1\35\1\40\1\51\1\45\4\1\1\15"+
    "\1\0\1\16\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\2\4\2\2\1\5\1\3"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\2\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\2\1\22\1\23"+
    "\11\3\1\2\1\24\2\5\1\25\1\1\1\26\1\27"+
    "\1\0\2\30\1\3\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\3\3\1\37\10\3\1\0\1\40\1\41\15\3"+
    "\1\0\1\42\2\3\1\43\1\44\7\3\1\0\1\45"+
    "\3\3\1\46\4\3\1\0\1\3\1\47\5\3\1\0"+
    "\1\3\1\50\4\3\1\0\2\3\1\51\2\3\1\52"+
    "\1\0\3\3\1\53\1\0\1\3\1\54\1\55\1\0"+
    "\1\3\1\56\1\57";

  private static int [] zzUnpackAction() {
    int [] result = new int[140];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\56\0\134\0\212\0\270\0\346\0\u0114\0\u0142"+
    "\0\u0170\0\212\0\u019e\0\212\0\212\0\212\0\212\0\212"+
    "\0\212\0\u01cc\0\u01fa\0\212\0\212\0\212\0\212\0\u0228"+
    "\0\u0256\0\212\0\u0284\0\u02b2\0\u02e0\0\u030e\0\u033c\0\u036a"+
    "\0\u0398\0\u03c6\0\u03f4\0\u0422\0\u0450\0\212\0\u047e\0\u04ac"+
    "\0\u04da\0\u0508\0\212\0\u0536\0\u0170\0\u0142\0\u0170\0\u0564"+
    "\0\212\0\212\0\212\0\212\0\212\0\212\0\u0592\0\u05c0"+
    "\0\u05ee\0\u061c\0\u064a\0\u0678\0\u06a6\0\u06d4\0\u0702\0\u0730"+
    "\0\u075e\0\u078c\0\u07ba\0\212\0\212\0\u07e8\0\u0816\0\u0844"+
    "\0\u0872\0\u08a0\0\u08ce\0\u08fc\0\u092a\0\u0958\0\u0986\0\u09b4"+
    "\0\u09e2\0\u0a10\0\u0a3e\0\270\0\u0a6c\0\u0a9a\0\270\0\270"+
    "\0\u0ac8\0\u0af6\0\u0b24\0\u0b52\0\u0b80\0\u0bae\0\u0bdc\0\u0c0a"+
    "\0\270\0\u0c38\0\u0c66\0\u0c94\0\270\0\u0cc2\0\u0cf0\0\u0d1e"+
    "\0\u0d4c\0\u0d7a\0\u0da8\0\270\0\u0dd6\0\u0e04\0\u0e32\0\u0e60"+
    "\0\u0e8e\0\u0ebc\0\u0eea\0\u0f18\0\u0f46\0\u0f74\0\u0fa2\0\u0fd0"+
    "\0\u0ffe\0\u102c\0\u105a\0\270\0\u1088\0\u10b6\0\270\0\u10e4"+
    "\0\u1112\0\u1140\0\u116e\0\270\0\u119c\0\u11ca\0\270\0\270"+
    "\0\u11f8\0\u1226\0\212\0\270";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[140];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\1\5\1\6\1\7\1\10\1\11\1\4\1\12"+
    "\1\13\2\5\1\14\1\15\1\16\1\17\1\20\1\21"+
    "\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
    "\1\32\1\33\1\34\1\35\1\36\2\5\1\37\1\40"+
    "\3\5\1\41\1\42\1\43\1\44\1\5\1\45\1\12"+
    "\1\46\22\12\1\47\1\50\33\12\1\51\3\52\4\51"+
    "\3\52\20\51\17\52\1\51\1\52\1\53\1\52\57\0"+
    "\3\5\4\0\3\5\20\0\17\5\5\0\1\54\2\6"+
    "\1\0\1\55\1\54\1\0\3\54\20\0\17\54\5\0"+
    "\1\54\2\56\1\0\1\55\1\54\1\0\3\54\20\0"+
    "\17\54\6\0\2\56\1\0\1\55\52\0\2\57\53\0"+
    "\3\5\4\0\1\5\1\60\1\5\20\0\17\5\26\0"+
    "\1\61\54\0\1\62\63\0\1\63\56\0\1\64\54\0"+
    "\1\65\2\0\1\66\24\0\3\5\4\0\3\5\20\0"+
    "\1\5\1\67\1\5\1\70\13\5\5\0\3\5\4\0"+
    "\3\5\20\0\11\5\1\71\5\5\5\0\3\5\4\0"+
    "\1\5\1\72\1\5\20\0\17\5\5\0\3\5\4\0"+
    "\1\5\1\73\1\5\20\0\17\5\5\0\3\5\4\0"+
    "\2\5\1\74\20\0\2\5\1\75\14\5\5\0\3\5"+
    "\4\0\3\5\20\0\1\5\1\76\15\5\5\0\3\5"+
    "\4\0\1\5\1\77\1\5\20\0\17\5\5\0\3\5"+
    "\4\0\3\5\20\0\3\5\1\100\1\101\12\5\5\0"+
    "\3\5\4\0\3\5\20\0\6\5\1\102\10\5\37\0"+
    "\1\103\44\0\1\104\54\0\1\105\34\0\54\51\1\0"+
    "\2\51\3\52\4\51\3\52\20\51\17\52\1\51\1\52"+
    "\1\0\1\52\1\0\3\54\2\0\1\54\1\0\3\54"+
    "\20\0\17\54\5\0\3\5\4\0\2\5\1\106\20\0"+
    "\17\5\5\0\3\5\4\0\3\5\20\0\2\5\1\107"+
    "\14\5\5\0\3\5\4\0\3\5\20\0\4\5\1\110"+
    "\12\5\5\0\3\5\4\0\3\5\20\0\5\5\1\111"+
    "\11\5\5\0\3\5\4\0\2\5\1\112\20\0\17\5"+
    "\5\0\3\5\4\0\3\5\20\0\14\5\1\113\2\5"+
    "\5\0\3\5\4\0\3\5\20\0\5\5\1\114\11\5"+
    "\5\0\3\5\4\0\3\5\20\0\1\115\16\5\5\0"+
    "\3\5\4\0\3\5\20\0\1\116\16\5\5\0\3\5"+
    "\4\0\3\5\20\0\6\5\1\117\10\5\5\0\3\5"+
    "\4\0\3\5\20\0\4\5\1\120\12\5\5\0\3\5"+
    "\4\0\1\5\1\121\1\5\20\0\17\5\5\0\3\5"+
    "\4\0\3\5\20\0\12\5\1\122\4\5\42\0\1\123"+
    "\20\0\3\5\3\0\1\12\3\5\20\0\17\5\1\0"+
    "\1\12\1\0\1\12\1\0\3\5\4\0\3\5\20\0"+
    "\3\5\1\124\13\5\5\0\3\5\4\0\3\5\20\0"+
    "\5\5\1\125\11\5\5\0\3\5\4\0\3\5\20\0"+
    "\6\5\1\126\10\5\5\0\3\5\4\0\3\5\20\0"+
    "\3\5\1\127\13\5\5\0\3\5\4\0\3\5\20\0"+
    "\3\5\1\130\13\5\5\0\3\5\4\0\3\5\20\0"+
    "\6\5\1\131\10\5\5\0\3\5\4\0\3\5\20\0"+
    "\4\5\1\132\12\5\5\0\3\5\4\0\1\5\1\133"+
    "\1\5\20\0\17\5\5\0\3\5\4\0\2\5\1\134"+
    "\20\0\17\5\5\0\3\5\4\0\3\5\20\0\15\5"+
    "\1\135\1\5\5\0\3\5\4\0\2\5\1\136\20\0"+
    "\17\5\5\0\3\5\4\0\3\5\20\0\16\5\1\137"+
    "\16\0\1\140\44\0\3\5\4\0\3\5\20\0\6\5"+
    "\1\141\10\5\5\0\3\5\4\0\3\5\20\0\4\5"+
    "\1\142\12\5\5\0\3\5\4\0\3\5\20\0\4\5"+
    "\1\143\12\5\5\0\3\5\4\0\1\5\1\144\1\5"+
    "\20\0\17\5\5\0\3\5\4\0\3\5\20\0\3\5"+
    "\1\145\13\5\5\0\3\5\4\0\3\5\20\0\5\5"+
    "\1\146\11\5\5\0\3\5\4\0\3\5\20\0\6\5"+
    "\1\147\10\5\5\0\3\5\4\0\3\5\20\0\1\150"+
    "\16\5\5\0\3\5\4\0\3\5\20\0\6\5\1\151"+
    "\10\5\41\0\1\152\21\0\3\5\4\0\2\5\1\153"+
    "\20\0\17\5\5\0\3\5\4\0\3\5\20\0\3\5"+
    "\1\154\13\5\5\0\3\5\4\0\3\5\20\0\7\5"+
    "\1\155\7\5\5\0\3\5\4\0\3\5\20\0\4\5"+
    "\1\156\12\5\5\0\3\5\4\0\1\157\2\5\20\0"+
    "\17\5\5\0\3\5\4\0\1\5\1\160\1\5\20\0"+
    "\17\5\5\0\3\5\4\0\3\5\20\0\11\5\1\161"+
    "\5\5\44\0\1\162\16\0\3\5\4\0\3\5\20\0"+
    "\1\5\1\163\15\5\5\0\3\5\4\0\3\5\20\0"+
    "\6\5\1\164\10\5\5\0\3\5\4\0\3\5\20\0"+
    "\1\5\1\165\15\5\5\0\3\5\4\0\3\5\20\0"+
    "\6\5\1\166\10\5\5\0\3\5\4\0\3\5\20\0"+
    "\14\5\1\167\2\5\5\0\3\5\4\0\3\5\20\0"+
    "\12\5\1\170\4\5\40\0\1\171\22\0\3\5\4\0"+
    "\3\5\20\0\5\5\1\172\11\5\5\0\3\5\4\0"+
    "\3\5\20\0\10\5\1\173\6\5\5\0\3\5\4\0"+
    "\3\5\20\0\2\5\1\174\14\5\5\0\3\5\4\0"+
    "\3\5\20\0\1\175\16\5\5\0\3\5\4\0\3\5"+
    "\20\0\1\5\1\176\15\5\5\0\3\5\4\0\3\5"+
    "\20\0\6\5\1\177\10\5\16\0\1\200\44\0\3\5"+
    "\4\0\1\5\1\201\1\5\20\0\17\5\5\0\3\5"+
    "\4\0\2\5\1\202\20\0\17\5\5\0\3\5\4\0"+
    "\3\5\20\0\5\5\1\203\11\5\5\0\3\5\4\0"+
    "\3\5\20\0\11\5\1\204\5\5\44\0\1\205\16\0"+
    "\3\5\4\0\3\5\20\0\12\5\1\206\4\5\5\0"+
    "\3\5\4\0\3\5\20\0\5\5\1\207\11\5\5\0"+
    "\3\5\4\0\3\5\20\0\3\5\1\210\13\5\45\0"+
    "\1\211\15\0\3\5\4\0\3\5\20\0\1\5\1\212"+
    "\15\5\57\0\1\213\3\0\3\5\4\0\3\5\20\0"+
    "\2\5\1\214\14\5\4\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4692];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\1\1\11\5\1\1\11\1\1\6\11\2\1"+
    "\4\11\2\1\1\11\13\1\1\11\4\1\1\11\1\1"+
    "\1\0\3\1\6\11\14\1\1\0\2\11\15\1\1\0"+
    "\14\1\1\0\11\1\1\0\7\1\1\0\6\1\1\0"+
    "\6\1\1\0\4\1\1\0\3\1\1\0\1\1\1\11"+
    "\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[140];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
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


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Scanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Scanner(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 126) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) throws LexicalError {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new LexicalError(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  throws LexicalError {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    	if(commentCount != 0){ 
		LexicalError error = new LexicalError ("Comentario mal balanceado o anidamiento incorrecto.");
        error.setLine (yyline + 1);
        error.setColumn (yycolumn + 1);
        error.setLexema (yytext ());
        lexicalErrorManager.lexicalError (error);
        System.exit(-1); //detenemos ejecuci�n
	}
	
	if(stringCount != 0){ 
		LexicalError error = new LexicalError ("Apertura de cadena sin cierre.");
        error.setLine (yyline + 1);
        error.setColumn (yycolumn + 1);
        error.setLexema (yytext ());
        lexicalErrorManager.lexicalError (error);
        System.exit(-1); //detenemos ejecuci�n
	}
  yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException, LexicalError {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 7: 
          { return createToken (sym.PARENTESISDCH);
          }
        case 48: break;
        case 19: 
          { return createToken (sym.PLUS);
          }
        case 49: break;
        case 4: 
          { return createToken (sym.NUM);
          }
        case 50: break;
        case 33: 
          { commentCount = commentCount-1;
    					 if (commentCount==0) { yybegin(YYINITIAL); }
          }
        case 51: break;
        case 20: 
          { stringCount = stringCount+1; yybegin(CADENA_SIN_COMILLAS);
          }
        case 52: break;
        case 22: 
          { stringCount = stringCount-1; 
                         if (stringCount==0) { yybegin(YYINITIAL); }
          }
        case 53: break;
        case 6: 
          { return createToken (sym.PARENTESISIZQ);
          }
        case 54: break;
        case 21: 
          { LexicalError error = new LexicalError ("Car�cter(es) no permitido(s) en la cadena.");
                           error.setLine (yyline + 1);
                           error.setColumn (yycolumn + 1);
                           error.setLexema (yytext ());
                           lexicalErrorManager.lexicalError (error);
                           System.exit(-1); //detenemos ejecuci�n
          }
        case 55: break;
        case 1: 
          { return createToken (sym.STRING);
          }
        case 56: break;
        case 36: 
          { return createToken (sym.TYPE);
          }
        case 57: break;
        case 38: 
          { return createToken (sym.VOID);
          }
        case 58: break;
        case 26: 
          { LexicalError error = new LexicalError ("Cierre de comentario antes de apertura.");
                           error.setLine (yyline + 1);
                           error.setColumn (yycolumn + 1);
                           error.setLexema (yytext ());
                           lexicalErrorManager.lexicalError (error);
                           System.exit(-1); //detenemos ejecuci�n
          }
        case 59: break;
        case 34: 
          { return createToken (sym.CASE);
          }
        case 60: break;
        case 43: 
          { return createToken (sym.MAIN);
          }
        case 61: break;
        case 35: 
          { return createToken (sym.ELSE);
          }
        case 62: break;
        case 9: 
          { return createToken (sym.LLAVEDCH);
          }
        case 63: break;
        case 15: 
          { return createToken (sym.PUNTOCOMA);
          }
        case 64: break;
        case 8: 
          { return createToken (sym.LLAVEIZQ);
          }
        case 65: break;
        case 11: 
          { return createToken (sym.CORCHETEDCH);
          }
        case 66: break;
        case 10: 
          { return createToken (sym.CORCHETEIZQ);
          }
        case 67: break;
        case 16: 
          { return createToken (sym.MINOR);
          }
        case 68: break;
        case 14: 
          { return createToken (sym.COMA);
          }
        case 69: break;
        case 27: 
          { return createToken (sym.EQUAL);
          }
        case 70: break;
        case 44: 
          { return createToken (sym.WRITEINT);
          }
        case 71: break;
        case 37: 
          { return createToken (sym.BREAK);
          }
        case 72: break;
        case 41: 
          { return createToken (sym.WHILE);
          }
        case 73: break;
        case 29: 
          { return createToken (sym.ASSIGNWITHSUM);
          }
        case 74: break;
        case 32: 
          { commentCount = commentCount+1;
          }
        case 75: break;
        case 17: 
          { return createToken (sym.ASSIGN);
          }
        case 76: break;
        case 25: 
          { commentCount = commentCount+1; yybegin(COMENTARIO);
          }
        case 77: break;
        case 42: 
          { return createToken (sym.RETURN);
          }
        case 78: break;
        case 46: 
          { return createToken (sym.CTE);
          }
        case 79: break;
        case 31: 
          { return createToken (sym.IF);
          }
        case 80: break;
        case 30: 
          { return createToken (sym.AUTOINCREMENT);
          }
        case 81: break;
        case 13: 
          { return createToken (sym.DOSPUNTOS);
          }
        case 82: break;
        case 39: 
          { return createToken (sym.INT);
          }
        case 83: break;
        case 18: 
          { return createToken (sym.NOT);
          }
        case 84: break;
        case 28: 
          { return createToken (sym.AND);
          }
        case 85: break;
        case 3: 
          { return createToken (sym.ID);
          }
        case 86: break;
        case 40: 
          { return createToken (sym.WRITE);
          }
        case 87: break;
        case 45: 
          { return createToken (sym.DEFAULT);
          }
        case 88: break;
        case 12: 
          { return createToken (sym.PRODUCT);
          }
        case 89: break;
        case 23: 
          { LexicalError error = new LexicalError ("Identificador incorrecto.");
                           error.setLine (yyline + 1);
                           error.setColumn (yycolumn + 1);
                           error.setLexema (yytext ());
                           lexicalErrorManager.lexicalError (error);
                           System.exit(-1); //detenemos ejecuci�n
          }
        case 90: break;
        case 24: 
          { LexicalError error = new LexicalError ("N�mero incorrecto.");
                           error.setLine (yyline + 1);
                           error.setColumn (yycolumn + 1);
                           error.setLexema (yytext ());
                           lexicalErrorManager.lexicalError (error);
                           System.exit(-1); //detenemos ejecuci�n
          }
        case 91: break;
        case 47: 
          { return createToken (sym.ALTERNATIVE);
          }
        case 92: break;
        case 2: 
          { LexicalError error = new LexicalError ("No coincide con ning�n patr�n");
                           error.setLine (yyline + 1);
                           error.setColumn (yycolumn + 1);
                           error.setLexema (yytext ());
                           lexicalErrorManager.lexicalError (error);
                           System.exit(-1); //detenemos ejecuci�n
          }
        case 93: break;
        case 5: 
          { 
          }
        case 94: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
