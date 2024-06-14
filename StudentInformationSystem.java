import javax.swing.*;
import java.awt.*;

public class StudentInformationSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Student Information System");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 400);

                StudentController controller = new StudentController();
                frame.setContentPane(controller.getMainPanel());

                frame.setVisible(true);
            }
        });
    }
}
