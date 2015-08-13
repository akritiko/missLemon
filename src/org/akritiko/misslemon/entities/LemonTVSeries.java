/**
 * 
 */
package org.akritiko.misslemon.entities;

/**
 * @author krap
 *
 */
public class LemonTVSeries {
	
	private String name;
	int season;
	int episode;
	boolean hasEnded;
	
	public LemonTVSeries(String name, int season, int episode) {
		this.name = name;
		this.season = season;
		this.episode = episode;
	}

	public LemonTVSeries(String name, boolean hasEnded) {
		this.name = name;
		this.hasEnded = hasEnded;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public int getEpisode() {
		return episode;
	}

	public void setEpisode(int episode) {
		this.episode = episode;
	}

	public boolean isHasEnded() {
		return hasEnded;
	}

	public void setHasEnded(boolean hasEnded) {
		this.hasEnded = hasEnded;
	};
}
