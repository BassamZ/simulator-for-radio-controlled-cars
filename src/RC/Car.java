package RC;

public class Car {
    private RCsimulator simulator;
    private ModelType modelType;

    public Car(ModelType modelType) {
        this.modelType = modelType;
        if (modelType == ModelType.MonsterTrack) {
            simulator = new MonsterTruckRCsimulator();
        }
    }

    public RCsimulator getSimulator() {
        return simulator;
    }

    public void setSimulator(RCsimulator simulator) {
        this.simulator = simulator;
    }

    public ModelType getModelType() {
        return modelType;
    }

    public void setModelType(ModelType modelType) {
        this.modelType = modelType;
    }

    public void operation(InputData userinfo){

        simulator.operation(userinfo);
    }
}
