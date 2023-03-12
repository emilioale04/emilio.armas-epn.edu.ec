package Framework;

public enum APP {
    EA_GLOBAL;
    public final  String  EA_DB_NAME            = "EA_DB_NAME";
    public final  String  EA_DB_PATH            = "EA_DB_PATH";
    public final  String  EA_CEDULA             = "1750315986";
    public final  String  EA_NOMBRE_COMPLETO    = "Emilio Alejandro Armas Armas";
    private final String  EA_EXCEPTION_UNDEFINED;
    private final String  EA_EXCEPTION_UNDEFINED_CLASS;
     
    APP(){
        EA_EXCEPTION_UNDEFINED_CLASS   = "Excepcion sin decripcion de clase ";
        EA_EXCEPTION_UNDEFINED         = "Excepcion sin decripcion";
    }

    public String  eaGetExceptionUndefined()        {   return  EA_EXCEPTION_UNDEFINED; }
    public String  eaGetExceptionUndefinedClass()   {   return  EA_EXCEPTION_UNDEFINED_CLASS; }
}
