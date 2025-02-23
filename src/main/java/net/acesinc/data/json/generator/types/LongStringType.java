package net.acesinc.data.json.generator.types;

/**
 *
 * @author andrewserff
 */
public class LongStringType extends TypeHandler {

    public static final String TYPE_NAME = "longString";
    public static final String TYPE_DISPLAY_NAME = "Long String";

    private long min;
    private long max;

    public LongStringType() {
    }

    @Override
    public void setLaunchArguments(String[] launchArguments) {
        super.setLaunchArguments(launchArguments);
        if (launchArguments.length == 0) {
            min = 0;
            max = Long.MAX_VALUE;
        } else if (launchArguments.length == 1) {
            //min only
            min = Long.parseLong(launchArguments[0]);
            max = Long.MAX_VALUE;
        } else if (launchArguments.length == 2) {
            min = Long.parseLong(launchArguments[0]);
            max = Long.parseLong(launchArguments[1]);
        }
    }

    @Override
    public String getNextRandomValue() {
        return String.valueOf(getRand().nextLong(min, max));
    }

    @Override
    public String getName() {
        return TYPE_NAME;
    }

}
