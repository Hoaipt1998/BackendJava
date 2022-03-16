package com.example.TamGiac.model;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class TamGiac {
	private int canh1, canh2, canh3;

	public TamGiac() {
		super();
	}

	public TamGiac(int canh1, int canh2, int canh3) {
		super();
		this.canh1 = canh1;
		this.canh2 = canh2;
		this.canh3 = canh3;
	}

	public int getCanh1() {
		return canh1;
	}

	public void setCanh1(int canh1) {
		this.canh1 = canh1;
	}

	public int getCanh2() {
		return canh2;
	}

	public void setCanh2(int canh2) {
		this.canh2 = canh2;
	}

	public int getCanh3() {
		return canh3;
	}

	public void setCanh3(int canh3) {
		this.canh3 = canh3;
	}

	public boolean CheckTamGiacVuong(int canh1, int canh2, int canh3) {
		if (Math.pow(canh1, 2) + Math.pow(canh2, 2) == Math.pow(canh3, 2)) {
			return true;
		}
		return false;
	}

	public boolean CheckTamGiacDeu(int canh1, int canh2, int canh3) {
		if (canh1 == canh2 && canh1 == canh3 && canh2 == canh3) {
			return true;
		}
		return false;
	}

	public boolean CheckTamGiacCan(int canh1, int canh2) {
		if (canh1 == canh2) {
			return true;
		}
		return false;
	}
	
	public int getTamGiac() {
		if (this.canh1 + this.canh2 < this.canh3 || this.canh1 + this.canh3 < this.canh2 || this.canh2 + this.canh3 < this.canh1) {
			return 0;
		} else if (CheckTamGiacDeu(this.canh1, this.canh2, this.canh3)) {
			return 1;
		} else if (CheckTamGiacCan(this.canh1, this.canh2) || CheckTamGiacCan(this.canh1, this.canh3) || CheckTamGiacCan(canh2, canh3)) {
			if (CheckTamGiacVuong(this.canh1, this.canh2, this.canh3) || CheckTamGiacVuong(this.canh2, this.canh3, this.canh1)
					|| CheckTamGiacVuong(this.canh3, this.canh1, this.canh2)) {
				return 3;
			} else
				return 2;

		} else if (CheckTamGiacVuong(this.canh1, this.canh2, this.canh3) || CheckTamGiacVuong(this.canh2, this.canh3, this.canh1)
				|| CheckTamGiacVuong(this.canh3,this.canh1, this.canh2)) {
			return 4;
		}
		return 5;
	}

}
