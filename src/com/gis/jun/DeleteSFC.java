package com.gis.jun;

import java.io.File;

public class DeleteSFC {
	public void Delete(String fileName) {
		File file = new File(fileName);
		if(file.exists()) {
			boolean d = file.delete();
			if(d){}
			else {
				System.out.println("删除文件失败！");
			}
		}
	}
}
