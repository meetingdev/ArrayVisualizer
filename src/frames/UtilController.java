package frames;

import main.Main;

public class UtilController {

    public void selectVisualStyle(){
        Main.arrayVisualizer.getUtilFrame().jButton2ActionPerformed();
    }

    public void changeSpeed(){
        Main.arrayVisualizer.getUtilFrame().jButton3ActionPerformed();
    }

    public void chooseSort(){
        Main.arrayVisualizer.getUtilFrame().jButton1ActionPerformed();
    }

    public void skipSort(){
        Main.arrayVisualizer.getUtilFrame().jButton4ActionPerformed();
    }

    public void chooseShuffle(){
        Main.arrayVisualizer.getUtilFrame().jButton6ActionPerformed();
    }

    public void clearStats(){
        Main.arrayVisualizer.getUtilFrame().jButton5ActionPerformed();
    }
}
