package Models;

//Throw if number entered is out of Range
public class OutOfRangeException extends Exception{
    public OutOfRangeException(String exception){
        super(exception);
    }
}
