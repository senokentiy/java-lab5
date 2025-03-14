package Commands;

import App.App;
import App.SaverCSV;


public class Save implements Command
{
    @Override
    public void execute(String arg)
    {
        SaverCSV saver = App.getInstance().getSaverCSV();
        saver.save();
    }

    @Override
    public String getDescription() {
        return "saves tickets data to csv file.";
    }
}
