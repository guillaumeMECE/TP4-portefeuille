package controller;

public class FondExistant extends Exception {
    @Override
    public String getMessage() {
        return "Fond Existant";
    }
}
