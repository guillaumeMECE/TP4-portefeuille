package controller;

public class InstrumentInexistant extends Exception {

    @Override
    public String getMessage() {
        return "ERR : Instrument Inexistant";
    }
}
