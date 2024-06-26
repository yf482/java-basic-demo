package com.mode.sample_3_composite.gobang;

// The Component interface for the sample_3_composite pattern
public abstract class ChessComponent {
     public abstract void setPosition(int x, int y);
     public abstract int[ ] getPosition();
	 public abstract String showInfo();
	 public abstract int getColor();
}