package Framework;

public class AppException extends Exception  {

    public AppException(Throwable cause, Object className, String message) {
        super(className +":"+message, cause);
        eaSetDebuggingLog();
    }

    public AppException(Throwable cause, Object className) {
        super(className +":" + APP.EA_GLOBAL.eaGetExceptionUndefined(), cause);
        eaSetDebuggingLog();
    }

    public AppException(String message) {
        super(APP.EA_GLOBAL.eaGetExceptionUndefinedClass()+":"+message);
        eaSetDebuggingLog();
    }

    void eaSetDebuggingLog(){
        System.out.println("{AppException}");
        System.out.println(getMessage());
        System.out.println(getCause());
    }
}
