package com.github.alexwibowo.shout;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * User: alexwibowo
 */
public class ShoutGenerator {

    public static final int BUFFERED_IMAGE_WIDTH = 144;

    public static final int BUFFERED_IMAGE_HEIGHT = 32;

    public static final int DEFAULT_FONT_SIZE = 20;

    public static final ShoutStyle DEFAULT_SHOUT_STYLE =  ShoutStyle.PLAIN;

    /**
     * Standard shout - with {@link #DEFAULT_SHOUT_STYLE} style and size {@link #DEFAULT_FONT_SIZE}
     */
    public static String shout(String message) {
        return shout(message, DEFAULT_SHOUT_STYLE, DEFAULT_FONT_SIZE);
    }

    /**
     * More flexible shout
     */
    public static String shout(String message, ShoutStyle shoutStyle, int fontSize) {
        BufferedImage image = createTextualImage(message, shoutStyle.fontStyle, fontSize);

        StringBuilder shoutBuilder = new StringBuilder();
        for (int y = 0; y < BUFFERED_IMAGE_HEIGHT; y++) {
            StringBuilder lineBuilder = new StringBuilder();
            for (int x = 0; x < BUFFERED_IMAGE_WIDTH; x++) {
                lineBuilder.append(image.getRGB(x, y) == -16777216 ? " " : image.getRGB(x, y) == -1 ? "#" : "*");
            }
            if (lineBuilder.toString().trim().isEmpty()) {
                continue;
            }
            shoutBuilder.append(lineBuilder).append("\n");
        }

        return shoutBuilder.toString();
    }

    private static BufferedImage createTextualImage(String message, int fontStyle, int messageSize) {
        BufferedImage image = new BufferedImage(BUFFERED_IMAGE_WIDTH, BUFFERED_IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("Dialog", fontStyle, messageSize));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString(message, 6, 24);
        return image;
    }

    public static enum ShoutStyle {
        PLAIN(Font.PLAIN),
        ITALIC(Font.ITALIC),
        BOLD(Font.BOLD);

        private int fontStyle;

        ShoutStyle(int fontStyle) {
            this.fontStyle = fontStyle;
        }
    }
}
