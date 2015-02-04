package support;

public class LLObjectNode {
	private LLObjectNode link;
	private Object info;
	
	public LLObjectNode(Object info){
		this.info = info;
		link=null;
	}
	
	public void setInfo(Object info){
		this.info = info;
	}
	
	public Object getInfo(){
		return info;		
	}
	
	public void setLink(LLObjectNode link){
		this.link = link;		
	}
	
	public LLObjectNode getLink(){
		return link;
	}
}
