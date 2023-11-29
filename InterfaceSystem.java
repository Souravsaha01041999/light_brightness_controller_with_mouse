import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class MainInterfaceClass
{
    File file;
    OutputStream osp;
    boolean isSet;
    public MainInterfaceClass()
    {
        isSet=true;
        file=new File("C:\\Users\\USER\\Desktop\\mouse_light_bright\\data.txt");
        JFrame f=new JFrame();
        f.setBounds(100,100,500,500);
        f.setVisible(true);
        f.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {

                if (e.getWheelRotation()>0)
                {
                    setData(true);
                }
                else {
                    setData(false);
                }
            }
        });

        f.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    osp=new FileOutputStream(file);
                    if (isSet)
                        osp.write("y".getBytes());
                    else
                        osp.write("n".getBytes());
                    osp.flush();
                    osp.close();
                    isSet=!isSet;
                }
                catch (IOException ex)
                {

                }
            }
        });

    }

    public void setData(boolean dir)
    {
        try {
            osp=new FileOutputStream(file);
            if (dir)
                osp.write("i".getBytes());
            else
                osp.write("d".getBytes());
            osp.flush();
            osp.close();
        }
        catch (IOException e)
        {

        }
    }
}

public class InterfaceSystem
{
    public static void main(String[] args) {
        new MainInterfaceClass();
    }
}
