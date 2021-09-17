import java.util.Objects;
import java.util.Random;

public class BMV implements Maintainable,Tank,Engine {
    String name="BMV";
    int gasLevel=70+new Random().nextInt()%30;

    @Override
    public void changeOil() {
        System.out.println("BMV change Oil");
    }

    @Override
    public void tuneUp() {
        System.out.println("BMV tune up");
    }


    @Override
    public void startEngine() {
        System.out.println("BMV engine starts");
    }

    @Override
    public void stopEngine() {
        System.out.println("BMV engine stops");
    }

    @Override
    public int noiseLevel() {
        //This value isn't real :) That is just a method :)
        return new Random().nextInt()%20+5;
    }

    @Override
    //This value isn't real :) That is just a method :)
    public int tankVolume() {
        return 125;
    }

    @Override
    public void fillIn() {
        while(tankVolume()>gasLevel) {
            System.out.println("BMV tank fill in. Current level="+gasLevel);
            gasLevel+=5;
        }
        gasLevel= tankVolume();
    }

    @Override
    public void stopFilling() {
        System.out.println("BMV stop tank filling. Current level="+gasLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gasLevel);
    }
}
