package com.gis.jun;
import javax.swing.JOptionPane;
public class Check{
	public boolean CheckMax(String str, float maxSpec) {
		try {
			float f = Float.parseFloat(str);
			if (f < maxSpec) {
				return true;
			} else {
				return false;
			}
		} catch(Exception e) {
			System.out.println("数据格式错误:" + e);
			JOptionPane.showMessageDialog(null,"数据格式错误，请重新测试！！");
			return true;
		}
	}
	
	public boolean CheckMin(String str, float minSpec) {
		try {
			float f = Float.parseFloat(str);
			if (f > minSpec) {
				return true;
			} else {
				return false;
			}
		} catch(Exception e) {
			System.out.println("数据格式错误:" + e);
			JOptionPane.showMessageDialog(null,"数据格式错误，请重新测试！！");
			return true;
		}
	}
	
	public boolean CheckMaxMin(String str, float maxSpec, float minSpec) {
		try {
			float f = Float.parseFloat(str);
			if (f< maxSpec && f > minSpec) {
				return false;
			} else {
				return true;
			}
		} catch(Exception e) {
			System.out.println("数据格式错误:" + e);
			JOptionPane.showMessageDialog(null,"数据格式错误，请重新测试！！");
			return true;
		}
	}
		
}
