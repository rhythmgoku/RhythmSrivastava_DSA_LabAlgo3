package pairsum;

public class Pair {

	private Node one;
	private Node two;
	
	public Node getOne() {
		return one;
	}
	public void setOne(Node one) {
		this.one = one;
	}
	public Node getTwo() {
		return two;
	}
	public void setTwo(Node two) {
		this.two = two;
	}
	@Override
	public String toString() {
		return "(" + this.getOne().getData() + ","+ this.getTwo().getData() + ") ";
	}
	
	public Pair() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pair(Node one, Node two) {
		super();
		this.one = one;
		this.two = two;
	}
	static Pair of(Node one, Node two) {
		return new Pair(one, two); 
	}
	
    @Override
    public boolean equals(Object object) { 
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Pair pair = (Pair) object;
        return (one == pair.one && two == pair.two) || (one == pair.two && two == pair.one);
    }
	
}
