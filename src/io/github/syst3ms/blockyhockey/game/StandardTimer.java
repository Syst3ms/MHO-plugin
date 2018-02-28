package io.github.syst3ms.blockyhockey.game;

public class StandardTimer implements Timer {
	private int minutes;
	private int seconds;
	private int tenths;

	public StandardTimer(int minutes, int seconds, int tenths) {
		this.minutes = minutes;
		this.seconds = seconds;
		this.tenths = tenths;
	}

	@Override
	public boolean advanceTime() {
		tenths--;
		if (tenths == -1) {
			tenths = 9;
			seconds--;
		}
		if (seconds == -1) {
			seconds = 59;
			minutes = 0;
		}
		return minutes + seconds + tenths == 0;
	}

	@Override
	public String getTimeString() {
		if (minutes == 0) {
			return String.format("%d.%d", seconds, tenths);
		} else {
			return String.format("%02d:%02d", minutes, seconds);
		}
	}
}
