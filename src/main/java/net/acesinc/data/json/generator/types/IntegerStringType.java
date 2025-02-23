package net.acesinc.data.json.generator.types;

public class IntegerStringType extends TypeHandler {

    public static final String TYPE_NAME = "integerString";
    public static final String TYPE_DISPLAY_NAME = "Integer String";

    private int min;
    private int max;

    @Override
    public void setLaunchArguments(String[] launchArguments) {
        super.setLaunchArguments(launchArguments);
        if (launchArguments.length == 0) {
            min = 0;
            max = Integer.MAX_VALUE;
        } else if (launchArguments.length == 1) {
            //min only
            min = Integer.parseInt(launchArguments[0]);
            max = Integer.MAX_VALUE;
        } else if (launchArguments.length == 2) {
            min = Integer.parseInt(launchArguments[0]);
            max = Integer.parseInt(launchArguments[1]);
        }
    }

    @Override
    public String getNextRandomValue() {
        return String.valueOf(getRand().nextInt(min, max));
    }

    @Override
    public String getName() {
        return TYPE_NAME;
    }
}

