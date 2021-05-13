import Controller.MainFormController;
import Model.Model;
import View.MainForm;
import com.sun.tools.javac.Main;

public class Application
{
    public static void main(String[] args)
    {
        Model model = new Model();
        MainForm mf = new MainForm();

        MainFormController controller = new MainFormController(model, mf);
        controller.ApplicationStart();
    }
}
