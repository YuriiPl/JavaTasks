
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Porsche implements Maintainable,Tank,Engine  {
    String name="Porsche";
    int gasLevel=70+new Random().nextInt()%30;

    @Override
    public void changeOil() {
        System.out.println("Porsche change Oil");
    }

    @Override
    public void tuneUp() {
        System.out.println("Porsche tune up");
    }

    @Override
    public void startEngine() {
        System.out.println("Porsche engine starts");
    }

    @Override
    public void stopEngine() {
        System.out.println("Porsche engine stops");
    }

    @Override
    public int noiseLevel() {
        //This value isn't real :) That is just a method :)
        return new Random().nextInt()%20+5;
    }

    @Override
    //This value isn't real :) That is just a method :)
    public int tankVolume() {
        return 100;
    }

    @Override
    public void fillIn() {
        while(tankVolume()>gasLevel) {
            System.out.println("Porsche tank fill in. Current level="+gasLevel);
            gasLevel+=5;
        }
        gasLevel= tankVolume();
    }

    @Override
    public void stopFilling() {
        System.out.println("Porsche tank stop filling. Current level="+gasLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,gasLevel);
    }
}
