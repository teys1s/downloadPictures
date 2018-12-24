package home_practic.url_load;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class FileDown {
    public static void download(String address,String localFileName){
        OutputStream out = null;
        URLConnection conn = null;
        InputStream in = null;
        try {
            URL url = new URL(address);
            out = new BufferedOutputStream(new FileOutputStream(localFileName));
            conn = url.openConnection();
            in = conn.getInputStream();
            byte[] buffer = new byte[1024];

            int numRead;

            while ((numRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, numRead);
            }

        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }
            catch (IOException ioe) {
            }
        }
    }
    public static Image loadImage(String url) {
        try {
            BufferedImage img = ImageIO.read(new URL(url));
            return img;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
