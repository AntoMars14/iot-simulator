package net.acesinc.data.json.generator.types;


import java.util.HashMap;
import java.util.Map;


public class RandomIncrementDoubleStringType extends TypeHandler {
    public static final String TYPE_NAME = "randomIncrementDoubleString";
    public static final String TYPE_DISPLAY_NAME = "Random Increment Double String";

    private class IncrementParameters {
        public double nextValue;
        public final double minStep;
        public final double maxStep;

        public IncrementParameters(double nextValue, double minStep, double maxStep) {
            this.nextValue = nextValue;
            this.minStep = minStep;
            this.maxStep = maxStep;
        }
    };

    private String currentRandomIncrementDoubleName;
    private final Map<String, IncrementParameters> namedRandomIncrementDoubleMap;

    public RandomIncrementDoubleStringType(){
        namedRandomIncrementDoubleMap = new HashMap<>();
    }

    @Override
    public void setLaunchArguments(String[] launchArguments) {
        if (launchArguments.length < 1) {
            throw new IllegalArgumentException("Arguments list is too short");
        }
        currentRandomIncrementDoubleName = launchArguments[0];
        if (namedRandomIncrementDoubleMap.get(currentRandomIncrementDoubleName) != null) {
            return;
        }

        double nextValue;
        double minStep;
        double maxStep;

        super.setLaunchArguments(launchArguments);
        switch (launchArguments.length) {
            case 1:
                nextValue = 0;
                minStep = 0;
                maxStep = Double.MAX_VALUE;
                break;
            case 2:
                nextValue = Double.parseDouble(launchArguments[1]);
                minStep = 0;
                maxStep = Double.MAX_VALUE;
                break;
            case 3:
                nextValue = Double.parseDouble(launchArguments[1]);
                minStep = Double.parseDouble(launchArguments[2]);
                maxStep = Double.MAX_VALUE;
                break;
            case 4:
                nextValue = Double.parseDouble(launchArguments[1]);
                minStep = Double.parseDouble(launchArguments[2]);
                maxStep = Double.parseDouble(launchArguments[3]);
                break;
            default:
                return;
        }

        namedRandomIncrementDoubleMap.put(currentRandomIncrementDoubleName, new IncrementParameters(nextValue, minStep, maxStep));
    }

    @Override
    public String getNextRandomValue() {
        IncrementParameters incrementParameters = namedRandomIncrementDoubleMap.get(currentRandomIncrementDoubleName);
        double value = incrementParameters.nextValue;
        incrementParameters.nextValue += incrementParameters.minStep + getRand().nextUniform(incrementParameters.minStep, incrementParameters.maxStep);

        return String.valueOf(value);
    }

    @Override
    public String getName() {
        return TYPE_NAME;
    }
}
