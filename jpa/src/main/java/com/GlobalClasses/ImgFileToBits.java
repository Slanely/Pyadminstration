package com.GlobalClasses;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class ImgFileToBits {
    public static byte[] fileToByte(File img) throws Exception {
        byte[] bytes = null;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            BufferedImage bi;
            bi = ImageIO.read(img);
            ImageIO.write(bi, "png", baos);
            bytes = baos.toByteArray();
        }
        return bytes;
    }
}
