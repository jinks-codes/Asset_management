package myException;

public class AssetNotFoundException extends Exception {
    public AssetNotFoundException(String message) {
        super(message);
    }
}