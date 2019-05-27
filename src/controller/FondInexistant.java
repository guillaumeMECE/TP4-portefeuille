package controller;

public class FondInexistant extends Exception {

    @Override
    public String getMessage() {
        return "ERR : Fond Inexistant";
    }
}
