package org.polytech.project.balladeapp5.The3DSParser;

/**
 * Any errors from the parser is wrapped in a ParserException for
 * easy error handling.
 *
 * @author Kjetil Østerås
 */
public class ParserException extends Exception {

    public ParserException(Throwable cause) {
        super(cause);
    }

    public ParserException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
