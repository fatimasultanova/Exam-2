package exceptions;

public class AppExceptions extends RuntimeException{
    public AppExceptions(ExceptionsMessage exceptionsMessage){
        super(exceptionsMessage.getMassage());

    }
}
