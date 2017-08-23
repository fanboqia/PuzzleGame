package com.frank.main;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.FileStore;
import java.util.Arrays;
import java.util.Random;

import com.frank.ui.GameFrame;
import com.frank.ui.LogoFrame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Main {

	public final static int MAX_LV = 4;

	public static final Random RANDOM = new Random();

	public static final int getRandom(int max, int min) {
		return RANDOM.nextInt(max - min) + min;
	}

	public static final void flushRandomArray(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int randomIndex = getRandom(arr.length, i);
			int a = arr[randomIndex];
			arr[randomIndex] = arr[i];
			arr[i] = a;
		}
	}

	/** 排行榜分数 **/
	public static int[] arrNIScore = new int[5];

	/** 排行榜排名算法 **/
	public static final void appendScore(int niScore) {
		int[] arrNINewScore = new int[arrNIScore.length];
		int i = 0;
		for (; i < arrNINewScore.length; i++) {
			if (niScore > arrNIScore[i]) {
				arrNINewScore[i] = niScore;
				break;
			} else {
				arrNINewScore[i] = arrNIScore[i];
			}
		}

		for (int j = i + 1; j < arrNINewScore.length; j++) {
			arrNINewScore[j] = arrNIScore[i];
		}
		arrNIScore = arrNINewScore;
	}
	
	// 存储方法
	public static final void save() throws IOException {
		String savContent = "";
		// 存储关卡号
		savContent += GameFrame.lv + ",";
		// 存储排行榜
		for (int i = 0; i < arrNIScore.length; i++) {
			savContent += arrNIScore[i] + ",";
		}
		System.out.println(savContent);
		//File file = new File("data.txt");
	}
	
	public static void main(String[] args) {
		
		
		/**读取存档**/
		
		//String savData = fileLoad("~/Desktop/data.txt");
		//String[] arrSavData = savData.split(",");
		//lv = Integer.parseInt(arrSavData[0]);
//		for(int i = 0; i < arrNIScore.length; i++){
//			arrNIScore[i] = Integer.parseInt(arrSavData[i+1]);
//		}
		
		new LogoFrame();

		// String [] arr = {"1","4","3","2"};
		// System.out.println(Arrays.toString(arr));
		// flushRandomArray(arr);
		// System.out.println(Arrays.toString(arr));
	}
}
