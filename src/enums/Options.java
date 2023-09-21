package enums;

public enum Options {
    EXIT("[0].Exit!"),
    START("[1].Start!"),
    ADD("[2].Add!"),
    SEE("[3].See history!");




    private final String message;
    public String getMessage() {
        return message;
    }
    Options(String message){
        this.message=message;

    }


}
