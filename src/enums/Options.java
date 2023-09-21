package enums;

public enum Options {
    EXIT("\n[0].Exit!"),
    START("\n[1].Start!"),
    ADD("\n[2].Add!"),
    SEE("\n[3].See history!");




    private final String message;
    public String getMessage() {
        return message;
    }
    Options(String message){
        this.message=message;

    }


}
