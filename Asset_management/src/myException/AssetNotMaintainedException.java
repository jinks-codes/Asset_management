package myException;

public class AssetNotMaintainedException extends Exception {
    public AssetNotMaintainedException(String message) {
        super(message);
    }
}