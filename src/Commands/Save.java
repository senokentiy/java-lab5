package Commands;

import App.App;
import App.SaverCSV;
import java.io.IOException;


public class Save implements Command
{
    @Override
    public void execute(String arg) throws IOException
    {
        SaverCSV saver = App.getInstance().getSaver();
        saver.save();
    }

    @Override
    public String getDescription() {
        return "saves tickets data to csv file.";
    }
}
