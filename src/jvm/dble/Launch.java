package jvm.dble;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class Launch {
    private static final int Tmax = 25;
    double pasGrille=5;
   static int DimXYZ=100;

    public static void main(String[] argv) throws IOException {
        double gm = -1.0;// gm < 0
        double pas = 0.1;
        int nbcorps=10;



        Initialisation init = new Initialisation(gm, nbcorps, Tmax, pas,DimXYZ);
        init.calculate();
       // print(init, 4);
       print(init);
        convert3DTo2DToInt(init);
    }

    private static void convert3DTo2DToInt(Initialisation init) throws IOException {
        Corps[][] I = init.getNCorpsT0();
        boolean[][] coord= new boolean[DimXYZ][DimXYZ];
        for (int n = 0; n < init.getNbDeCorps(); n++) {
            double[] param = I[n][0].getParam();
            int X = (int) (param[0] / param[2]);
            int Y = (int) (param[1] / param[2]);
            System.out.print(X);
            System.out.print(" ; ");
            System.out.print(Y);
            System.out.println(" ; ");
            coord[X][Y] =true;


        }
        byte[] preimg = new byte[3 * DimXYZ * DimXYZ];
        int k=0;
        for (int i = 0; i < DimXYZ; i++) {
            for (int j = 0; j < DimXYZ; j++) {
             if (!coord[i][j] ) {
                 preimg[k] = (byte) 0xff;
                 preimg[k++] = (byte) 0xff;
                 preimg[k++] = (byte) 0xff;
             }else{
                 preimg[k] = 0x0;
                 preimg[k++] = 0x0;
                 preimg[k++] =0x0;
             }
             k++;
            }

        }
        image(preimg);
    }

    private static void image(byte[] preimg) throws IOException {
        int width = DimXYZ;
        int height = DimXYZ;

        DataBuffer buffer = new DataBufferByte(preimg, preimg.length);
        //3 bytes per pixel: red, green, blue
        WritableRaster raster = Raster.createInterleavedRaster(buffer, width, height,
                3 * width, 3, new int[]{0, 1, 2}, (Point) null);
        ColorModel cm = new ComponentColorModel(ColorModel.getRGBdefault().getColorSpace(), false,
                true, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
        BufferedImage image = new BufferedImage(cm, raster, true, null);
        ImageIO.write(image, "png", new File("image.png"));
       // ImageIO.write(image, "png", new File("image.png"));
    }


    private static void print(Initialisation init) {
        Corps[][] I = init.getNCorpsT0();
        for (int n = 0; n < init.getNbDeCorps(); n++) {
            double[] param = I[n][0].getParam();
            System.out.print(param[0]);
            System.out.print(" ; ");
            System.out.print(param[1]);
            System.out.print(" ; ");
            System.out.print(param[2]);
            System.out.println(" ; ");
        }
    }

    static void print(Initialisation init, int n) {
        Corps[][] I = init.getNCorpsT0();
        for (int t = 0; t < Tmax; t++) {
            double[] param = I[n][t].getParam();
            System.out.print(param[0]);
            System.out.print(" ; ");
            System.out.print(param[1]);
            System.out.print(" ; ");
            System.out.print(param[2]);
            System.out.println(" ; ");
        }

    }
}

