public class Main {
    public static void main(String[] args){
        ServiceStation serviceStation = new ServiceStation();
        BMV bmv = new BMV();
        Porsche porsche = new Porsche();

        serviceStation.maintain(bmv);
        serviceStation.maintain(porsche);

        serviceStation.testEngine(bmv);
        serviceStation.testEngine(porsche);

        serviceStation.fillUpWithGasoline(bmv);
        serviceStation.fillUpWithGasoline(porsche);
    }
}
