package net.acesinc.data.json.generator.types;

import java.util.Random;
import org.apache.commons.math3.util.Precision;

/**
 *
 * @author andrewserff
 */
public class DoubleStringType extends TypeHandler {

    public static final String TYPE_NAME = "doubleString";
    public static final String TYPE_DISPLAY_NAME = "Double String";

    private double min;
    private double max;
    private Random rand;
    private static final int decimalPlaces = 4;

    public DoubleStringType() {
        super();
        rand = new Random();
    }

    @Override
    public void setLaunchArguments(String[] launchArguments) {
        super.setLaunchArguments(launchArguments);
        if (launchArguments.length == 0) {
            min = 0;
            max = Double.MAX_VALUE;
        } else if (launchArguments.length == 1) {
            //min only
            min = Double.parseDouble(launchArguments[0]);
            max = Double.MAX_VALUE;
        } else if (launchArguments.length == 2) {
            min = Double.parseDouble(launchArguments[0]);
            max = Double.parseDouble(launchArguments[1]);
        }
    }

    @Override
    public String getNextRandomValue() {
        double range = max - min;
        double scaled = rand.nextDouble() * range;
        double shifted = scaled + min;

        return String.valueOf(Precision.round(shifted, decimalPlaces));

    }

    @Override
    public String getName() {
        return TYPE_NAME;
    }

}
