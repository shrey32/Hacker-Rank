package com.leetcode.monthchallenge.may;

import java.util.Arrays;

/**
 * <b>Flood Fill</b>
 * <p>
 * An image is represented by a 2-D array of integers, each integer representing
 * the pixel value of the image (from 0 to 65535).
 * </p>
 * 
 * <p>
 * Given a coordinate (sr, sc) representing the starting pixel (row and column)
 * of the flood fill, and a pixel value newColor, "flood fill" the image.
 * </p>
 * 
 * <p>
 * To perform a "flood fill", consider the starting pixel, plus any pixels
 * connected 4-directionally to the starting pixel of the same color as the
 * starting pixel, plus any pixels connected 4-directionally to those pixels
 * (also with the same color as the starting pixel), and so on. Replace the
 * color of all of the aforementioned pixels with the newColor.
 * </p>
 * 
 * <p>
 * At the end, return the modified image.
 * </p>
 * 
 * <b>Example 1:</b>
 * <p>
 * <b>Input:</b> image = [[1,1,1],[1,1,0],[1,0,1]],sr = 1, sc = 1, newColor = 2
 * </p>
 * <p>
 * <b>Output:</b> [[2,2,2],[2,2,0],[2,0,1]]
 * </p>
 * <p>
 * <b>Explanation:</b> From the center of the image (with position (sr, sc) =
 * (1, 1)), all pixels connected by a path of the same color as the starting
 * pixel are colored with the new color. Note the bottom corner is not colored
 * 2, because it is not 4-directionally connected to the starting pixel.
 * </p>
 * 
 * <b>Note:</b>
 * 
 * <li>The length of image and image[0] will be in the range [1, 50].</li>
 * <li>The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc
 * < image[0].length.</li>
 * <li>The value of each color in image[i][j] and newColor will be an integer in
 * [0, 65535].</li>
 * <p>
 * <b>Hide Hint #1</b>
 * </p>
 * <p>
 * Write a recursive function that paints the pixel if it's the correct color,
 * then recurses on neighboring pixels.
 * </p>
 * 
 * @author Shrey
 *
 */
public class FloodFill {

	public static void main(String[] args) {
		print(floodFill(new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }, 1, 1, 2));
	}

	private static void print(int[][] image) {
		for (int i = 0; i < image.length; i++) {
			System.out.println(Arrays.toString(image[i]));
		}
	}

	private static int[] DIR = new int[] { 0, 1, 0, -1, 0 };

	public static int[][] floodFill(int[][] image, int r, int c, int newColor) {
		int m = image.length, n = image[0].length;
		if (image[r][c] == newColor)
			return image;
		int oldColor = image[r][c];
		image[r][c] = newColor; // set new color
		for (int i = 0; i < 4; i++) {
			int nr = r + DIR[i], nc = c + DIR[i + 1];
			if (nr < 0 || nr == m || nc < 0 || nc == n || image[nr][nc] != oldColor)
				continue;
			floodFill(image, nr, nc, newColor);
		}
		return image;
	}

}
