package net.kvamstadsolutions.urbandict.data;

public class UrbanWord {

	private int defid;
	private String word;
	private String author;
	private String permalink;
	private String definition;
	private String example;
	private int thumbs_up = 140;
	private int thumbs_down = 200;

	public UrbanWord(String word, String definition, String author) {
		this.word = word;
		this.definition = definition;
		this.author = author;
	}
	public int getDefid() {
		return defid;
	}

	public void setDefid(int defid) {
		this.defid = defid;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public int getThumbs_up() {
		return thumbs_up;
	}

	public void setThumbs_up(int thumbs_up) {
		this.thumbs_up = thumbs_up;
	}

	public int getThumbs_down() {
		return thumbs_down;
	}

	public void setThumbs_down(int thumbs_down) {
		this.thumbs_down = thumbs_down;
	}
	
	@Override
	public String toString() {
		return getWord() + " by author: " + getAuthor();
	}
}
