package common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class ImageUploadCommon {

	public ImageUploadCommon() {
	}

	public void img_delete(HttpServletRequest request, String uploads, String oldImage)
			throws ServletException, IOException {

		// 古い画像を削除
		Path oldPass = Paths.get(uploads + File.separator + oldImage);
		if (Files.exists(oldPass)) {
			try {
				Files.delete(oldPass);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}

	public String img_upload(HttpServletRequest request, String uploads, String oldImage)
			throws ServletException, IOException {

		String imageName = oldImage;

		try {//新しい画像を登録
			Part filePart = request.getPart("image");
			String image = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			if (image.equals("")) {
			} else {
				//画像の拡張子
				String ext = image.substring(image.lastIndexOf(".") + 1);
				//かぶらないファイル名を生成する
				Random rnd = new Random();
				int rndNum = rnd.nextInt(10000);
				SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
				imageName = sdf.format(new Date())
						+ String.format("%04d", rndNum)
						+ "." + ext;
				System.out.println("upload > " + uploads + File.separator + imageName);
				//新しいファイル名で保存
				filePart.write(uploads + File.separator + imageName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return imageName;
	}

}
