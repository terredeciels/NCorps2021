package jvm.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;

public class BufferedImageTOImage {
    public static void main(String[] argv) throws Exception {

//        byte[] aByteArray = {0x0,0x0,0x0, 0x0, 0x0,0x0,0x0,0x0, 0x0, 0x0,0x0,0x0,0x0, 0x0, 0x0,0x0,0x0,0x0, 0x0, 0x0,
//                (byte) 0xff,(byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff,(byte) 0xff, (byte) 0xff, (byte) 0xff};
        byte[]  aByteArray = {0x0,0x0,0x0, (byte) 0xff,(byte)  0xff,(byte) 0xff,0x0,0x0, 0x0, 0x0,0x0,0x0,0x0, 0x0, 0x0,0x0,0x0,0x0, 0x0, 0x0,
               0x0,0x0,0x0, 0x0, (byte) 0xff,(byte)  0xff,(byte) 0xff};
        System.out.println(aByteArray.length);
        int width = 3;
        int height = 3;

        DataBuffer buffer = new DataBufferByte(aByteArray, aByteArray.length);

//3 bytes per pixel: red, green, blue

        WritableRaster raster = Raster.createInterleavedRaster(buffer, width, height,
                3 * width, 3, new int[]{0, 1, 2}, (Point) null);

        ColorModel cm = new ComponentColorModel(ColorModel.getRGBdefault().getColorSpace(), false,
                true, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);

        BufferedImage image = new BufferedImage(cm, raster, true, null);



        ImageIO.write(image, "jpg", new File("image.jpg"));
        ImageIO.write(image, "png", new File("image.png"));
    }
}