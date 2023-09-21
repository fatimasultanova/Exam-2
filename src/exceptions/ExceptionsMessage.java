package exceptions;

public enum ExceptionsMessage {
    ILLEGAL_CHARACTER_EXCEPTION("Yanlış simvol daxil edildi!"),
    ILLEGAL_POINT_EXCEPTION("Point mənfi dəyər ala bilməz!");

    public String getMassage() {
        return massage;
    }

    private final String massage;

    ExceptionsMessage(String massage){
        this.massage=massage;
    }
}
