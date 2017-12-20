package dogma.gui;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ImageScraper {

    public void getImages(String goUrl, int minSize) throws IOException {
        try {
      
            Document doc = Jsoup.connect(goUrl).timeout(300000).get();
            int minimumSize = minSize;

            // Take image urls
            Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
            
            // Get Folder from GUI
            String folderpath;
            folderpath = DogmaMainWindow.jTextSaveFolder.getText();

            // Image counter
            int i = 0;
            int tooSmall = 0;

            for (Element image : images) {
                try {
                    String srco = image.attr("abs:src");
                    String src = CommonBal.urlCleanup(srco);
                    
                    // Read images
                    URL url = new URL(src);
                    ByteArrayOutputStream out;
                    try (InputStream in = new BufferedInputStream(url.openStream())) {
                        out = new ByteArrayOutputStream();
                        byte[] buf = new byte[1024];
                        int n = 0;
                        while (-1 != (n = in.read(buf))) {
                            out.write(buf, 0, n);
                        }
                        out.close();
                    }
                    byte[] response = out.toByteArray();
                    if (response.length > minimumSize) {
                        //Exctract the name of the image from the src attribute
                        int indexname = src.lastIndexOf("/");
                        indexname++;

                        if (indexname == src.length()) {
                            src = src.substring(1, indexname);
                        }

                        String name = src.substring(indexname, src.length());

                        try ( // Save images
                                FileOutputStream fos = new FileOutputStream(folderpath + "/" + name)) {
                            OutputStream out2 = new BufferedOutputStream(fos);
                            out2.write(response);
                            out2.close();
                            BufferedImage img = ImageIO.read(new File(folderpath + "/" + name));
                            DogmaMainWindow.updateImage(img);
                        }
                        i++;
                    } else {
                        tooSmall++;
                    }
                } catch (IOException e) {
                    System.err.println("Error in reading & storing images: " + e.getMessage());
                }
            }
            int totalfound;
            totalfound = i + tooSmall;
            System.out.print("Found "+totalfound+" images. Grabbed "+i+"\n");
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
