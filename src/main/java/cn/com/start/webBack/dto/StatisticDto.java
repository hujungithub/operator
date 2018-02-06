package cn.com.start.webBack.dto;

import java.util.Arrays;

public class StatisticDto {
	private int xAxis[];
	private float yAxis[];
	private int yAxisc[];

	@Override
	public String toString() {
		return "StatisticDto [xAxis=" + Arrays.toString(xAxis) + ", yAxis="
				+ Arrays.toString(yAxis) + ", yAxisc="
				+ Arrays.toString(yAxisc) + "]";
	}

	public int[] getyAxisc() {
		return yAxisc;
	}

	public void setyAxisc(int[] yAxisc) {
		this.yAxisc = yAxisc;
	}

	public int[] getxAxis() {
		return xAxis;
	}

	public void setxAxis(int[] xAxis) {
		this.xAxis = xAxis;
	}

	public float[] getyAxis() {
		return yAxis;
	}

	public void setyAxis(float[] yAxis) {
		this.yAxis = yAxis;
	}

}
