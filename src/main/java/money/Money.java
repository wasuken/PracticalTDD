package money;

class Money implements Expression{
	protected int amount;
	protected String currency;
	Money times(int multiplier) {
		return new Money(amount * multiplier,currency);
	}
	Expression plus(Money addend) {
		return new Sum(this,addend);
	}
	public	Money reduce(String to) {
		return this;
	}
	Money(int amount,String currency){
		this.amount = amount;
		this.currency = currency;
	}
	String currency(){
		return currency;
	}
	public boolean equals(Object object){
		Money money = (Money)object;
		return money.amount == this.amount && currency().equals(money.currency());
	}
	static Money dollar(int amount){
		return new Money(amount,"USD");
	}
	static Money franc(int amount){
		return new Money(amount,"CHF");
	}
	public String toString() {
		return amount + " " + currency;
	}
}
