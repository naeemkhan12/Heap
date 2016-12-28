
public class node {

	private String data = null;
	private int prior = 0; // priority of each element

	public node(String data, int prior){
		this.data = data;
		this.prior= prior;
	}

	public void setPriority(int num){
		this.prior = num;
	}
	@Override
	public String toString(){
		return data+"   "+prior;
	}
	public int getPriority(){
		return prior;
	}

}
