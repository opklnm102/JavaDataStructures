package support;
//도착, 서비스, 종료 시간 애트리뷰트를 갖는 고객 객체를 지원
//대기 시간을 계산하고 리턴하는 책임이 있음

public class Customer {
	protected int arrivalTime;
	protected int serviceTime;
	protected int finishTime;
	
	public Customer(int arrivalTime, int serviceTime){
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
	}
	
	public int getArrivalTime(){
		return arrivalTime;
	}
	
	public int getServiceTime(){
		return serviceTime;
	}
	
	public void setFinishTime(int time){
		finishTime = time;
	}
	
	public int getFinishTime(){
		return finishTime;
	}
	
	public int getWaitTime(){
		return (finishTime - arrivalTime - serviceTime);
	}
}
