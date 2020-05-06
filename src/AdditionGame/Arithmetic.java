package AdditionGame;

/**
 * Implementation of Arithmetic object
 * @author Gustavo Marcano, Student I.D: 000812644
 */
public class Arithmetic {

    /**
     * right, instance variable that will represent the right answers
     * **/
    private int right;

    /**
     * wrong, instance variable that will represent the wrong answers
     * **/
    private int wrong;

    /**
     * txtField, instance variable that will represent the result of the addition
     * **/
    private int txtField;

    /**
     * randDigit1, instance variable that will represent the random number1
     * **/
    private int randDigit1;

    /**
     * randDigit2, instance variable that will represent the random number1
     * **/
    private int randDigit2;

    /**
     * generateRandNumbers, method that generate both random numbers
     * **/
    public void generateRandNumbers(){
        randDigit1 = (int) (Math.random() * 100);
        randDigit2 = (int) (Math.random() * 100);
    }

    /**
     * getRight, method that returns of the value the la instance variable right
     * **/
    public int getRight() {
        return right;
    }

    /**
     * getWrong, method that returns the value of the la instance variable wrong
     * **/
    public int getWrong() {
        return wrong;
    }

    /**
     * getRandDigit1, method that returns of the value the instance variable randDigit1
     * **/
    public int getRandDigit1() {

        return randDigit1;
    }

    /**
     * getRandDigit1, method that returns the value of the instance variable randDigit2
     * **/
    public int getRandDigit2() {
        return randDigit2;
    }

    /**
     * setTxtField, method that sets the value of the instance variable randDigit2
     * **/
    public void setTxtField(int txtField) {
        this.txtField = txtField;
    }

    /**
     * getTxtField, method that returns the value of the instance variable randDigit2
     * **/
    public int getTxtField() {
        return txtField;
    }

    /**
     * increaseRight, method that increases the instance variable right
     * **/
    public void increaseRight() {
        right++;
    }

    /**
     * increaseWrong, method that increases the instance variable wrong
     * **/
    public void increaseWrong() {
        wrong++;
    }

    /**
     * reset, method that resets  the instance variabbles right and wrong to zero
     * **/
    public void reset() {

        right = 0;
        wrong = 0;

    }


    boolean checkResult() {

        return txtField == randDigit1 + randDigit2;

    }
}
