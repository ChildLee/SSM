package cn.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 工具类
 */
public class Util {

    /**
     * 将上传的图片进行压缩后返回图片流
     *
     * @param is     图片流
     * @param suffix 图片后缀
     * @return 图片流
     */
    public static InputStream ImgCompression(InputStream is, String suffix) {
        BufferedImage bufferedImage = null;
        InputStream inputStream = null;
        try {
            bufferedImage = ImageIO.read(is);
            //等比压缩倍数
            double scale = 0.8;
            //获取图片宽度
            int width = bufferedImage.getWidth();
            //获取图片高度
            int height = bufferedImage.getHeight();
            //将宽度等比缩放
            width = (int) (width * scale);
            //将高度等比缩放
            height = (int) (height * scale);

            //压缩处理
            Image image = bufferedImage.getScaledInstance(width, height,
                    Image.SCALE_SMOOTH);
            BufferedImage outputImage = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics graphics = outputImage.getGraphics();
            graphics.drawImage(image, 0, 0, null);
            graphics.dispose();
            //将BufferedImage转换成inputStream流
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(outputImage, suffix, os);
            inputStream = new ByteArrayInputStream(os.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

}
