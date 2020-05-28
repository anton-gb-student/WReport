package gb.android1.wreport;

public final class StateSaver {

    private static StateSaver instance = null;
    private static final Object syncObj = new Object();

    private ChoiceActivity choiceActivity;

    private boolean airPressureChecked;
    private boolean windSpeedChecked;

    private StateSaver() {
        airPressureChecked = choiceActivity.airPressureCheckBox.isChecked();
        windSpeedChecked = choiceActivity.windSpeedCheckBox.isChecked();
    }

    public static StateSaver getInstance(){
        synchronized (syncObj) {
            if (instance == null) {
                instance = new StateSaver();
            }
            return instance;
        }
    }

    public boolean isAirPressureChecked() {
        return airPressureChecked;
    }

    public boolean isWindSpeedChecked() {
        return windSpeedChecked;
    }
}
