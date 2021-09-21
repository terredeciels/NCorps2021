package jvm.image;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class DemoImage {

    public static final int WIDTH = 100;
    public static final int OFFSET = 10;
    private static final int IWIDTH = ((WIDTH / 2) - OFFSET);
    private static final int INB = IWIDTH * IWIDTH;

    public static void main(String[] args) {

        final int[][] array = create();

        final BufferedImage[] images = {
                createImage(array, convertToRGB(array), BufferedImage.TYPE_INT_RGB),
                createImage(array, convertToARGB(array), BufferedImage.TYPE_INT_ARGB),
                createImage(array, convertToGray(array), BufferedImage.TYPE_BYTE_GRAY)
        };

        final JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        for (final BufferedImage image : images) {
            panel.add(new JLabel(new ImageIcon(image)));
        }

        JOptionPane.showMessageDialog(null, panel);

    }

    private static BufferedImage createImage(final int[][] array,
                                             final int[] pixelArray, final int type) {
        final BufferedImage image = new BufferedImage(array[0].length, array.length, type);
        final WritableRaster raster = image.getRaster();
        raster.setPixels(0, 0, array[0].length, array.length, pixelArray);
        return image;
    }

    private static int[] convertToRGB(final int[][] array) {
        final int[] pixelArray = new int[array.length * array[0].length * 3];
        for (int i = 0; i < pixelArray.length; i += 3) {
            final int r = array[(i / 3) / array[0].length][(i / 3) % array[0].length];
            pixelArray[i] = r;
            pixelArray[i + 1] = r;
            pixelArray[i + 2] = r;
        }
        return pixelArray;
    }

    private static int[] convertToARGB(int[][] array) {
        final int[] pixelArray = new int[array.length * array[0].length * 4];
        for (int i = 0; i < pixelArray.length; i += 4) {
            int x = (i / 4) % array[0].length;
            int y = (i / 4) / array[0].length;
            final int r = array[y][x];
            pixelArray[i] = r;
            pixelArray[i + 1] = r;
            pixelArray[i + 2] = r;
            pixelArray[i + 3] = (x >= OFFSET && x < WIDTH - OFFSET && y >= OFFSET && y < WIDTH - OFFSET) ? 255 : 0; // alpha
        }
        return pixelArray;
    }

    private static int[] convertToGray(int[][] array) {
        final int[] pixelArray = new int[array.length * array[0].length];
        for (int i = 0; i < pixelArray.length; i++) {
            final int r = array[i / array[0].length][i % array[0].length];
            pixelArray[i] = r;
        }
        return pixelArray;
    }

    private static int[][] create() {

        final int[][] array = new int[WIDTH][WIDTH];

        for (int i = OFFSET, r = 0; i < WIDTH / 2; i++) {
            for (int j = OFFSET; j < WIDTH / 2; j++) {
                array[i][j] =
                        array[j][i] =
                                array[99 - i][j] =
                                        array[99 - j][i] =
                                                array[i][99 - j] =
                                                        array[j][99 - i] =
                                                                array[99 - i][99 - j] =
                                                                        array[99 - j][99 - i] = (int) (r * 255.0 / INB);
                r++;
            }
        }
        return array;

    }

}
