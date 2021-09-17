
public class ServiceStation {

    public void testEngine(Engine engine){
        if(engine==null){
            System.out.println("Oops there is no engine!");
            return;
        }
        engine.startEngine();
        System.out.println("Noise level = "+engine.noiseLevel());
        engine.stopEngine();
    }

    public void maintain(Maintainable maintainable){
        if(maintainable==null){
            System.out.println("Oops there is nothing to maintain!");
            return;
        }
        maintainable.changeOil();
        maintainable.tuneUp();
    }

    public void fillUpWithGasoline(Tank tank){
        tank.fillIn();
        tank.stopFilling();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
