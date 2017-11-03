package data;

public class Faq {
	
	private int topic_id;
	private String question;
	private String answer;
	
	public Faq(int topic_id, String question, String answer) {
		super();
		this.topic_id = topic_id;
		this.question = question;
		this.answer = answer;
	}

	public int getTopic_id() {
		return topic_id;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}
	
	

}
