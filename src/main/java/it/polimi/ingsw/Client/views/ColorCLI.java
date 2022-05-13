package it.polimi.ingsw.Client.views;

public enum ColorCLI {
    ANSI_RED("\u001B[31m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_YELLOW("\u001B[33m"),
    ANSI_YELLOWCHIARO("\u001B[93m"),
    ANSI_BLUE("\u001B[34m"),
    ANSI_PURPLE("\u001B[35m"),
    ANSI_BLACK("\u001B[30m"),   /*USED WHEN THERE'S NO A PEDINA*/
    ANSI_WHITE("\u001B[37m"),
    ANSI_CYAN("\u001B[36m"),
    ANSI_GRAY("\u001B[90m"),
    ANSI_WHITEPURO("\u001B[97m");


    static final String RESET = "\u001B[0m";


    private String escape;


    ColorCLI(String escape)
    {
        this.escape = escape;
    }


    public String getEscape()
    {
        return escape;
    }


    @Override
    public String toString()
    {
        return escape;
    }
}
