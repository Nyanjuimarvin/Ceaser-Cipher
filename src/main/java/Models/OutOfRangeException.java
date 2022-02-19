package Models;

//Throw if number enterd is out of Ranfe
public class OutOfRangeException extends Exception{
    public OutOfRangeException(String exception){
        super(exception);
    }
}
