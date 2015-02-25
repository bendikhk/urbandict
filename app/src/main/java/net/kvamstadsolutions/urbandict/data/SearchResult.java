package net.kvamstadsolutions.urbandict.data;

import java.util.List;

public class SearchResult {

	private String[] tags;
	private List<UrbanWord> list;

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public List<UrbanWord> getList() {
		return list;
	}

	public void setList(List<UrbanWord> list) {
		this.list = list;
	}

}
