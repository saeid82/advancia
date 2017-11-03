package data;

public class Topics {
	private int topic_id;
	private String topic_name;
	public Topics(int topic_id, String topic_name) {
		this.topic_id = topic_id;
		this.topic_name = topic_name;
	}
	public int getTopic_id() {
		return topic_id;
	}
	public String getTopic_name() {
		return topic_name;
	}


}
