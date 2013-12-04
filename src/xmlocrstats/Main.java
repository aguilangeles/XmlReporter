package xmlocrstats;

import javax.swing.SwingUtilities;

/**
 *
 * Date: 10/14/12 Time: 6:42 PM
 */
public class Main {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Log().setVisible(true);
      }
    });
  }
}
