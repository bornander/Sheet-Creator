package com.bornander.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class ImageUtils {

    private ImageUtils() {
    }

    public static BufferedImage padImage(BufferedImage source, int tileSize, int tilePadding) {
        int rows = source.getHeight() / tileSize;
        int cols = source.getWidth() / tileSize;

        int paddedWidth = cols * (tileSize + tilePadding * 2);
        int paddedHeight = rows * (tileSize + tilePadding * 2);

        int paddedTileSize = tileSize + tilePadding * 2;

        BufferedImage target = new BufferedImage(paddedWidth, paddedHeight, BufferedImage.TYPE_4BYTE_ABGR);

        Graphics2D tg = (Graphics2D) target.getGraphics();

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                int sx1 = col * tileSize;
                int sy1 = row * tileSize;
                int sx2 = sx1 + tileSize;
                int sy2 = sy1 + tileSize;

                int tx1 = col * paddedTileSize + tilePadding;
                int ty1 = row * paddedTileSize + tilePadding;
                int tx2 = tx1 + tileSize;
                int ty2 = ty1 + tileSize;

                tg.drawImage(source, tx1, ty1, tx2, ty2, sx1, sy1, sx2, sy2, null);
            }
        }

        float[] pixel = new float[4];
        WritableRaster wr = target.getRaster();
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                int bx = col * paddedTileSize;
                int by = row * paddedTileSize;

                for (int x = bx + tilePadding; x < bx + tileSize + tilePadding; ++x) {
                    for (int t = 0; t < tilePadding; ++t) {
                        pixel = wr.getPixel(x, by + tilePadding, pixel);
                        wr.setPixel(x, by + t, pixel);

                        pixel = wr.getPixel(x, by + tilePadding + tileSize - 1, pixel);
                        wr.setPixel(x, by + paddedTileSize - (t + 1), pixel);
                    }
                }

                for (int y = by + tilePadding; y < by + tileSize + tilePadding; ++y) {
                    for (int t = 0; t < tilePadding; ++t) {
                        pixel = wr.getPixel(bx + tilePadding, y, pixel);
                        wr.setPixel(bx + t, y, pixel);

                        pixel = wr.getPixel(bx + tilePadding + tileSize - 1, y, pixel);
                        wr.setPixel(bx + paddedTileSize - (t + 1), y, pixel);
                    }
                }
            }
        }
        target.setData(wr);
        target.flush();

        return target;
    }
}
