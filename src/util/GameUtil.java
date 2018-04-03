package util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GameUtil {
	private GameUtil(){}//工具类最好将构造器私有化
	public static Image getImage(String path){
		BufferedImage bi = null;
		URL url = GameUtil.class.getClassLoader().getResource(path);
		try {
			bi = javax.imageio.ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bi;
	}
}
